package br.com.idel.site_jogos.Jogos.Repository;

import br.com.idel.site_jogos.Jogos.Model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {
}
