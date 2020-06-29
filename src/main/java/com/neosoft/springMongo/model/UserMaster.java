package com.neosoft.springMongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class UserMaster {
    @MongoId
    private UUID userUUID =UUID.randomUUID();
    private String userName;
    private String password;
    private Boolean active=true;
    private Date createdDate;
    private Date updatedDate;
    private UserDetail userDetail;


}
