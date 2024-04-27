package br.com.fiap.concessionaria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "TB_ACESSORIOS")
public class Acessorio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ACESSORIOS")
    @SequenceGenerator(name = "SQ_ACESSORIOS", sequenceName = "SQ_ACESSORIOS", allocationSize = 1)
    @Column(name = "ID_ACESSORIOS")
    private Long id;

    @Column(name = "NM_ACESSORIOS")
    private String nome;

    @Column(name = "PC_ACESSORIOS")
    private Double preco;


}
