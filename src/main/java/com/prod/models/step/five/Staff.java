package com.prod.models.step.five;

import java.util.Date;

public class Staff {

    public String orgName;
    public String scope;
    public String departmentName;
    public String empId;
    public String scheduledStart;
    public String scheduledEnd;
    public int lunchMinutes;
    public int breakMinutes;
    public int additionalMinutes;
    public int onsiteMinutes;
    public float fullTimeStatus;
    public String comments;
    public int totalOnsiteMinutes;

    public int getTotalOnsiteMinutes() {
        return totalOnsiteMinutes;
    }

    public void setTotalOnsiteMinutes(int totalOnsiteMinutes) {
        this.totalOnsiteMinutes = totalOnsiteMinutes;
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

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getScheduledStart() {
        return scheduledStart;
    }

    public void setScheduledStart(String scheduledStart) {
        this.scheduledStart = scheduledStart;
    }

    public String getScheduledEnd() {
        return scheduledEnd;
    }

    public void setScheduledEnd(String scheduledEnd) {
        this.scheduledEnd = scheduledEnd;
    }

    public int getLunchMinutes() {
        return lunchMinutes;
    }

    public void setLunchMinutes(int lunchMinutes) {
        this.lunchMinutes = lunchMinutes;
    }

    public int getBreakMinutes() {
        return breakMinutes;
    }

    public void setBreakMinutes(int breakMinutes) {
        this.breakMinutes = breakMinutes;
    }

    public int getAdditionalMinutes() {
        return additionalMinutes;
    }

    public void setAdditionalMinutes(int additionalMinutes) {
        this.additionalMinutes = additionalMinutes;
    }

    public int getOnsiteMinutes() {
        return onsiteMinutes;
    }

    public void setOnsiteMinutes(int onsiteMinutes) {
        this.onsiteMinutes = onsiteMinutes;
    }

    public float getFullTimeStatus() {
        return fullTimeStatus;
    }

    public void setFullTimeStatus(float fullTimeStatus) {
        this.fullTimeStatus = fullTimeStatus;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
