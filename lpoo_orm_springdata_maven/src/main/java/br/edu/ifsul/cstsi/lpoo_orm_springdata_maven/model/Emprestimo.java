package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name="emprestimo")
@Table(name="emprestimo")
public class Emprestimo {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_emprestimo")
    private int codigo;
    @Column(name = "dt_emprestimo")
    private LocalDate dataEmprestimo;
    @Column(name = "dt_devolucao")
    private LocalDate dataDevolucao;

    @OneToOne
    private Clientes clientes;
    @OneToOne
    private Exemplares exemplares;
}
