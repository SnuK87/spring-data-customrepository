package de.snuk.springdata.customrepo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SecondEntity {

	@Id
	@GeneratedValue
	private Long id;

	private String value;

	public SecondEntity() {

	}

	public SecondEntity(Long id, String value) {
		this.id = id;
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "SecondEntity [id=" + id + ", value=" + value + "]";
	}
}
