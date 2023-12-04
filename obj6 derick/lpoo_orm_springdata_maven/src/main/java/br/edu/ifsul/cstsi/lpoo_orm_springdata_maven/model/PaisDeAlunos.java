package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.model;

import jakarta.persistence.*;

@Entity(name="paisDeAlunos")
@Table(name= "paisDeAlunos")
@PrimaryKeyJoinColumn(name="id_clientes")
public class PaisDeAlunos extends Clientes{

}
