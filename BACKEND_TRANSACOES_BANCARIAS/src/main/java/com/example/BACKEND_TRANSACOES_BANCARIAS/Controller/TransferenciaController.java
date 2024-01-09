package com.example.BACKEND_TRANSACOES_BANCARIAS.Controller;

import com.example.BACKEND_TRANSACOES_BANCARIAS.Model.Transferencia;
import com.example.BACKEND_TRANSACOES_BANCARIAS.Repository.TransferenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@CrossOrigin
public class TransferenciaController {

    @Autowired
    TransferenciaRepository transferenciaRepository;

    @GetMapping("/transferencia")
    public List<Transferencia> getTransferencia(){

        //Retorna a lista
        return transferenciaRepository.findAll();

    }

    @PostMapping("/transferencia")
    @ResponseStatus(HttpStatus.CREATED)
    public Transferencia salvar(@RequestBody Transferencia transferencia) {

        //O metado save grava e retorna o valor
        //gravado
        return transferenciaRepository.save(transferencia);

    }


    @GetMapping("/transferencia/{id}")
    public Transferencia getTransferencia(@PathVariable Long id) {

        return transferenciaRepository.findById(id).get();

    }


    @GetMapping("/transferencia/datatra")
    public List<Transferencia> getaproximardata_transferencia(@RequestParam("datatra") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate datatra) {
        // Ajusta a data para o formato esperado na consulta
        String dataFormatada = datatra.format(DateTimeFormatter.ISO_LOCAL_DATE);

        // Chama o método de busca no repositório
        return transferenciaRepository.search(dataFormatada);
    }



    @GetMapping("/transferencia/nome_operador_transacao")
    public ResponseEntity<List<Transferencia>> getTransferenciaBynomeoperador(@RequestParam String nome_operador_transacao){

        try {

            return new ResponseEntity<List<Transferencia>>(transferenciaRepository.searchByNomeoperadortransacao(nome_operador_transacao), HttpStatus.OK);

        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



    @GetMapping("/transferencia/dataEoperador")
    public List<Transferencia> dataEoperador(@RequestParam("data_transferencia") java.sql.Date dataTransferencia,
                                             @RequestParam("nome_operador_transacao") String nomeOperadorTransacao) {

        return transferenciaRepository.search2(dataTransferencia, nomeOperadorTransacao);

    }


    @GetMapping("/transferencia/Entredata")
    public List<Transferencia> Entredata(@RequestParam Date data_transferencia1, Date data_transferencia2){

        return transferenciaRepository.search3(data_transferencia1, data_transferencia2);

    }


    @GetMapping("/transferencia/soma")
    public float soma(){

        return transferenciaRepository.search4();

    }


}

