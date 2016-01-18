package beans;

public class DVD extends Media {
	public DVD(String title, String author) {
		super(title, author);
	}
	
	@Override
	public String getType() {
		return this.getClass().getSimpleName();
	}
}