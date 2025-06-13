package br.com.idel.site_jogos.Jogos.Controllers;

import br.com.idel.site_jogos.Jogos.Model.Usuario;
import br.com.idel.site_jogos.Jogos.Service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.IntToLongFunction;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        return ResponseEntity.ok(usuariosService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> listarPorId(@PathVariable Long id) {
        return usuariosService.listarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> criarEmpresa(@RequestBody Usuario usuario) {
        usuario.setId_usuario(null);
        try {
            Usuario novoUsuario = usuariosService.criarUsuario(usuario);
            return ResponseEntity.ok(novoUsuario);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {
        return usuariosService.listarPorId(id).map(usuarioExistente -> {
            usuarioExistente.setEmail(usuarioAtualizado.getEmail());
            Usuario atualizada = usuariosService.atualizarUsuario(usuarioExistente);
            return ResponseEntity.ok(atualizada);
        }).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarSenha(@PathVariable Long id, @RequestBody Usuario atualizarSenha) {
        return usuariosService.listarPorId(id).map(usuarioExistente -> {
            usuarioExistente.setSenha(atualizarSenha.getSenha());
            Usuario atualizada = usuariosService.atualizarUsuario(usuarioExistente);
            return ResponseEntity.ok(atualizada);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerUsuario(@PathVariable Long id) {
        if (usuariosService.listarPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        usuariosService.deletar(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
