package com.example.BACKEND_TRANSACOES_BANCARIAS.Repository;

import com.example.BACKEND_TRANSACOES_BANCARIAS.Model.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {

    @Query(value = "SELECT * FROM transferencia WHERE TO_CHAR(data_transferencia, 'YYYY-MM-DD') LIKE CONCAT('%', :data_transferencia, '%')", nativeQuery = true)
    public List<Transferencia> search(@Param("data_transferencia") String data_transferencia);

    @Query("SELECT t FROM Transferencia t WHERE LOWER(t.nomeoperadortransacao) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Transferencia> searchByNomeoperadortransacao(@Param("nome") String nomeoperadortransacao);

    @Query(value = "SELECT * FROM transferencia WHERE DATE_TRUNC('DAY', data_transferencia) = DATE_TRUNC('DAY', CAST(:data_transferencia AS DATE)) AND LOWER(nome_operador_transacao) LIKE LOWER(concat('%', :nomeoperadortransacao, '%'))", nativeQuery = true)
    public List<Transferencia> search2(@Param("data_transferencia") java.sql.Date data_transferencia, @Param("nomeoperadortransacao") String nomeoperadortransacao);

    @Query(value = "SELECT * FROM transferencia WHERE DATE(data_transferencia) BETWEEN DATE(:data_transferencia1) AND DATE(:data_transferencia2)", nativeQuery = true)
    public List<Transferencia> search3(Date data_transferencia1, Date data_transferencia2);

    @Query(value = "SELECT SUM(valor) FROM transferencia WHERE tipo='DEPOSITO'", nativeQuery = true)
    public float search4();

}
