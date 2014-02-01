angular.module('myBottles')
.controller('BottleController', function BottleController($scope, $resource) {
    // Create a new Resource object
    var Bottle = $resource('/api/bottle/:bottleId', {bottleId:'@id'});

    // load bottle from REST interface with Resource object
    $scope.bottles = Bottle.query();

    $scope.newBottle = function () {
        var bottle = {
            name : '',
            description: '',
            rate : 1
        }
        // Create resource object from bottle
        $scope.currentBottle = new Bottle(bottle);
    };

    $scope.createBottle = function () {
        // Save current object
        $scope.currentBottle.$save(function(bottle) {
            $scope.currentBottle = bottle;
            $scope.bottles = Bottle.query();
        });
    };

    $scope.changeCurrentBottle = function(id) {
        // Display the bottle from id
        $scope.currentBottle = Bottle.get({bottleId:id});
    };

    $scope.delete = function() {
        // Delete current object from server and update bottles list
        $scope.currentBottle.$delete(function(){
            //refresh bottles list
            $scope.bottles = Bottle.query();
            // clear view with a new bottle
            $scope.newBottle();
        });
    };

    $scope.newBottle();
});