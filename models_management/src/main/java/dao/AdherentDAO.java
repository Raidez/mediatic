package dao;

import java.util.List;

import models.Adherent;

public interface AdherentDAO {
	public Adherent getById(long id);
	public List<Adherent> getByIdBeginning(long id);
	public List<Adherent> getByName(String name); //recherche de type contient
	public List<Adherent> getByFirstName(String firstName);	//facultatif
	public Adherent insert(Adherent newAdherent);
	public Adherent update(Adherent newAdherent);
	public Adherent delete(long id);
}
