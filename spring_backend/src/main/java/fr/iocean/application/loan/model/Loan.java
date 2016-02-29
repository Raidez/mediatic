package fr.iocean.application.loan.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.iocean.application.adherent.model.Adherent;
import fr.iocean.application.media.model.Media;
import fr.iocean.application.util.persistence.IoEntity;

@Entity
@Table(name = "loan")
public class Loan  implements IoEntity{
	// attr
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	private Media media;
	@ManyToOne
	private Adherent adherent;
	@Column(nullable = false)
	private LocalDate loanDate;

	// get
	public Long getId() {
		return this.id;
	}

	public Media getMedia() {
		return this.media;
	}


	public Adherent getAdherent() {
		return this.adherent;
	};

	public LocalDate getDate() {
		return this.loanDate;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	// constr
	public Loan() {
	}

	public Loan(Media media, Adherent adherent, LocalDate loanDate) {
		this.media = media;
		this.adherent = adherent;
		this.loanDate = loanDate;
	}

	// method
	public LocalDate getReturnDate() {
		LocalDate dateRetour = null;

		switch (this.media.getType()) {
		default:
		case BOOK:
			dateRetour = this.loanDate.plusDays(30);
			break;
		case CD:
		case DVD:
			dateRetour = this.loanDate.plusDays(15);
			break;
		}
		return dateRetour;
	}
}