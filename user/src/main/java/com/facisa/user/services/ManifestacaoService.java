package com.facisa.user.services;

import com.facisa.user.entities.Manifestacao;
import com.facisa.user.repositories.ManifestacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ManifestacaoService {

    @Autowired
    ManifestacaoRepository repository;

    @GetMapping
    public List<Manifestacao> findAll() {
        return repository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Manifestacao findById(Long id){
        Optional<Manifestacao> obj = repository.findById(id);
        return obj.get();
    }
}
