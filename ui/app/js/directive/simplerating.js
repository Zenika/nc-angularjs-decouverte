/**
 * https://github.com/Taranys/simplerating
 */
angular.module('SimpleRating', [])
    .directive('simpleRating', function () {
        return {
            restrict: 'A',
            template: '<ul style="padding: 0">' +
                '<li ng-repeat="star in stars" style="color: #FFD700" ng-style="getCursor()" class="glyphicon" ng-class="getStarClass($index)" ng-click="click($index)"></li>' +
                '</ul>',
            scope: {
                rating: "=",
                ratingMax: "=",
                readOnly: "="
            },
            link: function ($scope) {
                $scope.getStarClass = function (index) {
                    return ($scope.rating >= index) ? 'glyphicon-star' : 'glyphicon-star-empty';
                };

                $scope.getCursor = function() {
                    return { cursor : ($scope.readOnly?'not-allowed':'pointer') };
                };

                $scope.$watch('rating', function () {
                    $scope.stars = [];
                    for (var i = 0; i < $scope.ratingMax; i++) {
                        $scope.stars.push({});
                    }
                });

                $scope.click = function (starRating) {
                    if (!$scope.readOnly) {
                        $scope.rating = starRating;
                    }
                };
            }
        };
    });