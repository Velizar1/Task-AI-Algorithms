package com.company;

import java.util.List;
import java.util.stream.Collectors;

public class ProbabilityOfSet {

    //TODO
    //Create 16 attribute classes for each param probability, then calculate

    private Double handicappedYRep;
    private Double handicappedNRep;
    private Double handicappedNullRep;
    private Double handicappedYDem;
    private Double handicappedNDem;
    private Double handicappedNullDem;

    private Double waterProjectYRep;
    private Double waterProjectNRep;
    private Double waterProjectNullRep;
    private Double waterProjectYDem;
    private Double waterProjectNDem;
    private Double waterProjectNullDem;

    private Double adoptionOfTheBudgetYRep;
    private Double adoptionOfTheBudgetNRep;
    private Double adoptionOfTheBudgetNullRep;
    private Double adoptionOfTheBudgetYDem;
    private Double adoptionOfTheBudgetNDem;
    private Double adoptionOfTheBudgetNullDem;

    private Double physicianFeeYRep;
    private Double physicianFeeNRep;
    private Double physicianFeeNullRep;
    private Double physicianFeeYDem;
    private Double physicianFeeNDem;
    private Double physicianFeeNullDem;

    private Double elSalvadorAidYRep;
    private Double elSalvadorAidNRep;
    private Double elSalvadorAidNullRep;
    private Double elSalvadorAidYDem;
    private Double elSalvadorAidNDem;
    private Double elSalvadorAidNullDem;

    private Double religiousGroupsYRep;
    private Double religiousGroupsNRep;
    private Double religiousGroupsNullRep;
    private Double religiousGroupsYDem;
    private Double religiousGroupsNDem;
    private Double religiousGroupsNullDem;

    private Double antiSatelliteYRep;
    private Double antiSatelliteNRep;
    private Double antiSatelliteNullRep;
    private Double antiSatelliteYDem;
    private Double antiSatelliteNDem;
    private Double antiSatelliteNullDem;

    private Double aidToNicaraguanYRep;
    private Double aidToNicaraguanNRep;
    private Double aidToNicaraguanNullRep;
    private Double aidToNicaraguanYDem;
    private Double aidToNicaraguanNDem;
    private Double aidToNicaraguanNullDem;

    private Double mxMissileYRep;
    private Double mxMissileNRep;
    private Double mxMissileNullRep;
    private Double mxMissileYDem;
    private Double mxMissileNDem;
    private Double mxMissileNullDem;

    private Double immigrationYRep;
    private Double immigrationNRep;
    private Double immigrationNullRep;
    private Double immigrationYDem;
    private Double immigrationNDem;
    private Double immigrationNullDem;

    private Double synfuelsCorporationYRep;
    private Double synfuelsCorporationNRep;
    private Double synfuelsCorporationNullRep;
    private Double synfuelsCorporationYDem;
    private Double synfuelsCorporationNDem;
    private Double synfuelsCorporationNullDem;

    private Double educationSpendingYRep;
    private Double educationSpendingNRep;
    private Double educationSpendingNullRep;
    private Double educationSpendingYDem;
    private Double educationSpendingNDem;
    private Double educationSpendingNullDem;

    private Double superfundRightYRep;
    private Double superfundRightNRep;
    private Double superfundRightNullRep;
    private Double superfundRightYDem;
    private Double superfundRightNDem;
    private Double superfundRightNullDem;

    private Double crimeYRep;
    private Double crimeNRep;
    private Double crimeNullRep;
    private Double crimeYDem;
    private Double crimeNDem;
    private Double crimeNullDem;

    private Double dutyFreeExportsYRep;
    private Double dutyFreeExportsNRep;
    private Double dutyFreeExportsNullRep;
    private Double dutyFreeExportsYDem;
    private Double dutyFreeExportsNDem;
    private Double dutyFreeExportsNullDem;

    private Double exportAdministrationYRep;
    private Double exportAdministrationNRep;
    private Double exportAdministrationNullRep;
    private Double exportAdministrationYDem;
    private Double exportAdministrationNDem;
    private Double exportAdministrationNullDem;

    ProbabilityOfSet(){

    }

    private double getValue(Double dob1,Double dob2,Double dob3){
        return Double.parseDouble(String.format("%.4f",dob1/(dob1+dob2+dob3)).replace(",","."));
    }

    public Double[] findProbabilityOfRep(List<Attribute> list,int b){
       Double var1;
       Double var2;
       Double var3;
       Double var4;
       Double var5;
       Double var6;
       Double findItem1Y = (double) (int) list.stream()
               .filter(x -> x.getFunk(b)!=null&&x.getFunk(b)==true && x.getClassName().equals("republicafalse")).count();
       Double findItem2N = (double) (int) list.stream()
               .filter(x -> x.getFunk(b)!=null&&x.getFunk(b)!=true && x.getClassName().equals("republicafalse")).count();
       Double findItem3N = (double) (int) list.stream()
               .filter(x -> x.getFunk(b) == null && x.getClassName().equals("republicafalse")).count()+0.01;

       var1=getValue(findItem1Y,findItem2N,findItem3N);
       var2=getValue(findItem2N,findItem1Y,findItem3N);
       var3=getValue(findItem3N,findItem1Y,findItem2N);

        findItem1Y = (double) (int) list.stream()
                .filter(x -> x.getFunk(b)!=null&&x.getFunk(b) && x.getClassName().equals("democrat")).count();
        findItem2N = (double) (int) list.stream()
                .filter(x -> x.getFunk(b)!=null&&!x.getFunk(b) && x.getClassName().equals("democrat")).count();
        findItem3N = (double) (int) list.stream()
                .filter(x -> x.getFunk(b) == null && x.getClassName().equals("democrat")).count()+0.01;

        var4=getValue(findItem1Y,findItem2N,findItem3N);
        var5=getValue(findItem2N,findItem1Y,findItem3N);
        var6=getValue(findItem3N,findItem1Y,findItem2N);
        return new Double[]{var1,var2,var3,var4,var5,var6};
    }

    public Double getHandicappedYRep() {
        return handicappedYRep;
    }

    public Double getHandicappedNRep() {
        return handicappedNRep;
    }

    public Double getHandicappedNullRep() {
        return handicappedNullRep;
    }

    public Double getHandicappedYDem() {
        return handicappedYDem;
    }

    public Double getHandicappedNDem() {
        return handicappedNDem;
    }

    public Double getHandicappedNullDem() {
        return handicappedNullDem;
    }

    public Double getWaterProjectYRep() {
        return waterProjectYRep;
    }

    public Double getWaterProjectNRep() {
        return waterProjectNRep;
    }

    public Double getWaterProjectNullRep() {
        return waterProjectNullRep;
    }

    public Double getWaterProjectYDem() {
        return waterProjectYDem;
    }

    public Double getWaterProjectNDem() {
        return waterProjectNDem;
    }

    public Double getWaterProjectNullDem() {
        return waterProjectNullDem;
    }

    public Double getAdoptionOfTheBudgetYRep() {
        return adoptionOfTheBudgetYRep;
    }

    public Double getAdoptionOfTheBudgetNRep() {
        return adoptionOfTheBudgetNRep;
    }

    public Double getAdoptionOfTheBudgetNullRep() {
        return adoptionOfTheBudgetNullRep;
    }

    public Double getAdoptionOfTheBudgetYDem() {
        return adoptionOfTheBudgetYDem;
    }

    public Double getAdoptionOfTheBudgetNDem() {
        return adoptionOfTheBudgetNDem;
    }

    public Double getAdoptionOfTheBudgetNullDem() {
        return adoptionOfTheBudgetNullDem;
    }

    public Double getPhysicianFeeYRep() {
        return physicianFeeYRep;
    }

    public Double getPhysicianFeeNRep() {
        return physicianFeeNRep;
    }

    public Double getPhysicianFeeNullRep() {
        return physicianFeeNullRep;
    }

    public Double getPhysicianFeeYDem() {
        return physicianFeeYDem;
    }

    public Double getPhysicianFeeNDem() {
        return physicianFeeNDem;
    }

    public Double getPhysicianFeeNullDem() {
        return physicianFeeNullDem;
    }

    public Double getElSalvadorAidYRep() {
        return elSalvadorAidYRep;
    }

    public Double getElSalvadorAidNRep() {
        return elSalvadorAidNRep;
    }

    public Double getElSalvadorAidNullRep() {
        return elSalvadorAidNullRep;
    }

    public Double getElSalvadorAidYDem() {
        return elSalvadorAidYDem;
    }

    public Double getElSalvadorAidNDem() {
        return elSalvadorAidNDem;
    }

    public Double getElSalvadorAidNullDem() {
        return elSalvadorAidNullDem;
    }

    public Double getReligiousGroupsYRep() {
        return religiousGroupsYRep;
    }

    public Double getReligiousGroupsNRep() {
        return religiousGroupsNRep;
    }

    public Double getReligiousGroupsNullRep() {
        return religiousGroupsNullRep;
    }

    public Double getReligiousGroupsYDem() {
        return religiousGroupsYDem;
    }

    public Double getReligiousGroupsNDem() {
        return religiousGroupsNDem;
    }

    public Double getReligiousGroupsNullDem() {
        return religiousGroupsNullDem;
    }

    public Double getAntiSatelliteYRep() {
        return antiSatelliteYRep;
    }

    public Double getAntiSatelliteNRep() {
        return antiSatelliteNRep;
    }

    public Double getAntiSatelliteNullRep() {
        return antiSatelliteNullRep;
    }

    public Double getAntiSatelliteYDem() {
        return antiSatelliteYDem;
    }

    public Double getAntiSatelliteNDem() {
        return antiSatelliteNDem;
    }

    public Double getAntiSatelliteNullDem() {
        return antiSatelliteNullDem;
    }

    public Double getAidToNicaraguanYRep() {
        return aidToNicaraguanYRep;
    }

    public Double getAidToNicaraguanNRep() {
        return aidToNicaraguanNRep;
    }

    public Double getAidToNicaraguanNullRep() {
        return aidToNicaraguanNullRep;
    }

    public Double getAidToNicaraguanYDem() {
        return aidToNicaraguanYDem;
    }

    public Double getAidToNicaraguanNDem() {
        return aidToNicaraguanNDem;
    }

    public Double getAidToNicaraguanNullDem() {
        return aidToNicaraguanNullDem;
    }

    public Double getMxMissileYRep() {
        return mxMissileYRep;
    }

    public Double getMxMissileNRep() {
        return mxMissileNRep;
    }

    public Double getMxMissileNullRep() {
        return mxMissileNullRep;
    }

    public Double getMxMissileYDem() {
        return mxMissileYDem;
    }

    public Double getMxMissileNDem() {
        return mxMissileNDem;
    }

    public Double getMxMissileNullDem() {
        return mxMissileNullDem;
    }

    public Double getImmigrationYRep() {
        return immigrationYRep;
    }

    public Double getImmigrationNRep() {
        return immigrationNRep;
    }

    public Double getImmigrationNullRep() {
        return immigrationNullRep;
    }

    public Double getImmigrationYDem() {
        return immigrationYDem;
    }

    public Double getImmigrationNDem() {
        return immigrationNDem;
    }

    public Double getImmigrationNullDem() {
        return immigrationNullDem;
    }

    public Double getSynfuelsCorporationYRep() {
        return synfuelsCorporationYRep;
    }

    public Double getSynfuelsCorporationNRep() {
        return synfuelsCorporationNRep;
    }

    public Double getSynfuelsCorporationNullRep() {
        return synfuelsCorporationNullRep;
    }

    public Double getSynfuelsCorporationYDem() {
        return synfuelsCorporationYDem;
    }

    public Double getSynfuelsCorporationNDem() {
        return synfuelsCorporationNDem;
    }

    public Double getSynfuelsCorporationNullDem() {
        return synfuelsCorporationNullDem;
    }

    public Double getEducationSpendingYRep() {
        return educationSpendingYRep;
    }

    public Double getEducationSpendingNRep() {
        return educationSpendingNRep;
    }

    public Double getEducationSpendingNullRep() {
        return educationSpendingNullRep;
    }

    public Double getEducationSpendingYDem() {
        return educationSpendingYDem;
    }

    public Double getEducationSpendingNDem() {
        return educationSpendingNDem;
    }

    public Double getEducationSpendingNullDem() {
        return educationSpendingNullDem;
    }

    public Double getSuperfundRightYRep() {
        return superfundRightYRep;
    }

    public Double getSuperfundRightNRep() {
        return superfundRightNRep;
    }

    public Double getSuperfundRightNullRep() {
        return superfundRightNullRep;
    }

    public Double getSuperfundRightYDem() {
        return superfundRightYDem;
    }

    public Double getSuperfundRightNDem() {
        return superfundRightNDem;
    }

    public Double getSuperfundRightNullDem() {
        return superfundRightNullDem;
    }

    public Double getCrimeYRep() {
        return crimeYRep;
    }

    public Double getCrimeNRep() {
        return crimeNRep;
    }

    public Double getCrimeNullRep() {
        return crimeNullRep;
    }

    public Double getCrimeYDem() {
        return crimeYDem;
    }

    public Double getCrimeNDem() {
        return crimeNDem;
    }

    public Double getCrimeNullDem() {
        return crimeNullDem;
    }

    public Double getDutyFreeExportsYRep() {
        return dutyFreeExportsYRep;
    }

    public Double getDutyFreeExportsNRep() {
        return dutyFreeExportsNRep;
    }

    public Double getDutyFreeExportsNullRep() {
        return dutyFreeExportsNullRep;
    }

    public Double getDutyFreeExportsYDem() {
        return dutyFreeExportsYDem;
    }

    public Double getDutyFreeExportsNDem() {
        return dutyFreeExportsNDem;
    }

    public Double getDutyFreeExportsNullDem() {
        return dutyFreeExportsNullDem;
    }

    public Double getExportAdministrationYRep() {
        return exportAdministrationYRep;
    }

    public Double getExportAdministrationNRep() {
        return exportAdministrationNRep;
    }

    public Double getExportAdministrationNullRep() {
        return exportAdministrationNullRep;
    }

    public Double getExportAdministrationYDem() {
        return exportAdministrationYDem;
    }

    public Double getExportAdministrationNDem() {
        return exportAdministrationNDem;
    }

    public Double getExportAdministrationNullDem() {
        return exportAdministrationNullDem;
    }

    public void setHandicappedYRep(Double handicappedYRep) {
        this.handicappedYRep = handicappedYRep;
    }

    public void setHandicappedNRep(Double handicappedNRep) {
        this.handicappedNRep = handicappedNRep;
    }

    public void setHandicappedNullRep(Double handicappedNullRep) {
        this.handicappedNullRep = handicappedNullRep;
    }

    public void setHandicappedYDem(Double handicappedYDem) {
        this.handicappedYDem = handicappedYDem;
    }

    public void setHandicappedNDem(Double handicappedNDem) {
        this.handicappedNDem = handicappedNDem;
    }

    public void setHandicappedNullDem(Double handicappedNullDem) {
        this.handicappedNullDem = handicappedNullDem;
    }

    public void setWaterProjectYRep(Double waterProjectYRep) {
        this.waterProjectYRep = waterProjectYRep;
    }

    public void setWaterProjectNRep(Double waterProjectNRep) {
        this.waterProjectNRep = waterProjectNRep;
    }

    public void setWaterProjectNullRep(Double waterProjectNullRep) {
        this.waterProjectNullRep = waterProjectNullRep;
    }

    public void setWaterProjectYDem(Double waterProjectYDem) {
        this.waterProjectYDem = waterProjectYDem;
    }

    public void setWaterProjectNDem(Double waterProjectNDem) {
        this.waterProjectNDem = waterProjectNDem;
    }

    public void setWaterProjectNullDem(Double waterProjectNullDem) {
        this.waterProjectNullDem = waterProjectNullDem;
    }

    public void setAdoptionOfTheBudgetYRep(Double adoptionOfTheBudgetYRep) {
        this.adoptionOfTheBudgetYRep = adoptionOfTheBudgetYRep;
    }

    public void setAdoptionOfTheBudgetNRep(Double adoptionOfTheBudgetNRep) {
        this.adoptionOfTheBudgetNRep = adoptionOfTheBudgetNRep;
    }

    public void setAdoptionOfTheBudgetNullRep(Double adoptionOfTheBudgetNullRep) {
        this.adoptionOfTheBudgetNullRep = adoptionOfTheBudgetNullRep;
    }

    public void setAdoptionOfTheBudgetYDem(Double adoptionOfTheBudgetYDem) {
        this.adoptionOfTheBudgetYDem = adoptionOfTheBudgetYDem;
    }

    public void setAdoptionOfTheBudgetNDem(Double adoptionOfTheBudgetNDem) {
        this.adoptionOfTheBudgetNDem = adoptionOfTheBudgetNDem;
    }

    public void setAdoptionOfTheBudgetNullDem(Double adoptionOfTheBudgetNullDem) {
        this.adoptionOfTheBudgetNullDem = adoptionOfTheBudgetNullDem;
    }

    public void setPhysicianFeeYRep(Double physicianFeeYRep) {
        this.physicianFeeYRep = physicianFeeYRep;
    }

    public void setPhysicianFeeNRep(Double physicianFeeNRep) {
        this.physicianFeeNRep = physicianFeeNRep;
    }

    public void setPhysicianFeeNullRep(Double physicianFeeNullRep) {
        this.physicianFeeNullRep = physicianFeeNullRep;
    }

    public void setPhysicianFeeYDem(Double physicianFeeYDem) {
        this.physicianFeeYDem = physicianFeeYDem;
    }

    public void setPhysicianFeeNDem(Double physicianFeeNDem) {
        this.physicianFeeNDem = physicianFeeNDem;
    }

    public void setPhysicianFeeNullDem(Double physicianFeeNullDem) {
        this.physicianFeeNullDem = physicianFeeNullDem;
    }

    public void setElSalvadorAidYRep(Double elSalvadorAidYRep) {
        this.elSalvadorAidYRep = elSalvadorAidYRep;
    }

    public void setElSalvadorAidNRep(Double elSalvadorAidNRep) {
        this.elSalvadorAidNRep = elSalvadorAidNRep;
    }

    public void setElSalvadorAidNullRep(Double elSalvadorAidNullRep) {
        this.elSalvadorAidNullRep = elSalvadorAidNullRep;
    }

    public void setElSalvadorAidYDem(Double elSalvadorAidYDem) {
        this.elSalvadorAidYDem = elSalvadorAidYDem;
    }

    public void setElSalvadorAidNDem(Double elSalvadorAidNDem) {
        this.elSalvadorAidNDem = elSalvadorAidNDem;
    }

    public void setElSalvadorAidNullDem(Double elSalvadorAidNullDem) {
        this.elSalvadorAidNullDem = elSalvadorAidNullDem;
    }

    public void setReligiousGroupsYRep(Double religiousGroupsYRep) {
        this.religiousGroupsYRep = religiousGroupsYRep;
    }

    public void setReligiousGroupsNRep(Double religiousGroupsNRep) {
        this.religiousGroupsNRep = religiousGroupsNRep;
    }

    public void setReligiousGroupsNullRep(Double religiousGroupsNullRep) {
        this.religiousGroupsNullRep = religiousGroupsNullRep;
    }

    public void setReligiousGroupsYDem(Double religiousGroupsYDem) {
        this.religiousGroupsYDem = religiousGroupsYDem;
    }

    public void setReligiousGroupsNDem(Double religiousGroupsNDem) {
        this.religiousGroupsNDem = religiousGroupsNDem;
    }

    public void setReligiousGroupsNullDem(Double religiousGroupsNullDem) {
        this.religiousGroupsNullDem = religiousGroupsNullDem;
    }

    public void setAntiSatelliteYRep(Double antiSatelliteYRep) {
        this.antiSatelliteYRep = antiSatelliteYRep;
    }

    public void setAntiSatelliteNRep(Double antiSatelliteNRep) {
        this.antiSatelliteNRep = antiSatelliteNRep;
    }

    public void setAntiSatelliteNullRep(Double antiSatelliteNullRep) {
        this.antiSatelliteNullRep = antiSatelliteNullRep;
    }

    public void setAntiSatelliteYDem(Double antiSatelliteYDem) {
        this.antiSatelliteYDem = antiSatelliteYDem;
    }

    public void setAntiSatelliteNDem(Double antiSatelliteNDem) {
        this.antiSatelliteNDem = antiSatelliteNDem;
    }

    public void setAntiSatelliteNullDem(Double antiSatelliteNullDem) {
        this.antiSatelliteNullDem = antiSatelliteNullDem;
    }

    public void setAidToNicaraguanYRep(Double aidToNicaraguanYRep) {
        this.aidToNicaraguanYRep = aidToNicaraguanYRep;
    }

    public void setAidToNicaraguanNRep(Double aidToNicaraguanNRep) {
        this.aidToNicaraguanNRep = aidToNicaraguanNRep;
    }

    public void setAidToNicaraguanNullRep(Double aidToNicaraguanNullRep) {
        this.aidToNicaraguanNullRep = aidToNicaraguanNullRep;
    }

    public void setAidToNicaraguanYDem(Double aidToNicaraguanYDem) {
        this.aidToNicaraguanYDem = aidToNicaraguanYDem;
    }

    public void setAidToNicaraguanNDem(Double aidToNicaraguanNDem) {
        this.aidToNicaraguanNDem = aidToNicaraguanNDem;
    }

    public void setAidToNicaraguanNullDem(Double aidToNicaraguanNullDem) {
        this.aidToNicaraguanNullDem = aidToNicaraguanNullDem;
    }

    public void setMxMissileYRep(Double mxMissileYRep) {
        this.mxMissileYRep = mxMissileYRep;
    }

    public void setMxMissileNRep(Double mxMissileNRep) {
        this.mxMissileNRep = mxMissileNRep;
    }

    public void setMxMissileNullRep(Double mxMissileNullRep) {
        this.mxMissileNullRep = mxMissileNullRep;
    }

    public void setMxMissileYDem(Double mxMissileYDem) {
        this.mxMissileYDem = mxMissileYDem;
    }

    public void setMxMissileNDem(Double mxMissileNDem) {
        this.mxMissileNDem = mxMissileNDem;
    }

    public void setMxMissileNullDem(Double mxMissileNullDem) {
        this.mxMissileNullDem = mxMissileNullDem;
    }

    public void setImmigrationYRep(Double immigrationYRep) {
        this.immigrationYRep = immigrationYRep;
    }

    public void setImmigrationNRep(Double immigrationNRep) {
        this.immigrationNRep = immigrationNRep;
    }

    public void setImmigrationNullRep(Double immigrationNullRep) {
        this.immigrationNullRep = immigrationNullRep;
    }

    public void setImmigrationYDem(Double immigrationYDem) {
        this.immigrationYDem = immigrationYDem;
    }

    public void setImmigrationNDem(Double immigrationNDem) {
        this.immigrationNDem = immigrationNDem;
    }

    public void setImmigrationNullDem(Double immigrationNullDem) {
        this.immigrationNullDem = immigrationNullDem;
    }

    public void setSynfuelsCorporationYRep(Double synfuelsCorporationYRep) {
        this.synfuelsCorporationYRep = synfuelsCorporationYRep;
    }

    public void setSynfuelsCorporationNRep(Double synfuelsCorporationNRep) {
        this.synfuelsCorporationNRep = synfuelsCorporationNRep;
    }

    public void setSynfuelsCorporationNullRep(Double synfuelsCorporationNullRep) {
        this.synfuelsCorporationNullRep = synfuelsCorporationNullRep;
    }

    public void setSynfuelsCorporationYDem(Double synfuelsCorporationYDem) {
        this.synfuelsCorporationYDem = synfuelsCorporationYDem;
    }

    public void setSynfuelsCorporationNDem(Double synfuelsCorporationNDem) {
        this.synfuelsCorporationNDem = synfuelsCorporationNDem;
    }

    public void setSynfuelsCorporationNullDem(Double synfuelsCorporationNullDem) {
        this.synfuelsCorporationNullDem = synfuelsCorporationNullDem;
    }

    public void setEducationSpendingYRep(Double educationSpendingYRep) {
        this.educationSpendingYRep = educationSpendingYRep;
    }

    public void setEducationSpendingNRep(Double educationSpendingNRep) {
        this.educationSpendingNRep = educationSpendingNRep;
    }

    public void setEducationSpendingNullRep(Double educationSpendingNullRep) {
        this.educationSpendingNullRep = educationSpendingNullRep;
    }

    public void setEducationSpendingYDem(Double educationSpendingYDem) {
        this.educationSpendingYDem = educationSpendingYDem;
    }

    public void setEducationSpendingNDem(Double educationSpendingNDem) {
        this.educationSpendingNDem = educationSpendingNDem;
    }

    public void setEducationSpendingNullDem(Double educationSpendingNullDem) {
        this.educationSpendingNullDem = educationSpendingNullDem;
    }

    public void setSuperfundRightYRep(Double superfundRightYRep) {
        this.superfundRightYRep = superfundRightYRep;
    }

    public void setSuperfundRightNRep(Double superfundRightNRep) {
        this.superfundRightNRep = superfundRightNRep;
    }

    public void setSuperfundRightNullRep(Double superfundRightNullRep) {
        this.superfundRightNullRep = superfundRightNullRep;
    }

    public void setSuperfundRightYDem(Double superfundRightYDem) {
        this.superfundRightYDem = superfundRightYDem;
    }

    public void setSuperfundRightNDem(Double superfundRightNDem) {
        this.superfundRightNDem = superfundRightNDem;
    }

    public void setSuperfundRightNullDem(Double superfundRightNullDem) {
        this.superfundRightNullDem = superfundRightNullDem;
    }

    public void setCrimeYRep(Double crimeYRep) {
        this.crimeYRep = crimeYRep;
    }

    public void setCrimeNRep(Double crimeNRep) {
        this.crimeNRep = crimeNRep;
    }

    public void setCrimeNullRep(Double crimeNullRep) {
        this.crimeNullRep = crimeNullRep;
    }

    public void setCrimeYDem(Double crimeYDem) {
        this.crimeYDem = crimeYDem;
    }

    public void setCrimeNDem(Double crimeNDem) {
        this.crimeNDem = crimeNDem;
    }

    public void setCrimeNullDem(Double crimeNullDem) {
        this.crimeNullDem = crimeNullDem;
    }

    public void setDutyFreeExportsYRep(Double dutyFreeExportsYRep) {
        this.dutyFreeExportsYRep = dutyFreeExportsYRep;
    }

    public void setDutyFreeExportsNRep(Double dutyFreeExportsNRep) {
        this.dutyFreeExportsNRep = dutyFreeExportsNRep;
    }

    public void setDutyFreeExportsNullRep(Double dutyFreeExportsNullRep) {
        this.dutyFreeExportsNullRep = dutyFreeExportsNullRep;
    }

    public void setDutyFreeExportsYDem(Double dutyFreeExportsYDem) {
        this.dutyFreeExportsYDem = dutyFreeExportsYDem;
    }

    public void setDutyFreeExportsNDem(Double dutyFreeExportsNDem) {
        this.dutyFreeExportsNDem = dutyFreeExportsNDem;
    }

    public void setDutyFreeExportsNullDem(Double dutyFreeExportsNullDem) {
        this.dutyFreeExportsNullDem = dutyFreeExportsNullDem;
    }

    public void setExportAdministrationYRep(Double exportAdministrationYRep) {
        this.exportAdministrationYRep = exportAdministrationYRep;
    }

    public void setExportAdministrationNRep(Double exportAdministrationNRep) {
        this.exportAdministrationNRep = exportAdministrationNRep;
    }

    public void setExportAdministrationNullRep(Double exportAdministrationNullRep) {
        this.exportAdministrationNullRep = exportAdministrationNullRep;
    }

    public void setExportAdministrationYDem(Double exportAdministrationYDem) {
        this.exportAdministrationYDem = exportAdministrationYDem;
    }

    public void setExportAdministrationNDem(Double exportAdministrationNDem) {
        this.exportAdministrationNDem = exportAdministrationNDem;
    }

    public void setExportAdministrationNullDem(Double exportAdministrationNullDem) {
        this.exportAdministrationNullDem = exportAdministrationNullDem;
    }
}
