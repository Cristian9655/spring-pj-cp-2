package br.com.fiap.concessionaria.resource;

import br.com.fiap.concessionaria.dto.request.AcessorioRequest;
import br.com.fiap.concessionaria.dto.response.AcessorioResponse;
import br.com.fiap.concessionaria.entity.Acessorio;
import br.com.fiap.concessionaria.service.AcessorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Collection;
import java.util.Objects;

@RestController
@RequestMapping(value = "/acessorio")
public class AcessorioResource implements ResourceDTO<Acessorio, AcessorioRequest, AcessorioResponse>{

    @Autowired
    private AcessorioService service;

    @GetMapping
    public ResponseEntity<Collection<AcessorioResponse>> findAll(

            @RequestParam(name = "acessorio.nome",required = false) String nomeA,
            @RequestParam(name = "acessorio.preco",required = false) Double precoA
    ){

        var acessorio = Acessorio.builder()
                .nome(nomeA)
                .preco(precoA)
                .build();

        ExampleMatcher matcher = ExampleMatcher.matchingAll().withIgnoreNullValues().withIgnoreCase();

        Example<Acessorio> example = Example.of(acessorio, matcher);

        Collection<Acessorio> accessorizes = service.findAll(example);

        var response = accessorizes.stream().map(service::toResponse).toList();

        return ResponseEntity.ok(response);

    }


    @GetMapping(value = "/{id}")
    @Override
    public ResponseEntity<AcessorioResponse> findById(Long id) {
        var entity = service.findById(id);

        if (Objects.isNull(entity)) return  ResponseEntity.notFound().build();

        var response = service.toResponse(entity);

        return ResponseEntity.ok(response);
    }

    @Transactional
    @PostMapping
    @Override
    public ResponseEntity<AcessorioResponse> save(AcessorioRequest r) {
        var entity = service.toEntity(r);
        var saved = service.save(entity);
        var response = service.toResponse(saved);

        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saved.getId())
                .toUri();

        return ResponseEntity.created(uri).body(response);
    }
}
