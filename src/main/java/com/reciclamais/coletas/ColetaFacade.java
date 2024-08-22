package com.reciclamais.coletas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ColetaFacade {
    @Autowired
    private IColetaRepository coletaRepository;

    public ColetaDTO criar(ColetaDTO coletaDTO) {
        Coleta coleta = new Coleta();
        coleta.setNome(coletaDTO.getNome());
        coleta.setCpf(tratarCpf(coletaDTO.getCpf()));
        coleta.setTelefone(tratarTelefone(coletaDTO.getTelefone()));
        coleta.setEmail(coletaDTO.getEmail());
        coleta.setTipoobjetodescartado(coletaDTO.getTipoobjetodescartado());
        coleta.setObjetodescartado(coletaDTO.getObjetodescartado());
        coleta.setResponsavelcoleta(coletaDTO.getResponsavelcoleta());
        coleta.setMotivodescarte(coletaDTO.getMotivodescarte());
        coleta.setDatahora(coletaDTO.getDatahora());

        coletaRepository.save(coleta);
        coletaDTO.setId(coleta.getId());
        return coletaDTO;
    }

    public ColetaDTO atualizar (ColetaDTO coletaDTO, Long coletaId) {
        Coleta coletaDatabase = coletaRepository.getOne(coletaId);
        coletaDatabase.setNome(coletaDTO.getNome());
        coletaDatabase.setCpf(coletaDTO.getCpf());
        coletaDatabase.setTelefone(coletaDTO.getTelefone());
        coletaDatabase.setEmail(coletaDTO.getEmail());
        coletaDatabase.setTipoobjetodescartado(coletaDTO.getTipoobjetodescartado());
        coletaDatabase.setObjetodescartado(coletaDTO.getObjetodescartado());
        coletaDatabase.setResponsavelcoleta(coletaDTO.getResponsavelcoleta());
        coletaDatabase.setMotivodescarte(coletaDTO.getMotivodescarte());
        coletaDatabase.setDatahora(coletaDTO.getDatahora());

        coletaRepository.save(coletaDatabase);
        return coletaDTO;
    }

    private ColetaDTO converter (Coleta coleta) {
        ColetaDTO result = new ColetaDTO();
        result.setId(coleta.getId());
        result.setNome(coleta.getNome());
        result.setCpf(coleta.getCpf());
        result.setTelefone(coleta.getTelefone());
        result.setEmail(coleta.getEmail());
        result.setTipoobjetodescartado(coleta.getTipoobjetodescartado());
        result.setObjetodescartado(coleta.getObjetodescartado());
        result.setResponsavelcoleta(coleta.getResponsavelcoleta());
        result.setMotivodescarte(coleta.getMotivodescarte());
        result.setDatahora(coleta.getDatahora());

        return result;
    }

    public ColetaDTO listarPorId(Long coletaId) {
        Optional<Coleta> optEntity = coletaRepository.findById(coletaId);


        return optEntity.map(this::converter).orElse(null);
    }

    public List<ColetaDTO> buscarPorNome(String nome) {
        return coletaRepository.BuscarPorNome(nome)
                .stream()
                .map(coleta -> converter(coleta)).collect(Collectors.toList());
    }

    public List<ColetaDTO> listarTodos() {
        return coletaRepository
                .findAll()
                .stream()
                .map(this::converter).collect(Collectors.toList());
    }

    public void excluir(Long coletaId) {
        coletaRepository.deleteById(coletaId);
    }

    private String tratarTelefone(String telefone){
        return telefone
                .replace("-", "")
                .replace("(", "")
                .replace(")", "")
                .replace(" ", "")
                .trim();
    }

    private String tratarCpf(String cpf){
        return cpf
                .replace("-", "")
                .replace(".", "")
                .trim();
    }
}
