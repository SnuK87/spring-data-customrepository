package de.snuk.customrepo.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

public class CustomRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements CustomRepository<T, ID> {

	private final EntityManager entityManager;

	public CustomRepositoryImpl(JpaEntityInformation<T, ID> entityMetadata, EntityManager entityManager) {
		super(entityMetadata, entityManager);
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public boolean findAllByValue(String value) {
		return false;
	}

	@Override
	@Transactional
	public <S extends T> S save(S entity) {
		entityManager.persist(entity);

		return entity;
	}

}
