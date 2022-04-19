package com.roleManagement.rolebasedManagement.controller;
import com.roleManagement.rolebasedManagement.entity.Role;
import com.roleManagement.rolebasedManagement.pojo.RoleRequest;
import com.roleManagement.rolebasedManagement.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleController {
    @Autowired
     RoleService roleService;
    Logger logger= LoggerFactory.getLogger(RoleController.class);
     @GetMapping("/roles")
     public List<Role> getAllRole(){
        logger.info("getting all the role from the db");
      return roleService.listAllRole();
     }
@PostMapping("/saveRole")
public Role add(@RequestBody RoleRequest roleRequest){
        logger.info("Adding role to the db ");
  return roleService.saveRole(roleRequest);
     }
}

