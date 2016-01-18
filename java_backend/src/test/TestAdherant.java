package test;

import beans.Adherant;
import beans.Contribution;
import exceptions.InvalidMailException;
import util.datesManagement.DateFormatList;

public class TestAdherant {
	public static void main(String[] args) {
		Contribution c1 = new Contribution();
		Contribution c2 = new Contribution(20, "1992-12-11");
		Contribution c3 = new Contribution(20, "14/12/1992" , DateFormatList.french);
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		
		System.out.println(c1.isValid());
		System.out.println(c3.isValid());
		
		//test normal
		try {
			Adherant a1 = new Adherant("Verite" , "Hugo" , "2015-12-14" , "veritehugo@gmail.com");
			System.out.println(a1);
		} catch (InvalidMailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//test mail invalide
		try {
			Adherant a1 = new Adherant("Verite" , "Hugo" , "2015-12-14" , "veritehugo");
			System.out.println(a1);
		} catch (InvalidMailException e) {
			System.err.println("mail invalide");
		}
	}
}
