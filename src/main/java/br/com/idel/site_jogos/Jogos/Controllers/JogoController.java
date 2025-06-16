package br.com.idel.site_jogos.Jogos.Controllers;


import br.com.idel.site_jogos.Jogos.Model.Jogo;
import br.com.idel.site_jogos.Jogos.Service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jogos")
public class JogoController {


        @Autowired
        private JogoService jogoService;

        @GetMapping("/{nomeJogo}")
        public ResponseEntity<List<Jogo>> listarJogos(@PathVariable String nomeJogo) {
            List<Jogo> eventos = jogoService.buscarJogo(nomeJogo);
            return ResponseEntity.ok(eventos);
        }
    }
