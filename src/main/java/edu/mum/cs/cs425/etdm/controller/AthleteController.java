package edu.mum.cs.cs425.etdm.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs.cs425.etdm.model.Athlete;
import edu.mum.cs.cs425.etdm.service.IAthleteService;
import edu.mum.cs.cs425.etdm.service.IEliteAthleteService;
import edu.mum.cs.cs425.etdm.service.impl.AthleteService;

@Controller
@RequestMapping(value = "/etdm/athletes")
public class AthleteController {
	
	@Autowired
	private IAthleteService athleteService;
	
//	@Autowired
//	private IEliteAthleteService eliteAthleteService;
	
	@Autowired
	public AthleteController(AthleteService athleteService) {
		this.athleteService = athleteService;
	}
	
	@GetMapping(value = {"/list"})
    public ModelAndView listAthletes() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("athletes", athleteService.getAllAthletes());
        modelAndView.setViewName("athletes/list");
        return modelAndView;
    }
	
	@GetMapping(value = {"/new"})
    public String displayNewAthleteForm(Model model) {
        model.addAttribute("athlete", new Athlete());
        return "athletes/new";
    }
	
    @PostMapping(value = {"/new"})
    public String addNewAthlete(@Valid @ModelAttribute("athlete") Athlete athlete,
                                     BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "athletes/new";
        }
        athlete = athleteService.addNewAthlete(athlete);
        return "redirect:/etdm/athletes/list";
    }
    
	@GetMapping(value = {"/elite/list"})
    public ModelAndView listEliteAthletes() {
		ModelAndView mav = new ModelAndView();
		
		String date = "2019-10-19";		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(date, formatter);
		
		mav.addObject("athletes", athleteService.getElite(localDate));
		mav.setViewName("/athletes/elite/list");
		return mav;	
    }


}
