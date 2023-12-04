package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.model;

import jakarta.persistence.*;

@Entity(name="alunos")
@Table(name= "alunos")
@PrimaryKeyJoinColumn(name="id_clientes")
public class Alunos extends Clientes{
}
