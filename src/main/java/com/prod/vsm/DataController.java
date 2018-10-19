package com.prod.vsm;

import com.prod.models.OrgDepartment;
import com.prod.models.OrgScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    }

    @RequestMapping(method = RequestMethod.POST, value = "/department")
    public void saveOrgDepartment(@RequestBody OrgDepartment payload)
    {
        //Call mongodb to save OrgDepartment
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
}
