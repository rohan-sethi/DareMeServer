package com.dareme.controller;

import com.dareme.enums.CollectionName;
import com.dareme.model.User;
import com.dareme.model.UserData;
import com.dareme.repositories.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/userData")
public class UserDataController {


    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserDataRepository userDataRepository;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public int create(@RequestBody UserData userData){
        System.out.println("------------------User Data---------------------");
        System.out.println(userData);
        mongoTemplate.insert(userData, CollectionName.USER_DATA.getValue());
        return 1;
    }

    @RequestMapping(value = "/findByUserID", method = RequestMethod.GET)
    public String find(String userID) {
        UserData userData = userDataRepository.findByUserID(userID);
        return userData.toString();
    }

}