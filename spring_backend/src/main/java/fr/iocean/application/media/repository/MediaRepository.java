package fr.iocean.application.media.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.iocean.application.media.model.Media;
import fr.iocean.application.media.model.TypeMedia;
import fr.iocean.application.util.persistence.AbstractJpaRepository;

@Repository
@Transactional
public class MediaRepository extends AbstractJpaRepository<Media> implements IMedia {

	@Override
	protected Class<Media> getEntityClass() {
		return Media.class;
	}
	
	@Override
	public List<Media> getByTitle(String title) {
		Criteria crit = this.getSession().createCriteria(Media.class).add(Restrictions.eq("title", title));
		return (List<Media>) crit.list();
	}

	@Override
	public List<Media> getByAuthor(String author) {
		Criteria crit = this.getSession().createCriteria(Media.class).add(Restrictions.eq("author", author));
		return (List<Media>) crit.list();
	}

	@Override
	public List<Media> getByType(TypeMedia media) {
		Criteria crit = this.getSession().createCriteria(Media.class).add(Restrictions.eq("type", media));
		return (List<Media>) crit.list();
	}

	@Override
	public Media insert(Media newMedia) {
		return super.save(newMedia);
	}

	@Override
	public Media update(Media newMedia) {
		return super.save(newMedia);
	}

	@Override
	public Media getById(Long id) {
		return super.findOne(id);
	}

	@Override
	public Media delete(Long id) {
		Media m = this.getById(id);
		super.delete(m);
		return m;
	}

}
