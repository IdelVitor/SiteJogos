package br.com.idel.site_jogos.Jogos.Service;

import br.com.idel.site_jogos.Jogos.Model.Usuario;
import br.com.idel.site_jogos.Jogos.Repository.UsuariosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {

    private UsuariosRepository usuariosRepository;

    public Usuario criarUsuario(Usuario usuario) {
        if (usuario.getCpf() != null && usuariosRepository.findByCpf(String.valueOf(usuario.getCpf())).isPresent()) {
            throw new IllegalArgumentException("CPF já cadastrado.");
        }
        return usuariosRepository.save(usuario);
    }

    public List<Usuario> listarTodos(){
        return usuariosRepository.findAll();
    }

    public Optional<Usuario> listarPorId(Long id) {
        return usuariosRepository.findById(id);
    }

    public Usuario atualizarUsuario(Usuario usuarioExistente){
        return usuariosRepository.save(usuarioExistente);
    }

    public void deletar(Long id) {
        usuariosRepository.deleteById(id);
    }
}
