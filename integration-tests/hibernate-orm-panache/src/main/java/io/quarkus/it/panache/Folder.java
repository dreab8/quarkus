package org.acme.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity(name = "folder")
public class Folder extends EntityBase {
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	public Content content;
}
