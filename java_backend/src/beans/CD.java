package beans;

public class CD extends Media {
	public CD(String title, String author) {
		super(title, author);
	}
	
	@Override
	public String getType() {
		return this.getClass().getSimpleName();
	}
}