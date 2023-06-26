package com.rodrigo.newJournal2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rodrigo.newJournal2.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
