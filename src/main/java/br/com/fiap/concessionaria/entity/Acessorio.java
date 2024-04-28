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
@Table(name = "TB_ACESSORIO")
public class Acessorio {
    @Id
    @GeneratedValue(generator = "SQ_ACESSORIO", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SQ_ACESSORIO", sequenceName = "SQ_ACESSORIO", allocationSize = 1)
    @Column(name = "ID_ACESSORIO")
    private Long id;

    @Column(name = "NM_ACESSORIO")
    private String nome;

    @Column(name = "PC_ACESSORIO")
    private Double preco;


}
