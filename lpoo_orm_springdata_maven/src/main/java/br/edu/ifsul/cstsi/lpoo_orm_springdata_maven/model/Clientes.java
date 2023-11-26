package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.model;

import jakarta.persistence.*;

@Entity(name= "clientes")
@Table(name= "clientes")
@Inheritance(strategy = InheritanceType.JOINED)
public class Clientes {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_clientes")
    private int codigo;
    @Column(name= "nome_clientes")
    private String nome;
    @Column(name= "idade_clientes")
    private int idade;
    @Column(name= "telefone_clientes")
    private int telefone;
    @Column(name= "endereco_clientes")
    private String endereco;
    @Column(name= "tipo_clientes")
    private int tipoCliente;
}
