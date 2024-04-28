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
@Table(name = "TB_CARACTERISTICA", uniqueConstraints = {
    @UniqueConstraint(
            name = "UK_NM_CARACTERISTICA_VEICULO",
            columnNames = {"NM_CARACTERISTICA", "VEICULO"}
    )
})
public class Caracteristica {

    @Id
    @GeneratedValue(generator = "SQ_CARACTERISTICA", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SQ_CARACTERISTICA", sequenceName = "SQ_CARACTERISTICA", allocationSize = 1)
    @Column(name = "ID_CARACTERISTICA")
    private Long id;

    @Column(name = "NM_CARACTERISTICA")
    private String nome;

    @Column(name = "DS_CARACTERISTICA")
    private String descricao;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "VEICULO",
            referencedColumnName = "ID_VEICULO",
            foreignKey = @ForeignKey(name = "FK_CARACTERISTICA_VEICULO")
    )
    private Veiculo veiculo;


}
