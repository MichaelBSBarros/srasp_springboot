package net.srasp.layout.service;

import net.srasp.layout.entity.Secretaria;
import net.srasp.layout.repository.SecretariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
public class SecretariaService {
    @Autowired
    private SecretariaRepository secretariaRepository;

    @Persistent
    private EntityManager entityManager;

    public List<Secretaria> getAll() {
        return secretariaRepository.findAll();
    }

    public void add(Secretaria instance) {
        secretariaRepository.save(instance);
    }

    public Optional<Secretaria> get(String id) {
        return secretariaRepository.findById(Long.parseLong(id));
    }

    public void update(String id, Secretaria instance_update) {
        Optional<Secretaria> existing_instance = secretariaRepository.findById(Long.parseLong(id));
        if (existing_instance.isPresent()) {
            if (existing_instance.get().getId().equals(instance_update.getId())) {
                secretariaRepository.save(instance_update);
            }
        }
    }

    public void delete(Long id) {
        secretariaRepository.deleteById(id);
    }

    public void save(Secretaria instance) {
        secretariaRepository.save(instance);
    }

    public Query createQuery(String query) {
        return entityManager.createQuery(query);
    }
}
