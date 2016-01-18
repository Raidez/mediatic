package beans;

public class DVD extends Media {
	public DVD(String title, String author) {
		super(title, author, 15);
	}

	public DVD(String title, String author, int loan) {
		super(title, author, loan);
	}

	@Override
	public TypeMedia getType() {
		return TypeMedia.DVD;
	}
}