package com.prod.vsm;


import com.mongodb.client.model.Filters;
import com.prod.models.step.four.DepartmentOperationsDays;
import com.prod.models.step.four.FutureThroughputGoals;
import com.prod.models.step.four.StaffRequirement;
import com.prod.models.step.two.DepartmentProcedureCount;
import com.prod.persistence.CollectionNames;
import com.prod.persistence.MongoOperations;
import org.bson.conversions.Bson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.prod.utils.Constants.API_PREFIX;

@RestController
@CrossOrigin
@RequestMapping(API_PREFIX + "/step4")
public class CustomerInterviewController {


    /**
     * Save the total number of procedure count for each department entry
     * e.g. Each call will have - PreOp or PreOp Hold or OR object with count
     * @param payload
     */
    @RequestMapping(method = RequestMethod.POST, value = "/throughput_goals")
    public void saveThroughputGoals(@RequestBody FutureThroughputGoals payload)
    {
        //Call mongodb to save OrgScope
        MongoOperations operations = new MongoOperations();
        operations.storeDocument(payload, CollectionNames.THROUGHPUT_GOALS_COLLECTION.toString());
    }


    /**
     * Fetches list of number of procedure count for each department
     * e.g. list will have - [PreOp, PreOp Hold, OR] object with each having the procedure count
     * @param orgName
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/throughput_goals")
    public ResponseEntity<List<FutureThroughputGoals>> getThroughputGoals(@RequestParam(value = "orgName") String orgName, @RequestParam(value = "scope") String scope)
    {
        if(orgName == null)
        {
            //Exception
            return ResponseEntity.notFound().build();
        }

        Bson query = Filters.and(Filters.eq("orgName", orgName), Filters.eq("scope", scope));

        MongoOperations operations = new MongoOperations();
        List<FutureThroughputGoals> orgList = operations.getDocumentById(query, FutureThroughputGoals.class, CollectionNames.THROUGHPUT_GOALS_COLLECTION.toString());
        return ResponseEntity.ok(orgList);
    }



    /**
     * Save the total number of procedure count for each department entry
     * e.g. Each call will have - PreOp or PreOp Hold or OR object with count
     * @param payload
     */
    @RequestMapping(method = RequestMethod.POST, value = "/operation_days")
    public void saveOperationDays(@RequestBody DepartmentOperationsDays payload)
    {
        //Call mongodb to save OrgScope
        MongoOperations operations = new MongoOperations();
        operations.storeDocument(payload, CollectionNames.DEPARTMENT_OPERATIONS_DAYS_COLLECTION.toString());
    }


    /**
     * Fetches list of number of procedure count for each department
     * e.g. list will have - [PreOp, PreOp Hold, OR] object with each having the procedure count
     * @param orgName
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/operation_days")
    public ResponseEntity<List<DepartmentOperationsDays>> getOperationDays(@RequestParam(value = "orgName") String orgName, @RequestParam(value = "scope") String scope)
    {
        if(orgName == null)
        {
            //Exception
            return ResponseEntity.notFound().build();
        }

        Bson query = Filters.and(Filters.eq("orgName", orgName), Filters.eq("scope", scope));

        MongoOperations operations = new MongoOperations();
        List<DepartmentOperationsDays> orgList = operations.getDocumentById(query, DepartmentOperationsDays.class, CollectionNames.DEPARTMENT_OPERATIONS_DAYS_COLLECTION.toString());
        return ResponseEntity.ok(orgList);
    }




    /**
     * Save the total number of procedure count for each department entry
     * e.g. Each call will have - PreOp or PreOp Hold or OR object with count
     * @param payload
     */
    @RequestMapping(method = RequestMethod.POST, value = "/staff_requirement")
    public void saveStaffRequirement(@RequestBody StaffRequirement payload)
    {
        //Call mongodb to save OrgScope
        MongoOperations operations = new MongoOperations();
        operations.storeDocument(payload, CollectionNames.STAFF_REQUIREMENT_COLLECTION.toString());
    }


    /**
     * Fetches list of number of procedure count for each department
     * e.g. list will have - [PreOp, PreOp Hold, OR] object with each having the procedure count
     * @param orgName
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/staff_requirement")
    public ResponseEntity<List<StaffRequirement>> getStaffRequirement(@RequestParam(value = "orgName") String orgName, @RequestParam(value = "scope") String scope)
    {
        if(orgName == null)
        {
            //Exception
            return ResponseEntity.notFound().build();
        }

        Bson query = Filters.and(Filters.eq("orgName", orgName), Filters.eq("scope", scope));

        MongoOperations operations = new MongoOperations();
        List<StaffRequirement> orgList = operations.getDocumentById(query, StaffRequirement.class, CollectionNames.STAFF_REQUIREMENT_COLLECTION.toString());
        return ResponseEntity.ok(orgList);
    }





}
