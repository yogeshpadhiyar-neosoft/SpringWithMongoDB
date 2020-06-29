package com.neosoft.springMongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class UserMaster {
    @Id
    private String userId;
    private String userName;
    private String password;
    private Boolean active=true;
    private Date createdDate;
    private Date updatedDate;
    private UserDetail userDetail;


}
