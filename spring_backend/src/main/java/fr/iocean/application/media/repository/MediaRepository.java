package fr.iocean.application.media.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

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
	public List<Media> getBy(String title, String author, TypeMedia type) {
		Criteria crit = this.getSession().createCriteria(Media.class);
		if(! StringUtils.isEmpty(title))
			crit.add(Restrictions.like("title", "%"+title+"%"));
		if(! StringUtils.isEmpty(author))
			crit.add(Restrictions.like("author", "%"+author+"%"));
		if(! StringUtils.isEmpty(type))
			crit.add(Restrictions.eq("type", type));
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
