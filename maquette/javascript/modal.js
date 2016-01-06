/**
 * 
 */

(function() {
	$(document).ready(function() {
		//enregistrement du nouvel item
		$("#enregistrerButton").click(function() {
			$("#submitButton").trigger("click");
		});
		
		$("#dateNaissance").change(function(eve) {
			var nais = moment($("#"+eve.currentTarget.id).val());
			var age = moment().diff(nais,'years');
			
			$("#labelAge").text(age + " ans");
		});
		
		
		$("#datePaiement").change(function(eve) {
			var dateFin = moment($("#"+eve.currentTarget.id).val()).add(1, 'year');
			$("#labelFinAbonnement").removeClass("hidden");
			$("#labelFinAbonnement").text("Date de fin d'abonnement : " + dateFin.format("DD/MM/YYYY"));
			
		});
		
		$('[data-toggle="tooltip"]').tooltip();
	});
})();