package com.neosoft.springMongo.service;

import com.neosoft.springMongo.constant.AllMessages;
import com.neosoft.springMongo.exception.CustomException;
import com.neosoft.springMongo.model.UserMaster;
import com.neosoft.springMongo.repository.UserMasterRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMasterServiceImpl implements UserMasterService{
    private  final Logger LOGGER = LoggerFactory.getLogger(UserMasterServiceImpl.class);
    private final UserMasterRepo userMasterRepo;

    @Autowired
    public UserMasterServiceImpl(UserMasterRepo userMasterRepo) {
        this.userMasterRepo = userMasterRepo;
    }

    @Override
    public UserMaster findByUserUUID(String userUUID) throws CustomException {
        LOGGER.info("Finding User by Id :"+userUUID);
        return userMasterRepo.findById(userUUID).orElseThrow(()-> new CustomException(HttpStatus.NO_CONTENT,AllMessages.NO_USER_FOUND));
    }

    @Override
    public UserMaster insertUserMaster(UserMaster userMaster) {
        LOGGER.info("Insert User (Input) :"+userMaster);
        return userMasterRepo.insert(userMaster);
    }

    @Override
    public List<UserMaster> findAll() throws CustomException {
        LOGGER.info("Finding All users");
        List<UserMaster> userMasterList =  userMasterRepo.findAll();
        if(userMasterList.isEmpty())
            throw new CustomException(HttpStatus.BAD_REQUEST, AllMessages.ANY_USER_NOT_FOUND);
        LOGGER.info("Users : "+userMasterList);
        return userMasterList;
    }

    @Override
    public UserMaster updateByUserUUID(UserMaster userMaster) {
        LOGGER.info("Updating User : "+userMaster);
        return userMasterRepo.save(userMaster);
    }

    @Override
    public void deleteByUserUUID(String userUUID) {
        LOGGER.info("User deleting which ID : "+userUUID);
        userMasterRepo.deleteById(userUUID);
    }
}
