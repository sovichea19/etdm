package edu.mum.cs.cs425.etdm.service;

import java.time.LocalDate;
import java.util.List;

import edu.mum.cs.cs425.etdm.model.Athlete;

public interface IAthleteService {
	
	List<Athlete> getAllAthletes();
	Athlete addNewAthlete(Athlete athlete);
	List<Athlete> getElite(LocalDate date);
	int countEliteAthletes();
	
	//List<Athlete> getAllEliteAthletes();

}
