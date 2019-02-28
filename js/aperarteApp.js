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
  .controller("35frameCtrl", function($scope, $sce, $routeParams) {
	
    $scope.name = '35frameCtrl';
    $scope.params = $routeParams;
	$scope.address = "https://www.mixcloud.com/widget/iframe/?hide_cover=1&light=1&feed=%2Ffederico-zanetti%2F"
	$scope.frameDescList  = 
		[
			{"title":"Federico Zanetti","desc":"Instagram: @zannafede\nFacebook: Federico Zanna\nMail: federico.zanetti.info@gmail.com"},
			{"title":"01 Panorama", "desc" :"Tremezzo, piccolo borgo sul Lago di como.Foto Scattata durante Festa dei Borghi"},
			{"title":"02 Portici", "desc" :""},
			{"title":"03 Arco", "desc" :"Via Bianchi Giovini a Como, collegamento tra piazza Roma e piazza Cavour. In questa foto è possibile apprezzare una simmetria tra i due lati del punto di fuga prospettico, con alla sinistra un bidone della spazzatura e a destra un ignaro passante. Forse una analogia cercata?"},
			{"title":"04 Alessandro Volta", "desc" :"Alessandro Giuseppe Antonio Anastasio Volta (Como, 18 febbraio 1745 – Como, 5 marzo 1827) è stato un chimico, fisico, accademico e rettore italiano, conosciuto soprattutto per l'invenzione del primo generatore elettrico mai realizzato, la pila, e per la scoperta del metano."}, 
			{"title":"05 Dame del Baradello", "desc" :" Foto scattata durante il Palio del Baradello 2018. La posizione privilegiata del broletto sulla manifestazione ha reso possibile assemblare nella foto un gioco di geometrie, che arrivano quasi al punto di collidere. Le dame sono 3 Sono in cerchio, su un quadrato posto su una croce Ci sono le dame, c’è il terreno, c’è il pubblico Riesci a trovare altri trittici?"},
			{"title":"06 San Fedele, Como - Angelo", "desc" :"Tutti sappiamo della Madonnina sopra al Duomo di Milano, dei gargoyles di Notre Dame, ma ci sono molte altre Creature sole e isolate, di cui non sappiamo della loro esistenza."},
			{"title":"07 Como Borghi", "desc" :"Como Borghi 22.30\nUna sera come altre\nTorni da lavoro\nA cena con la tipa\nCalici in compagnia\n\nPassi. Casa. Routine. Buio.\nPoi\nUn’Ombra\n\nAncora legati\nViticci del passato\nAndiamo avanti\nChini su pensieri\nSeduti su convinzioni\nAscoltiamo maschere\nAppese sul volto di nessuno\n\nMany Times, Many Places \nLittle Lines, With no Faces"},
			{"title":"08 Bellagio", "desc" :""},
			{"title":"09 Prospettive d'autunno", "desc" :"Scattata dopo la fine del set di Occultus, diretto dal regista Giorgio Pastore"},
			{"title":"10 little bird", "desc" :"Little bird, Stack on the border"},
			{"title":"11 Trogolo per Piccioni", "desc" :""},
			{"title":"12 Riflessioni", "desc" :"Uomo al bar disperso nei pensieri."},
			{"title":"13 Manichino", "desc" :"Ritratto di un manichino.la luce che arriva dall'alto sembra proiettare l'ombra di un volto umano."},
			{"title":"14 Panchina", "desc" :"Sulle linee verticali da sinistra a destra si vedono un fiore rosso, una coppia e gli altri. Lo sguardo cade su una coppia, scena che riconduce a un film d'amore. Ma lei non sembra scappare dall'abbraccio di lui?"},
			{"title":"15 L'osservatore", "desc" :"Sono tutti passanti, solo tu un osservatore."},
			{"title":"16 Signore giostra", "desc" :"Due donne, un uomo e un bambino, questa foto dovrebbe racchiudere anche il nostro tempo, che rimane nascosto dietro il nuovo."},
			{"title":"17 Palio del Baradello", "desc" :"Non stiamo Litigando, Stiamo discutendo."},
			{"title":"18 Stop", "desc" :"Il soggetto sembra proiettato in avanti, eppure lo sguardo si posa su uno specchio, come se stesse cercando di capire come è arrivato fino a qui."},
			{"title":"19 Sigaretta", "desc" :"Ritratto di un fumatore."},
			{"title":"20 Suonatrice di arpa", "desc" :"Una suonatrice di arpa che pare fermare la frenesia del tempo che ci circonda."},
			{"title":"21 Autoritratto", "desc" :"Chi di voi sa dire chi è? Non è che Voi conoscete solo una stroria che ho deciso io?"},
			{"title":"22 Giullare", "desc" :"Un giullare deve solo far ridere, ma per farlo deve conoscere. "},
			{"title":"23 Red Splice A", "desc" :""},
			{"title":"24 Red Splice B", "desc" :""}			
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
		.when("/35Frame",
			{
				templateUrl: "/Pages/35frame.html",
				controller: "35frameCtrl",
				hideNavbar: true
			}
		)
		
		.otherwise({redirectTo: "/podcast"});
})
;