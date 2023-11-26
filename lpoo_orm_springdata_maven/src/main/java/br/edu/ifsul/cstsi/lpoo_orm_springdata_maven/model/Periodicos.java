package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity(name= "periodicos")
@Table(name= "periodicos")
@PrimaryKeyJoinColumn(name="id_exemplar")
public class Periodicos extends Exemplares{
    @Column(name="editora_periodicos")
    private String editora;
}
