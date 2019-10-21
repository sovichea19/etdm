package edu.mum.cs.cs425.etdm.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.etdm.model.Athlete;
import edu.mum.cs.cs425.etdm.repository.IAthleteRepository;
import edu.mum.cs.cs425.etdm.service.IAthleteService;

@Service
public class AthleteService implements IAthleteService{
	
	@Autowired
	private IAthleteRepository athleteRepository;

	@Override
	public List<Athlete> getAllAthletes() {
		return athleteRepository.findAll(Sort.by("fullName"));
	}

	@Override
	public Athlete addNewAthlete(Athlete athlete) {
		return athleteRepository.save(athlete);
	}

	@Override
	public List<Athlete> getElite(LocalDate date) {
		return athleteRepository.findElites(date);
	}

	@Override
	public int countEliteAthletes() {
		String date = "2019-10-19";		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(date, formatter);
		
		return athleteRepository.findElites(localDate).size();
	}


	
	

}
