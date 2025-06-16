package br.com.idel.site_jogos.Jogos.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jogo {

        private String nome;
        private String imagem;
        private String dataLancamento;
        private String plataforma;

}
