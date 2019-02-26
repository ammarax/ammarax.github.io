app.factory("podcastService", function() {
	var self = {};
	self.utenti = [{ id:1, nome: "Andrea",   cognome: "Rossi",  citta: "Roma"    },
                   { id:2, nome: "Marco",    cognome: "Verdi",  citta: "Milano"  },
				   { id:3, nome: "Giovanni", cognome: "Neri",   citta: "Napoli"  },
				   { id:4, nome: "Roberto",  cognome: "Gialli", citta: "Palermo" }];
	self.getData = 
	function(spreadsheet){
        // Using the http class to fetch data. 
		console.log("enter function");
/*  
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
*/
	}
	
	self.data = self.getData();
	return self;
});