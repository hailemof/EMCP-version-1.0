package net.mofed.reportracking.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import net.mofed.reportracking.app.model.Document;



@Repository
public interface DocumentRepository extends JpaRepository<Document, String> {
	
	@Query("from Document as d where d.directorname =:dirid")
	public List<Document> findDirectorateDocument(@Param("dirid") String directorname);
}
