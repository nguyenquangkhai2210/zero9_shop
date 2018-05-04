var app = angular.module("homePage", []);

app.controller("navbar", controllerNavbar);

function controllerNavbar ($scope, $rootScope,$timeout) {
    $scope.display = "dsHidden";
    $scope.textColor = "text-white";
    $scope.icon = "navbar-toggler-icon-white";

    $rootScope.$on("clearFromParent", function () {
        $scope.clearColor();
        $scope.clearDropDown();
    });

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

    $scope.clearColor = function (){
        $scope.textColor = "text-white";
        $scope.linkColor = " ";
        $scope.bgColorCount = " ";
    }

    $scope.addColor = function (){
        $scope.textColor = "text-dark";
        $scope.linkColor = "text-dark";
        $scope.bgColorCount = "bg-dark text-white";
    }

    $scope.clearDropDown = function(){
        $scope.choosedInfo = " ";
        $scope.clearColor();
    };
    $scope.chooseInfo = function (choose){
        $scope.choosedInfo = choose;
        $scope.addColor();
    }
}

app.controller("window", function ($scope, $rootScope, $window) {
    $scope.clearColorNav = function () {
        if($window.innerWidth > 991)
            $rootScope.$emit("clearFromParent", {});
    }
});