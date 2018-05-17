angular.module('listProduct', ['ngCookies', 'navBar'])
    .factory('PagerService', PagerService)
    .controller('controllerListProduct', controllerListProduct)

function controllerListProduct(PagerService, $scope, $cookies, $http, $window) {
    var vm = this;

    //get json
    $http.get("http://5ad6e99acd67c10014c73d9d.mockapi.io/product").then(function (response) {
        vm.allProducts = response.data;
        initController();
    });
    vm.pager = {};
    vm.setPage = setPage;

    $scope.cart = [];
    $scope.total = 0;

    if (!angular.isUndefined($cookies.get('total'))) {
        $scope.total = parseFloat($cookies.get('total'));
    }

    if (!angular.isUndefined($cookies.get('cart'))) {
        $scope.cart = $cookies.getObject('cart');
    }

    $scope.addItemToCart = function (product) {
        if ($scope.cart.length === 0) {
            product.count = 1;
            $scope.cart.push(product);
        } else {
            var repeat = false;
            for (var i = 0; i < $scope.cart.length; i++) {
                if ($scope.cart[i].id === product.id) {
                    repeat = true;
                    $scope.cart[i].count += 1;
                }
            }

            if (!repeat) {
                product.count = 1;
                $scope.cart.push(product);
            }
        }
        var expireDate = new Date();
        expireDate.setDate(expireDate.getDate() + 1);
        $cookies.putObject('cart', $scope.cart, { 'expires': expireDate });
        $scope.cart = $cookies.getObject('cart');

        $scope.total += parseFloat(product.price);
        $cookies.put('total', $scope.total, { 'expires': expireDate });
    }

    $scope.removeItemCart = function (product) {

        if (product.count > 1) {
            product.count -= 1;
            var expireDate = new Date();
            expireDate.setDate(expireDate.getDate() + 1);
            $cookies.putObject('cart', $scope.cart, { 'expires': expireDate });
            $scope.cart = $cookies.getObject('cart');
        }
        else if (product.count === 1) {
            var index = $scope.cart.indexOf(product);
            $scope.cart.splice(index, 1);
            expireDate = new Date();
            expireDate.setDate(expireDate.getDate() + 1);
            $cookies.putObject('cart', $scope.cart, { 'expires': expireDate });
            $scope.cart = $cookies.getObject('cart');

        }

        $scope.total -= parseFloat(product.price);
        $cookies.put('total', $scope.total, { 'expires': expireDate });

    };

    // $scope.submit = function () {
    //     $scope.posts().then($scope.reloads());
    // }
    $scope.submit = function () {
        var request;
        for (var i = 0; i < vm.allProducts.length; i++) {
            delete vm.allProducts[i].count;
        }

        console.log(vm.allProducts);
        for (var i = 0; i < vm.allProducts.length; i++) {
            for (var j = 0; j < $scope.cart.length; j++)
                if (vm.allProducts[i].id === $scope.cart[j].id) {
                    repeat = true;
                    vm.allProducts[i].quantity -= $scope.cart[j].count;
                    request = $http.put("http://5ad6e99acd67c10014c73d9d.mockapi.io/product/" + vm.allProducts[i].id, vm.allProducts[i]);
                }
        }
        $cookies.remove("cart");
        $cookies.remove("total");
        request.then(function () {
            $window.location.reload();
        });
    }

    function initController() {
        // initialize to page 1
        vm.setPage(1);
    }

    function setPage(page) {
        if (page < 1 || page > vm.pager.totalPages) {
            return;
        }
        console.log(vm.allProducts);
        // get pager object from service
        vm.pager = PagerService.GetPager(vm.allProducts.length, page);

        // get current page of items
        vm.products = vm.allProducts.slice(vm.pager.startIndex, vm.pager.endIndex + 1);
    }
}

function PagerService() {
    // service definition
    var service = {};

    service.GetPager = GetPager;

    return service;

    // service implementation
    function GetPager(totalItems, currentPage, pageSize) {
        // default to first page
        currentPage = currentPage || 1;

        // default page size is 10
        pageSize = pageSize || 10;

        // calculate total pages
        var totalPages = Math.ceil(totalItems / pageSize);

        var startPage, endPage;
        if (totalPages <= 10) {
            // less than 10 total pages so show all
            startPage = 1;
            endPage = totalPages;
        } else {
            // more than 10 total pages so calculate start and end pages
            if (currentPage <= 6) {
                startPage = 1;
                endPage = 10;
            } else if (currentPage + 4 >= totalPages) {
                startPage = totalPages - 9;
                endPage = totalPages;
            } else {
                startPage = currentPage - 5;
                endPage = currentPage + 4;
            }
        }

        // calculate start and end item indexes
        var startIndex = (currentPage - 1) * pageSize;
        var endIndex = Math.min(startIndex + pageSize - 1, totalItems - 1);

        // create an array of pages to ng-repeat in the pager control
        var pages = _.range(startPage, endPage + 1);

        // return object with all pager properties required by the view
        return {
            totalItems: totalItems,
            currentPage: currentPage,
            pageSize: pageSize,
            totalPages: totalPages,
            startPage: startPage,
            endPage: endPage,
            startIndex: startIndex,
            endIndex: endIndex,
            pages: pages
        };
    }
}