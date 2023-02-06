package edu.stevens.cs548.clinic.data;

import jakarta.persistence.Index;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Collection;
import java.util.UUID;


/**
 * Entity implementation class for Entity: Treatment
 *
 */
@NamedQueries({
	@NamedQuery(
		name="SearchTreatmentByTreatmentId",
		query="select t from Treatment t where t.treatmentId = :treatmentId"),
	@NamedQuery(
			name="CountTreatmentByTreatmentId",
			query="select count(t) from Treatment t where t.treatmentId = :treatmentId"),
	@NamedQuery(
		name = "RemoveAllTreatments", 
		query = "delete from Treatment t")
})

// TODO

public abstract class Treatment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// TODO PK
	protected long id;
	
	// TODO
	protected UUID treatmentId;
	
	protected String diagnosis;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public UUID getTreatmentId() {
		return treatmentId;
	}

	public void setTreatmentId(UUID treatmentId) {
		this.treatmentId = treatmentId;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	/*
	 * TODO propagate persist of treatment to provider
	 */
	protected Patient patient;

	public Patient getPatient() {
		return patient;
	}

	void setPatient(Patient patient) {
		this.patient = patient;
		/*
		 * Make sure the patient also links back to this treatment.
		 */
		if (!patient.receives(this)) {
			patient.addTreatment(this);
		}
	}

	/*
	 * TODO propagate persist of treatment to provider
	 */
	protected Provider provider;

	public Provider getProvider() {
		return provider;
	}	
	
	public void setProvider(Provider provider) {
		// TODO see setPatient
	}	
	
	/*
	 * TODO
	 */
	protected Collection<Treatment> followupTreatments;
	
	public void addFollowupTreatment(Treatment t) {
		followupTreatments.add(t);
	}


	public Treatment() {
		super();
		/*
		 * TODO initialize lists
		 */
	}   
}
