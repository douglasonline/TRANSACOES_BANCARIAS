package com.example.BACKEND_TRANSACOES_BANCARIAS.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.math.RoundingMode;


@Entity
@Getter
@Setter
@Table(name="transferencia")
public class Transferencia {

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name="data_transferencia")
    private Timestamp datatransferencia;

    @NonNull
    private BigDecimal valor;

    @NonNull
    private String tipo;

    @Column(name="nome_operador_transacao")
    @NonNull
    private String nomeoperadortransacao;

    @NonNull
    private Integer conta_id;

    //A anotação @PrePersist é usada para especificar
    //um método de retorno de chamada que é acionado
    //antes que uma entidade seja persistida.

    //@PreUpdate: executa método anotado
    //antes da entidade ser atualizada;

    @PrePersist
    @PreUpdate
    public void pricePrecisionConvertion() {
        // Convertendo a escala decimal grande para 2
        this.valor = this.valor.setScale(2, RoundingMode.HALF_UP.ordinal());
    }

}
