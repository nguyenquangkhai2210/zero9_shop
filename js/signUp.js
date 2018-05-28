var app = angular.module('signUp', ['navBar', 'ngCookies', 'ngRoute']);
app.controller('submitForm', function ($scope) {
    // $scope.speciality = ["Software engineer", "Business"];
    $scope.user = { sex: 'Male' };

    // $scope.backgroundColor = function () {
    //     var arrObj = Object.keys($scope.user);
    //     for (var i = 0; i < arrObj.length; i++)
    //         if ($scope.user[arrObj[i]] == null)
    //             delete $scope.user[arrObj[i]];
    //     return 'color' + Object.keys($scope.user).length;
    // }
    $scope.submit = function () {
        alert("Finish");
    }
});