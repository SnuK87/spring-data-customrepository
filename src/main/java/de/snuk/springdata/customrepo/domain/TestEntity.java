package de.snuk.springdata.customrepo.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TestEntity {

	@Id
	@GeneratedValue
	private Long id;
	private String value;
	private LocalDateTime lastModified;

	public TestEntity() {

	}

	public TestEntity(Long id, String value, LocalDateTime lastModified) {
		this.id = id;
		this.value = value;
		this.lastModified = lastModified;
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

	public LocalDateTime getLastModified() {
		return lastModified;
	}

	public void setLastModified(LocalDateTime lastModified) {
		this.lastModified = lastModified;
	}

	@Override
	public String toString() {
		return "TestEntity [id=" + id + ", value=" + value + ", lastModified=" + lastModified + "]";
	}

}
