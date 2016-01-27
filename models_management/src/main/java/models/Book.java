package models;

public class Book extends Media {
	public Book(String title, String author) {
		super(title, author, 30);
	}

	public Book(String title, String author, int loan) {
		super(title, author, loan);
	}

	@Override
	public TypeMedia getType() {
		return TypeMedia.Book;
	}
}