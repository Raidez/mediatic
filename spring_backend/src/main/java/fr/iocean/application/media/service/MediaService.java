package fr.iocean.application.media.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.iocean.application.media.model.Media;
import fr.iocean.application.media.model.TypeMedia;
import fr.iocean.application.media.repository.IMedia;
import fr.iocean.application.media.repository.MediaRepository;

@Service
public class MediaService implements IMedia {
	@Autowired
	private MediaRepository mr;

	@Override
	public Media getById(Long id) {
		return mr.getById(id);
	}

	@Override
	public List<Media> getBy(String title, String author, TypeMedia type) {
		return mr.getBy(title, author, type);
	}



	@Override
	public Media insert(Media newMedia) {
		return mr.insert(newMedia);
	}

	@Override
	public Media update(Media newMedia) {
		return mr.update(newMedia);
	}

	@Override
	public Media delete(Long id) {
		return mr.delete(id);
	}
}