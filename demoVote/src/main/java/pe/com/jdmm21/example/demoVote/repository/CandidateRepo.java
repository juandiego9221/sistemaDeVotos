package pe.com.jdmm21.example.demoVote.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.com.jdmm21.example.demoVote.entity.Candidate;

public interface CandidateRepo extends JpaRepository<Candidate, Long>{

}
