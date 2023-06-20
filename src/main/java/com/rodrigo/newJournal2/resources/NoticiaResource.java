package com.rodrigo.newJournal2.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rodrigo.newJournal2.domain.Noticia;
import com.rodrigo.newJournal2.domain.dto.NoticiaDTO;
import com.rodrigo.newJournal2.service.NoticiaService;

@RestController
@RequestMapping(value = "/novasnoticias")
public class NoticiaResource {
	@Autowired
	private NoticiaService service;
	
	
	@GetMapping
	public ResponseEntity<List<NoticiaDTO>> findAll(){
		List<Noticia> list = service.findAll();
		List<NoticiaDTO> listDTO = list.stream().map(obj -> new NoticiaDTO(obj)).
				collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<NoticiaDTO> findById(@PathVariable Integer id){
		Noticia obj = service.findById(id);
		return ResponseEntity.ok().body(new NoticiaDTO(obj));
	}
	
	@PostMapping
	public ResponseEntity<NoticiaDTO>create(@RequestBody NoticiaDTO objDTO){
		Noticia newObj = service.create(objDTO);		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build(); 
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<NoticiaDTO> update(@PathVariable Integer id, @Valid @RequestBody NoticiaDTO objDTO ){
		Noticia obj = service.update(id,objDTO);
		return ResponseEntity.ok().body(new NoticiaDTO(obj));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<NoticiaDTO> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}

