package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class SetGenerator {

    private List<List<Attribute>> nSets;
    private BufferedReader bufferedReader;
    private ProbabilityOfSet probabilityOfSet;

    public SetGenerator() {
        probabilityOfSet=new ProbabilityOfSet();
        nSets=new ArrayList<>();
    }

    public SetGenerator(List<List<Attribute>> nSets, BufferedReader bufferedReader) {
        this.nSets = nSets;
        this.bufferedReader = bufferedReader;
    }

    public List<List<Attribute>> getnSets() {
        return nSets;
    }

    public void setnSets(List<List<Attribute>> nSets) {
        this.nSets = nSets;
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public void setBufferedReader(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }


    public void generateNSets(){
        try {
            bufferedReader=new BufferedReader(new FileReader("D:\\D-Downloads\\data.data"));
            String line = bufferedReader.readLine();
            List<Attribute> list=new ArrayList<Attribute>();
            while (line!=null){
                line=line.replace("n","false")
                        .replace("y","true")
                        .replace("?","null");
                String[] information=line.split(",");
                Attribute attribute=new Attribute();
                setAttributeInformation(information,attribute);
                list.add(attribute);
                line = bufferedReader.readLine();
            }
            Collections.shuffle(list);
            for (int i=0;i<10;i++){

                nSets.add(list.subList(43*i,43*(i+1)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setAttributeInformation(String[] information, Attribute attribute) {
       attribute.setClassName(information[0]);
       attribute.setHandicappedInfants(information[1].equals("null")?null:Boolean.valueOf(information[1]));
       attribute.setWaterProjectCostSharing(information[2].equals("null")?null:Boolean.valueOf(information[2]));
       attribute.setAdoptionOfTheBudgetResolution(information[3].equals("null")?null:Boolean.valueOf(information[3]));
       attribute.setPhysicianFeeFreeze(information[4].equals("null")?null:Boolean.valueOf(information[4]));
       attribute.setElSalvadorAid(information[5].equals("null")?null:Boolean.valueOf(information[5]));
       attribute.setReligiousGroupsInSchools(information[6].equals("null")?null:Boolean.valueOf(information[6]));
       attribute.setAntiSatelliteTestBan(information[7].equals("null")?null:Boolean.valueOf(information[7]));
       attribute.setAidToNicaraguanContras(information[8].equals("null")?null:Boolean.valueOf(information[8]));
       attribute.setMxMissile(information[9].equals("null")?null:Boolean.valueOf(information[9]));
       attribute.setImmigration(information[10].equals("null")?null:Boolean.valueOf(information[10]));
       attribute.setSynfuelsCorporationCutback(information[11].equals("null")?null:Boolean.valueOf(information[11]));
       attribute.setEducationSpending(information[12].equals("null")?null:Boolean.valueOf(information[12]));
       attribute.setSuperfundRightToSue(information[13].equals("null")?null:Boolean.valueOf(information[13]));
       attribute.setCrime(information[14].equals("null")?null:Boolean.valueOf(information[14]));
       attribute.setDutyFreeExports(information[15].equals("null")?null:Boolean.valueOf(information[15]));
       attribute.setExportAdministrationActSouthAfrica(information[16].equals("null")?null:Boolean.valueOf(information[16]));
    }

    public String classification(Attribute attribute,int i){
        calculatePropability(i);
        double republican=1.0;
        double democrat=1.0;

        if(attribute.isHandicappedInfants()!=null&&attribute.isHandicappedInfants()){
            republican*=probabilityOfSet.getHandicappedYRep();
            democrat*=probabilityOfSet.getHandicappedYDem();
        }else if(attribute.isHandicappedInfants()!=null&&!attribute.isHandicappedInfants()){
            republican*=probabilityOfSet.getHandicappedNRep();
            democrat*=probabilityOfSet.getHandicappedNDem();
        }else {
            republican*=probabilityOfSet.getHandicappedNullRep();
            democrat*=probabilityOfSet.getHandicappedNullDem();
        }

        if(attribute.isWaterProjectCostSharing()!=null&&attribute.isWaterProjectCostSharing()){
            republican*=probabilityOfSet.getWaterProjectYRep();
            democrat*=probabilityOfSet.getWaterProjectYDem();
        }else if(attribute.isWaterProjectCostSharing()!=null&&!attribute.isWaterProjectCostSharing()){
            republican*=probabilityOfSet.getWaterProjectNRep();
            democrat*=probabilityOfSet.getWaterProjectNDem();
        }else {
            republican*=probabilityOfSet.getWaterProjectNullRep();
            democrat*=probabilityOfSet.getWaterProjectNullDem();
        }

        if(attribute.isAdoptionOfTheBudgetResolution()!=null&&attribute.isAdoptionOfTheBudgetResolution()){
            republican*=probabilityOfSet.getAdoptionOfTheBudgetYRep();
            democrat*=probabilityOfSet.getAdoptionOfTheBudgetYDem();
        }else if(attribute.isAdoptionOfTheBudgetResolution()!=null&&!attribute.isAdoptionOfTheBudgetResolution()){
            republican*=probabilityOfSet.getAdoptionOfTheBudgetNRep();
            democrat*=probabilityOfSet.getAdoptionOfTheBudgetNDem();
        }else {
            republican*=probabilityOfSet.getAdoptionOfTheBudgetNullRep();
            democrat*=probabilityOfSet.getAdoptionOfTheBudgetNullDem();
        }

        if(attribute.isPhysicianFeeFreeze()!=null&&attribute.isPhysicianFeeFreeze()){
            republican*=probabilityOfSet.getPhysicianFeeYRep();
            democrat*=probabilityOfSet.getPhysicianFeeYDem();
        }else if(attribute.isPhysicianFeeFreeze()!=null&&!attribute.isPhysicianFeeFreeze()){
            republican*=probabilityOfSet.getPhysicianFeeNRep();
            democrat*=probabilityOfSet.getPhysicianFeeNDem();
        }else {
            republican*=probabilityOfSet.getPhysicianFeeNullRep();
            democrat*=probabilityOfSet.getPhysicianFeeNullDem();
        }

        if(attribute.isElSalvadorAid()!=null&&attribute.isElSalvadorAid()){
            republican*=probabilityOfSet.getElSalvadorAidYRep();
            democrat*=probabilityOfSet.getElSalvadorAidYDem();
        }else if(attribute.isElSalvadorAid()!=null&&!attribute.isElSalvadorAid()){
            republican*=probabilityOfSet.getElSalvadorAidNRep();
            democrat*=probabilityOfSet.getElSalvadorAidNDem();
        }else {
            republican*=probabilityOfSet.getElSalvadorAidNullRep();
            democrat*=probabilityOfSet.getElSalvadorAidNullDem();
        }

        if(attribute.isReligiousGroupsInSchools()!=null&&attribute.isReligiousGroupsInSchools()){
            republican*=probabilityOfSet.getReligiousGroupsYRep();
            democrat*=probabilityOfSet.getReligiousGroupsYDem();
        }else if(attribute.isReligiousGroupsInSchools()!=null&&!attribute.isReligiousGroupsInSchools()){
            republican*=probabilityOfSet.getReligiousGroupsNRep();
            democrat*=probabilityOfSet.getReligiousGroupsNDem();
        }else {
            republican*=probabilityOfSet.getReligiousGroupsNullRep();
            democrat*=probabilityOfSet.getReligiousGroupsNullDem();
        }

        if(attribute.isAntiSatelliteTestBan()!=null&&attribute.isAntiSatelliteTestBan()){
            republican*=probabilityOfSet.getAntiSatelliteYRep();
            democrat*=probabilityOfSet.getAntiSatelliteYDem();
        }else if(attribute.isAntiSatelliteTestBan()!=null&&!attribute.isAntiSatelliteTestBan()){
            republican*=probabilityOfSet.getAntiSatelliteNRep();
            democrat*=probabilityOfSet.getAntiSatelliteNDem();
        }else {
            republican*=probabilityOfSet.getAntiSatelliteNullRep();
            democrat*=probabilityOfSet.getAntiSatelliteNullDem();
        }

        if(attribute.isAidToNicaraguanContras()!=null&&attribute.isAidToNicaraguanContras()){
            republican*=probabilityOfSet.getAidToNicaraguanYRep();
            democrat*=probabilityOfSet.getAidToNicaraguanYDem();
        }else if(attribute.isAidToNicaraguanContras()!=null&&!attribute.isAidToNicaraguanContras()){
            republican*=probabilityOfSet.getAidToNicaraguanNRep();
            democrat*=probabilityOfSet.getAidToNicaraguanNDem();
        }else {
            republican*=probabilityOfSet.getAidToNicaraguanNullRep();
            democrat*=probabilityOfSet.getAidToNicaraguanNullDem();
        }

        if(attribute.isMxMissile()!=null&&attribute.isMxMissile()){
            republican*=probabilityOfSet.getMxMissileYRep();
            democrat*=probabilityOfSet.getMxMissileYDem();
        }else if(attribute.isMxMissile()!=null&&!attribute.isMxMissile()){
            republican*=probabilityOfSet.getMxMissileNRep();
            democrat*=probabilityOfSet.getMxMissileNDem();
        }else {
            republican*=probabilityOfSet.getMxMissileNullRep();
            democrat*=probabilityOfSet.getMxMissileNullDem();
        }

        if(attribute.isImmigration()!=null&&attribute.isImmigration()){
            republican*=probabilityOfSet.getImmigrationYRep();
            democrat*=probabilityOfSet.getImmigrationYDem();
        }else if(attribute.isImmigration()!=null&&!attribute.isImmigration()){
            republican*=probabilityOfSet.getImmigrationNRep();
            democrat*=probabilityOfSet.getImmigrationNDem();
        }else {
            republican*=probabilityOfSet.getImmigrationNullRep();
            democrat*=probabilityOfSet.getImmigrationNullDem();
        }

        if(attribute.isSynfuelsCorporationCutback()!=null&&attribute.isSynfuelsCorporationCutback()){
            republican*=probabilityOfSet.getSynfuelsCorporationYRep();
            democrat*=probabilityOfSet.getSynfuelsCorporationYDem();
        }else if(attribute.isSynfuelsCorporationCutback()!=null&&!attribute.isSynfuelsCorporationCutback()){
            republican*=probabilityOfSet.getSynfuelsCorporationNRep();
            democrat*=probabilityOfSet.getSynfuelsCorporationNDem();
        }else {
            republican*=probabilityOfSet.getSynfuelsCorporationNullRep();
            democrat*=probabilityOfSet.getSynfuelsCorporationNullDem();
        }

        if(attribute.isEducationSpending()!=null&&attribute.isEducationSpending()){
            republican*=probabilityOfSet.getEducationSpendingYRep();
            democrat*=probabilityOfSet.getEducationSpendingYDem();
        }else if(attribute.isEducationSpending()!=null&&!attribute.isEducationSpending()){
            republican*=probabilityOfSet.getEducationSpendingNRep();
            democrat*=probabilityOfSet.getEducationSpendingNDem();
        }else {
            republican*=probabilityOfSet.getEducationSpendingNullRep();
            democrat*=probabilityOfSet.getEducationSpendingNullDem();
        }

        if(attribute.isSuperfundRightToSue()!=null&&attribute.isSuperfundRightToSue()){
            republican*=probabilityOfSet.getSuperfundRightYRep();
            democrat*=probabilityOfSet.getSuperfundRightYDem();
        }else if(attribute.isSuperfundRightToSue()!=null&&!attribute.isSuperfundRightToSue()){
            republican*=probabilityOfSet.getSuperfundRightNRep();
            democrat*=probabilityOfSet.getSuperfundRightNDem();
        }else {
            republican*=probabilityOfSet.getSuperfundRightNullRep();
            democrat*=probabilityOfSet.getSuperfundRightNullDem();
        }

        if(attribute.isCrime()!=null&&attribute.isCrime()){
            republican*=probabilityOfSet.getCrimeYRep();
            democrat*=probabilityOfSet.getCrimeYDem();
        }else if(attribute.isCrime()!=null&&!attribute.isCrime()){
            republican*=probabilityOfSet.getCrimeNRep();
            democrat*=probabilityOfSet.getCrimeNDem();
        }else {
            republican*=probabilityOfSet.getCrimeNullRep();
            democrat*=probabilityOfSet.getCrimeNullDem();
        }

        if(attribute.isDutyFreeExports()!=null&&attribute.isDutyFreeExports()){
            republican*=probabilityOfSet.getDutyFreeExportsYRep();
            democrat*=probabilityOfSet.getDutyFreeExportsYDem();
        }else if(attribute.isDutyFreeExports()!=null&&!attribute.isDutyFreeExports()){
            republican*=probabilityOfSet.getDutyFreeExportsNRep();
            democrat*=probabilityOfSet.getDutyFreeExportsNDem();
        }else {
            republican*=probabilityOfSet.getDutyFreeExportsNullRep();
            democrat*=probabilityOfSet.getDutyFreeExportsNullDem();
        }

        if(attribute.isExportAdministrationActSouthAfrica()!=null&&attribute.isExportAdministrationActSouthAfrica()){
            republican*=probabilityOfSet.getExportAdministrationYRep();
            democrat*=probabilityOfSet.getExportAdministrationYDem();
        }else if(attribute.isExportAdministrationActSouthAfrica()!=null&&!attribute.isExportAdministrationActSouthAfrica()){
            republican*=probabilityOfSet.getExportAdministrationNRep();
            democrat*=probabilityOfSet.getExportAdministrationNDem();
        }else {
            republican*=probabilityOfSet.getExportAdministrationNullRep();
            democrat*=probabilityOfSet.getExportAdministrationNullDem();
        }

        return republican>democrat?"republican":"democrat";
    }
    //Check for mistakes ....Do in main class work... All ot the P are set here
    public void printList(){
        for (List<Attribute> l:nSets) {
            for (Attribute a:l) {
                a.print();
            }
            System.out.println();
            System.out.println("---------------------------------------------------------------------------");
            System.out.println();
           //l.stream().forEach(x-> x.print());
        }
    }
    private void calculatePropability(int i){


        //generateNSets();
        //printList();
        Double[] helper;
        helper=probabilityOfSet.findProbabilityOfRep(nSets.get(i), 0);
        probabilityOfSet.setHandicappedYRep(helper[0]);
        probabilityOfSet.setHandicappedNRep(helper[1]);
        probabilityOfSet.setHandicappedNullRep(helper[2]);
        probabilityOfSet.setHandicappedYDem(helper[3]);
        probabilityOfSet.setHandicappedNDem(helper[4]);
        probabilityOfSet.setHandicappedNullDem(helper[5]);

        helper=probabilityOfSet.findProbabilityOfRep(nSets.get(i),1);
        probabilityOfSet.setWaterProjectYRep(helper[0]);
        probabilityOfSet.setWaterProjectNRep(helper[1]);
        probabilityOfSet.setWaterProjectNullRep(helper[2]);
        probabilityOfSet.setWaterProjectYDem(helper[3]);
        probabilityOfSet.setWaterProjectNDem(helper[4]);
        probabilityOfSet.setWaterProjectNullDem(helper[5]);

        helper=probabilityOfSet.findProbabilityOfRep(nSets.get(i),2);
        probabilityOfSet.setAdoptionOfTheBudgetYRep(helper[0]);
        probabilityOfSet.setAdoptionOfTheBudgetNRep(helper[1]);
        probabilityOfSet.setAdoptionOfTheBudgetNullRep(helper[2]);
        probabilityOfSet.setAdoptionOfTheBudgetYDem(helper[3]);
        probabilityOfSet.setAdoptionOfTheBudgetNDem(helper[4]);
        probabilityOfSet.setAdoptionOfTheBudgetNullDem(helper[5]);

        helper=probabilityOfSet.findProbabilityOfRep(nSets.get(i),3);
        probabilityOfSet.setPhysicianFeeYRep(helper[0]);
        probabilityOfSet.setPhysicianFeeNRep(helper[1]);
        probabilityOfSet.setPhysicianFeeNullRep(helper[2]);
        probabilityOfSet.setPhysicianFeeYDem(helper[3]);
        probabilityOfSet.setPhysicianFeeNDem(helper[4]);
        probabilityOfSet.setPhysicianFeeNullDem(helper[5]);

        helper=probabilityOfSet.findProbabilityOfRep(nSets.get(i),4);
        probabilityOfSet.setElSalvadorAidYRep(helper[0]);
        probabilityOfSet.setElSalvadorAidNRep(helper[1]);
        probabilityOfSet.setElSalvadorAidNullRep(helper[2]);
        probabilityOfSet.setElSalvadorAidYDem(helper[3]);
        probabilityOfSet.setElSalvadorAidNDem(helper[4]);
        probabilityOfSet.setElSalvadorAidNullDem(helper[5]);

        helper=probabilityOfSet.findProbabilityOfRep(nSets.get(i),5);
        probabilityOfSet.setReligiousGroupsYRep(helper[0]);
        probabilityOfSet.setReligiousGroupsNRep(helper[1]);
        probabilityOfSet.setReligiousGroupsNullRep(helper[2]) ;
        probabilityOfSet.setReligiousGroupsYDem(helper[3]);
        probabilityOfSet.setReligiousGroupsNDem(helper[4]);
        probabilityOfSet.setReligiousGroupsNullDem(helper[5]);

        helper= probabilityOfSet.findProbabilityOfRep(nSets.get(i),6);
        probabilityOfSet.setAntiSatelliteYRep(helper[0]);
        probabilityOfSet.setAntiSatelliteNRep(helper[1]);
        probabilityOfSet.setAntiSatelliteNullRep(helper[2]);
        probabilityOfSet.setAntiSatelliteYDem(helper[3]);
        probabilityOfSet.setAntiSatelliteNDem(helper[4]);
        probabilityOfSet.setAntiSatelliteNullDem(helper[5]);

        helper= probabilityOfSet.findProbabilityOfRep(nSets.get(i),7);
        probabilityOfSet.setAidToNicaraguanYRep(helper[0]) ;
        probabilityOfSet.setAidToNicaraguanNRep(helper[1]);
        probabilityOfSet.setAidToNicaraguanNullRep(helper[2]);
        probabilityOfSet.setAidToNicaraguanYDem(helper[3]);
        probabilityOfSet.setAidToNicaraguanNDem(helper[4]);
        probabilityOfSet.setAidToNicaraguanNullDem(helper[5]);

        helper=probabilityOfSet.findProbabilityOfRep(nSets.get(i),8);
        probabilityOfSet.setMxMissileYRep(helper[0]);
        probabilityOfSet.setMxMissileNRep(helper[1]);
        probabilityOfSet.setMxMissileNullRep(helper[2]);
        probabilityOfSet.setMxMissileYDem(helper[3]) ;
        probabilityOfSet.setMxMissileNDem(helper[4]);
        probabilityOfSet.setMxMissileNullDem(helper[5]);

        helper=probabilityOfSet.findProbabilityOfRep(nSets.get(i),9);
        probabilityOfSet.setImmigrationYRep(helper[0]);
        probabilityOfSet.setImmigrationNRep(helper[1]);
        probabilityOfSet.setImmigrationNullRep(helper[2]);
        probabilityOfSet.setImmigrationYDem(helper[3]);
        probabilityOfSet.setImmigrationNDem(helper[4]);
        probabilityOfSet.setImmigrationNullDem(helper[5]);

        helper=probabilityOfSet.findProbabilityOfRep(nSets.get(i),10);
        probabilityOfSet.setSynfuelsCorporationYRep(helper[0]) ;
        probabilityOfSet.setSynfuelsCorporationNRep(helper[1]);
        probabilityOfSet.setSynfuelsCorporationNullRep(helper[2]);
        probabilityOfSet.setSynfuelsCorporationYDem(helper[3]);
        probabilityOfSet.setSynfuelsCorporationNDem(helper[4]);
        probabilityOfSet.setSynfuelsCorporationNullDem(helper[5]);

        helper=probabilityOfSet.findProbabilityOfRep(nSets.get(i),11);
        probabilityOfSet.setEducationSpendingYRep(helper[0]);
        probabilityOfSet.setEducationSpendingNRep(helper[1]);
        probabilityOfSet.setEducationSpendingNullRep(helper[2]);
        probabilityOfSet.setEducationSpendingYDem(helper[3]);
        probabilityOfSet.setEducationSpendingNDem(helper[4]);
        probabilityOfSet.setEducationSpendingNullDem(helper[5]);

        helper=probabilityOfSet.findProbabilityOfRep(nSets.get(i),12);
        probabilityOfSet.setSuperfundRightYRep(helper[0]) ;
        probabilityOfSet.setSuperfundRightNRep(helper[1]);
        probabilityOfSet.setSuperfundRightNullRep(helper[2]);
        probabilityOfSet.setSuperfundRightYDem(helper[3]);
        probabilityOfSet.setSuperfundRightNDem(helper[4]);
        probabilityOfSet.setSuperfundRightNullDem(helper[5]);

        helper=probabilityOfSet.findProbabilityOfRep(nSets.get(i),13);
        probabilityOfSet.setCrimeYRep(helper[0]);
        probabilityOfSet.setCrimeNRep(helper[1]);
        probabilityOfSet.setCrimeNullRep(helper[2]);
        probabilityOfSet.setCrimeYDem(helper[3]);
        probabilityOfSet.setCrimeNDem(helper[4]);
        probabilityOfSet.setCrimeNullDem(helper[5]);

        helper=probabilityOfSet.findProbabilityOfRep(nSets.get(i),14);
        probabilityOfSet.setDutyFreeExportsYRep(helper[0]);
        probabilityOfSet.setDutyFreeExportsNRep(helper[1]);
        probabilityOfSet.setDutyFreeExportsNullRep(helper[2]);
        probabilityOfSet.setDutyFreeExportsYDem(helper[3]);
        probabilityOfSet.setDutyFreeExportsNDem(helper[4]);
        probabilityOfSet.setDutyFreeExportsNullDem(helper[5]);

        helper= probabilityOfSet.findProbabilityOfRep(nSets.get(i),15);
        probabilityOfSet.setExportAdministrationYRep(helper[0]);
        probabilityOfSet.setExportAdministrationNRep(helper[1]);
        probabilityOfSet.setExportAdministrationNullRep(helper[2]);
        probabilityOfSet.setExportAdministrationYDem(helper[3]);
        probabilityOfSet.setExportAdministrationNDem(helper[4]);
        probabilityOfSet.setExportAdministrationNullDem(helper[5]);
    }
}
