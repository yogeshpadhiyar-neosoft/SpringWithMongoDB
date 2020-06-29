package com.neosoft.springMongo.repository;

import com.neosoft.springMongo.model.UserMaster;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserMasterRepo  extends MongoRepository<UserMaster , String> {

}
