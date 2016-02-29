package fr.iocean.application.media.repository;

import java.util.List;

import fr.iocean.application.media.model.Media;
import fr.iocean.application.media.model.TypeMedia;

public interface IMedia {
	public Media getById(Long id);
	public List<Media> getBy(String title, String author, TypeMedia type);	//type contient
	public Media insert(Media newMedia);
	public Media update(Media newMedia);
	public Media delete(Long id);
}