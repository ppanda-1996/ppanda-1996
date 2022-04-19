package com.roleManagement.rolebasedManagement.service;
import com.roleManagement.rolebasedManagement.entity.Action;
import com.roleManagement.rolebasedManagement.entity.Resource;
import com.roleManagement.rolebasedManagement.entity.Permission;
import com.roleManagement.rolebasedManagement.repository.PermissionRepository;
import com.roleManagement.rolebasedManagement.pojo.PermissionRequest;
import com.roleManagement.rolebasedManagement.repository.ActionRepository;
import com.roleManagement.rolebasedManagement.repository.ResourceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class PermissionService{
    @Autowired
    PermissionRepository permissionRepository;
    @Autowired
    ActionRepository actionRepository;
    @Autowired
    ResourceRepository resourceRepository;
    Logger logger=  LoggerFactory.getLogger(PermissionService.class);

    public List<Permission> listAllPermission() {
        logger.info("total permission number is: " + permissionRepository.count());
        return permissionRepository.findAll();
    }

    public Permission savePermission(PermissionRequest permissionRequest) {
            Permission permission = new Permission();
            String actionName = permissionRequest.getActionName();
            String resourceName = permissionRequest.getResourceName();
            Action action = actionRepository.findByActionName(actionName);
            Resource resource = resourceRepository.findByResourceName(resourceName);

            permission.setAction(action);
            permission.setResource(resource);
            permission.setPermissionName(resourceName + "." + actionName);
        logger.info("response is : " + permissionRepository.save(permission));
        return permissionRepository.save(permission);
        }

    }


