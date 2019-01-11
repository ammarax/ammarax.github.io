angular.module("aperarteApp", ["ngRoute"])
.config(function($routeProvider) {
	$routeProvider.when("/onBuilding",
			{
				templateUrl: "/onBuilding/onBuilding.html",
				controller: "onBuildingCtrl"
			}
		)
		.otherwise({redirectTo: "/onBuilding"});
})
;