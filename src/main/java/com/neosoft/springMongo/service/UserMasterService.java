package com.neosoft.springMongo.service;

import com.neosoft.springMongo.model.UserDetail;
import com.neosoft.springMongo.model.UserMaster;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface UserMasterService {
    List<UserMaster> findAll();

    UserMaster findByUserUUID(UUID userUUID);

    UserMaster insertUserMaster(UserMaster userMaster);

    UserMaster updateByUserUUID(UserMaster userMaster);

    void deleteByUserUUID(UUID userUUID);

}
