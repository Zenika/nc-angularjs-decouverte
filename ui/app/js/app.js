angular.module('myBottles', ['ngRoute'/*, 'Ymagik', 'SimpleRating'*//*, 'ngResource'*/])
.config(function($routeProvider) {
    $routeProvider
        .when('/sandbox', { templateUrl : 'view/sandbox.html' })
        .when('/bottles', { templateUrl : 'view/bottles.html'/*, controller : 'BottleController' */ })
        .otherwise({redirectTo : '/sandbox'});
});