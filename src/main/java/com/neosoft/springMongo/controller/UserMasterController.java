package com.neosoft.springMongo.controller;

import com.neosoft.springMongo.model.UserMaster;
import com.neosoft.springMongo.service.UserMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/mongo/user")
public class UserMasterController {
    private final UserMasterService userMasterService;

    @Autowired
    public UserMasterController(UserMasterService userMasterService) {
        this.userMasterService = userMasterService;
    }


    @GetMapping()
    public List<UserMaster> findAllUsers(){
        return  userMasterService.findAll();
    }

    @PostMapping()
    public UserMaster insertUserMaster(@RequestBody UserMaster userMaster){
        return userMasterService.insertUserMaster(userMaster);
    }

    @GetMapping("/{userUUID}")
    public UserMaster findByUserUUID(@PathVariable("userUUID") UUID userUUID){
        return  userMasterService.findByUserUUID(userUUID);
    }

    @PutMapping("/{userUUID}")
    public UserMaster updateByUserUUID(@PathVariable("userUUID") UUID userUUID,@RequestBody UserMaster userMaster ){
        userMaster.setUserUUID(userUUID);
        return  userMasterService.updateByUserUUID(userMaster);
    }

    @DeleteMapping("/{userUUID}")
    public void deleteByUserUUID(@PathVariable("userUUID") UUID userUUID){
        userMasterService.deleteByUserUUID(userUUID);
    }
}
