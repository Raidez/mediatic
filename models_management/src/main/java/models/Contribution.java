package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import util.datesManagement.DateFormatList;


public class Contribution {
	
	private double amount;
	private LocalDate payementDate;
	private LocalDate endDate;
	
	
	
	//Constructors
	//TODO EVENTUEL : test de validite des dates
	private Contribution(double amount, LocalDate payementDate, LocalDate endDate) {
		super();
		this.amount = amount;
		this.payementDate = payementDate;
		this.endDate = endDate;
	}
	
	public Contribution(double amount, LocalDate payementDate) {
		this(amount, payementDate, payementDate.plusYears(1));
	}
	
	public Contribution(double amount, String payementDate, DateFormatList format ) {
		super();
		this.amount = amount;
		this.payementDate = LocalDate.parse(payementDate  , DateTimeFormatter.ofPattern(format.toString()));
		this.endDate = this.payementDate.plusYears(1);
	}
	
	public Contribution(double amount, String payementDate) {
		super();
		this.amount = amount;
		this.payementDate = LocalDate.parse(payementDate );
		this.endDate = this.payementDate.plusYears(1);
	}
	
	public Contribution() {
		this(0, LocalDate.now(), LocalDate.now().plusYears(1));
	}
	
	//Getters and setters
	
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getPayementDate() {
		return payementDate;
	}
	
	//La date de fin est mise � jour en fction de la date de paiement
	public void setPayementDate(LocalDate payementDate) {
		this.payementDate = payementDate;
		this.endDate = payementDate.plusYears(1);
	}
	
	public void setPayementDate(String payementDate) {
		this.setPayementDate(LocalDate.parse(payementDate));
	}
	
	public void setBirthDate(String payementDate , DateFormatList dateFormat) {
		this.setPayementDate(LocalDate.parse(payementDate, DateTimeFormatter.ofPattern(dateFormat.toString())));
	}
	
	
	
	public LocalDate getEndDate() {
		return endDate;
	}

	@Override
	public String toString() {
		return "Contribution [amount=" + amount + ", payementDate=" + payementDate + ", endDate=" + endDate + "]";
	}

	
	
	public boolean isValid() {
		return this.endDate.isAfter(LocalDate.now());
	}

}
