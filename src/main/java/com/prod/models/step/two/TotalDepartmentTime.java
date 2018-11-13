package com.prod.models.step.two;

public class TotalDepartmentTime {


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

    public String departmentName;
    public int totalPatientTimePerCase;
    public String comments;
    public boolean isComplete;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getTotalPatientTimePerCase() {
        return totalPatientTimePerCase;
    }

    public void setTotalPatientTimePerCase(int totalPatientTimePerCase) {
        this.totalPatientTimePerCase = totalPatientTimePerCase;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }
}
