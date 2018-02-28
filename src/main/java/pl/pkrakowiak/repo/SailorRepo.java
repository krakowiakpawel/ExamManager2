package pl.pkrakowiak.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.pkrakowiak.entity.Sailor;

public interface SailorRepo extends JpaRepository <Sailor, Integer> {

	public Sailor findById(int id);
	
	
}
