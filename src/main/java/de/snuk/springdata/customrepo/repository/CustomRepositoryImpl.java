package de.snuk.springdata.customrepo.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.transaction.annotation.Transactional;

public class CustomRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements CustomRepository<T, ID> {

	private final EntityManager entityManager;
	private final JpaEntityInformation<T, ID> entityInformation;

	public CustomRepositoryImpl(JpaEntityInformation<T, ID> entityMetadata, EntityManager entityManager) {
		super(entityMetadata, entityManager);
		this.entityManager = entityManager;
		this.entityInformation = entityMetadata;
	}

	@Override
	@Transactional
	public <S extends T> S save(S entity) {
		if (entityInformation.isNew(entity)) {
			entityManager.persist(entity);
			return entity;
		}

		return null;
	}

	@Override
	@Transactional
	public <S extends T> S update(S entity) {
		if (!entityInformation.isNew(entity)) {
			return entityManager.merge(entity);
		}

		return null;
	}
}
