angular.module("aperarteApp")
.controller("onBuildingCtrl", function($scope, onBuildingService) {
	$scope.utenti = onBuildingService.utenti;
	
	$scope.spreadsheet = "1Ed6A0sDcaiXw2UOqwzBDsOYDCQdVuf6aS-4dcsv6cns";
	$scope.get_data = function(spreadsheet){
        // Using the http class to fetch data. 
        $http({
          url: 'https://spreadsheets.google.com/feeds/list/'+spreadsheet+'/od6/public/values?alt=json',
          method: "GET"
        })
        .then(function(response) {
			console.log(response);
        }
		//ERROR
		function(response) { // optional
          // If there is an error while fetching the data, log to the console. 
          console.log("spreadsheet not found.");
        }
});