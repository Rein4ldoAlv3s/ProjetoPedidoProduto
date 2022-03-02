package com.reinaldo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reinaldo.cursomcdois.services.exceptions.DataIntegrityException;
import com.reinaldo.cursomcdois.services.exceptions.ObjectNotFoundException;
import com.reinaldo.domain.Categoria;
import com.reinaldo.dto.CategoriaDTO;
import com.reinaldo.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria listar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	public List<Categoria> listarTodos(){
		return repo.findAll();
	}
	
	public Categoria fromDTO(CategoriaDTO objDto) {
		return new Categoria(objDto.getId(), objDto.getNome());
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		listar(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		listar(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos"); 
		}
	}
}
