package edu.mum.cs.cs425.etdm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
    @GetMapping(value = {"/", "/etdm", "/etdm/home"})
    public String home() {
        return "home/index";
    }
}
