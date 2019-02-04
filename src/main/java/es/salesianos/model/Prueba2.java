package es.salesianos.model;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("PRO")
public class Prueba2 implements PruebaInterface {

	@Override
	public String hablar() {
		return "adios";
	}

}
