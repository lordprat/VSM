package com.prod.vsm;


import com.mongodb.client.model.Filters;
import com.prod.models.step.seven.ProcessTime;
import com.prod.models.step.two.DepartmentProcedureCount;
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
public class DataAnalyticsController {



    @RequestMapping(method = RequestMethod.POST, value = API_PREFIX + "/department_procedure_count")
    public void saveDepartmentProcedureCount(@RequestBody DepartmentProcedureCount payload)
    {
        //Call mongodb to save OrgScope
        MongoOperations operations = new MongoOperations();
        operations.storeDocument(payload, CollectionNames.DEPARTMENT_PROCEDURE_COUNT.toString());
    }



    @RequestMapping(method = RequestMethod.GET, value = API_PREFIX + "/department_procedure_count")
    public ResponseEntity<List<DepartmentProcedureCount>> getDepartmentProcedureCount(@RequestParam(value = "orgName") String orgName)
    {
        if(orgName == null)
        {
            //Exception
            return ResponseEntity.notFound().build();
        }

        Bson query = Filters.eq("orgName", orgName);

        MongoOperations operations = new MongoOperations();
        List<DepartmentProcedureCount> orgList = operations.getDocumentById(query, DepartmentProcedureCount.class, CollectionNames.DEPARTMENT_PROCEDURE_COUNT.toString());
        return ResponseEntity.ok(orgList);
    }


}
