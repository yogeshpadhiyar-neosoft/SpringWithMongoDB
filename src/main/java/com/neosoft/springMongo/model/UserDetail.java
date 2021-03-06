package com.neosoft.springMongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class UserDetail {
    @Id
    private String userDetailId;
    private String name;
    private String surName;
    private String emailId;
    private String mobileNo;
    private Date dateOfBirth;
    private Date joinDate;
    private List<Address> addressList;
}
