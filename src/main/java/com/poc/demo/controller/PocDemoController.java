package com.poc.demo.controller;

import com.poc.demo.model.User;
import com.poc.demo.service.PocDemoService;
import org.hisp.dhis.Dhis2;
import org.hisp.dhis.Dhis2Config;
import org.hisp.dhis.auth.Authentication;
import org.hisp.dhis.auth.BasicAuthentication;
import org.hisp.dhis.model.OrgUnit;
import org.hisp.dhis.query.Order;
import org.hisp.dhis.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/poc/demo/")
public class PocDemoController {
    @Autowired
    PocDemoService pocDemoService;

    @PostMapping("/createUser")
    public void createUser(@RequestBody User user) {
        System.out.println("In User Controller");
        pocDemoService.createUser(user);
    }

    @GetMapping("/getOU")
    public void getOU() {
        Authentication authentication = new BasicAuthentication("admin", "district");
        Dhis2Config config = new Dhis2Config("https://play.dhis2.org/2.36.3", authentication);
        Dhis2 dhis2 = new Dhis2(config);
        List<OrgUnit> orgUnits = dhis2.getOrgUnits(Query.instance()
                .setOrder(Order.desc("name")));
        System.out.print(orgUnits.size());
    }

}
