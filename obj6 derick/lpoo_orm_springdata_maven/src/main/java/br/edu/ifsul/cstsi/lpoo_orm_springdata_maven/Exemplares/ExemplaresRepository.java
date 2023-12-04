package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.Exemplares;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ExemplaresRepository extends JpaRepository<Exemplares,Integer> {

    @Query(value = "SELECT c FROM Exemplares c where c.nome like ?1")
    List<Exemplares> findByNome(String nome);
//    List<Exemplares> findBySituacao(Boolean situacao);
//
//    @Query(value = "SELECT c FROM Exemplares c where c.id = ?1 and c.situacao=true")
//    Optional<Exemplares> finByIdSituacaoTrue(Integer id);

}
