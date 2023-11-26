package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity(name= "livros")
@Table(name= "livros")
@PrimaryKeyJoinColumn(name="id_exemplar")
public class Livros extends Exemplares {
    @Column(name= "autor_livros")
    private String autor;
    @Column(name= "editora_livros")
    private String editora;
    @Column(name= "edicao_livros")
    private int edicao;
}
