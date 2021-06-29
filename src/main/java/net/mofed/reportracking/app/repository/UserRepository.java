package net.mofed.reportracking.app.repository;

 
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.mofed.reportracking.app.model.User;



@Repository

public interface UserRepository extends CrudRepository<User, Long> {

	public Optional<User> findByUsername(String username);
	
	@Query("select u from User u where u.username =:username")
	public User getUserByUsername(@Param("username") String username);
	
	
   @Query("from User as u where u.user_dir_name =:directorid AND u.org_id=:theorgid ")
   public List<User> findExpertByDirectorateAndOrg(@Param ("directorid") String user_dir_name,@Param("theorgid") String org_id);
	
 }

