package com.prod.vsm;

import com.prod.models.OrgDepartment;
import com.prod.models.OrgScope;
import com.prod.persistence.CollectionNames;
import com.prod.persistence.MongoOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
public class DataController {


    @RequestMapping (method = RequestMethod.GET, value = "/")
    public String ping () {
        return "Webapp is running";
    }


    @RequestMapping(method = RequestMethod.POST, value = "/org")
    public void saveOrg(@RequestBody OrgScope payload)
    {
        //Call mongodb to save OrgScope
        MongoOperations operations = new MongoOperations();
        operations.storeDocument(payload, CollectionNames.ORG_SCOPE_COLLECTION.toString());
    }


    @RequestMapping(method = RequestMethod.POST, value = "/department")
    public void saveOrgDepartment(@RequestBody OrgDepartment payload)
    {
        //Call mongodb to save OrgDepartment
        MongoOperations operations = new MongoOperations();
        operations.storeDocument(payload, CollectionNames.ORG_DEPARTMENT_COLLECTION.toString());
    }


    @RequestMapping(method = RequestMethod.GET, value = "/org")
    public ResponseEntity<OrgScope> getOrgById(@RequestParam(value = "id") String id)
    {
        if(id == null)
        {
            //Exception
            return ResponseEntity.notFound().build();
        }

        //Get from mongo db by id

        return null;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/orgs")
    public ResponseEntity<List<OrgScope>> getAllOrgs()
    {
        List<OrgScope> orgList = new LinkedList<>();
        MongoOperations operations = new MongoOperations();
        operations.getAllDocuments(orgList, OrgScope.class, CollectionNames.ORG_SCOPE_COLLECTION.toString());
        return ResponseEntity.ok(orgList);
    }




    @RequestMapping(method = RequestMethod.GET, value = "/department")
    public ResponseEntity<OrgDepartment> getOrgDepartmentById(@RequestParam(value = "org") String org, @RequestParam(value = "scope") String scope)
    {
        //Call mongodb to save OrgDepartment
        if(org == null || scope == null)
        {
            return ResponseEntity.notFound().build();
        }

        return null;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/departments")
    public ResponseEntity<List<OrgDepartment>> getAllDepartments()
    {
        List<OrgDepartment> departmentList = new LinkedList<>();
        MongoOperations operations = new MongoOperations();
        operations.getAllDocuments(departmentList, OrgDepartment.class, CollectionNames.ORG_DEPARTMENT_COLLECTION.toString());
        return ResponseEntity.ok(departmentList);
    }
}
