package com.dareme.controller;

import com.dareme.co.SampleCO;
import com.dareme.dto.ResponseDto;
import com.dareme.enums.SuccessResponse;
import com.dareme.model.User;
import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dareme.model.Address;
import com.dareme.repositories.UserRepository;
import com.dareme.services.SampleService;
import com.dareme.util.response.PrepareResponseUtil;

@RestController
@RequestMapping(value = {"/sample"})
public class SampleController {


    @Autowired
    private PrepareResponseUtil responseUtil;
    @Autowired
    private SampleService sampleService;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private UserRepository userRepository;

    @SuppressWarnings("rawtypes")
    @RequestMapping(value = "/test")
    public ResponseDto sample(@RequestBody SampleCO sampleCO) {
        return responseUtil.prepareSuccessResponse(sampleService.sampleMethod(sampleCO), SuccessResponse.SAMPLE_MESSAGE, null);
    }

    @RequestMapping(value = "/demo")
    public String demo() {
//        DBCollection dbCollection = mongoTemplate.createCollection("Dummy");
        try {
            System.out.println(mongoTemplate.getCollectionNames());
            User user = new User();
            user.setId(2);
            user.setName("samle1");
            mongoTemplate.insert(user, "users");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error msg: "+e.getMessage());
        }
        return "demooooooooooooooooooooo";
    }

    @RequestMapping(value = "/find")
    public String find() {
//        DBCollection dbCollection = mongoTemplate.createCollection("Dummy");
        Query findQuery = new Query(Criteria.where("name").is("test"));
        User user = mongoTemplate.findOne(findQuery, User.class);
        System.out.println(user);

        System.out.println(userRepository.findByName("test"));
        return user.toString();
    }

    @RequestMapping(value = "/addAddress")
    public String addAddress() {
        Query findQuery = new Query(Criteria.where("name").is("test"));
        WriteResult upsert = mongoTemplate.upsert(findQuery, new Update().push("address", new Address("abc", "delhi")), User.class);
        upsert.toString();
        System.out.println(userRepository.findByName("test"));
        System.out.println(upsert.toString());
        return "update";
    }

}
