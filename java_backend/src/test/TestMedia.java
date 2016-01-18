package test;

import beans.Book;
import beans.CD;
import beans.DVD;

public class TestMedia {

	public static void main(String[] args) {
		CD c0 = new CD("azert", "Alexis");
		DVD c1 = new DVD("azert", "Alexis");
		CD c2 = new CD("azert", "Paul");
		Book c3 = new Book("azert", "Alexis");
		System.out.println(c0.getID() +": "+ c0.getTitle() +", "+ c0.getType());
		System.out.println(c1.getID() +": "+ c1.getAuthor() +", "+ c1.getType());
		System.out.println(c2.getID() +": "+ c2.getAuthor() +", "+ c2.getType());
		System.out.println(c3.getID() +": "+ c3.getAuthor() +", "+ c3.getType());
	}
}