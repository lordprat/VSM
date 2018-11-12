package com.prod.utils;

import com.prod.models.step.seven.ProcessTime;

public class ProcessTimeCalculations {

    public static ProcessTime setCalculatedValues(ProcessTime entity)
    {

        entity.setTotalTaskMinutes(entity.getOccurrence() * entity.getTaskMinutes());

        entity.setTotalCombinedTaskMinutes((entity.getTaskMinutes() + entity.getAdditionalTaskMinutes()) *
                entity.getOccurrence());

        entity.setTotalTurnoverMinutes(entity.getTurnoverWoToWiMinutes() * entity.getOccurrence());

        entity.setTotalCaregiverTurnoverMinutes(entity.getTurnoverPrimaryCaregiverWoToWiMinutes() * entity.getOccurrence());

        entity.setTotalCombinedTaskMinutesStaff((entity.getTaskMinutes()+entity.getTurnoverPrimaryCaregiverWoToWiMinutes()) *
                entity.getOccurrence());

        entity.setTotalCombinedTaskMinutesFacility((entity.getTaskMinutes() + entity.getAdditionalTaskMinutes() + entity.getTurnoverWoToWiMinutes()) *
                entity.getOccurrence());

        entity.setTotalPatientRequiredMinutes(entity.getOccurrence() * entity.getPatientRequiredMinutes());
        entity.setTotalCombinedPatientRequiredMinutes((entity.getPatientRequiredMinutes() + entity.getPatientRequiredAdditionalMinutes()) *
                entity.getOccurrence());
        entity.setTotalCombinedPatientWithTurnoverMinutes(entity.getTotalTurnoverMinutes() + entity.getTotalCombinedPatientRequiredMinutes());


        return entity;
    }

}
