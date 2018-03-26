package be.vdab.repositories;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Repository;

import be.vdab.entities.Persoon;

//@Repository
//@Qualifier("MeerdereRegels")
class PersoonRepositoryMeerdereRegels implements PersoonRepository {
	private final File bestand;
	
//	public PersoonRepositoryMeerdereRegels(@Value("${persoonRepositoryTXT}") File bestand) {
	PersoonRepositoryMeerdereRegels(File bestand) {
		this.bestand = bestand;
	}

	@Override
	public List<Persoon> findAll() throws IOException {
		List<Persoon> personen = new ArrayList<>();
		try (Scanner scanner = new Scanner(bestand)) {
			while(scanner.hasNext()) {
				int persoonNr = scanner.nextInt();
				scanner.nextLine();
				String voornaam = scanner.nextLine();
				String familienaam = scanner.nextLine();
				int aantalKinderen = scanner.nextInt();
				if (scanner.hasNext()) {
					scanner.nextLine();
				}
				personen.add(new Persoon(persoonNr, voornaam, familienaam, aantalKinderen));
			}
		}
		return personen;
	}

}
