package be.vdab.presentation;

import java.io.IOException;

import be.vdab.entities.Persoon;
import be.vdab.enums.PersoonEigenschap;
import be.vdab.services.PersoonService;

public class PersoonViewer {
	private final PersoonEigenschap[] eigenschappen;
	private final PersoonService persoonService;
	
	public PersoonViewer(PersoonEigenschap[] eigenschappen, PersoonService persoonService) {
		this.eigenschappen = eigenschappen;
		this.persoonService = persoonService;
	}

	public PersoonEigenschap[] getEigenschappen() {
		return eigenschappen;
	}
	
	public PersoonService getPersoonService() {
		return persoonService;
	}

	public void afbeelden() throws IOException {
		for (Persoon persoon : persoonService.findAll()) {
			for (PersoonEigenschap eigenschap : eigenschappen) {
				toonEigenschap(persoon, eigenschap);
				System.out.println(' ');
			}
			System.out.println();
		}
	}
	
//	public void afbeelden(List<Persoon> personen) {
//		for (Persoon persoon : personen) {
//			for (PersoonEigenschap eigenschap : eigenschappen) {
//				toonEigenschap(persoon, eigenschap);
//				System.out.print(' ');
//			}
//			System.out.println();
//		}
//	}

	public void toonEigenschap(Persoon persoon, PersoonEigenschap eigenschap) {
		switch (eigenschap) {
		case PERSOON_NR:
			System.out.print(persoon.getPersoonNr());
			break;
		case VOORNAAM:
			System.out.print(persoon.getVoornaam());
			break;
		case FAMILIENAAM:
			System.out.print(persoon.getFamilienaam());
			break;
		case AANTAL_KINDEREN:
			System.out.print(persoon.getAantalKinderen());
			break;
		}
	}

}
