package fr.iocean.application.media.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.iocean.application.loan.model.Loan;
import fr.iocean.application.util.persistence.IoEntity;

@Entity
@Table(name = "media")
public class Media implements IoEntity {
	// attr
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private String author;
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private TypeMedia type;

	public void setType(TypeMedia type) {
		this.type = type;
	}

	@OneToMany(mappedBy = "media", fetch = FetchType.EAGER)
	private List<Loan> loanList;

	// TODO
	// private Loan currentLoan; utiliser @Formula

	public List<Loan> getLoanList() {
		return loanList;
	}

	public void setLoanList(List<Loan> loanList) {
		this.loanList = loanList;
	}

	// get
	public Long getId() {
		return this.id;
	}

	public String getTitle() {
		return this.title;
	}

	public String getAuthor() {
		return this.author;
	}

	public TypeMedia getType() {
		return this.type;
	}

	// set
	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// constr
	public Media() {
	}

	public Media(String title, String author) {
		this.title = title;
		this.author = author;
	}
}