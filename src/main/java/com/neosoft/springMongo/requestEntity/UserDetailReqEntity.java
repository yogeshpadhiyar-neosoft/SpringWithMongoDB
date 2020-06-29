package com.neosoft.springMongo.requestEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailReqEntity {
    private String name;
    private String surName;
    private String emailId;
    private Date dateOfBirth;
    private Date joinDate;
    private List<AddressReqEntity> addressReqEntityList;
}
