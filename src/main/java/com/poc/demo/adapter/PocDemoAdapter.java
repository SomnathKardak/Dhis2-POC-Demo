package com.poc.demo.adapter;

import com.poc.demo.model.User;
import com.poc.demo.util.Dhis2Extender;
import org.hisp.dhis.Dhis2;
import org.hisp.dhis.Dhis2Config;
import org.hisp.dhis.auth.Authentication;
import org.hisp.dhis.auth.BasicAuthentication;
import org.hisp.dhis.model.OrgUnit;
import org.hisp.dhis.query.Order;
import org.hisp.dhis.query.Query;
import org.hisp.dhis.response.object.ObjectResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PocDemoAdapter {
    public void createUser(User user) {
        Authentication authentication = new BasicAuthentication("admin", "district");
        Dhis2Config config = new Dhis2Config("https://play.dhis2.org/2.36.3", authentication);
        Dhis2Extender dhis2 = new Dhis2Extender(config);
        ObjectResponse objectResponse = dhis2.saveUser(user);
        System.out.println("User created Successfully : " + objectResponse.toString());
    }
}
