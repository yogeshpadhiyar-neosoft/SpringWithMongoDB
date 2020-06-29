package com.neosoft.springMongo.service;

import org.springframework.stereotype.Service;

@Service
public interface UserDetailService {

    /**
     * check EmailId is exist or not
     * @param emailId
     * @return
     */
    boolean existEmailId(String emailId);

}
