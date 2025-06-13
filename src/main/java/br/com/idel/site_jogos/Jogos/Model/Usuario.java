package br.com.idel.site_jogos.Jogos.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id_usuario;

    @Column(name = "cpf")
    private Long cpf;

    @Column(name = "senha")
    private  String senha;

    @Column(name = "email")
    private String email;

}
