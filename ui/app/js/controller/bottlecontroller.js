angular.module('myBottles')
.controller('BottleController', function BottleController($scope, $http) {
    $scope.bottles = [];
    // download data from server
    $http.get('data.json').success(function(bottles) {
        $scope.bottles = bottles;
    });

    $scope.newBottle = function () {
        // replace current by a new empty object
        $scope.currentBottle = {
            name : '',
            description: '',
            rate : 1
        };
    };

    $scope.createBottle = function () {
        //if current object doesn't exist (no id), create it and give index as id
        if( $scope.currentBottle.id == undefined ) {
            $scope.currentBottle.id = $scope.bottles.length;
            $scope.bottles.push($scope.currentBottle);
        }
        // clear view
        $scope.newBottle();
    };

    $scope.changeCurrentBottle = function(id) {
        $scope.currentBottle = $scope.bottles[id];
    };

    $scope.newBottle();
});