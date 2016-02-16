'use strict';

var app = angular.module('media', ['ngRoute']);

app.config(function ($routeProvider, $httpProvider) {
    $routeProvider.when('/media/:id', {
        templateUrl: 'views/media-view/media.html',
        controller: 'mediaController'
    });
   
});

app.controller('mediaController', function ($http, $routeParams, serviceMedia) {
    var ctrl = this;
    
	/**
	 * utilisé pour temporiser la modification
	 * (cela permet d'enregistrer les modifications de média
	 * (titre, auteur, type) uniquement en cliquant sur 'enregistrer')
	 */
	
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
        if (ctrl.media)
            ctrl.tmpModifMedia = angular.copy(ctrl.media);
    };
	
    // envoie la modification du média
    this.sendPOST = function () {
        serviceMedia.postModif(ctrl.media);
    };
    
    // fonction de creation de nouveau emprunteur
    this.ajoutEmprunt = function () {
        if (ctrl.media) {
            ctrl.emprunt.adherent.id = ctrl.media.emprunteurs[ctrl.media.emprunteurs.length - 1].adherent.id + 1; //calcul de l'id du nouveau emprunteur
           
            //calcul de la date retour selon le type de média
            var dateRetour = new Date(ctrl.emprunt.depart);
            if (ctrl.media.type == 'Livre')
                dateRetour.setDate(dateRetour.getDate() + 30);
            else
                dateRetour.setDate(dateRetour.getDate() + 15);
                
            ctrl.emprunt.retour = dateRetour;

            ctrl.media.emprunteurs.push(angular.copy(ctrl.emprunt)); //ajout à la liste des emprunteurs
			
            // cache et reset la modal
            $('#ajoutEmprunteur').modal('hide');
            $('#ajoutEmprunteurForm')[0].reset();

            ctrl.sendPOST();
        }
    };

    //	loader zone
    serviceMedia.getMedia($routeParams.id, false).then(function (data) {
        ctrl.media = data;
        ctrl.refreshTmp();
    });
});