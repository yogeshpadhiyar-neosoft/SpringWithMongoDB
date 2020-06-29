package com.neosoft.springMongo.responseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMasterEntity {
    private String userName;
    private String password;
    private UserDetailEntity userDetailEntity;
}
