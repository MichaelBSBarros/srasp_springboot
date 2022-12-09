package net.srasp.layout.service;

import net.srasp.layout.entity.Regiao;
import net.srasp.layout.repository.RegiaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
public class RegiaoService {
    @Autowired
    private RegiaoRepository regiaoRepository;

    @Persistent
    private EntityManager entityManager;

    public List<Regiao> getAll() {
        return regiaoRepository.findAll();
    }

    public void add(Regiao instance) {
        regiaoRepository.save(instance);
    }

    public Optional<Regiao> get(String id) {
        return regiaoRepository.findById(Long.parseLong(id));
    }

    public void update(String id, Regiao instance_update) {
        Optional<Regiao> existing_instance = regiaoRepository.findById(Long.parseLong(id));
        if (existing_instance.isPresent()) {
            if (existing_instance.get().getId().equals(instance_update.getId())) {
                regiaoRepository.save(instance_update);
            }
        }
    }

    public void delete(Long id) {
        regiaoRepository.deleteById(id);
    }

    public void save(Regiao instance) {
        regiaoRepository.save(instance);
    }

    public Query createQuery(String query) {
        return entityManager.createQuery(query);
    }
}
