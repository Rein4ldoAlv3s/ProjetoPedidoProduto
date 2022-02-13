package com.reinaldo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reinaldo.domain.Cidade;
import com.reinaldo.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	public Cidade listar(Integer id) {
		Optional<Cidade> obj = cidadeRepository.findById(id);
		return obj.orElse(null);
	}
	
}
