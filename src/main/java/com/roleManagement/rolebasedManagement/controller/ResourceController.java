package com.roleManagement.rolebasedManagement.controller;
import com.roleManagement.rolebasedManagement.entity.Resource;
import com.roleManagement.rolebasedManagement.service.ResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ResourceController {
    @Autowired
    private ResourceService resourceService;
    Logger logger= LoggerFactory.getLogger(ResourceController.class);
    @GetMapping("/resources")
    public List<Resource> getAllResource(){
        logger.info("Getting all the resource from the db");
            return resourceService.listAllResource();
    }


    @PostMapping("/saveResource")
    public Resource add(@RequestBody Resource resource){
            logger.info("adding resource to the db");
            return resourceService.saveResource(resource);
        }
    }


