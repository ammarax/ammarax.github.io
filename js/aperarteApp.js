angular.module("aperarteApp", ["ngRoute"])
.config(function($routeProvider) {
	$routeProvider.when("/onBuilding",
			{
				templateUrl: "/onBuilding/onBuilding.html",
				controller: "onBuildingCtrl"
			}
		)
		.when("/podcast",
			{
				templateUrl: "/podcast/podcast.html",
				controller: "podcastCtrl"
			}
		)
		
		.otherwise({redirectTo: "/onBuilding"});
})
;