package com.neosoft.springMongo.requestEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserMasterReqEntity {
    private String userName;
    private UserDetailReqEntity userDetailReqEntity;
}
