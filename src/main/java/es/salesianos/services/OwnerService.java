package es.salesianos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.salesianos.model.Owner;
import es.salesianos.repositories.OwnerRepository;

@Service
public class OwnerService {

	@Autowired
	OwnerRepository ownerRepository;

	public Owner search(int codOwner) {
		return ownerRepository.search(codOwner);
	}

	public void insert(Owner owner) {
		ownerRepository.insert(owner);
	}

	public void update(Owner owner) {
		ownerRepository.update(owner);
	}

	public void delete(Integer codOwner) {
		ownerRepository.delete(codOwner);
	}

	public List<Owner> selectAllOwners() {
		return ownerRepository.selectAllOwners();
	}

}
