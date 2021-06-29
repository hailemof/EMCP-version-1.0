package net.mofed.reportracking.app.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


    public class Document {
	
	@Id
	private String id;
	
	private String reportype;
	
	@ManyToOne
	@JoinColumn(name="directorname",insertable=false,updatable=false)
	private Directorate directorate;
	private String directorname;
	
		
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReportype() {
		return reportype;
	}
	public void setReportype(String reportype) {
		this.reportype = reportype;
	}
	public Directorate getDirectorate() {
		return directorate;
	}
	public void setDirectorate(Directorate directorate) {
		this.directorate = directorate;
	}
	public String getDirectorname() {
		return directorname;
	}
	public void setDirectorname(String directorname) {
		this.directorname = directorname;
	}
	
}
