package net.srasp.layout.service;

import net.srasp.layout.entity.Severidade;
import net.srasp.layout.repository.SeveridadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
public class SeveridadeService {
    @Autowired
    private SeveridadeRepository severidadeRepository;

    @Persistent
    private EntityManager entityManager;

    public List<Severidade> getAll() {
        return severidadeRepository.findAll();
    }

    public void add(Severidade instance) {
        severidadeRepository.save(instance);
    }

    public Optional<Severidade> get(String id) {
        return severidadeRepository.findById(Long.parseLong(id));
    }

    public void update(String id, Severidade instance_update) {
        Optional<Severidade> existing_instance = severidadeRepository.findById(Long.parseLong(id));
        if (existing_instance.isPresent()) {
            if (existing_instance.get().getId().equals(instance_update.getId())) {
                severidadeRepository.save(instance_update);
            }
        }
    }

    public void delete(Long id) {
        severidadeRepository.deleteById(id);
    }

    public void save(Severidade instance) {
        severidadeRepository.save(instance);
    }

    public Query createQuery(String query) {
        return entityManager.createQuery(query);
    }
}
