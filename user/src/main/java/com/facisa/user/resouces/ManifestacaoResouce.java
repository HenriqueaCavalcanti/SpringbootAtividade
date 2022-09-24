package com.facisa.user.resouces;

import com.facisa.user.entities.Manifestacao;
import com.facisa.user.services.ManifestacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/manifestacao")
public class ManifestacaoResouce {

    @Autowired
    private ManifestacaoService service;

    @GetMapping
    public ResponseEntity<List<Manifestacao>> findAll() {
        List<Manifestacao> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Manifestacao> findById(@PathVariable Long id) {
        Manifestacao obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
