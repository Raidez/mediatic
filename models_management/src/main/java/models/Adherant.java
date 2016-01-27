package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import exceptions.InvalidMailException;
import util.MailManagement;
import util.datesManagement.DateFormatList;

public class Adherant {
	
	
	private static int ID = 1;
	
	
	private int id;
	private String name;
	private String firstName;
	private LocalDate birthDate;
	private String email;
	private String adress;
	private int postCode;
	private String city;
	private Contribution contribution;
	
	
	//Constructors
	public Adherant(String name, String firstName, LocalDate birthDate, String email, String adress,
			int postCode, String city, Contribution contribution) throws InvalidMailException {
		super();
		
		if(!MailManagement.validate(email))
			throw new InvalidMailException();
		
		this.id = ID;
		this.name = name;
		this.firstName = firstName;
		this.birthDate = birthDate;
		this.email = email;
		this.adress = adress;
		this.postCode = postCode;
		this.city = city;
		this.contribution = contribution;
		
		ID++;
	}
	
	
	public Adherant( String name, String firstName, LocalDate birthDate, String email) throws InvalidMailException {
		super();
		
		if(!MailManagement.validate(email))
			throw new InvalidMailException();
		
		this.id = ID;
		this.name = name;
		this.firstName = firstName;
		this.birthDate = birthDate;
		this.email = email;
		this.adress = "not assigned";
		this.postCode = 0;
		this.city = "not assigned";
		this.contribution = null;
		
		ID++;
	}
	
	
	public Adherant( String name, String firstName, String birthDate, String email) throws InvalidMailException {
		super();
		
		if(!MailManagement.validate(email))
			throw new InvalidMailException();
		
		this.id = ID;
		this.name = name;
		this.firstName = firstName;
		this.birthDate = LocalDate.parse(birthDate);
		this.email = email;
		this.adress = "not assigned";
		this.postCode = 0;
		this.city = "not assigned";
		this.contribution = null;
		
		ID++;
	}
	
	public Adherant( String name, String firstName, String birthDate, String email , DateFormatList dateFormat) throws InvalidMailException {
		super();
		
		if(!MailManagement.validate(email))
			throw new InvalidMailException();
		
		this.id = ID;
		this.name = name;
		this.firstName = firstName;
		this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern(dateFormat.toString()));
		this.email = email;
		this.adress = "not assigned";
		this.postCode = 0;
		this.city = "not assigned";
		this.contribution = null;
		
		ID++;
	}
	
	
	
	


	
	//Getters and Setters
	public int getId() {
		return id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public LocalDate getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	public void setBirthDate(String birthDate) {
		this.birthDate = LocalDate.parse(birthDate);
	}
	
	public void setBirthDate(String birthDate , DateFormatList dateFormat) {
		this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern(dateFormat.toString()));
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	public int getPostCode() {
		return postCode;
	}


	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public Contribution getContribution() {
		return contribution;
	}


	public void setContribution(Contribution contribution) {
		this.contribution = contribution;
	}


	//Other Methods
	@Override
	public String toString() {
		return "Adherant [id=" + id + ", name=" + name + ", firstName=" + firstName + ", birthDate=" + birthDate
				+ ", email=" + email + ", adress=" + adress + ", postCode=" + postCode + ", city=" + city
				+ ", contribution=" + contribution + "]";
	}
	
	
	public boolean validContribution() {
		return (contribution!=null)&&(contribution.isValid());
	}
	
	
	
	

}
