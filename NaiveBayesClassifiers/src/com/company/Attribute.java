package com.company;

public class Attribute {

    private String className;
    private Boolean handicappedInfants;
    private Boolean waterProjectCostSharing;
    private Boolean adoptionOfTheBudgetResolution;
    private Boolean physicianFeeFreeze;
    private Boolean elSalvadorAid;
    private Boolean religiousGroupsInSchools;
    private Boolean antiSatelliteTestBan;
    private Boolean aidToNicaraguanContras;
    private Boolean mxMissile;
    private Boolean immigration;
    private Boolean synfuelsCorporationCutback;
    private Boolean educationSpending;
    private Boolean superfundRightToSue;
    private Boolean crime;
    private Boolean dutyFreeExports;
    private Boolean exportAdministrationActSouthAfrica;

    public Attribute() {
    }

    public void print(){
        System.out.printf("%s,%b,%b,%b,%b,%b,%b,%b,%b,%b,%b,%b,%b,%b,%b,%b,%b\n",className,handicappedInfants,waterProjectCostSharing
        ,adoptionOfTheBudgetResolution,physicianFeeFreeze,elSalvadorAid,religiousGroupsInSchools,antiSatelliteTestBan
        ,aidToNicaraguanContras,mxMissile,immigration,synfuelsCorporationCutback,educationSpending,superfundRightToSue,className
        ,dutyFreeExports,exportAdministrationActSouthAfrica);
    }
    public Attribute(String className, Boolean handicappedInfants,Boolean waterProjectCostSharing, Boolean adoptionOfTheBudgetResolution, Boolean physicianFeeFreeze, Boolean elSalvadorAid, Boolean religiousGroupsInSchools,Boolean antiSatelliteTestBan, Boolean aidToNicaraguanContras, Boolean mxMissile, Boolean immigration, Boolean synfuelsCorporationCutback, Boolean educationSpending, Boolean superfundRightToSue, Boolean crime, Boolean dutyFreeExports,Boolean exportAdministrationActSouthAfrica) {
        this.className = className;
        this.handicappedInfants = handicappedInfants;
        this.waterProjectCostSharing = waterProjectCostSharing;
        this.adoptionOfTheBudgetResolution = adoptionOfTheBudgetResolution;
        this.physicianFeeFreeze = physicianFeeFreeze;
        this.elSalvadorAid = elSalvadorAid;
        this.religiousGroupsInSchools = religiousGroupsInSchools;
        this.antiSatelliteTestBan = antiSatelliteTestBan;
        this.aidToNicaraguanContras = aidToNicaraguanContras;
        this.mxMissile = mxMissile;
        this.immigration = immigration;
        this.synfuelsCorporationCutback = synfuelsCorporationCutback;
        this.educationSpending = educationSpending;
        this.superfundRightToSue = superfundRightToSue;
        this.crime = crime;
        this.dutyFreeExports = dutyFreeExports;
        this.exportAdministrationActSouthAfrica = exportAdministrationActSouthAfrica;
    }

    public Boolean getFunk(int num){
        if(num==0)return isHandicappedInfants();
        if(num==1)return isWaterProjectCostSharing();
        if(num==2)return isAdoptionOfTheBudgetResolution();
        if(num==3)return isPhysicianFeeFreeze();
        if(num==4)return isElSalvadorAid();
        if(num==5)return isReligiousGroupsInSchools();
        if(num==6)return isAntiSatelliteTestBan();
        if(num==7)return isAidToNicaraguanContras();
        if(num==8)return isMxMissile();
        if(num==9)return isImmigration();
        if(num==10)return isSynfuelsCorporationCutback();
        if(num==11)return isEducationSpending();
        if(num==12)return isSuperfundRightToSue();
        if(num==13)return isCrime();
        if(num==14)return isDutyFreeExports();
        if(num==15)return isExportAdministrationActSouthAfrica();
        return false;
    }
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Boolean isHandicappedInfants() {
        return handicappedInfants;
    }

    public void setHandicappedInfants(Boolean handicappedInfants) {
        this.handicappedInfants = handicappedInfants;
    }

    public Boolean isWaterProjectCostSharing() {
        return waterProjectCostSharing;
    }

    public void setWaterProjectCostSharing(Boolean waterProjectCostSharing) {
        this.waterProjectCostSharing = waterProjectCostSharing;
    }

    public Boolean isAdoptionOfTheBudgetResolution() {
        return adoptionOfTheBudgetResolution;
    }

    public void setAdoptionOfTheBudgetResolution(Boolean adoptionOfTheBudgetResolution) {
        this.adoptionOfTheBudgetResolution = adoptionOfTheBudgetResolution;
    }

    public Boolean isPhysicianFeeFreeze() {
        return physicianFeeFreeze;
    }

    public void setPhysicianFeeFreeze(Boolean physicianFeeFreeze) {
        this.physicianFeeFreeze = physicianFeeFreeze;
    }

    public Boolean isElSalvadorAid() {
        return elSalvadorAid;
    }

    public void setElSalvadorAid(Boolean elSalvadorAid) {
        this.elSalvadorAid = elSalvadorAid;
    }

    public Boolean isReligiousGroupsInSchools() {
        return religiousGroupsInSchools;
    }

    public void setReligiousGroupsInSchools(Boolean religiousGroupsInSchools) {
        this.religiousGroupsInSchools = religiousGroupsInSchools;
    }

    public Boolean isAntiSatelliteTestBan() {
        return antiSatelliteTestBan;
    }

    public void setAntiSatelliteTestBan(Boolean antiSatelliteTestBan) {
        this.antiSatelliteTestBan = antiSatelliteTestBan;
    }

    public Boolean isAidToNicaraguanContras() {
        return aidToNicaraguanContras;
    }

    public void setAidToNicaraguanContras(Boolean aidToNicaraguanContras) {
        this.aidToNicaraguanContras = aidToNicaraguanContras;
    }

    public Boolean isMxMissile() {
        return mxMissile;
    }

    public void setMxMissile(Boolean mxMissile) {
        this.mxMissile = mxMissile;
    }

    public Boolean isImmigration() {
        return immigration;
    }

    public void setImmigration(Boolean immigration) {
        this.immigration = immigration;
    }

    public Boolean isSynfuelsCorporationCutback() {
        return synfuelsCorporationCutback;
    }

    public void setSynfuelsCorporationCutback(Boolean synfuelsCorporationCutback) {
        this.synfuelsCorporationCutback = synfuelsCorporationCutback;
    }

    public Boolean isEducationSpending() {
        return educationSpending;
    }

    public void setEducationSpending(Boolean educationSpending) {
        this.educationSpending = educationSpending;
    }

    public Boolean isSuperfundRightToSue() {
        return superfundRightToSue;
    }

    public void setSuperfundRightToSue(Boolean superfundRightToSue) {
        this.superfundRightToSue = superfundRightToSue;
    }

    public Boolean isCrime() {
        return crime;
    }

    public void setCrime(Boolean crime) {
        this.crime = crime;
    }

    public Boolean isDutyFreeExports() {
        return dutyFreeExports;
    }

    public void setDutyFreeExports(Boolean dutyFreeExports) {
        this.dutyFreeExports = dutyFreeExports;
    }

    public Boolean isExportAdministrationActSouthAfrica() {
        return exportAdministrationActSouthAfrica;
    }

    public void setExportAdministrationActSouthAfrica(Boolean exportAdministrationActSouthAfrica) {
        this.exportAdministrationActSouthAfrica = exportAdministrationActSouthAfrica;
    }
}
