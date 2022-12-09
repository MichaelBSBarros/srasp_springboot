package net.srasp.layout.service;

import net.srasp.layout.entity.Unidade;
import net.srasp.layout.repository.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
public class UnidadeService {
    @Autowired
    private UnidadeRepository unidadeRepository;

    @Persistent
    private EntityManager entityManager;

    public List<Unidade> getAll() {
        return unidadeRepository.findAll();
    }

    public void add(Unidade instance) {
        unidadeRepository.save(instance);
    }

    public Optional<Unidade> get(String id) {
        return unidadeRepository.findById(Long.parseLong(id));
    }

    public void update(String id, Unidade instance_update) {
        Optional<Unidade> existing_instance = unidadeRepository.findById(Long.parseLong(id));
        if (existing_instance.isPresent()) {
            if (existing_instance.get().getId().equals(instance_update.getId())) {
                unidadeRepository.save(instance_update);
            }
        }
    }

    public void delete(Long id) {
        unidadeRepository.deleteById(id);
    }

    public void save(Unidade instance) {
        unidadeRepository.save(instance);
    }

    public Query createQuery(String query) {
        return entityManager.createQuery(query);
    }
}
