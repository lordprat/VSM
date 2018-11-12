package com.prod.vsm;

import com.mongodb.client.model.Filters;
import com.prod.models.step.seven.ProcessTime;
import com.prod.models.step.six.Facility;
import com.prod.models.step.five.Staff;
import com.prod.persistence.CollectionNames;
import com.prod.persistence.MongoOperations;
import com.prod.utils.AvailableTimeDiffUtil;
import org.bson.conversions.Bson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.prod.utils.Constants.API_PREFIX;
import static com.prod.utils.Constants.DAYS_PER_WEEK;

@RestController
@CrossOrigin
public class AvailableTimeController {


    @RequestMapping(method = RequestMethod.POST, value = API_PREFIX+"/availableTimeStaff")
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


    @RequestMapping(method = RequestMethod.POST, value = API_PREFIX+"/availableTimeFacility")
    public void saveAvailableTimeFacility(@RequestBody Facility payload)
    {
        //Call mongodb to save OrgScope
        MongoOperations operations = new MongoOperations();
        payload.setMinutesAvailable(payload.getDaysPerWeek() * AvailableTimeDiffUtil.getAvailableTimeDiffMinutes(payload.scheduledStart, payload.scheduledEnd));
        operations.storeDocument(payload, CollectionNames.AVAILABLE_TIME_FACILITY_COLLECTION.toString());
    }



    @RequestMapping(method = RequestMethod.GET, value = API_PREFIX + "/availableTimeFacility")
    public ResponseEntity<List<Facility>> getAvailableTimeFacility(@RequestParam(value = "orgName") String orgName, @RequestParam(value = "deptName") String deptName)
    {
        if(orgName == null || deptName == null)
        {
            //Exception
            return ResponseEntity.notFound().build();
        }

        Bson query = Filters.eq("orgName", orgName);

        MongoOperations operations = new MongoOperations();
        List<Facility> orgList = operations.getDocumentById(query, Facility.class, CollectionNames.AVAILABLE_TIME_FACILITY_COLLECTION.toString());
        return ResponseEntity.ok(orgList);
    }


    @RequestMapping(method = RequestMethod.GET, value = API_PREFIX + "/availableTimeStaff")
    public ResponseEntity<List<Staff>> getAvailableTimeStaff(@RequestParam(value = "orgName") String orgName, @RequestParam(value = "deptName") String deptName)
    {
        if(orgName == null || deptName == null)
        {
            //Exception
            return ResponseEntity.notFound().build();
        }

        Bson query = Filters.eq("orgName", orgName);

        MongoOperations operations = new MongoOperations();
        List<Staff> orgList = operations.getDocumentById(query, Staff.class, CollectionNames.AVAILABLE_TIME_STAFF_COLLECTION.toString());
        return ResponseEntity.ok(orgList);
    }

}
