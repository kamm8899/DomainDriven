package edu.stevens.cs548.clinic.data;

public class TreatmentFactory implements ITreatmentFactory {

	@Override
	public DrugTreatment createDrugTreatment() {
		return new DrugTreatment();
	}

	// TODO define other factory methods
	@Override
	public RadiologyTreatment createRadiologyTreatment() {
		return new RadiologyTreatment();
	}

	@Override
	public PhysiotherapyTreatment createPhysiotherapyTreatment() {
		return new PhysiotherapyTreatment();
	}

	@Override
	public SurgeryTreatment createSurgeryTreatment() {
		return new SurgeryTreatment();
	}

}
