package net.mofed.reportracking.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.mofed.reportracking.app.model.Role;



@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{

	public Role findByName(String name);
}
