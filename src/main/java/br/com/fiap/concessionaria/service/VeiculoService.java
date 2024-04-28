package br.com.fiap.concessionaria.service;

import br.com.fiap.concessionaria.dto.request.VeiculoRequest;
import br.com.fiap.concessionaria.dto.response.FabricanteResponse;
import br.com.fiap.concessionaria.dto.response.VeiculoResponse;
import br.com.fiap.concessionaria.entity.Veiculo;
import br.com.fiap.concessionaria.repository.AcessorioRepository;
import br.com.fiap.concessionaria.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class VeiculoService implements ServiceDTO<Veiculo, VeiculoRequest, VeiculoResponse>{

    @Autowired
    private VeiculoRepository repo;
    @Autowired
    private TipoVeiculoService tipoVeiculoService;
    @Autowired
    private FabricanteService fabricanteService;

    @Override
    public Collection<Veiculo> findAll(Example<Veiculo> example) {
        return repo.findAll(example);
    }

    @Override
    public Veiculo findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Veiculo save(Veiculo e) {
        return repo.save(e);
    }

    @Override
    public Veiculo toEntity(VeiculoRequest dto) {
        var tipoVeiculo = tipoVeiculoService.findById(dto.tipo().id());
        var fabricante = fabricanteService.findById(dto.fabricante().id());

        return Veiculo.builder()
                .nome(dto.nome())
                .anoDeFabricacao(dto.anoDeFabricacao())
                .cor(dto.cor())
                .preco(dto.preco())
                .cilindradas(dto.cilindradas())
                .modelo(dto.modelo())
                .palavraDeEfeito(dto.palavraDeEfeito())
                .tipo(tipoVeiculo)
                .fabricante(fabricante)
                .build();
    }

    @Override
    public VeiculoResponse toResponse(Veiculo e) {
        var tipoVeiculo = tipoVeiculoService.toResponse(e.getTipo());
        var fabricante = fabricanteService.toResponse(e.getFabricante());
        return VeiculoResponse.builder()
                .id(e.getId())
                .nome(e.getNome())
                .anoDeFabricacao(e.getAnoDeFabricacao())
                .cor(e.getCor())
                .preco(e.getPreco())
                .cilindradas(e.getCilindradas())
                .modelo(e.getModelo())
                .palavraDeEfeito(e.getPalavraDeEfeito())
                .tipo(tipoVeiculo)
                .fabricante(fabricante)
                .build();
    }
}
