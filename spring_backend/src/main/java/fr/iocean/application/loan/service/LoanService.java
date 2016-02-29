package fr.iocean.application.loan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.iocean.application.adherent.model.Adherent;
import fr.iocean.application.loan.model.Loan;
import fr.iocean.application.loan.repository.ILoan;
import fr.iocean.application.loan.repository.LoanRepository;
import fr.iocean.application.media.model.Media;

@Service
public class LoanService implements ILoan {

	//@Autowired
	private LoanRepository lr;

	@Override
	public Loan insert(Media media, Adherent loaner) {
		return lr.insert(media, loaner);
	}

	@Override
	public Loan currentLoan(Long media_id) {
		return lr.currentLoan(media_id);
	}

	@Override
	public Loan update(Loan loan) {
		return lr.update(loan);
	}

	@Override
	public Loan returnMedia(Long media_id) {
		return lr.returnMedia(media_id);
	}

	@Override
	public Loan delete(Long media_id) {
		return lr.delete(media_id);
	}
	
	
}
