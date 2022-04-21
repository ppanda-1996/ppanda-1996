package com.roleManagement.rolebasedManagement.controller;

import com.roleManagement.rolebasedManagement.entity.Action;
import com.roleManagement.rolebasedManagement.exception.DuplicateResource;
import com.roleManagement.rolebasedManagement.repository.ActionRepository;
import com.roleManagement.rolebasedManagement.service.ActionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ActionController {
    Logger logger= LoggerFactory.getLogger(ActionController.class);
    @Autowired
    ActionService actionService;
    @Autowired
    ActionRepository actionRepository;
    @GetMapping("/actions")
    public List<Action> getAllAction()  {
        logger.info("Getting all the Action list");
         return actionService.listAllAction();
    }

@PostMapping("/saveAction")
    public Action add(@RequestBody @Valid Action action){
    logger.info("Adding role to the db ");
    if(this.actionRepository.existsByActionName(action.getActionName())){
        logger.error("Data is present in the db");
        throw new DuplicateResource("Data is alredy there in db");
    }
    else{
        return actionService.saveAction(action);

    }
    }
}
