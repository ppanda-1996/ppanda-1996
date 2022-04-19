package com.roleManagement.rolebasedManagement.service;
import com.roleManagement.rolebasedManagement.entity.Action;
import com.roleManagement.rolebasedManagement.repository.ActionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ActionService {
    @Autowired
    ActionRepository actionRepository;
    Logger logger=  LoggerFactory.getLogger(ActionService.class);
    public List<Action>listAllAction() {
        logger.info("total action number is: " + actionRepository.count());
        return  actionRepository.findAll();

        }

    public Action saveAction(Action action){
        logger.info("response is : " + actionRepository.save(action));
        return actionRepository.save(action);
        }
    }

