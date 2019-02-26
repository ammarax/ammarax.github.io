app.controller("onBuildingCtrl", function($scope, onBuildingService) {
	$scope.utenti = onBuildingService.utenti;
});