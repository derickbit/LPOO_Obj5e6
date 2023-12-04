package br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.Exemplares;

import br.edu.ifsul.cstsi.lpoo_orm_springdata_maven.Exemplares.ExemplaresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExemplaresService {

    @Autowired
    private ExemplaresRepository rep;
    private static ExemplaresService exemplaresService;
    public List<Exemplares> getExemplares() {
        return rep.findAll();
    }

    public Exemplares getExemplaresById(Integer id) {
        Optional<Exemplares> optional = rep.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

        public List<Exemplares> getExemplaresByNome(String nome) {
        return new ArrayList<>(rep.findByNome(nome + "%"));
    }

    public Exemplares insert(Exemplares exemplares) {
        Assert.isNull(exemplares.getId(),"Não foi possível inserir o registro");
        return rep.save(exemplares);
    }

    public Exemplares update(Exemplares exemplares) {
        Assert.notNull(exemplares.getId(),"Não foi possível atualizar o registro");

        // Busca o produto no banco de dados
        Optional<Exemplares> optional = rep.findById(exemplares.getId());
        if(optional.isPresent()) {
            Exemplares db = optional.get();
            // Copiar as propriedades
            db.setNome(exemplares.getNome());
            db.setTipoExemplar(exemplares.getTipoExemplar());
            // Atualiza o produto
            rep.save(db);

            return db;
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Integer id) {
        rep.deleteById(id);
    }
}
