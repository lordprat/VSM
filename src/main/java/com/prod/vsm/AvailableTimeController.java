package com.prod.vsm;

import com.prod.models.Facility;
import com.prod.models.Staff;
import com.prod.persistence.CollectionNames;
import com.prod.persistence.MongoOperations;
import com.prod.utils.AvailableTimeDiffUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.prod.utils.Constants.DAYS_PER_WEEK;

@RestController
public class AvailableTimeController {


    @RequestMapping(method = RequestMethod.POST, value = "/availableTimeStaff")
    public void saveAvailableTimeStaff(@RequestBody Staff payload)
    {
        //Call mongodb to save OrgScope
        MongoOperations operations = new MongoOperations();
        payload.setOnsiteMinutes(AvailableTimeDiffUtil.getStaffAvailableTimeDiffMinutes(
                payload.getScheduledStart(), payload.getScheduledEnd(), payload.getBreakMinutes(),
                payload.getLunchMinutes(), payload.getAdditionalMinutes()
        ));
        payload.setTotalOnsiteMinutes(payload.getOnsiteMinutes()*(int)(DAYS_PER_WEEK*payload.getFullTimeStatus()));
        operations.storeDocument(payload, CollectionNames.AVAILABLE_TIME_STAFF_COLLECTION.toString());
    }


    @RequestMapping(method = RequestMethod.POST, value = "/availableTimeFacility")
    public void saveAvailableTimeFacility(@RequestBody Facility payload)
    {
        //Call mongodb to save OrgScope
        MongoOperations operations = new MongoOperations();
        payload.setMinutesAvailable(payload.getDaysPerWeek() * AvailableTimeDiffUtil.getAvailableTimeDiffMinutes(payload.scheduledStart, payload.scheduledEnd));
        operations.storeDocument(payload, CollectionNames.AVAILABLE_TIME_FACILITY_COLLECTION.toString());
    }




}
