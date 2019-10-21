package edu.mum.cs.cs425.etdm.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.etdm.model.Athlete;
import edu.mum.cs.cs425.etdm.repository.IAthleteRepository;
import edu.mum.cs.cs425.etdm.repository.IEliteAthleteRepository;
import edu.mum.cs.cs425.etdm.service.IEliteAthleteService;

@Service
public class EliteAthleteService implements IEliteAthleteService{
	@Autowired
	private IEliteAthleteRepository eliteAthleteRepository;

	@SuppressWarnings("unchecked")
	@Override
	public List<Athlete> getEliteAthlete() {
		List<Athlete> elites = null;
		
		List<Athlete> athletes = eliteAthleteRepository.findAll(getAthleteOrderBySalaryDESC());
		
		Calendar c1 = Calendar.getInstance();
		
		for(Athlete athlete: athletes) {
			if(!(athlete.getDateOfRegistration().getYear() <= (Calendar.YEAR - 5))) {
				if (!(athlete.getTotalNumberOfMedalsWon() >= 3)) {
					elites = (List<Athlete>) athlete;
				}
			}
		}
		
		return elites;
	}
	
	private Sort getAthleteOrderBySalaryDESC() {
		return new Sort(Sort.Direction.DESC, "monthlySalary");
		
	}

	@Override
	public Integer countEliteAthletes() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public Integer countEliteAthletes() {
//		Integer count = 0;
//		List<Athlete> athletes = eliteAthleteRepository.findAll();
//		for(Athlete athlete: athletes) {
//			if(!(athlete.getDateOfRegistration().getYear() > 5)) {
//				if(!(athlete.getTotalNumberOfMedalsWon() >= 3)) {
//					
//				}
//			}
//		}
//
//	}
}
