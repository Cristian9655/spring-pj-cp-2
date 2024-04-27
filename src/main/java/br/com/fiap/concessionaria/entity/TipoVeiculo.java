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
@Table(name = "TB_TIPOVEICULO")
public class TipoVeiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TIPOVEICULO")
    @SequenceGenerator(name = "SQ_TIPOVEICULO", sequenceName = "SQ_TIPOVEICULO", allocationSize = 1)
    @Column(name = "ID_TIPOVEICULO")
    private Long id;

    @Column(name = "NM_TIPOVEICULO")
    private String nome;
}
