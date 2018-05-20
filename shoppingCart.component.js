var shoppingCart = {
    template: `
        <div>
            <h1>CART-SHOW</h1>
            <span>
                {{count2}}
            </span>
        </div>
    `,

    controller: function ($scope,$cookies, $window){
        $scope.cart = [];
        $scope.count2 = 0;

        $window.onclick = function(){
            console.log($scope.count2);
            $scope.cart = $cookies.getObject('cart');
            $scope.count2 = $scope.cart.length;
            console.log($scope.count2);
        }
    }
}

angular.module('shoppingCart')
    .component('shoppingCart', shoppingCart);