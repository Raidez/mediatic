package fr.iocean.application.loan.repository;

import java.time.LocalDate;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import fr.iocean.application.adherent.model.Adherent;
import fr.iocean.application.loan.model.Loan;
import fr.iocean.application.media.model.Media;
import fr.iocean.application.util.persistence.AbstractJpaRepository;
@Repository
public class LoanRepository extends AbstractJpaRepository<Loan> implements ILoan  {

	@Override
	protected Class<Loan> getEntityClass() {
		return Loan.class;
	}
	

	@Override
	public Loan insert(Media media, Adherent loaner) {
		Loan l = new Loan(media, loaner, LocalDate.now());
		return super.save(l);
	}

	@Override
	public Loan currentLoan(Long media_id) {
		Criteria crit= super.getSession().createCriteria(Loan.class).add(Restrictions.eq("media_id", media_id));
		return (Loan) crit.uniqueResult();
	}

	@Override
	public Loan update(Loan loan) {
		return super.save(loan);
	}

	@Override
	public Loan returnMedia(Long media_id) {
		Criteria crit= super.getSession().createCriteria(Loan.class).add(Restrictions.eq("media_id", media_id));
		return (Loan) crit.uniqueResult();
	}


	@Override
	public Loan delete(Long media_id) {
		Loan l= this.currentLoan(media_id);
		super.delete(l);
		return l;
	}

}
