package com.neosoft.springMongo.controller;


import com.google.gson.Gson;
import com.neosoft.springMongo.FactoryPattern.RequestResponse;
import com.neosoft.springMongo.constant.Regex;
import com.neosoft.springMongo.exception.CustomException;
import com.neosoft.springMongo.model.UserMaster;
import com.neosoft.springMongo.requestEntity.UserMasterReqEntity;
import com.neosoft.springMongo.responseEntity.UserMasterEntity;
import com.neosoft.springMongo.service.UserDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public abstract class Validation {
    private final Logger LOGGER = LoggerFactory.getLogger(Validation.class);
    private final UserDetailService userDetailService;

    @Autowired
    public Validation(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }


    /**
     * Use for validate user request
     * @param userMasterEntity
     * @return boolean
     */
    public boolean valid(UserMasterEntity userMasterEntity){
        LOGGER.info("Checking Validation");
        CustomException customException = new CustomException();
        List<String> errors = new ArrayList<>();
        if(!userNameValidator(userMasterEntity.getUserName())){
            errors.add("UserName Not Valid");
        }
        if(!passwordValidator(userMasterEntity.getPassword())){
            errors.add("Password Not Valid");
        }
        if(!emailIdValidator(userMasterEntity.getUserDetailEntity().getEmailId())){
            errors.add("Please Enter Valid EmailId.");
        }
        if(!mobileNoValidator(userMasterEntity.getUserDetailEntity().getMobileNo())){
            errors.add("Mobile Number Not Valid");
        }
        userMasterEntity.getUserDetailEntity().getAddressEntityList().forEach(x->{
            if(!pinCodeValidator(x.getPinCode())){
                errors.add("PinCode Not Valid");
            }
        });

        if(errors.isEmpty()){
            return true;
        }
        else{
            customException.setHttpStatus(HttpStatus.BAD_REQUEST);
            customException.setErrorMessage("Input Json Not Valid");
            customException.setErrors(errors);
            throw customException;
        }

    }


    /**
     * All specific validator
     */
    public boolean userNameValidator(String userName){
        Pattern userNamePattern = Pattern.compile(Regex.USERNAME);
        boolean check =userNamePattern.matcher(userName).matches();
        LOGGER.info("UserName validation :"+check);
        return check;
    }

    public boolean passwordValidator(String password){
        Pattern pattern = Pattern.compile(Regex.PASSWORD);
        boolean check =pattern.matcher(password).matches();
        LOGGER.info("Password validation :"+check);
        return check;
    }

    public boolean emailIdValidator(String emailId){
        Pattern pattern = Pattern.compile(Regex.EMAIL_ID);
        boolean check =(pattern.matcher(emailId).matches() & !userDetailService.existEmailId(emailId));
        LOGGER.info("EmailId Validation :"+ check);
        return check;
    }

    public boolean mobileNoValidator(String mobileNo){
        Pattern pattern = Pattern.compile(Regex.MOBILE_NO);
        boolean check =pattern.matcher(mobileNo).matches();
        LOGGER.info("mobile Number validation :"+check);
        return check;
    }

    public boolean pinCodeValidator(int pinCode){
        Pattern pattern = Pattern.compile(Regex.PIN_CODE);
        boolean check =pattern.matcher(String.valueOf(pinCode)).matches();
        LOGGER.info("pinCode validation :"+check);
        return check;
    }


    /**
     * for generic response of Entity
     * @param userMaster
     * @return
     * @throws CustomException
     */
    protected ResponseEntity<Object> responseBuilder(UserMaster userMaster ) throws CustomException{
        UserMasterReqEntity userMasterReqEntity = RequestResponse.userResponse(userMaster);
        return new ResponseEntity<>(userMasterReqEntity , HttpStatus.ACCEPTED);
    }


    /**
     * for generic response of List Entity
     * @param userMasterList
     * @return
     * @throws CustomException
     */
    protected ResponseEntity<Object> responseBuilder(List<UserMaster> userMasterList ) throws CustomException{
        List<UserMasterReqEntity> userMasterReqEntities = new ArrayList<>();
        userMasterList.forEach(userMaster -> {
            userMasterReqEntities.add(RequestResponse.userResponse(userMaster));
        });
        return new ResponseEntity<>(userMasterReqEntities , HttpStatus.ACCEPTED);
    }


    /**
     * Only for return Custom message
     * @param message
     * @return
     */
    protected ResponseEntity<Object> responseMessage(String message) {
        return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
    }


    /**
     * Response Custom error as generic response
     * @param ex
     * @return
     */
    protected ResponseEntity<Object> responseEx(CustomException ex) {
        return new ResponseEntity<>(new Gson().toJson(ex), HttpStatus.BAD_REQUEST);
    }
}
