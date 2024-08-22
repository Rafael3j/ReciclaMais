package com.reciclamais.coletas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/coletas", produces = MediaType.APPLICATION_JSON_VALUE)
public class ColetaApi {
    @Autowired
    private ColetaFacade facade;

    @PostMapping
    @ResponseBody
    public ResponseEntity<ColetaDTO> criar(@RequestBody ColetaDTO coletaDTO, UriComponentsBuilder uriBuilder) {
        coletaDTO.setDatahora(LocalDateTime.now());
        coletaDTO = facade.criar(coletaDTO);

        URI uri = uriBuilder.path("/coletas/{id}").buildAndExpand(coletaDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(coletaDTO);
    }

    @PutMapping("/{coletaId}")
    @ResponseBody
    public ColetaDTO atualizar(@PathVariable("coletaId") Long coletaId, @RequestBody ColetaDTO coleta) {
        return facade.atualizar(coleta, coletaId);
    }

    @GetMapping("/{coletaId}")
    @ResponseBody
    public ColetaDTO buscar(@PathVariable("coletaId") Long coletaId) {
        return facade.listarPorId(coletaId);
    }

    @GetMapping
    @ResponseBody
    public List<ColetaDTO> listarTodos() {
        return facade.listarTodos();
    }

    @GetMapping(value = "buscarPorNome")
    @ResponseBody
    public List<ColetaDTO> buscarPorNome(@RequestParam String nome) {
        return facade.buscarPorNome(nome.toLowerCase());
    }

    @DeleteMapping("/{coletaId}")
    @ResponseBody
    public ResponseEntity remover(@PathVariable("coletaId") Long coletaId) {
        facade.excluir(coletaId);
        return ResponseEntity.ok().build();
    }
}
