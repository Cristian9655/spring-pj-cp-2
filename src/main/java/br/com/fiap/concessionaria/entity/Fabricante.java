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
@Table(name = "TB_FABRICANTE")
public class Fabricante {
    @Id
    @GeneratedValue(generator = "SQ_FABRICANTE", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SQ_FABRICANTE", sequenceName = "SQ_FABRICANTE", allocationSize = 1)
    @Column(name = "ID_FABRICANTE")
    private Long id;

    @Column(name = "NM_FABRICANTE")
    private String nome;

    @Column(name = "NMF_FABRICANTE")
    private String nomeFantasia;

}
