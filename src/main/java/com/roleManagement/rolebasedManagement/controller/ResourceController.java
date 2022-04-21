package com.roleManagement.rolebasedManagement.controller;
import com.roleManagement.rolebasedManagement.entity.Resource;
import com.roleManagement.rolebasedManagement.exception.DuplicateResource;
import com.roleManagement.rolebasedManagement.repository.ResourceRepository;
import com.roleManagement.rolebasedManagement.service.ResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ResourceController {
    @Autowired
    private ResourceService resourceService;
    @Autowired
    ResourceRepository resourceRepository;
    Logger logger= LoggerFactory.getLogger(ResourceController.class);
    @GetMapping("/resources")
    public List<Resource> getAllResource(){
        logger.info("Getting all the resource from the db");
            return resourceService.listAllResource();
    }


    @PostMapping("/saveResource")
    public Resource add(@RequestBody @Valid Resource resource){
        logger.info("Adding role to the db ");
        if(this.resourceRepository.existsByResourceName(resource.getResourceName())){
            logger.error("Data is present in the db");
            throw new DuplicateResource("Data is alredy there in db");
        }
        else{
            return resourceService.saveResource(resource);

        }
        }
    }


