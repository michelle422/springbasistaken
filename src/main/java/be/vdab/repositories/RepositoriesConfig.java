package be.vdab.repositories;

import java.io.File;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:repositories.properties")
public class RepositoriesConfig {
	@Bean
	@Qualifier("CSV")
	PersoonRepository persoonRepositoryCSV(
			@Value("${persoonRepositoryCSV}") File file) {
		return new PersoonRepositoryCSV(file);
	}
	@Bean
	@Qualifier("MeerdereRegels")
	PersoonRepository persoonRepositoryMeerdereRegels(
			@Value("${persoonRepositoryTXT}") File file) {
		return new PersoonRepositoryMeerdereRegels(file);
	}
}
