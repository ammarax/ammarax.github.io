app.controller("podcastCtrl", function($scope, podcastService) {
	
	$scope.utenti = podcastService.utenti;
	$scope.get_data = podcastService.data;
});