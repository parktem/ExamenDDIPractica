package es.salesianos.model;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("local")
public class Prueba1 implements PruebaInterface {

	@Override
	public String hablar() {
		return "hola";

	}

}
