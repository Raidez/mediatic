package beans;

public abstract class Media {
	//attr
	private static int counter = 0;
	private int id;
	private String title;
	private String author;
	
	//get
	public int getID() { return this.id; }
	public String getTitle() { return this.title; }
	public String getAuthor() { return this.author; }
	
	//set
	public void setTitle(String title) { this.title = title; }
	public void setAuthor(String author) { this.author = author; }
	
	//constr
	public Media(String title, String author) {
		this.id = counter++; //increment counter for next media
		this.title = title;
		this.author = author;
	}
	
	//method
	public abstract String getType();
}