package fr.iocean.application.media.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import antlr.Utils;
import fr.iocean.application.media.model.Media;
import fr.iocean.application.media.model.TypeMedia;
import fr.iocean.application.media.service.MediaService;

@RestController
@RequestMapping("/media")
public class MediaController {

	@Autowired
	private MediaService ms;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void addMedia(@RequestBody Media media) {
		this.ms.insert(media);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Media getMediaById(@PathVariable Long id) {
		return this.ms.getById(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Media> getMediaByOther(@RequestParam(required = false) String title,
			@RequestParam(required = false) String author, @RequestParam(required = false) TypeMedia type) {
		return this.ms.getBy(title, author, type);

	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Media mediaUpdate(@PathVariable Long id, @RequestBody Media media) {
		Media mr = getMediaById(id);
		if (!StringUtils.isEmpty(media.getTitle()))
			mr.setTitle(media.getTitle());
		if (!StringUtils.isEmpty(media.getAuthor()))
			mr.setAuthor(media.getAuthor());
		if (!StringUtils.isEmpty(media.getType()))
			mr.setType(media.getType());
		return this.ms.update(mr);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public Media mediaDelete(@PathVariable Long id) {
		return this.ms.delete(id);
	}

}
