package be.vdab.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import be.vdab.repositories.PersoonRepository;

@Configuration
public class ServicesConfig {
	PersoonService persoonService(
			@Qualifier("CSV") PersoonRepository persoonRepository) {
		return new PersoonServiceImpl(persoonRepository);
	}
}
