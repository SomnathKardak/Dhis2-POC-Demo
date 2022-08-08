package com.poc.demo.service.impl;

import com.poc.demo.adapter.PocDemoAdapter;
import com.poc.demo.model.User;
import com.poc.demo.service.PocDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PocDemoServiceImpl implements PocDemoService {
    @Autowired
    PocDemoAdapter pocDemoAdapter;

    @Override
    public void createUser(User user) {
        pocDemoAdapter.createUser(user);
    }
}
