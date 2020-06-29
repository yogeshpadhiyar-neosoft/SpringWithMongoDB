package com.neosoft.springMongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class UserDetail {
    @MongoId
    private UUID userDetailUUId = UUID.randomUUID();
    private String name;
    private String surName;
    private String emailId;
    private String mobileNo;
    private Date dateOfBirth;
    private Date joinDate;
    private List<Address> addressList;
}
