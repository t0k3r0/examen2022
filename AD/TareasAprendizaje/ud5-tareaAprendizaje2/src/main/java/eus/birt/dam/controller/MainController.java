package eus.birt.dam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
		@GetMapping("/")
		public String getIndex(){
        return "index";
		}
		
		@GetMapping("/que")
		public String getQue(Model model){
        model.addAttribute("queText", "Esta es la página qué");
			return "que";
		}
		
		@GetMapping("/contacto")
		public String getContacto(Model model){
        model.addAttribute("contactoText", "Esta es la página de contacto");
			return "contacto";
		}
}
