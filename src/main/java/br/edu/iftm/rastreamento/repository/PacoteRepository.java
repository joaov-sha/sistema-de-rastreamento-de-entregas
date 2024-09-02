package br.edu.iftm.rastreamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.iftm.rastreamento.model.Pacote;

@Repository
public interface PacoteRepository extends CrudRepository<Pacote, Long> {
	
    @Query("SELECT p FROM Pacote p WHERE p.status = :status")
    List<Pacote> findByStatus(String status);

    @Query("SELECT p FROM Pacote p WHERE p.destinatario = :destinatario")
    List<Pacote> findByDestinatario(String destinatario);
}
