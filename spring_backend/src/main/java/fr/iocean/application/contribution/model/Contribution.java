package fr.iocean.application.contribution.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import fr.iocean.application.adherent.model.Adherent;
import fr.iocean.application.util.dateManagement.DateFormatList;

@Entity
@Table(name = "contribution")
public class Contribution {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private Double amount;
	@Column
	private LocalDate payementDate;
	@Column
	private LocalDate endDate;

	@OneToOne(mappedBy = "contribution")
	private Adherent adherent;

	// Constructors
	// TODO EVENTUEL : test de validite des dates
	// private Contribution(double amount, LocalDate payementDate, LocalDate
	// endDate) {
	// super();
	// this.amount = amount;
	// this.payementDate = payementDate;
	// this.endDate = endDate;
	// }
	//
	// public Contribution(double amount, LocalDate payementDate) {
	// this(amount, payementDate, payementDate.plusYears(1));
	// }
	//
	// public Contribution(double amount, String payementDate, DateFormatList
	// format ) {
	// super();
	// this.amount = amount;
	// this.payementDate = LocalDate.parse(payementDate ,
	// DateTimeFormatter.ofPattern(format.toString()));
	// this.endDate = this.payementDate.plusYears(1);
	// }
	//
	// public Contribution(double amount, String payementDate) {
	// super();
	// this.amount = amount;
	// this.payementDate = LocalDate.parse(payementDate );
	// this.endDate = this.payementDate.plusYears(1);
	// }
	//
	// public Contribution() {
	// this(0, LocalDate.now(), LocalDate.now().plusYears(1));
	// }
	//
	// Getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getPayementDate() {
		return payementDate;
	}

	// La date de fin est mise � jour en fction de la date de paiement
	public void setPayementDate(LocalDate payementDate) {
		this.payementDate = payementDate;
		this.endDate = payementDate.plusYears(1);
	}

	public void setPayementDate(String payementDate) {
		this.setPayementDate(LocalDate.parse(payementDate));
	}

	public void setPayementDate(String payementDate, DateFormatList dateFormat) {
		this.setPayementDate(LocalDate.parse(payementDate, DateTimeFormatter.ofPattern(dateFormat.toString())));
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	// attention : ne pas afficher l'adherent, puisque celui-ci affiche sa
	// cotisation (dépassement mémoire)
	@Override
	public String toString() {
		return "Contribution [amount=" + amount + ", payementDate=" + payementDate + ", endDate=" + endDate + "]";
	}

	public boolean isValid() {
		return this.endDate.isAfter(LocalDate.now());
	}

}
