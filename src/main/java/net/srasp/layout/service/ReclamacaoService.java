package net.srasp.layout.service;

import net.srasp.layout.entity.Reclamacao;
import net.srasp.layout.repository.ReclamacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
public class ReclamacaoService {
    @Autowired
    private ReclamacaoRepository reclamacaoRepository;

    @Persistent
    private EntityManager entityManager;

    public List<Reclamacao> getAll() {
        return reclamacaoRepository.findAll();
    }

    public void add(Reclamacao instance) {
        reclamacaoRepository.save(instance);
    }

    public Optional<Reclamacao> get(String id) {
        return reclamacaoRepository.findById(Long.parseLong(id));
    }

    public void update(String id, Reclamacao instance_update) {
        Optional<Reclamacao> existing_instance = reclamacaoRepository.findById(Long.parseLong(id));
        if (existing_instance.isPresent()) {
            if (existing_instance.get().getId().equals(instance_update.getId())) {
                reclamacaoRepository.save(instance_update);
            }
        }
    }

    public void delete(Long id) {
        reclamacaoRepository.deleteById(id);
    }

    public void save(Reclamacao instance) {
        reclamacaoRepository.save(instance);
    }

    public Query createQuery(String query) {
        return entityManager.createQuery(query);
    }
}
