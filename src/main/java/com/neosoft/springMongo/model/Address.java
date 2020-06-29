package com.neosoft.springMongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Address {
    @MongoId
    private UUID addressUUID = UUID.randomUUID();
    private String addressType;
    private String houseNo;
    private String society;
    private String nearBy;
    private int pinCode;
}
