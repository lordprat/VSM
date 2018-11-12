package com.prod.vsm;


import com.mongodb.client.model.Filters;
import com.prod.models.step.one.OrgScope;
import com.prod.models.step.seven.ProcessTime;
import com.prod.persistence.CollectionNames;
import com.prod.persistence.MongoOperations;
import com.prod.utils.ProcessTimeCalculations;
import org.bson.conversions.Bson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.prod.utils.Constants.API_PREFIX;

@RestController
@CrossOrigin
public class ProcessTimeController {



    @RequestMapping(method = RequestMethod.POST, value = API_PREFIX+"/process_time")
    public void saveProcessTime(@RequestBody ProcessTime payload)
    {
        //Calculate and save auto-fields
        payload = ProcessTimeCalculations.setCalculatedValues(payload);

        //Call mongodb to save OrgScope
        MongoOperations operations = new MongoOperations();
        operations.storeDocument(payload, CollectionNames.PROCESS_TIME_COLLECTION.toString());
    }



    @RequestMapping(method = RequestMethod.GET, value = API_PREFIX + "/process_time")
    public ResponseEntity<List<ProcessTime>> getProcessTime(@RequestParam(value = "orgName") String orgName, @RequestParam(value = "deptName") String deptName)
    {
        if(orgName == null || deptName == null)
        {
            //Exception
            return ResponseEntity.notFound().build();
        }

        Bson query = Filters.eq("orgName", orgName);

        MongoOperations operations = new MongoOperations();
        List<ProcessTime> orgList = operations.getDocumentById(query, ProcessTime.class, CollectionNames.PROCESS_TIME_COLLECTION.toString());
        return ResponseEntity.ok(orgList);
    }


}


