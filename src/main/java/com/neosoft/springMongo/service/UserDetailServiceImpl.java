package com.neosoft.springMongo.service;

import com.neosoft.springMongo.repository.UserDetailRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl  implements  UserDetailService{

    private final UserDetailRepo userDetailRepo;

    @Autowired
    public UserDetailServiceImpl(UserDetailRepo userDetailRepo) {
        this.userDetailRepo = userDetailRepo;
    }

    @Override
    public boolean existEmailId(String emailId) {
        return userDetailRepo.existsUserDetailByEmailId(emailId);
    }
}
