package com.roleManagement.rolebasedManagement.controller;

import com.roleManagement.rolebasedManagement.entity.Action;
import com.roleManagement.rolebasedManagement.service.ActionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActionController {
    Logger logger= LoggerFactory.getLogger(ActionController.class);
    @Autowired
    ActionService actionService;
    @GetMapping("/actions")
    public List<Action> getAllAction(){
        logger.info("Getting all the Action list");
         return actionService.listAllAction();
    }

@PostMapping("/saveAction")
    public Action add(@RequestBody Action action){
        logger.info("Adding action to the db");
            return actionService.saveAction(action);
    }
}
