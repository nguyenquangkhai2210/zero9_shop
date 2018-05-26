var navbarComponent = {
    bindings: {
        navbar: '<'
    },
    controller: function ($scope, $window, $cookies, $route, $anchorScroll) {
        $scope.productType = ['hat', 'shirt', 'pants', 'shoes', 'accessories'];
        $scope.productsData = [{
            id: 1,
            name: 'product1',
            price: 100.0,
            image: './img/nav-content-info/Etq-Amsterdam-Fitpic-Low-3-Ash-1-1-750x0-c-default.jpg',
            info: 'Lorem ipsum dolor sit amet consectetur, adipisicing elit',
        }, {
            id: 2,
            name: 'product2',
            price: 14.5,
            image: './img/nav-content-info/Etq-Amsterdam-Fitpic-Low-3-Ash-1-1-750x0-c-default.jpg',
            info: 'Lorem ipsum dolor sit amet consectetur, adipisicing elit',
        }, {
            id: 3,
            name: 'product3',
            price: 100.43,
            image: './img/nav-content-info/Etq-Amsterdam-Fitpic-Low-3-Ash-1-1-750x0-c-default.jpg',
            info: 'Lorem ipsum dolor sit amet consectetur, adipisicing elit',
        }, {
            id: 4,
            name: 'product4',
            price: 99.9,
            image: './img/nav-content-info/Etq-Amsterdam-Fitpic-Low-3-Ash-1-1-750x0-c-default.jpg',
            info: 'Lorem ipsum dolor sit amet consectetur, adipisicing elit',
        }];

        $scope.display = "dsHidden";
        $scope.textColor = "text-white";
        $scope.icon = "navbar-toggler-icon-white";

        this.$onInit = function () {
            if (this.navbar == "blackColor") {
                $scope.addColor();
            }
        }

        var handler;

        handler = function () {
            if ($window.pageYOffset > 10) {
                $scope.bgScroll = "bgScroll";
                $scope.filter = "positionFixed";
                $route.reload();
            }
            else {
                $scope.bgScroll = " ";
                $scope.filter = " ";
                $route.reload();
            }
        };

        angular.element($window).on('scroll', handler);

        $scope.controlMiniBar = function () {
            if ($scope.display == "dsHidden") {
                $scope.bgColorNav = "bg-white";
                $scope.display = "dsBlock";
                $scope.icon = "navbar-toggler-icon";
                $scope.addColor();
            }
            else {
                $scope.display = "dsHidden";
                $scope.bgColorNav = " ";
                $scope.icon = "navbar-toggler-icon-white";
                $scope.clearColor();
            }
        }

        $scope.clearColor = function () {
            $scope.textColor = "text-white";
            $scope.linkColor = " ";
            $scope.bgColorCount = " ";
        }

        $scope.addColor = function () {
            $scope.textColor = "text-dark";
            $scope.linkColor = "text-dark";
            $scope.bgColorCount = "bg-dark text-white";
        }

        $scope.clearDropDown = function () {
            $scope.choosedInfo = " ";
            this.$onInit = function () {
                if (this.navbar !== "blackColor") {
                    $scope.clearColor();
                }
            }

        };
        $scope.chooseInfo = function (choose) {
            $scope.choosedInfo = choose;
            $scope.addColor();
            flag = 0;
        }

        var flag = 0;
        $scope.openSwitch = function () {
            flag = -1;
        }
        $scope.clearColorNav = function () {
            if ($window.innerWidth > 991) {
                flag *= -1;
                if (flag) {
                    $scope.clearDropDown();
                    flag = 0;
                }
            }
        }

        $scope.cart = [];
        $scope.count = 0;

        if (!angular.isUndefined($cookies.get('total'))) {
            $scope.total = parseFloat($cookies.get('total'));
        }

        if (!angular.isUndefined($cookies.get('cart'))) {
            $scope.cart = $cookies.getObject('cart');
        }

        $window.onclick = function () {
            try {
                $scope.cart = $cookies.getObject('cart');
                $scope.count = $scope.cart.length;
                $route.reload();
            } catch (err) {
            }
        }

    },
    templateUrl: './component/navbar/navbar.component.html'
}

angular.module('navBar')
    .component('navbar', navbarComponent)
