package com.facisa.user.services;

import com.facisa.user.entities.Usuario;
import com.facisa.user.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

        @Autowired
        private UsuarioRepository repository;

        @GetMapping
        public List<Usuario> findAll(){
            return repository.findAll();
        }

        @GetMapping(value = "/{id}")
        public Usuario findById(Long id){
            Optional<Usuario> obj = repository.findById(id);
            return obj.get();
        }
    }
