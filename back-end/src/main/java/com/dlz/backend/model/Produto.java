package com.dlz.backend.model;

import com.dlz.backend.dto.request.ProdutoRequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
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
    private UUID idProduto;

    @Column(nullable = false, columnDefinition = "VARCHAR(45)")
    private  String nome;

    @Column(nullable = false, columnDefinition = "INT")
    private int quantidade;

    @Column(nullable = false, columnDefinition = "INT")
    private int preco_em_centavos;

    @Column(nullable = false, columnDefinition = "VARCHAR(45)")
    private String imagem;

    @ManyToOne()
    @JoinColumn(name = "idDepartamento", referencedColumnName = "idDepartamento")
    private Departamento departamento;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<ItemPedido> pedidosComProduto;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<Carrinho> carrinhosComProduto;

    @Builder
    public Produto(ProdutoRequestDTO produtoRequestDTO) {
        this.nome = produtoRequestDTO.nome();
        this.quantidade = produtoRequestDTO.quantidade();
        this.preco_em_centavos = produtoRequestDTO.preco_em_centavos();
        this.imagem = produtoRequestDTO.imagem();
        this.departamento = produtoRequestDTO.departamento();

    }

    public Produto(UUID idProduto){
        this.idProduto = idProduto;
    }

}
