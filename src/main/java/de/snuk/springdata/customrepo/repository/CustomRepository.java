package de.snuk.springdata.customrepo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
// This ensures that Spring Data JPA won’t try to create an
// implementation for the BaseRepository interface

/**
 * intermediate interface
 * 
 * @author snuk
 *
 * @param <T>
 * @param <ID>
 */
public interface CustomRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

	boolean findAllByValue(String value);

}
