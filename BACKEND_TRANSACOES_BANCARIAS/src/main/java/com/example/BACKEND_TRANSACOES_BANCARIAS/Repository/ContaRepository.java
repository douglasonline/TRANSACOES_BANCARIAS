package com.example.BACKEND_TRANSACOES_BANCARIAS.Repository;

import com.example.BACKEND_TRANSACOES_BANCARIAS.Model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

}
