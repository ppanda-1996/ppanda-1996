package com.roleManagement.rolebasedManagement.service;
import com.roleManagement.rolebasedManagement.entity.Resource;
import com.roleManagement.rolebasedManagement.repository.ResourceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ResourceService {
    @Autowired
    private ResourceRepository resourceRepository;
    Logger logger=  LoggerFactory.getLogger(ResourceService.class);
    public List<Resource> listAllResource() {
        logger.info("total action number is: " + resourceRepository.count());
        return resourceRepository.findAll();
        }


    public Resource saveResource(Resource resource) {
        logger.info("response is : " + resourceRepository.save(resource));
        return resourceRepository.save(resource);
    }
}
