package com.dlz.backend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "Produto")
@Getter
@Setter
@NoArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private UUID idCliente;

    @Column(nullable = false, columnDefinition = "VARCHAR(45)")
    private  String nome;

    @Column(nullable = false, columnDefinition = "INT")
    private int quantidade;

    @Column(nullable = false, columnDefinition = "INT")
    private int preco_em_centavos;

    @Column(nullable = false, columnDefinition = "VARCHAR(45)")
    private String imagem;

    @ManyToOne()
    @JoinColumn(name = "idDepartamento", nullable = false)
    private Departamento departamento;

    @Builder
    public Produto(String nome, int quantidade, int preco_em_centavos, String imagem, Departamento departamento) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco_em_centavos = preco_em_centavos;
        this.imagem = imagem;
        this.departamento = departamento;
    }
}
