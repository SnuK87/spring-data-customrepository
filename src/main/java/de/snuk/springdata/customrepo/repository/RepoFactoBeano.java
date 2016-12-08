package de.snuk.springdata.customrepo.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

public class RepoFactoBeano<R extends JpaRepository<T, I>, T, I extends Serializable>
		extends JpaRepositoryFactoryBean<R, T, I> {

	@SuppressWarnings("rawtypes")
	@Override
	protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {

		return new RepoFacto(entityManager);
	}

	private static class RepoFacto<T, I extends Serializable> extends JpaRepositoryFactory {

		private EntityManager entityManager;

		public RepoFacto(EntityManager entityManager) {
			super(entityManager);

			this.entityManager = entityManager;
		}

		@SuppressWarnings({ "unused", "unchecked" })
		protected Object getTargetRepository(RepositoryMetadata metadata) {

			return new CustomRepositoryImpl<T, I>((JpaEntityInformation<T, I>) getEntityInformation(metadata.getDomainType()),
					entityManager);
		}

		@Override
		protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
			return CustomRepositoryImpl.class;
		}
	}

}
