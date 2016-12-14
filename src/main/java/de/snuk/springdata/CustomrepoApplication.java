package de.snuk.springdata;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.snuk.springdata.customrepo.domain.SecondEntity;
import de.snuk.springdata.customrepo.domain.SecondRepository;
import de.snuk.springdata.customrepo.domain.TestEntity;
import de.snuk.springdata.customrepo.domain.TestEntityRepository;

@SpringBootApplication
public class CustomrepoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CustomrepoApplication.class, args);
	}

	@Autowired
	private TestEntityRepository repository;

	@Autowired
	private SecondRepository secondRepo;

	@Override
	public void run(String... args) throws Exception {
		TestEntity t = new TestEntity(null, "Value", LocalDateTime.now());
		TestEntity savedEntity = repository.save(t);
		System.out.println("Saved Entity: " + savedEntity);

		savedEntity.setValue("newValue");
		TestEntity update = repository.update(savedEntity);
		System.out.println("Updated Entity: " + update);

		SecondEntity s = new SecondEntity(null, "SecondValue");
		SecondEntity saved = secondRepo.save(s);
		System.out.println("Saved Entity: " + saved);

		saved.setValue("new second val");
		SecondEntity update2 = secondRepo.update(saved);
		System.out.println("Updated Entity: " + update2);
	}
}
