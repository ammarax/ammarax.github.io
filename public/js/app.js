var app = angular.module('exampleApp', []);
app.controller('LoggedUserController', function LoggedUserController($scope, $http) {
//    $http.get('http://127.0.0.1:8080/loggedUsers').
//        then(function(response) {
//            $scope.loggedUsers = response;
//        });
	
//	$scope.loggedUsers = [
//	    {
//	      name: 'Nexus S',
//	      code: 'Fast just got faster with Nexus S.'
//	    }, {
//	      name: 'Motorola XOOM™ with Wi-Fi',
//	      code: 'The Next, Next Generation tablet.'
//	    }, {
//	      name: 'MOTOROLA XOOM™',
//	      code: 'The Next, Next Generation tablet.'
//	    }
//	  ];
	$http({
		method : "GET",
		headers: {
			'Content-Type': 'application/json'
		},
		url : 'http://127.0.0.1:8080/loggedUsers',
		params : {username : 'user', password : 'password'} })
	.then(function(response) {
		$scope.loggedUsers = response;
	});
});