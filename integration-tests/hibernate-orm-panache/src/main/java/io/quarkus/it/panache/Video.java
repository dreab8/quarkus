package org.acme.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "video")
public class Video extends Content {
	@Column(nullable = false)
	public long length;
}
