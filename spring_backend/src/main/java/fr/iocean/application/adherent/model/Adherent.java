package fr.iocean.application.adherent.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import fr.iocean.application.persistence.GenericEntity;
import fr.iocean.application.persistence.util.date.LocalDateConverter2;



@Entity
@Table(name="adherent")
public class Adherent implements GenericEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3108200830137429187L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable=false)
	@NotBlank
	private String name;
	@Column(nullable=false)
	@NotBlank
	private String firstName;
	@Column(nullable=false)
	private Date birthDate;
	@Column(nullable=false)
	@NotBlank
	@Email
	private String email;
	@Column
	private String adress;
	@Column
	private int postCode;
	@Column
	private String city;
	@Column
	private Double amount;
	@Column
	private Date payementDate;


//	@OneToMany(mappedBy = "adherent")
//	private List<Loan> loanList;



	
	//Getters and Setters
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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


//	public LocalDate getBirthDate() {
//		return birthDate;
//	}
//
//
//	public void setBirthDate(LocalDate birthDate) {
//		this.birthDate = birthDate;
//	}
//	
//	public void setBirthDate(int [] birthDate) {
//		this.birthDate = LocalDate.of(birthDate[0], birthDate[1], birthDate[2]);
//	}
//	


	
//	public void setBirthDate(String birthDate , DateFormatList dateFormat) {
//		this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern(dateFormat.toString()));
//	}


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
	
	
	
	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getPayementDate() {
		return payementDate;
	}

	public void setPayementDate(Date payementDate) {
		this.payementDate = payementDate;
	}


//	public LocalDate getPayementDate() {
//		return payementDate;
//	}
//
//
//	public void setPayementDate(LocalDate payementDate) {
//		this.payementDate = payementDate;
//	}
//	
//	public void setPayementDate(int [] payementDate) {
//		this.payementDate = LocalDate.of(payementDate[0], payementDate[1], payementDate[2]);
//	}
//
//
	@JsonProperty
	public Date getEndDate() {
		return LocalDateConverter2.toDate(LocalDateConverter2.toLocalDate(payementDate).plusYears(1));
	}
//
//	
//	
//	
//	public boolean validContribution() {
//		return this.getEndDate().isAfter(LocalDate.now());
//	}
	
	
	
	

}
