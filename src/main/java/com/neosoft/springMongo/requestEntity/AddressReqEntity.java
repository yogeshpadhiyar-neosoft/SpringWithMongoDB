package com.neosoft.springMongo.requestEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressReqEntity {
    private String addressType;
    private String houseNo;
    private String society;
    private String nearBy;
    private int pinCode;
}
