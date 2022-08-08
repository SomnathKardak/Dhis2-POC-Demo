package com.poc.demo.util;

import com.poc.demo.model.User;
import org.hisp.dhis.Dhis2;
import org.hisp.dhis.Dhis2Config;
import org.hisp.dhis.response.object.ObjectResponse;

public class Dhis2Extender extends Dhis2 {
    public Dhis2Extender(Dhis2Config config) {
        super(config);
    }
    public ObjectResponse saveUser(User user) {
        return this.saveMetadataObject("users", user);
    }
}
