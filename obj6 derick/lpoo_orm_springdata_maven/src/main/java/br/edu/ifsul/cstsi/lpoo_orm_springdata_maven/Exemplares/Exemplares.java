package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.Exemplares;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name= "exemplares")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exemplares {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_exemplar")
    private Integer id;

    @Column(name="nome_exemplar")
    private String nome;
    @Column(name="tipo_exemplar")
    private String tipoExemplar;

}
