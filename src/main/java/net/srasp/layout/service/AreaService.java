package net.srasp.layout.service;

import net.srasp.layout.entity.Area;
import net.srasp.layout.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
public class AreaService {
    @Autowired
    private AreaRepository areaRepository;

    @Persistent
    private EntityManager entityManager;

    public List<Area> getAll() {
        return areaRepository.findAll();
    }

    public void add(Area instance) {
        areaRepository.save(instance);
    }

    public Optional<Area> get(String id) {
        return areaRepository.findById(Long.parseLong(id));
    }

    public void update(String id, Area instance_update) {
        Optional<Area> existing_instance = areaRepository.findById(Long.parseLong(id));
        if (existing_instance.isPresent()) {
            if (existing_instance.get().getId().equals(instance_update.getId())) {
                areaRepository.save(instance_update);
            }
        }
    }

    public void delete(Long id) {
        areaRepository.deleteById(id);
    }

    public void save(Area instance) {
        areaRepository.save(instance);
    }

    public Query createQuery(String query) {
        return entityManager.createQuery(query);
    }
}
