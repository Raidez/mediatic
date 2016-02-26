package fr.iocean.application.loan.repository;

import fr.iocean.application.adherent.model.Adherent;
import fr.iocean.application.loan.model.Loan;
import fr.iocean.application.media.model.Media;

public interface ILoan {
	public Loan insert(Media media , Adherent loaner);	//ou bien des id seulement en param
	public Loan currentLoan(Long media_id);
	public Loan update(Loan loan);
	public Loan returnMedia(Long media_id);
	public Loan delete(Long media_id);
}