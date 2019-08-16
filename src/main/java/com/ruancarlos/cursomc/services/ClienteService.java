package com.ruancarlos.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruancarlos.cursomc.domain.Cliente;
import com.ruancarlos.cursomc.repositories.ClienteRepository;
import com.ruancarlos.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
}
