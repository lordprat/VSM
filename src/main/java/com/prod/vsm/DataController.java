package com.prod.vsm;

import com.mongodb.client.model.Filters;
import com.prod.models.step.one.OrgDepartment;
import com.prod.models.step.one.OrgScope;
import com.prod.persistence.CollectionNames;
import com.prod.persistence.MongoOperations;
import org.bson.conversions.Bson;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static com.prod.utils.Constants.API_PREFIX;

@RestController
@CrossOrigin
public class DataController {


    @RequestMapping(method = RequestMethod.POST, value = API_PREFIX+"/org")
    public void saveOrg(@RequestBody OrgScope payload)
    {
        //Call mongodb to save OrgScope
        MongoOperations operations = new MongoOperations();
        operations.storeDocument(payload, CollectionNames.ORG_SCOPE_COLLECTION.toString());
    }


    @RequestMapping(method = RequestMethod.POST, value = API_PREFIX+"/department")
    public void saveOrgDepartment(@RequestBody OrgDepartment payload)
    {
        //Call mongodb to save OrgDepartment
        MongoOperations operations = new MongoOperations();
        operations.storeDocument(payload, CollectionNames.ORG_DEPARTMENT_COLLECTION.toString());
    }


    @RequestMapping(method = RequestMethod.GET, value = API_PREFIX+"/org")
    public ResponseEntity<List<OrgScope>> getOrgById(@RequestParam(value = "id") String id)
    {
        if(id == null)
        {
            //Exception
            return ResponseEntity.notFound().build();
        }

        Bson query = Filters.eq("orgName", id);

        MongoOperations operations = new MongoOperations();
        List<OrgScope> orgList = operations.getDocumentById(query, OrgScope.class, CollectionNames.ORG_SCOPE_COLLECTION.toString());
        return ResponseEntity.ok(orgList);
        //Get from mongo db by id

    }


    @RequestMapping(method = RequestMethod.GET, value = API_PREFIX+"/orgs")
    public ResponseEntity<List<OrgScope>> getAllOrgs()
    {
        List<OrgScope> orgList = new LinkedList<>();
        MongoOperations operations = new MongoOperations();
        operations.getAllDocuments(orgList, OrgScope.class, CollectionNames.ORG_SCOPE_COLLECTION.toString());
        return ResponseEntity.ok(orgList);
    }




    @RequestMapping(method = RequestMethod.GET, value = API_PREFIX+"/department")
    public ResponseEntity<List<OrgDepartment>> getOrgDepartmentsById(@RequestParam(value = "org") String org, @RequestParam(value = "scope") String scope)
    {
        //Call mongodb to save OrgDepartment
        if(org == null || scope == null)
        {
            return ResponseEntity.notFound().build();
        }

        Bson query = Filters.and(Filters.eq("orgName", org), Filters.eq("scope", scope));

        MongoOperations operations = new MongoOperations();
        List<OrgDepartment> orgList = operations.getDocumentById(query, OrgDepartment.class, CollectionNames.ORG_DEPARTMENT_COLLECTION.toString());
        return ResponseEntity.ok(orgList);
    }


    @RequestMapping(method = RequestMethod.GET, value = API_PREFIX+"/departments")
    public ResponseEntity<List<OrgDepartment>> getAllDepartments()
    {
        List<OrgDepartment> departmentList = new LinkedList<>();
        MongoOperations operations = new MongoOperations();
        operations.getAllDocuments(departmentList, OrgDepartment.class, CollectionNames.ORG_DEPARTMENT_COLLECTION.toString());
        return ResponseEntity.ok(departmentList);
    }
}
