'use strict';

var app = angular.module('media', ['ngRoute']);

app.config(function ($routeProvider) {
	$routeProvider.when('/media', {
		templateUrl: 'views/media-view/media.html',
		controller: 'mediaController'
	});
});

app.controller('mediaController', function ($http, $routeParams, $scope) {
	var ctrl = this;
	// TODO: service get media from id
    /*
	var url = "http://192.168.1.14:8080/resource/media.accession";
	$http.get(url).then(function(res) {
		ctrl.media = res.data;
        ctrl.media.type= "CD"; //DEBUG!!
	});*/
    
	this.modifMedia = function() {
		if(ctrl.media) {
			ctrl.media.titre = ctrl.tmp.titre;
			ctrl.media.type = ctrl.tmp.type;
			ctrl.media.auteur = ctrl.tmp.auteur;
			
			ctrl.tmp = angular.copy(ctrl.media);
		}
	};
	this.refresh = function() {
		ctrl.tmp = angular.copy(ctrl.media);
	};
	
    this.ajoutEmprunt = function(callback) {
        /*
        id->get
        date retour -> calcul
        *nom,prénom,date d'emprunt -> set
        
        */
        if(ctrl.media) {
            ctrl.emprunt.adherent.id = ctrl.media.emprunteurs.length + 1; //TODO: côté serveur
            
            //calcul de la date retour selon le type de média
            var dateRetour = new Date(ctrl.emprunt.depart);
            if(ctrl.media.type == 'Livre') {
                dateRetour.setDate(dateRetour.getDate() + 30);
            }
            else {
                dateRetour.setDate(dateRetour.getDate() + 15);
            }
            ctrl.emprunt.retour = dateRetour;
			
            ctrl.media.emprunteurs.push(angular.copy(ctrl.emprunt)); //ajout à la liste des emprunteurs
            callback();
        }
    }
	
	this.media = { "id": 10, "titre": "La petite maison dans la prairie", "auteur": "Laura Ingalss Wilder", "type": "Livre", "emprunteurs": [{ "adherent": { "id": 1, "nom": "NicolÃ¨de", "prenom": "Maitre" }, "depart": "2015-01-01 00:00:00.000", "retour": "2015-01-15 00:00:00.000" }, { "adherent": { "id": 2, "nom": "NicolÃ¨de", "prenom": "Cian" }, "depart": "2015-01-17 00:00:00.000", "retour": "2015-02-01 00:00:00.000" }, { "adherent": { "id": 3, "nom": "NicolÃ¨de", "prenom": "Cixi" }, "depart": "2015-01-17 00:00:00.000", "retour": "2015-02-01 00:00:00.000" }, { "adherent": { "id": 4, "nom": "Le troll", "prenom": "HÃ©bus" }, "depart": "2015-01-17 00:00:00.000", "retour": "2015-02-01 00:00:00.000" }] };
	this.tmp = angular.copy(ctrl.media);
});