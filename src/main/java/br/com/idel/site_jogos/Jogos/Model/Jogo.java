package br.com.idel.site_jogos.Jogos.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "jogo")
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jogo")
    private Long id_jogo;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_lancamento")
    private LocalDate data_lancamento;

    @Column(name = "campanha_principal")
    private double campanha_principal;

    @Column(name = "campanha_completa")
    private double campanha_completa;
}
