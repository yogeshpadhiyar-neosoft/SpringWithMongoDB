package com.neosoft.springMongo.FactoryPattern;

import com.neosoft.springMongo.model.Address;
import com.neosoft.springMongo.model.UserDetail;
import com.neosoft.springMongo.model.UserMaster;
import com.neosoft.springMongo.requestEntity.AddressReqEntity;
import com.neosoft.springMongo.requestEntity.UserDetailReqEntity;
import com.neosoft.springMongo.requestEntity.UserMasterReqEntity;
import com.neosoft.springMongo.responseEntity.UserMasterEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class RequestResponse {
    private static  final Logger LOGGER = LoggerFactory.getLogger(RequestResponse.class);

    /**
     * Convert UserRequest pojo  into Model class
     * @param userMasterEntity
     * @return
     */
    public static UserMaster userRequest(UserMasterEntity userMasterEntity){
        LOGGER.info("Converting UserMasterEntity into UserMaster");
        List<Address> addressList = new ArrayList<>();
        userMasterEntity.getUserDetailEntity().getAddressEntityList().forEach(addressEntity -> {
            Address address = new Address();
            address.setAddressType(addressEntity.getAddressType());
            address.setHouseNo(addressEntity.getHouseNo());
            address.setSociety(addressEntity.getSociety());
            address.setNearBy(addressEntity.getNearBy());
            address.setPinCode(addressEntity.getPinCode());
            addressList.add(address);
        });

        UserDetail userDetail = new UserDetail();
        userDetail.setName(userMasterEntity.getUserDetailEntity().getName());
        userDetail.setSurName(userMasterEntity.getUserDetailEntity().getSurName());
        userDetail.setEmailId(userMasterEntity.getUserDetailEntity().getEmailId());
        userDetail.setMobileNo(userMasterEntity.getUserDetailEntity().getMobileNo());
        userDetail.setDateOfBirth(userMasterEntity.getUserDetailEntity().getDateOfBirth());
        userDetail.setJoinDate(userMasterEntity.getUserDetailEntity().getJoinDate());
        userDetail.setAddressList(addressList);

        UserMaster userMaster = new UserMaster();
        userMaster.setUserName(userMasterEntity.getUserName());
        userMaster.setPassword(userMasterEntity.getPassword());
        userMaster.setActive(true);
        userMaster.setCreatedDate(new Date(System.currentTimeMillis()));
        userMaster.setUpdatedDate(new Date(System.currentTimeMillis()));
        userMaster.setUserDetail(userDetail);
        return userMaster;
    }


    /**
     * Give to user response with specific field
     * @param userMaster
     * @return
     */
    public static UserMasterReqEntity userResponse(UserMaster userMaster){
        LOGGER.info("Converting UserMaster into UserMasterReqEntity : "+userMaster.getUserName());
        List<AddressReqEntity> addressReqEntities = new ArrayList<>();
        userMaster.getUserDetail().getAddressList().forEach(addressEntity -> {
            AddressReqEntity address = new AddressReqEntity();
            address.setAddressType(addressEntity.getAddressType());
            address.setHouseNo(addressEntity.getHouseNo());
            address.setSociety(addressEntity.getSociety());
            address.setNearBy(addressEntity.getNearBy());
            address.setPinCode(addressEntity.getPinCode());
            addressReqEntities.add(address);
        });

        UserDetailReqEntity userDetailReqEntity = new UserDetailReqEntity();
        userDetailReqEntity.setName(userMaster.getUserDetail().getName());
        userDetailReqEntity.setSurName(userMaster.getUserDetail().getSurName());
        userDetailReqEntity.setEmailId(userMaster.getUserDetail().getEmailId());
        userDetailReqEntity.setDateOfBirth(userMaster.getUserDetail().getDateOfBirth());
        userDetailReqEntity.setJoinDate(userMaster.getUserDetail().getJoinDate());
        userDetailReqEntity.setAddressReqEntityList(addressReqEntities);

        UserMasterReqEntity userMasterReqEntity = new UserMasterReqEntity();
        userMasterReqEntity.setUserName(userMaster.getUserName());
        userMasterReqEntity.setUserDetailReqEntity(userDetailReqEntity);
        return userMasterReqEntity;
    }
}
