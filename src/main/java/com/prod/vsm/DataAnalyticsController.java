package com.prod.vsm;


import com.mongodb.client.model.Filters;
import com.prod.models.step.two.DepartmentProcedureCount;
import com.prod.models.step.two.TotalDepartmentTime;
import com.prod.persistence.CollectionNames;
import com.prod.persistence.MongoOperations;
import org.bson.conversions.Bson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.prod.utils.Constants.API_PREFIX;

@RestController
@CrossOrigin
@RequestMapping(API_PREFIX + "/step2")
public class DataAnalyticsController {


    /**
     * Save the total number of procedure count for each department entry
     * e.g. Each call will have - PreOp or PreOp Hold or OR object with count
     * @param payload
     */
    @RequestMapping(method = RequestMethod.POST, value = "/department_procedure_count")
    public void saveDepartmentProcedureCount(@RequestBody DepartmentProcedureCount payload)
    {
        //Call mongodb to save OrgScope
        MongoOperations operations = new MongoOperations();
        operations.storeDocument(payload, CollectionNames.DEPARTMENT_PROCEDURE_COUNT_COLLECTION.toString());
    }


    /**
     * Fetches list of number of procedure count for each department
     * e.g. list will have - [PreOp, PreOp Hold, OR] object with each having the procedure count
     * @param orgName
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/department_procedure_count")
    public ResponseEntity<List<DepartmentProcedureCount>> getDepartmentProcedureCount(@RequestParam(value = "orgName") String orgName, @RequestParam(value = "scope") String scope)
    {
        if(orgName == null)
        {
            //Exception
            return ResponseEntity.notFound().build();
        }

        Bson query = Filters.and(Filters.eq("orgName", orgName), Filters.eq("scope", scope));

        MongoOperations operations = new MongoOperations();
        List<DepartmentProcedureCount> orgList = operations.getDocumentById(query, DepartmentProcedureCount.class, CollectionNames.DEPARTMENT_PROCEDURE_COUNT_COLLECTION.toString());
        return ResponseEntity.ok(orgList);
    }


    /**
     * Save the total time for each department entry
     * e.g. Each call will have - PreOp or PreOp Hold or OR object with count
     * @param payload
     */
    @RequestMapping(method = RequestMethod.POST, value = "/department_total_time_in_room")
    public void saveTotalTimePatientInRoom(@RequestBody TotalDepartmentTime payload)
    {
        //Call mongodb to save OrgScope
        MongoOperations operations = new MongoOperations();
        operations.storeDocument(payload, CollectionNames.TOTAL_DEPARTMENT_TIME_COLLECTION.toString());
    }


    /**
     * Fetches list of total time for each department
     * e.g. list will have - [PreOp, PreOp Hold, OR] object with each having the procedure count
     * @param orgName
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/department_total_time_in_room")
    public ResponseEntity<List<TotalDepartmentTime>> getTotalTimePatientInRoom(@RequestParam(value = "orgName") String orgName, @RequestParam(value = "scope") String scope)
    {
        if(orgName == null)
        {
            //Exception
            return ResponseEntity.notFound().build();
        }

        Bson query = Filters.and(Filters.eq("orgName", orgName), Filters.eq("scope", scope));

        MongoOperations operations = new MongoOperations();
        List<TotalDepartmentTime> orgList = operations.getDocumentById(query, TotalDepartmentTime.class, CollectionNames.TOTAL_DEPARTMENT_TIME_COLLECTION.toString());
        return ResponseEntity.ok(orgList);
    }



}
