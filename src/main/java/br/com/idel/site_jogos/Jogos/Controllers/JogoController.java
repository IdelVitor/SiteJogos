package br.com.idel.site_jogos.Jogos.Controllers;

import br.com.idel.site_jogos.Jogos.Model.Jogo;
import br.com.idel.site_jogos.Jogos.Model.Usuario;
import br.com.idel.site_jogos.Jogos.Service.JogoService;
import br.com.idel.site_jogos.Jogos.Service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jogo")
public class JogoController {

    @Autowired
    private JogoService jogoService;

    @GetMapping
    public ResponseEntity<List<Jogo>> listar() {
        return ResponseEntity.ok(jogoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogo> listarPorId(@PathVariable Long id) {
        return jogoService.listarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> AdcionarJogo(@RequestBody Jogo jogo) {
        jogo.setId_jogo(null);
        try {
            Jogo novoJogo = jogoService.adcionarJogo(jogo);
            return ResponseEntity.ok(novoJogo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarJogo(@PathVariable Long id, @RequestBody Jogo jogoAtualizado) {
        return jogoService.listarPorId(id).map(jogoExistente -> {
            jogoExistente.setNome(jogoAtualizado.getNome());
            jogoExistente.setCampanha_principal(jogoAtualizado.getCampanha_principal());
            jogoExistente.setCampanha_completa(jogoAtualizado.getCampanha_completa());
            Jogo atualizado = jogoService.atualizarJogo(jogoExistente);
            return ResponseEntity.ok(atualizado);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerJogo(@PathVariable Long id) {
        if (jogoService.listarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        jogoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
