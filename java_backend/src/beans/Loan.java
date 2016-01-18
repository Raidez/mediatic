package beans;

import java.time.LocalDate;

public class Loan {
	//attr
	private Media media;
	private Adherant adherant;
	private LocalDate loanDate;
	
	//get
	public Media getMedia() { return this.media; }
	public Adherant getAdherant() { return this.adherant; };
	public LocalDate getDate() { return this.loanDate; }
	
	//constr
	public Loan(Media media, Adherant adherant, LocalDate loanDate) {
		this.media = media;
		this.adherant = adherant;
		this.loanDate = loanDate;
	}
	
	//method
	public LocalDate getReturnDate() {
		LocalDate returnDate = this.loanDate;
		switch(this.media.getType()) {
			case "CD":
			case "DVD":
				returnDate = this.loanDate.plusDays(15);
				break;
			case "Book":
				returnDate = this.loanDate.plusDays(30);
				break;
		}
		return returnDate;
	}
}