package com.roleManagement.rolebasedManagement.controller;

import com.roleManagement.rolebasedManagement.entity.Permission;
import com.roleManagement.rolebasedManagement.pojo.PermissionRequest;
import com.roleManagement.rolebasedManagement.service.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
@RestController
public class PermissionController {
    @Autowired
    PermissionService permissionService;
    Logger logger= LoggerFactory.getLogger(PermissionController.class);
    @GetMapping("/permissions")
     public List<Permission> getAllPermission(){
      logger.info("Getting all the permission from the database");
    return permissionService.listAllPermission();
}
    @PostMapping("/savePermission")
    public Permission add(@RequestBody @Valid PermissionRequest permissionRequest){
        logger.info("Adding Permission to the Database");
        return permissionService.savePermission(permissionRequest);
    }
}
