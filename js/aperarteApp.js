var app = angular.module("aperarteApp", ["ngRoute"])
.config(function($routeProvider) {
	$routeProvider.when("/onBuilding",
			{
				templateUrl: "/onBuilding/onBuilding.html",
				controller: "onBuildingCtrl",
				hideNavbar: true
			}
		)
		.when("/podcast",
			{
				templateUrl: "/podcast/podcast.html",
				controller: "podcastCtrl",
				hideNavbar: true
			}
		)
		
		.otherwise({redirectTo: "/onBuilding"});
})
;