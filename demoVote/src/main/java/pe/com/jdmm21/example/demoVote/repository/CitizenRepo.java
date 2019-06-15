package pe.com.jdmm21.example.demoVote.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.com.jdmm21.example.demoVote.entity.Citizen;

@Repository
public interface CitizenRepo extends JpaRepository<Citizen, Long>{
	
	public Citizen findByName(String name);

}
