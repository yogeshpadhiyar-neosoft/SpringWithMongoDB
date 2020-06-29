package com.neosoft.springMongo.controller;

import com.neosoft.springMongo.FactoryPattern.RequestResponse;
import com.neosoft.springMongo.constant.AllMessages;
import com.neosoft.springMongo.exception.CustomException;
import com.neosoft.springMongo.model.UserMaster;
import com.neosoft.springMongo.responseEntity.UserMasterEntity;
import com.neosoft.springMongo.service.UserDetailService;
import com.neosoft.springMongo.service.UserMasterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mongo/user")
public class UserMasterController extends Validation{
    private final Logger LOGGER = LoggerFactory.getLogger(UserMasterController.class);

    private final UserMasterService userMasterService;

    @Autowired
    public UserMasterController(UserMasterService userMasterService , UserDetailService userDetailService) {
        super(userDetailService);
        this.userMasterService = userMasterService;
    }


    /**
     * Find All registered User
     * @return Generic Response
     */
    @GetMapping()
    public ResponseEntity<Object> findAllUsers(){
        LOGGER.info("Finding All registered user");
        ResponseEntity<Object> responseEntity;
        try {
            responseEntity = responseBuilder(userMasterService.findAll());
        } catch (CustomException e) {
            e.setErrorMessage(AllMessages.ANY_USER_NOT_FOUND);
            responseEntity = responseEx(e);
        }
        LOGGER.info("Registered User:"+responseEntity);
        return responseEntity;
    }

    /**
     *  use for Register new user
     * @param userMasterEntity
     * @return Generic Response
     */
    @PostMapping()
    public ResponseEntity<Object> insertUserMaster(@RequestBody UserMasterEntity userMasterEntity){
        LOGGER.debug("Inserting  User");
        LOGGER.info("Insert User (Input) :"+userMasterEntity);
        ResponseEntity<Object> responseEntity = null;
        try {
            if (valid(userMasterEntity)) {
                UserMaster userMaster = RequestResponse.userRequest(userMasterEntity);
                responseEntity = responseBuilder(userMasterService.insertUserMaster(userMaster));
            }
        }catch (CustomException e){
            responseEntity = responseEx(e);
        }
        LOGGER.info("Inserted user : "+responseEntity);
        return responseEntity;
    }


    /**
     * This method use for Find user using UUID
     * @param userUUID
     * @return Generic Response
     */
    @GetMapping("/{userUUID}")
    public ResponseEntity<Object> findByUserUUID(@PathVariable("userUUID") String userUUID){
        LOGGER.debug("Finding User By User ID");
        LOGGER.info("Finding User by Id :"+userUUID);
        ResponseEntity<Object> responseEntity;
        try{
            responseEntity = responseBuilder(userMasterService.findByUserUUID(userUUID));
        }catch (CustomException e){
            responseEntity = responseEx(e);
        }
        LOGGER.info("User is : "+responseEntity);
        return  responseEntity;
    }


    /**
     * This method is use for update user
     * @param userUUID
     * @param userMasterEntity
     * @return Generic Response
     */
    @PutMapping("/{userUUID}")
    public ResponseEntity<Object> updateByUserUUID(@PathVariable("userUUID") String userUUID, @RequestBody UserMasterEntity userMasterEntity ){
        LOGGER.debug("Updating User");
        LOGGER.info("Updating User ID : "+userUUID+ "\n Updating info :"+userMasterEntity);
        ResponseEntity<Object> responseEntity =null;
        try {
            if(valid(userMasterEntity)){
                UserMaster userMaster = RequestResponse.userRequest(userMasterEntity);
                userMaster.setUserId(userUUID);
                responseEntity = responseBuilder(userMasterService.updateByUserUUID(userMaster));
            }
        }catch (CustomException e){
            responseEntity = responseEx(e);
        }
        LOGGER.info("Updated User :"+responseEntity);
        return responseEntity;
    }


    /**
     * This method use for Delete user
     * @param userUUID
     * @return Generic Response
     */
    @DeleteMapping("/{userUUID}")
    public ResponseEntity<Object> deleteByUserUUID(@PathVariable("userUUID") String userUUID){
        LOGGER.debug("deleting user ");
        LOGGER.info("Deleting user Id :"+userUUID);
        ResponseEntity<Object> responseEntity;
        try {
            userMasterService.deleteByUserUUID(userUUID);
            responseEntity = responseMessage(AllMessages.USER_DELETED);
        }catch (CustomException e){
            responseEntity = responseEx(e);
        }
        LOGGER.info(AllMessages.USER_DELETED);
        return responseEntity;
    }
}
