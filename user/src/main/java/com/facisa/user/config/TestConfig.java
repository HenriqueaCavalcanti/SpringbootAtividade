package com.facisa.user.config;

import com.facisa.user.entities.Manifestacao;
import com.facisa.user.entities.Usuario;
import com.facisa.user.entities.enums.ManifestacaoStatus;
import com.facisa.user.entities.enums.ManifestacaoTipo;
import com.facisa.user.repositories.ManifestacaoRepository;
import com.facisa.user.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ManifestacaoRepository manifestacaoRepository;


    @Override
    public void run(String... args) throws Exception {
        Usuario u1 = new Usuario(null, "Weslley", "1234");
        Usuario u2 = new Usuario(null, "Henrique", "1354689");

        Manifestacao m1 = new Manifestacao(null, Instant.parse("2022-06-20T19:53:07Z"), "Eletronico", "Celular sem funcionar", ManifestacaoTipo.RECLAMACAO, ManifestacaoStatus.AGUARDANDO_ANALISE, u1);
        Manifestacao m2 = new Manifestacao(null, Instant.parse("2022-07-20T14:30:25Z"), "Livros", "Aprendendo outro idioma", ManifestacaoTipo.SUGESTAO, ManifestacaoStatus.SOLICITACAO_ATENDIDA, u2);
        Manifestacao m3 = new Manifestacao(null, Instant.parse("2022-09-20T21:00:32Z"), "Livros", "Livro muito ruim", ManifestacaoTipo.RECLAMACAO, ManifestacaoStatus.SOLICITACAO_CANCELADA, u1);


        usuarioRepository.saveAll(Arrays.asList(u1, u2));

        manifestacaoRepository.saveAll(Arrays.asList(m1,m2,m3));
    }
}
