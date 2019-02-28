var app = angular.module("app", ["ngRoute"]);
app
 .controller('MainController', function($scope, $route, $routeParams, $location) {
     $scope.$route = $route;
     $scope.$location = $location;
     $scope.$routeParams = $routeParams;
 })
 .controller("podcastCtrl", function($scope, $sce, $routeParams) {
	
    $scope.name = 'podcastCtrl';
    $scope.params = $routeParams;
	$scope.address = "https://www.mixcloud.com/widget/iframe/?hide_cover=1&light=1&feed=%2Ffederico-zanetti%2F"
	$scope.podcastList  = 
		[
		"aperarte-ep-5-francesca-lucioni-curatela-di-cities-2%2F",
		"aperarte-ep-4-nella-mente-di-psycho-boss%2F",
		"aperarte-ep-3-nel-atelier-di-ester-negretti%2F",
		"aperarte-ep-2-damiano-riva-e-la-fotografia%2F",
		"aperarte-ep-1-dario-luzzani-e-la-mostra-frammenti%2F",
		"aperarte-ep-0-mr-savethewall-e-la-post-street-art%2F"
		];
	 $scope.trustAsUrl = function(url){
		return $sce.trustAsResourceUrl($scope.address + url)
     }
  })
 .config(function($routeProvider) {
	$routeProvider
		.when("/podcast",
			{
				templateUrl: "/podcast/podcast.html",
				controller: "podcastCtrl",
				hideNavbar: true
			}
		)
		
		.otherwise({redirectTo: "/podcast"});
})
;