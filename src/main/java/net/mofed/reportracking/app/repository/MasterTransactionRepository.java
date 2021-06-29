package net.mofed.reportracking.app.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



import net.mofed.reportracking.app.model.MasterTransaction;
import net.mofed.reportracking.app.model.User;


@Repository
public interface MasterTransactionRepository extends JpaRepository<MasterTransaction, Integer>

       {
        @Query("SELECT p FROM MasterTransaction p WHERE CONCAT(p.id, ' ', p.transactiondocumentid) LIKE %?1%")
    	public List<MasterTransaction> findByDirectorate(String keyword);
        
	    @Query("SELECT z FROM MasterTransaction z WHERE CONCAT(z.id, ' ', z.createdBy) LIKE %?1%")
	    public List<MasterTransaction> findTransactionByUsername(String  orgtrans);
	    
	    
	    @Query("from MasterTransaction as m where m.user.id =:userid")
		
		public List<MasterTransaction> findTransactionByOrg(@Param("userid") Long id);
	   
	   
           @Query("from MasterTransaction as m where m.assigned_expert_user_id =:expertid")
		public List<MasterTransaction> findTransactionByExpert(@Param("expertid") Long assigned_expert_user_id);	    
		
        
           @Query("from MasterTransaction as m where m.organizaid =:orgcode")
   		public List<MasterTransaction> findAllTransactionByOrg(@Param("orgcode") String organizaid);
           
           
	    
	    @Query("SELECT t FROM MasterTransaction t where t.createdBy = :createdBy AND t.docname = :docname")
	    public List <MasterTransaction> findByUsertransaction(@Param("createdBy") String createdBy, 
	                                                    @Param("docname") User user);
	    
	    @Modifying
	    @Query("update MasterTransaction u set u.reportstatus = :reportstatus where u.id = :id")
	    public List<MasterTransaction> updateReportStatus(@Param(value = "id") Integer id, @Param(value = "reportstatus") String reportstatus);

       }


  




