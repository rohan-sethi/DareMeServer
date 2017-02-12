package com.dareme.repositories;

import com.dareme.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, ObjectId> {
    public User findByName(String name);
}
