package com.neosoft.springMongo.service;

import com.neosoft.springMongo.FactoryPattern.RequestResponse;
import com.neosoft.springMongo.repository.UserDetailRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl  implements  UserDetailService{
    private final Logger LOGGER = LoggerFactory.getLogger(UserDetailServiceImpl.class);
    private final UserDetailRepo userDetailRepo;

    @Autowired
    public UserDetailServiceImpl(UserDetailRepo userDetailRepo) {
        this.userDetailRepo = userDetailRepo;
    }

    @Override
    public boolean existEmailId(String emailId) {
        LOGGER.info("Check Email Id is exist or not : "+emailId);
        boolean check = userDetailRepo.existsUserDetailByEmailId(emailId);
        LOGGER.info("Email ID exist : "+check);
        return check;
    }
}
