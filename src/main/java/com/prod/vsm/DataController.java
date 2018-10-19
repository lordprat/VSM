package com.prod.vsm;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    @RequestMapping (method = RequestMethod.GET, value = "/getData")
    public String getData () {
        return "Hello World";
    }

    @RequestMapping (method = RequestMethod.GET, value = "/")
    public String getD () {
        return "Hello";
    }

}
