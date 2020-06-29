package com.neosoft.springMongo.service;

import com.neosoft.springMongo.model.UserDetail;
import com.neosoft.springMongo.model.UserMaster;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface UserMasterService {

    /**
     * Use to find all registered user
     * @return List<UserMaster>
     */
    List<UserMaster> findAll();

    /**
     * Find user By UUID
     * @param userUUID
     * @return UserMaster
     */
    UserMaster findByUserUUID(String userUUID);

    /**
     * Register new User using this method
     * need to give valid Json
     * @param userMaster
     * @return UserMaster
     */
    UserMaster insertUserMaster(UserMaster userMaster);

    /**
     * update User info
     * @param userMaster
     * @return updated UserMaster
     */
    UserMaster updateByUserUUID(UserMaster userMaster);

    /**
     * Delete User info
     * @param userUUID
     */
    void deleteByUserUUID(String userUUID);

}
