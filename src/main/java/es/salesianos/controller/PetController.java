package es.salesianos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Pet;
import es.salesianos.repositories.PetRepository;

@Controller
public class PetController {

	@Autowired
	PetRepository petRepository;

	@GetMapping(path = "/addPet")
	public ModelAndView getAddOwnerPage(@RequestParam Integer codOwner) {
		ModelAndView model = new ModelAndView("addPet");
		Pet pet = new Pet();
		pet.setCodOwner(codOwner);
		model.addObject("pet", pet);
		return model;
	}

	@PostMapping(path = "/addPet")
	public String addPet(Pet pet) {
		petRepository.insert(pet);
		return "index";
	}

}
