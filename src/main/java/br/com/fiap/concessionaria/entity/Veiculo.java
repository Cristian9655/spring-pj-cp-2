package br.com.fiap.concessionaria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "TB_VEICULO")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_VEICULO")
    @SequenceGenerator(name = "SQ_VEICULO", sequenceName = "SQ_VEICULO", allocationSize = 1)
    @Column(name = "ID_VEICULO")
    private Long id;

    @Column(name = "NM_VEICULO")
    private String nome;

    private Year anoDeFabricacao;

    private String cor;

    @Column(name = "PC_VEICULO")
    private Double preco;

    private Short cilindradas;

    private String modelo;

    private String palavraDeEfeito;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "FABRICANTE",
            referencedColumnName = "ID_FABRICANTE",
            foreignKey = @ForeignKey(name = "FK_VEICULO_FABRICANTE"),
            nullable = false
    )
    private Fabricante fabricante;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "TIPO",
            referencedColumnName = "ID_TIPO",
            foreignKey = @ForeignKey(name = "FK_VEICULO_TIPO"),
            nullable = false
    )
    private TipoVeiculo tipo;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "TB ACESSORIOS_VEICULO",
            joinColumns = {
                    @JoinColumn(
                            name = "VEICULO",
                            referencedColumnName = "ID_VEICULO",
                            foreignKey = @ForeignKey(name = "FK_VEICULO_ACESSORIOS")
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "ACESSORIOS",
                            referencedColumnName = "ID_ACESSORIOS",
                            foreignKey = @ForeignKey(name = "FK_ACESSORIOS_VEICULO")
                    )
            }
    )
    private Set<Acessorio> acessorios = new LinkedHashSet<>();

}
