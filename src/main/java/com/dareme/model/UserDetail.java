package com.dareme.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_detail")
public class UserDetail {
    @Id
    Long id;
    String email;
    String name;

}
