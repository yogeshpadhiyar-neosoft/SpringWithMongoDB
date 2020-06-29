package com.neosoft.springMongo.responseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity {
    private String addressType;
    private String houseNo;
    private String society;
    private String nearBy;
    private int pinCode;
}
