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
	@Transient
	private Adherant adherant;
	private LocalDate loanDate;

	// get
	public Long getID() {
		return this.id;
	}

	public Media getMedia() {
		return this.media;
	}

	public Adherant getAdherant() {
		return this.adherant;
	};

	public LocalDate getDate() {
		return this.loanDate;
	}

	// constr
	public Loan() {
	}

	public Loan(Media media, Adherant adherant, LocalDate loanDate) {
		this.media = media;
		this.adherant = adherant;
		this.loanDate = loanDate;
	}

	// method
	public LocalDate getReturnDate() {
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