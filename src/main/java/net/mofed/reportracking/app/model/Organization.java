package net.mofed.reportracking.app.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Organization {
	
	@Id
	
	private String id;
	private String orgname;
	private String email;
	private String telephone;
	private String organizationhead;
	
		public String  getId() {
		return id;
	     }
	

	public void setId(String id) {
		this.id = id;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getOrganizationhead() {
		return organizationhead;
	}

	public void setOrganizationhead(String organizationhead) {
		this.organizationhead = organizationhead;
	}


	
	  
}
