package com.roleManagement.rolebasedManagement.controller;
import com.roleManagement.rolebasedManagement.entity.Role;
import com.roleManagement.rolebasedManagement.exception.DuplicateResource;
import com.roleManagement.rolebasedManagement.pojo.RoleRequest;
import com.roleManagement.rolebasedManagement.repository.RoleRepository;
import com.roleManagement.rolebasedManagement.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleController {
    @Autowired
     RoleService roleService;
    @Autowired
    RoleRepository roleRepository;
    Logger logger= LoggerFactory.getLogger(RoleController.class);
     @GetMapping("/roles")
     public List<Role> getAllRole()  {
        logger.info("getting all the role from the db");
            return roleService.listAllRole();

     }
@PostMapping("/saveRole")
public Role add(@RequestBody @Valid RoleRequest roleRequest){
        logger.info("Adding role to the db ");
        if(this.roleRepository.existsByRoleName(roleRequest.roleName)){
            logger.error("Data is present in the db");
            throw new DuplicateResource("Data is alredy there in db");
        }
        else{
            return roleService.saveRole(roleRequest);

        }
     }
}

