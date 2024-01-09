package com.example.BACKEND_TRANSACOES_BANCARIAS.Controller;

import com.example.BACKEND_TRANSACOES_BANCARIAS.Model.Conta;
import com.example.BACKEND_TRANSACOES_BANCARIAS.Repository.ContaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ContaController {

    @Autowired
    ContaRepository contaRepository;

    @GetMapping("/conta")
    public List<Conta> getConta(){

        //Retorna a lista
        return contaRepository.findAll();

    }

    @PostMapping("/conta")
    @ResponseStatus(HttpStatus.CREATED)
    public Conta salvar(@RequestBody Conta conta) {

        //O metado save grava e retorna o valor
        //gravado
        return contaRepository.save(conta);

    }

    @PutMapping("/conta/{id}")
    public ResponseEntity<Object> atualizarConta(@PathVariable Long id, @RequestBody Conta contaAtualizada) {
        Optional<Conta> contaExistenteOptional = contaRepository.findById(id);

        if (contaExistenteOptional.isPresent()) {
            Conta contaExistente = contaExistenteOptional.get();

            contaExistente.setNome_responsavel(contaAtualizada.getNome_responsavel());
            // Atualize outros campos conforme necessário

            Conta contaAtualizadaSalva = contaRepository.save(contaExistente);

            return ResponseEntity.ok(contaAtualizadaSalva);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Conta com o ID: " + id + " não encontrada");
        }
    }


    @DeleteMapping("/conta/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long codigo) {

        contaRepository.deleteById(codigo);

    }

}

