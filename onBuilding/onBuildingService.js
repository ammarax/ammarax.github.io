angular.module("aperarteApp")
.factory("onBuildingService", function() {
	var self = {};
	self.utenti = [{ id:1, nome: "Andrea",   cognome: "Rossi",  citta: "Roma"    },
                   { id:2, nome: "Marco",    cognome: "Verdi",  citta: "Milano"  },
				   { id:3, nome: "Giovanni", cognome: "Neri",   citta: "Napoli"  },
				   { id:4, nome: "Roberto",  cognome: "Gialli", citta: "Palermo" }];
	return self;
});