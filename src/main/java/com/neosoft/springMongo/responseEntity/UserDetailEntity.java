package com.neosoft.springMongo.responseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailEntity {
    private String name;
    private String surName;
    private String emailId;
    private String mobileNo;
    private Date dateOfBirth;
    private Date joinDate;
    private List<AddressEntity> addressEntityList;
}
