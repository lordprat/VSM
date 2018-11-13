package com.prod.models.step.two;

public class DepartmentProcedureCount {


    public String departmentName;
    public String orgName;
    public String scope;

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public int patientAnnualCount;
    public String comments;
    public int patientRevisitCount;
    public int patientInBedCount;
    public boolean isComplete;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getPatientAnnualCount() {
        return patientAnnualCount;
    }

    public void setPatientAnnualCount(int patientAnnualCount) {
        this.patientAnnualCount = patientAnnualCount;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getPatientRevisitCount() {
        return patientRevisitCount;
    }

    public void setPatientRevisitCount(int patientRevisitCount) {
        this.patientRevisitCount = patientRevisitCount;
    }

    public int getPatientInBedCount() {
        return patientInBedCount;
    }

    public void setPatientInBedCount(int patientInBedCount) {
        this.patientInBedCount = patientInBedCount;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }
}
