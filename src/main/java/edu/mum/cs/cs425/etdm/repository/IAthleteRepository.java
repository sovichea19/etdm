package edu.mum.cs.cs425.etdm.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs425.etdm.model.Athlete;

@Repository
public interface IAthleteRepository extends JpaRepository<Athlete, Integer>{

	@Query("select a from Athlete a where a.totalNumberOfMedalsWon>3 and a.dateOfRegistration<?1 order by a.monthlySalary desc")
	List<Athlete> findElites(LocalDate date);

}
