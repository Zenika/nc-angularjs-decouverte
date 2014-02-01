angular.module('myBottles', ['ngRoute'])
.config(function($routeProvider) {
    $routeProvider
        .when('/sandbox', { templateUrl : 'view/sandbox.html' })
        .when('/bottles', { templateUrl : 'view/bottles.html'/*, controller : 'BottleController' */ })
        .otherwise({redirectTo : '/sandbox'});
});