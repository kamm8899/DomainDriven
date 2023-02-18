package edu.stevens.cs548.clinic.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;


// TODO
@Entity
@Table(name = "physiotherapy_treatment")
public class PhysiotherapyTreatment extends Treatment {

	private static final long serialVersionUID = 5602950140629148756L;

	// TODO (including order by date)
	@OrderBy
	@ElementCollection
	protected List<LocalDate> treatmentDates;

	public void addTreatmentDate(LocalDate date) {
		treatmentDates.add(date);
	}
	public PhysiotherapyTreatment() {
		super();
		treatmentDates = new ArrayList<>();
	}
}
