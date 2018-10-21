package com.prod.models;

import java.util.Date;

public class Facility {

    public String orgName;
    public String scope;
    public String departmentName;
    public String facilityId;
    public String scheduledStart;
    public String scheduledEnd;
    public int daysPerWeek;
    public int minutesAvailable;
    public String comments;


    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
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

    public int getDaysPerWeek() {
        return daysPerWeek;
    }

    public void setDaysPerWeek(int daysPerWeek) {
        this.daysPerWeek = daysPerWeek;
    }

    public int getMinutesAvailable() {
        return minutesAvailable;
    }

    public void setMinutesAvailable(int minutesAvailable) {
        this.minutesAvailable = minutesAvailable;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }


    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
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


}
