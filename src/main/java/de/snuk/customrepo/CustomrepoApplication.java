package de.snuk.customrepo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import de.snuk.customrepo.domain.model.TestEntity;
import de.snuk.customrepo.domain.repository.TestEntityRepository;
import de.snuk.customrepo.repository.RepoFactoBeano;

@EnableJpaRepositories(basePackages = "de.snuk.customrepo", entityManagerFactoryRef = "entityManagerFactory", repositoryFactoryBeanClass = RepoFactoBeano.class)
@SpringBootApplication
public class CustomrepoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CustomrepoApplication.class, args);
	}

	@Autowired
	private TestEntityRepository repository;

	@Override
	public void run(String... args) throws Exception {
		TestEntity t = new TestEntity(null, "Val", LocalDateTime.now());
		TestEntity savedEntity = repository.save(t);
		System.out.println(savedEntity);
	}
}
