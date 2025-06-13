package br.com.idel.site_jogos.Jogos.Service;

import br.com.idel.site_jogos.Jogos.Model.Jogo;
import br.com.idel.site_jogos.Jogos.Model.Usuario;
import br.com.idel.site_jogos.Jogos.Repository.JogoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogoService {

    private JogoRepository jogoRepository;

    public Jogo adcionarJogo(Jogo jogo) {
        if (jogo.getNome() != null) {
            throw new IllegalArgumentException("Jogo já cadastrado");
        }
        return jogoRepository.save(jogo);
    }

    public List<Jogo> listarTodos(){
        return jogoRepository.findAll();
    }

    public Optional<Jogo> listarPorId(Long id) {
        return jogoRepository.findById(id);
    }

    public Jogo atualizarJogo(Jogo jogoExistente){
        return jogoRepository.save(jogoExistente);
    }

    public void deletar(Long id) {
        jogoRepository.deleteById(id);
    }
}
