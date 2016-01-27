package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LoanList {
	// attr
	private ArrayList<Loan> loanList;

	// get
	public ArrayList<Loan> getLoanList() {
		return this.loanList;
	}

	// constr
	public LoanList() {
		this.loanList = new ArrayList<Loan>();
	}

	// method
	public void add(Loan loan) {
		this.loanList.add(loan);
	}

	public Loan sortAsDate() {
		return this.sortListAsDate().get(0);
	}

	/**
	 * trie les emprunts par date de retour (la plus proche)
	 * 
	 * @return ArrayList<Loan>
	 */
	public ArrayList<Loan> sortListAsDate() {
		ArrayList<Loan> sort = this.loanList;
		Collections.sort(sort, new Comparator<Loan>() {
			public int compare(Loan o1, Loan o2) {
				LocalDate v1 = o1.getReturnDate();
				LocalDate v2 = o2.getReturnDate();
				return v1.compareTo(v2);
			}

		});
		return sort;
	}

	/**
	 * trie la liste des emprunts par type de m�dia (ordre alphab�tique (Book,
	 * CD, DVD))
	 * 
	 * @return ArrayList<Loan>
	 */
	public ArrayList<Loan> sortListAsMedia() {
		ArrayList<Loan> sort = this.loanList;
		Collections.sort(sort, new Comparator<Loan>() {
			public int compare(Loan o1, Loan o2) {
				TypeMedia v1 = o1.getMedia().getType();
				TypeMedia v2 = o2.getMedia().getType();
				return v1.compareTo(v2);
			}

		});
		return sort;
	}

	/**
	 * filtre la liste par m�dia choisi
	 * 
	 * @param media
	 *            (insensible � la casse)
	 * @return ArrayList<Loan>
	 */
	public ArrayList<Loan> sortListAsMedia(TypeMedia media) {
		ArrayList<Loan> sort = new ArrayList<Loan>();
		for (Loan loan : this.loanList) {
			TypeMedia compare = loan.getMedia().getType();
			if (media.equals(compare))
				sort.add(loan);
		}
		return sort;
	}
}