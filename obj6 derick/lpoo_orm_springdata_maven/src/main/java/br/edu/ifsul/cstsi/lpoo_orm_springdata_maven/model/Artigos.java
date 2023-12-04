package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.model;

import br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.Exemplares.Exemplares;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity(name= "artigos")
@Table(name= "artigos")
@PrimaryKeyJoinColumn(name="id_exemplar")
public class Artigos extends Exemplares {
    @Column(name="autor_artigos")
    private String autor;
}
