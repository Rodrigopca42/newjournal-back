package com.rodrigo.newJournal2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodrigo.newJournal2.domain.Noticia;

public interface NoticiaRepository extends JpaRepository<Noticia, Integer>{

}
