package com.prod.models.step.one;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class OrgDepartment {

    public String orgName;
    public String scope;
    public List<Department> departments;
    public String assumptions;
    public String outOfScopeSupplier;
    public String outOfScopeCustomer;
    public int utilizationRate;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="MMM dd, yyyy, HH:mm:ss a")
    public Date dateUpdated;

    public Date getDateUpdated() {
        return dateUpdated;
    }

    public void setDateUpdated(Date dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public String getOutOfScopeSupplier() {
        return outOfScopeSupplier;
    }

    public void setOutOfScopeSupplier(String outOfScopeSupplier) {
        this.outOfScopeSupplier = outOfScopeSupplier;
    }

    public String getOutOfScopeCustomer() {
        return outOfScopeCustomer;
    }

    public void setOutOfScopeCustomer(String outOfScopeCustomer) {
        this.outOfScopeCustomer = outOfScopeCustomer;
    }

    public int getUtilizationRate() {
        return utilizationRate;
    }

    public void setUtilizationRate(int utilizationRate) {
        this.utilizationRate = utilizationRate;
    }

    public String getAssumptions() {
        return assumptions;
    }

    public void setAssumptions(String assumptions) {
        this.assumptions = assumptions;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
