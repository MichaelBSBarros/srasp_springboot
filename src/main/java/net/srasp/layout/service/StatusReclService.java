package net.srasp.layout.service;

import net.srasp.layout.entity.StatusRecl;
import net.srasp.layout.repository.StatusReclRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
public class StatusReclService {
    @Autowired
    private StatusReclRepository statusreclRepository;

    @Persistent
    private EntityManager entityManager;

    public List<StatusRecl> getAll() {
        return statusreclRepository.findAll();
    }

    public void add(StatusRecl instance) {
        statusreclRepository.save(instance);
    }

    public Optional<StatusRecl> get(String id) {
        return statusreclRepository.findById(Long.parseLong(id));
    }

    public void update(String id, StatusRecl instance_update) {
        Optional<StatusRecl> existing_instance = statusreclRepository.findById(Long.parseLong(id));
        if (existing_instance.isPresent()) {
            if (existing_instance.get().getId().equals(instance_update.getId())) {
                statusreclRepository.save(instance_update);
            }
        }
    }

    public void delete(Long id) {
        statusreclRepository.deleteById(id);
    }

    public void save(StatusRecl instance) {
        statusreclRepository.save(instance);
    }

    public Query createQuery(String query) {
        return entityManager.createQuery(query);
    }
}
