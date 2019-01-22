angular.module('demo', [])
.controller('Hello', function($scope, $http) {
    $http.get('http://127.0.0.1:8080/greeting').
        then(function(response) {
            $scope.greeting = response.data;
        });
});