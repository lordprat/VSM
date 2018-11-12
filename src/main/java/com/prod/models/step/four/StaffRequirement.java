package com.prod.models.step.four;

public class StaffRequirement {


    public String departmentName;
    public String episodeType;
    public int annualVolume;
    public float patientToStaffRatio;
    public int minimumStaffPerTeam;


    public String orgName;

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getEpisodeType() {
        return episodeType;
    }

    public void setEpisodeType(String episodeType) {
        this.episodeType = episodeType;
    }

    public int getAnnualVolume() {
        return annualVolume;
    }

    public void setAnnualVolume(int annualVolume) {
        this.annualVolume = annualVolume;
    }

    public float getPatientToStaffRatio() {
        return patientToStaffRatio;
    }

    public void setPatientToStaffRatio(float patientToStaffRatio) {
        this.patientToStaffRatio = patientToStaffRatio;
    }

    public int getMinimumStaffPerTeam() {
        return minimumStaffPerTeam;
    }

    public void setMinimumStaffPerTeam(int minimumStaffPerTeam) {
        this.minimumStaffPerTeam = minimumStaffPerTeam;
    }
}
