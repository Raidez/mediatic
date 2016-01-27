package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import util.datesManagement.DateFormatList;

@Entity
@Table(name="adherent")
public class Adherent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String firstName;
	@Column(nullable=false)
	private LocalDate birthDate;
	@Column(nullable=false)
	private String email;
	@Column
	private String adress;
	@Column
	private int postCode;
	@Column
	private String city;
	@OneToOne()
	private Contribution contribution;

	@OneToMany(mappedBy = "adherent")
	private List<Loan> loanList;



	
	//Getters and Setters
	public Long getId() {
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
