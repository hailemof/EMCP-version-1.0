package net.mofed.reportracking.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@EqualsAndHashCode(callSuper=false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@DynamicUpdate
  public class MasterTransaction extends Auditable<String> {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	 	    
	    private String docname;
		//private String doctype;
		private String reportstatus;
		
		@Column(length=5000)
		private String remarks;
		
	
		public String getRemarks() {
			return remarks;
		}

		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}

		@JsonIgnore
		@ManyToOne
		@JoinColumn(name="user_id", updatable =false)
		private User user;
		
		@ManyToOne
		@JoinColumn(name="organizaid", insertable =false,updatable =false)
		private Organization organiza;
		String organizaid;
		
		
		@ManyToOne
		@JoinColumn(name="assigned_expert_user_id", insertable =false,updatable =false)
		private User user2;
		private long assigned_expert_user_id ;
		
		
		
		public User getUser2() {
			return user2;
		}

		public void setUser2(User user2) {
			this.user2 = user2;
		}

		public long getAssigned_expert_user_id() {
			return assigned_expert_user_id;
		}

		public void setAssigned_expert_user_id(long assigned_expert_user_id) {
			this.assigned_expert_user_id = assigned_expert_user_id;
		}

		public String getOrganizaid() {
			return organizaid;
		}

		public void setOrganizaid(String organizaid) {
			this.organizaid = organizaid;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public String getReportstatus() {
			return reportstatus;
		}

		public void setReportstatus(String reportstatus) {
			this.reportstatus = reportstatus;
		}

		@ManyToOne
		@JoinColumn(name="transactiondocumentid",insertable=false,updatable=false)
		private Document transactiondocument;
		private  String transactiondocumentid;
		

		public Document getTransactiondocument() {
			return transactiondocument;
		}

		public void setTransactiondocument(Document transactiondocument) {
			this.transactiondocument = transactiondocument;
		}

		public String getTransactiondocumentid() {
			return transactiondocumentid;
		}

		public void setTransactiondocumentid(String transactiondocumentid) {
			this.transactiondocumentid = transactiondocumentid;
		}
				
	//	@Lob
	//	private byte[] data;
		
		
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

	public String getDocname() {
		return docname;
	}

		public void setDocname(String docname) {
			this.docname = docname;
		}

		
		
  }

