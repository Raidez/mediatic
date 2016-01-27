package dao;


import models.Adherent;
import models.Loan;
import models.Media;

public interface ILoanDAO {
	public Loan insert(Media media , Adherent loaner);	//ou bien des id seulement en param
	public Loan currentLoan(Media media);
	public Loan update(Loan loan);
	public Loan returnMedia(long id_media);
	
}
