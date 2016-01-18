package beans;

public class CD extends Media {
	public CD(String title, String author) {
		super(title, author, 15);
	}

	public CD(String title, String author, int loan) {
		super(title, author, loan);
	}

	@Override
	public TypeMedia getType() {
		return TypeMedia.CD;
	}
}