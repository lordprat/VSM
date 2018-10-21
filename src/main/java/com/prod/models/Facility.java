package com.prod.models;

import java.util.Date;

public class Facility {

    public String getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(String facilityId) {
        this.facilityId = facilityId;
    }

    public Date getScheduledStart() {
        return scheduledStart;
    }

    public void setScheduledStart(Date scheduledStart) {
        this.scheduledStart = scheduledStart;
    }

    public Date getScheduledEnd() {
        return scheduledEnd;
    }

    public void setScheduledEnd(Date scheduledEnd) {
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

    public String departmentName;
    public String facilityId;
    public Date scheduledStart;
    public Date scheduledEnd;
    public int daysPerWeek;
    public int minutesAvailable;
    public String comments;


}
