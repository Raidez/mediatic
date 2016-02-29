package fr.iocean.application.persistence;

import java.io.Serializable;

public interface GenericEntity extends Serializable{
	Long getId();
	void setId(Long id);
}
