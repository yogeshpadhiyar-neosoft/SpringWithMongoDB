package com.neosoft.springMongo.service;

import com.neosoft.springMongo.model.UserDetail;
import com.neosoft.springMongo.model.UserMaster;
import com.neosoft.springMongo.repository.UserMasterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserMasterServiceImpl implements UserMasterService{

    private final UserMasterRepo userMasterRepo;

    @Autowired
    public UserMasterServiceImpl(UserMasterRepo userMasterRepo) {
        this.userMasterRepo = userMasterRepo;
    }

    @Override
    public UserMaster findByUserUUID(UUID userUUID) {
        return userMasterRepo.findById(userUUID).orElse(null);
    }

    @Override
    public UserMaster insertUserMaster(UserMaster userMaster) {
        return userMasterRepo.insert(userMaster);
    }

    @Override
    public List<UserMaster> findAll() {
        return userMasterRepo.findAll();
    }

    @Override
    public UserMaster updateByUserUUID(UserMaster userMaster) {
        return userMasterRepo.save(userMaster);
    }

    @Override
    public void deleteByUserUUID(UUID userUUID) {
        userMasterRepo.deleteById(userUUID);
    }
}
