package beans;

import java.time.LocalDate;

public class Loan {
	// attr
	private Media media;
	private Adherant adherant;
	private LocalDate loanDate;

	// get
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
	public Loan(Media media, Adherant adherant, LocalDate loanDate) {
		this.media = media;
		this.adherant = adherant;
		this.loanDate = loanDate;
	}

	// method
	public LocalDate getReturnDate() {
		return this.loanDate.plusDays(this.media.getLoanDays());
	}
}