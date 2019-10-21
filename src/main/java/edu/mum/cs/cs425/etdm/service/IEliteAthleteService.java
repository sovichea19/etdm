package edu.mum.cs.cs425.etdm.service;

import java.util.List;

import edu.mum.cs.cs425.etdm.model.Athlete;

public interface IEliteAthleteService {
	
	List<Athlete> getEliteAthlete();
	Integer countEliteAthletes(); 

}
