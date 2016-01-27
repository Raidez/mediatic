package models;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "loan")
public class Loan {
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
	private LocalDate returnDate;

	// get
	public Long getID() {
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
	public LocalDate getReturnDate() {
		return this.returnDate;
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
	public LocalDate getCalculatedDate() {
		LocalDate dateRetour = null;

		switch (this.media.getType()) {
		default:
		case Book:
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