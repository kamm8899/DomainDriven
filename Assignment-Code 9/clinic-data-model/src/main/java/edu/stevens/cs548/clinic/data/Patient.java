package edu.stevens.cs548.clinic.data;

import jakarta.persistence.Index;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

/**
 * Entity implementation class for Entity: Patient
 *
 */
/**
 * Entity implementation class for Entity: Patient
 *
 */
@NamedQueries({
	@NamedQuery(
		name="SearchPatientByPatientId",
		query="select p from Patient p where p.patientId = :patientId"),
	@NamedQuery(
		name="CountPatientByPatientId",
		query="select count(p) from Patient p where p.patientId = :patientId"),
	@NamedQuery(
		name = "SearchAllPatients", 
		query = "select p from Patient p"),
	@NamedQuery(
		name = "RemoveAllPatients", 
		query = "delete from Patient p")
})

// TODO

public class Patient implements Serializable {
		
	private static final long serialVersionUID = -4512912599605407549L;

	// TODO PK
	private long id;
	
	// TODO
	private UUID patientId;
			
	private String name;

	private LocalDate dob;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public UUID getPatientId() {
		return patientId;
	}

	public void setPatientId(UUID patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	// TODO JPA annotations (propagate persist of patient to treatments)
	private Collection<Treatment> treatments;

	
	public boolean receives(Treatment t) {
		return treatments.contains(t);
	}

	/**
	 * Call both this and Provider::addTreatment
	 */
	public void addTreatment (Treatment t) {
		treatments.add(t);
		if (t.getPatient() != this) {
			t.setPatient(this);
		}
	}
	
	public Patient() {
		super();
		treatments = new ArrayList<Treatment>();
	}
   
}
