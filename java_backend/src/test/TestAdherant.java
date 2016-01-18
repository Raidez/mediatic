package test;

import beans.Contribution;
import util.datesManagement.DateFormatList;

public class TestAdherant {
	public static void main(String[] args) {
		Contribution c1 = new Contribution();
		Contribution c2 = new Contribution(20, "1992-12-11");
		Contribution c3 = new Contribution(20, "14/12/1992" , DateFormatList.french);
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
	}
}
