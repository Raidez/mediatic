package fr.iocean.application.media.repository;

import java.util.List;

import fr.iocean.application.media.model.Media;
import fr.iocean.application.media.model.TypeMedia;

public interface IMedia {
	public Media getById(Long id);
	public List<Media> getByTitle(String title);	//type contient
	public List<Media> getByAuthor(String author);	//type contient
	public List<Media> getByType(TypeMedia media);
	public Media insert(Media newMedia);
	public Media update(Media newMedia);
	public Media delete(Long id);
}