package com.reciclamais.coletas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/coletas", produces = MediaType.APPLICATION_JSON_VALUE)
public class ColetaApi {
    @Autowired
    private ColetaFacade facade;

    @PostMapping
    @ResponseBody
    public ColetaDTO criar(@RequestBody ColetaDTO coleta) {
        return facade.criar(coleta);
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

    @DeleteMapping("/{coletaId}")
    @ResponseBody
    public String remover(@PathVariable("coletaId") Long coletaId) {
        return facade.excluir(coletaId);
    }
}
