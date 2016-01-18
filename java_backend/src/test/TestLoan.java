package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import beans.*;

public class TestLoan {

	public static void main(String[] args) {
		Media m0 = new Book("Le chien des baskerville", "Conan Doyle");
		Book m1 = new Book("Disque-Monde", "Terry Pratchett");
		DVD m2 = new DVD("Disque-Monde 2", "Terry Pratchett");
		CD m3 = new CD("Casse-oreilles", "One Diretion");
		
		Loan l0 = new Loan(m0, null, LocalDate.now());
		Loan l1 = new Loan(m1, null, LocalDate.now().plusDays(5));
		Loan l2 = new Loan(m2, null, LocalDate.now().plusMonths(5));
		Loan l3 = new Loan(m3, null, LocalDate.now().plusDays(2));
		
		LoanList list = new LoanList();
		list.add(l0);
		list.add(l3);
		list.add(l2);
		list.add(l1);
		
		ArrayList<Loan> li = list.getLoanList();
		Iterator<Loan> it = li.iterator();
		while(it.hasNext()) {
			Loan elem = it.next();
			System.out.println(elem.getMedia().getTitle() +" ("+ elem.getMedia().getType() +") : "+ elem.getReturnDate().toString());
		}
		
		System.out.println();
		ArrayList<Loan> li2 = list.sortListAsDate();
		Iterator<Loan> it2 = li2.iterator();
		while(it2.hasNext()) {
			Loan elem = it2.next();
			System.out.println(elem.getMedia().getTitle() +" ("+ elem.getMedia().getType() +") : "+ elem.getReturnDate().toString());
		}
		
		System.out.println();
		ArrayList<Loan> li3 = list.sortListAsMedia();
		Iterator<Loan> it3 = li3.iterator();
		while(it3.hasNext()) {
			Loan elem = it3.next();
			System.out.println(elem.getMedia().getTitle() +" ("+ elem.getMedia().getType() +") : "+ elem.getReturnDate().toString());
		}
		
		System.out.println();
		ArrayList<Loan> li4 = list.sortListAsMedia("BOOK");
		Iterator<Loan> it4 = li4.iterator();
		while(it4.hasNext()) {
			Loan elem = it4.next();
			System.out.println(elem.getMedia().getTitle() +" ("+ elem.getMedia().getType() +") : "+ elem.getReturnDate().toString());
		}
	}
}