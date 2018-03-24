package be.vdab;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import be.vdab.presentations.PersoonViewer;

public class Main {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("container.xml")) {
			context.getBean(PersoonViewer.class).afbeelden();
//				.afbeelden(Arrays.asList(new Persoon(1, "Eddy", "Wally", 1), 
//										new Persoon(2, "Allan", "Norico", 1), 
//										new Persoon(3, "Andrew", "Sabate", 2), 
//										new Persoon(4, "Ives", "Oliquiano", 3)));
//			context.getBean(PersoonViewer.class).isAantalKinderenTonen();
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

}
