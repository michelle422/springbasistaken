package be.vdab.repositories;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import be.vdab.entities.Persoon;

public class PersoonRepositoryCSV implements PersoonRepository {
	private final File bestand;
	
	public PersoonRepositoryCSV(File bestand) {
		this.bestand = bestand;
	}

	@Override
	public List<Persoon> findAll() throws IOException {
		List<Persoon> personen = new ArrayList<>();
		try (Scanner scanner = new Scanner(bestand)) {
			while (scanner.hasNext()) {
				String[] onderdelen = scanner.nextLine().split(",");
				personen.add(new Persoon(Integer
						.parseInt(onderdelen[0]), onderdelen[1], onderdelen[2], Integer.parseInt(onderdelen[3])));
			}
		}
		return personen;
	}

}
