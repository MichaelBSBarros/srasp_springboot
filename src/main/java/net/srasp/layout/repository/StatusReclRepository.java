package net.srasp.layout.repository;

import net.srasp.layout.entity.StatusRecl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface StatusReclRepository extends JpaRepository<StatusRecl, Long> {

}
