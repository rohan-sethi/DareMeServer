package com.dareme.repositories;

import com.dareme.model.UserData;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by vikas on 12/2/17.
 */
public interface UserDataRepository extends CrudRepository<UserData, ObjectId> {
    public UserData findByUserID(String userID);
}
