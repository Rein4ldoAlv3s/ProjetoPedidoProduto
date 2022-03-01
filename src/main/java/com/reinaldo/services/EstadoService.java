package com.reinaldo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reinaldo.domain.Estado;
import com.reinaldo.repositories.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;
	
	public Estado buscar(Integer id) {
		Optional<Estado> obj = estadoRepository.findById(id);
		return obj.orElse(null);
	}
}
