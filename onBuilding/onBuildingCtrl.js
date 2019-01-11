angular.module("aperarteApp")
.controller("onBuildingCtrl", function($scope, onBuildingService) {
	$scope.utenti = onBuildingService.utenti;
});