package com.rodrigo.newJournal2.service;

import java.util.List;
import java.util.Optional;

import com.rodrigo.newJournal2.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigo.newJournal2.domain.Noticia;
import com.rodrigo.newJournal2.domain.dto.NoticiaDTO;
import com.rodrigo.newJournal2.repositories.NoticiaRepository;

@Service
public class NoticiaService {

	
	@Autowired
	private NoticiaRepository repository;
	
	public List<Noticia> findAll() {
		return repository.findAll();
	}

	public Noticia findById(Integer id) {
		Optional<Noticia> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: "+ id));
	}

	public Noticia create(NoticiaDTO objDTO) {
		objDTO.setId(null);
		Noticia newObj = new Noticia(objDTO);
		return repository.save(newObj);
	}

	public Noticia update(Integer id, NoticiaDTO objDTO) {
		objDTO.setId(id);
		Noticia oldObj = findById(id);
		oldObj = new Noticia(objDTO);
		return repository.save(oldObj);
	}

	public void delete(Integer id) {
		Noticia obj = findById(id);
		repository.deleteById(id);
		
	}
	
}


