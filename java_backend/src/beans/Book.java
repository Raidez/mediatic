package beans;

public class Book extends Media {
	public Book(String title, String author) {
		super(title, author);
	}
	
	@Override
	public String getType() {
		return this.getClass().getSimpleName();
	}
}