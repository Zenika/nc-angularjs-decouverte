angular.module('myBottles')
.controller('BottleController', function BottleController($scope, $http) {
    $scope.bottles = [];

    //TODO load bottles list from server

    $scope.newBottle = function () {
        $scope.currentBottle = {
            name : '',
            description: '',
            rate : 1
        };
    };

    $scope.createBottle = function () {
        //TODO add a bottle to list

        //TODO clear view to enter a new bottle
    };

    $scope.changeCurrentBottle = function(id) {
        //TODO display current bottle
    };

    $scope.newBottle();
});