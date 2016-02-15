'use strict';

var app = angular.module('media', ['ngRoute']);

app.config(function ($routeProvider, $httpProvider) {
    $routeProvider.when('/media', {
        templateUrl: 'views/media-view/media.html',
        controller: 'mediaController'
    });
    $httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=UTF8';
});

app.controller('mediaController', function ($http, $routeParams) {
    var ctrl = this;
	/**
	 * utilisé pour temporiser la modification
	 * (cela permet d'enregistrer les modifications de média
	 * (titre, auteur, type) uniquement en cliquant sur 'enregistrer')
	 */

    // TODO: service get media from id
    /*
	var url = "http://192.168.1.14:8080/resource/media.accession";
	$http.get(url).then(function(res) {
		ctrl.media = res.data;
        ctrl.media.type= "CD"; //DEBUG!!
	});*/
	
	/**
	 * lors du click sur 'enregistrer' sur la modal de modif média
	 * on récupère les attributs-tampon de 'tmpModifMedia'
	 * puis on envoie les données au serveur
	 */
    this.applyModifMedia = function () {
        if (ctrl.media) {
            ctrl.media.titre = ctrl.tmpModifMedia.titre;
            ctrl.media.type = ctrl.tmpModifMedia.type;
            ctrl.media.auteur = ctrl.tmpModifMedia.auteur;
			
			ctrl.refreshTmp();
			ctrl.sendPOST();
        }
    };
	
	// récupère une copie profonde du média
    this.refreshTmp = function () {
		if(ctrl.media)
        	ctrl.tmpModifMedia = angular.copy(ctrl.media);
    };
	
	// envoie la modification du média
	this.sendPOST = function () {
        var postUrl = "http://192.168.1.14:8080/resource/media.modification";
        $http.post(postUrl, ctrl.media).success(function () {
            ctrl.message = "Modification Enregistrée";
        });
    };

    this.ajoutEmprunt = function () {
        if (ctrl.media) {
            ctrl.emprunt.adherent.id = ctrl.media.emprunteurs.length + 1; //TODO: côté serveur
            
            //calcul de la date retour selon le type de média
            var dateRetour = new Date(ctrl.emprunt.depart);
            if (ctrl.media.type == 'Livre') {
                dateRetour.setDate(dateRetour.getDate() + 30);
            }
            else {
                dateRetour.setDate(dateRetour.getDate() + 15);
            }
            ctrl.emprunt.retour = dateRetour;

            ctrl.media.emprunteurs.push(angular.copy(ctrl.emprunt)); //ajout à la liste des emprunteurs
			
            $('#ajoutEmprunteur').modal('hide');
            $('#ajoutEmprunteurForm')[0].reset();
			
			ctrl.sendPOST();
        }
    }

	//	loader zone
    this.media = { "id": 10, "titre": "La petite maison dans la prairie", "auteur": "Laura Ingalss Wilder", "type": "Livre", "emprunteurs": [{ "adherent": { "id": 1, "nom": "NicolÃ¨de", "prenom": "Maitre" }, "depart": "2015-01-01 00:00:00.000", "retour": "2015-01-15 00:00:00.000" }, { "adherent": { "id": 2, "nom": "NicolÃ¨de", "prenom": "Cian" }, "depart": "2015-01-17 00:00:00.000", "retour": "2015-02-01 00:00:00.000" }, { "adherent": { "id": 3, "nom": "NicolÃ¨de", "prenom": "Cixi" }, "depart": "2015-01-17 00:00:00.000", "retour": "2015-02-01 00:00:00.000" }, { "adherent": { "id": 4, "nom": "Le troll", "prenom": "HÃ©bus" }, "depart": "2015-01-17 00:00:00.000", "retour": "2015-02-01 00:00:00.000" }] };
    
	ctrl.refreshTmp();
});