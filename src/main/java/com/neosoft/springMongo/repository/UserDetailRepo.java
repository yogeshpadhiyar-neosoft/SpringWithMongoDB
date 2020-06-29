package com.neosoft.springMongo.repository;

import com.neosoft.springMongo.model.UserDetail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserDetailRepo  extends MongoRepository<UserDetail , String> {

    /**
     * Check EmailId is exist or not
     * @param emailId
     * @return boolean
     */
    boolean existsUserDetailByEmailId(String emailId);
}
