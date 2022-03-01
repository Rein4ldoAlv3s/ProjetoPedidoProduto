package com.reinaldo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reinaldo.domain.Estado;
import com.reinaldo.services.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoResource {

	@Autowired
	private EstadoService estadoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Estado> buscar(@PathVariable Integer id){
		Estado obj = estadoService.buscar(id);
		return ResponseEntity.ok(obj);
	}
}
