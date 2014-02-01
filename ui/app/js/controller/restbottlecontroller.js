angular.module('myBottles')
.controller('BottleController', function BottleController($scope, $resource) {
    //TODO Create a new Resource object

    $scope.bottles = [];
    //TODO load bottle from REST interface with Resource object

    $scope.newBottle = function () {
        var bottle = {
            name : '',
            description: '',
            rate : 1
        }
        //TODO Create resource object from bottle
    };

    $scope.createBottle = function () {
        //TODO Save current object
    };

    $scope.changeCurrentBottle = function(id) {
        //TODO Display the bottle from id
    };

    $scope.delete = function() {
        //TODO Delete current object from server and upadte bottles list
        //TODO clear view with a new bottle
    };

    $scope.newBottle();
});