package edu.mum.cs.cs425.etdm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs425.etdm.model.Athlete;

@Repository
public interface IEliteAthleteRepository extends JpaRepository<Athlete, Integer>{

}
