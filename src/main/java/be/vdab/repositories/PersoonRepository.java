package be.vdab.repositories;

import java.io.IOException;
import java.util.List;

import be.vdab.entities.Persoon;

public interface PersoonRepository {
	List<Persoon> findAll() throws IOException;
}
