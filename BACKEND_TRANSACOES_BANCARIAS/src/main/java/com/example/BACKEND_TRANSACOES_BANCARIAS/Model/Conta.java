package com.example.BACKEND_TRANSACOES_BANCARIAS.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name="conta")
public class Conta {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conta")
    private Long id_conta;

    @NonNull
    private String nome_responsavel;

    //O OrphanRemoval marca entidades "filhas"
    //para serem excluídas quando não tem qualquer
    //outro vinculo com uma entidade pai, por exemplo,
    //quando você tem um carro em uma lista de carros
    //relacionados a um concessionária.

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "conta_id")
    private List<Transferencia> transferencia = new ArrayList<>();

}
