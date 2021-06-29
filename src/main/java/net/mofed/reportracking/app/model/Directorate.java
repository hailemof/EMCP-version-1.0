package net.mofed.reportracking.app.model;

import java.util.List;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Directorate {
	
	 @Id
	 private String directoratename;
	
	
	private String telephone;
	private String  email;
	
	@OneToMany(mappedBy="directorate")
	private List<Document> documents;

	public String getDirectoratename() {
		return directoratename;
	}

	public void setDirectoratename(String directoratename) {
		this.directoratename = directoratename;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	
		
	
}
