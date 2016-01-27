package dao;

import java.util.List;

import models.Media;
import models.TypeMedia;

public interface MediaDAO {
	public Media getById(long id);
	public List<Media> getByTitle(String title);	//type contient
	public List<Media> getByAuthor(String author);	//type contient
	public List<Media> getByType(TypeMedia media);
	public Media insert(Media newAdherent);
	public Media update(Media newAdherent);
	public Media delete(long id);
}
