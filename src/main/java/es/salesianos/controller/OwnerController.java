package es.salesianos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Owner;
import es.salesianos.model.PruebaInterface;
import es.salesianos.services.OwnerService;

@Controller
public class OwnerController {

	@Autowired
	OwnerService ownerService;

	@Autowired
	private PruebaInterface prueba;

	@GetMapping(path = "addOwner")
	public ModelAndView getAddOwnerPage() {
		ModelAndView model = new ModelAndView("addOwner");
		model.addObject("owner", new Owner());
		model.addObject("selectAllOwners", ownerService.selectAllOwners());
		for (Owner owner : ownerService.selectAllOwners()) {
			System.out.println(owner.getName());
		}
		System.out.println(prueba.hablar());
		return model;
	}

	@PostMapping(path = "addOwner")
	public String saveOwner(Owner owner) {
		ownerService.insert(owner);
		return "index";
	}

	@GetMapping(path = "deleteOwner")
	public String deleteOwner(@RequestParam Integer codOwner) {
		ownerService.delete(codOwner);
		return "index";
	}

	@GetMapping(path = "editOwner")
	public ModelAndView editOwner(@RequestParam Integer codOwner) {
		ModelAndView model = new ModelAndView("editOwner");
		model.addObject("owner", ownerService.search(codOwner));
		return model;
	}

	@PostMapping(path = "saveEditOwner")
	public String saveEditOwner(Owner owner) {
		System.out.println(owner.getCodOwner());
		System.out.println("llega aquí");
		ownerService.update(owner);
		return "index";
	}

}
