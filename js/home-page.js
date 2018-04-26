var shoppingCart = angular.module("shoppingCart", []);

shoppingCart.controller("navbar", function($scope){
    $scope.display = "dsHidden";
    $scope.textColor = "text-white";
    $scope.icon = "navbar-toggler-icon-white";

    $scope.controlMiniBar = function(){
        if($scope.display == "dsHidden"){
            $scope.bgColorNav = "bg-white";
            $scope.display = "dsBlock";
            $scope.textColor = "text-dark";
            $scope.bgColorCount = "bg-dark text-white";
            $scope.icon = "navbar-toggler-icon";
        }
        else{
            $scope.display = "dsHidden";
            $scope.bgColorNav = " ";
            $scope.textColor = "text-white";
            $scope.bgColorCount = " ";
            $scope.icon = "navbar-toggler-icon-white";
        }
    }
});