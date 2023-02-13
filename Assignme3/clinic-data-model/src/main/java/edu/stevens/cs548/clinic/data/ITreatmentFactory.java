package edu.stevens.cs548.clinic.data;

public interface ITreatmentFactory {

	public DrugTreatment createDrugTreatment();

	/*
	 * TODO add methods for Radiology, Surgery, Physiotherapy
	 */
	public RadiologyTreatment createRadiologyTreatment();

	public PhysiotherapyTreatment createPhysiotherapyTreatment();

	public SurgeryTreatment createSurgeryTreatment();
}