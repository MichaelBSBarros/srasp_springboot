package net.srasp.layout.service;

import net.srasp.layout.entity.Microrregiao;
import net.srasp.layout.repository.MicrorregiaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
public class MicrorregiaoService {
    @Autowired
    private MicrorregiaoRepository microrregiaoRepository;

    @Persistent
    private EntityManager entityManager;

    public List<Microrregiao> getAll() {
        return microrregiaoRepository.findAll();
    }

    public void add(Microrregiao instance) {
        microrregiaoRepository.save(instance);
    }

    public Optional<Microrregiao> get(String id) {
        return microrregiaoRepository.findById(Long.parseLong(id));
    }

    public void update(String id, Microrregiao instance_update) {
        Optional<Microrregiao> existing_instance = microrregiaoRepository.findById(Long.parseLong(id));
        if (existing_instance.isPresent()) {
            if (existing_instance.get().getId().equals(instance_update.getId())) {
                microrregiaoRepository.save(instance_update);
            }
        }
    }

    public void delete(Long id) {
        microrregiaoRepository.deleteById(id);
    }

    public void save(Microrregiao instance) {
        microrregiaoRepository.save(instance);
    }

    public Query createQuery(String query) {
        return entityManager.createQuery(query);
    }
}
