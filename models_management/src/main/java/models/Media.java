package models;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name= "media")
public abstract class Media {
	// attr
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String author;
	@Enumerated(EnumType.STRING)
	private TypeMedia type;
	
	@OneToMany(mappedBy = "media")
	private List<Loan> loanList;
	
	

	// get
	public Long getID() {
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

	// constr
	public Media() {
	}

	public Media(String title, String author) {
		this.title = title;
		this.author = author;
	}
}