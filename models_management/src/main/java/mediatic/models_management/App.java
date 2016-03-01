package mediatic.models_management;

import javax.persistence.EntityManager;

import dao.AdherentDAOImpl;
import dao.EmfSingleton;
import models.Adherent;
import models.Contribution;
import util.datesManagement.DateFormatList;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        EntityManager em = EmfSingleton.getEm();
//        Adherent ad1 = new Adherent();
//        ad1.setBirthDate("14/12/1992",DateFormatList.french);
//        ad1.setName("JESUS");
//        ad1.setFirstName("RATPTOR");
//        ad1.setEmail("jesusraptor@gmail.com");
//        
//        Contribution contribution = new Contribution();
//        contribution.setAmount(10);
//        contribution.setPayementDate("20/01/2014", DateFormatList.french);
//        ad1.setContribution(contribution);
//        System.out.println(ad1);
//        em.getTransaction().begin();
//        System.out.println(em.find(Contribution.class, 2L));
//        em.getTransaction().commit();
//        em.close();
    	
//    	System.out.println("test succes get by id" + AdherentDAOImpl.getById(1));
//    	System.out.println("test debut id succes: " + AdherentDAOImpl.getByIdBeginning(1));
//    	System.out.println("test debut id rien: " + AdherentDAOImpl.getByIdBeginning(8));
//    	System.out.println("test get by name 1 : " + AdherentDAOImpl.getByName("JESUS"));
//    	System.out.println("test get by name 2 : " + AdherentDAOImpl.getByName("JES"));
//    	System.out.println("test get by name injection : " + AdherentDAOImpl.getByName("';DROP TABLE adherent ; '"));
    	
    	
    	
    	Adherent a1 = new Adherent();
    	a1.setBirthDate("1998-07-05");
    	a1.setName("Quichangemesnomputin");
    	a1.setFirstName("Alexis");
    	a1.setEmail("onsenfou2@gmail.com");
    	
    	AdherentDAOImpl.delete(5);
    	System.out.println("test get by name injection : " + AdherentDAOImpl.insert(a1));
    	a1.setName("Fuckboy");
    	AdherentDAOImpl.update(a1);
    }
}
