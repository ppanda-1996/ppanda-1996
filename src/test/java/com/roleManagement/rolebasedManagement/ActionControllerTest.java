package com.roleManagement.rolebasedManagement;

import com.roleManagement.rolebasedManagement.controller.ActionController;
import com.roleManagement.rolebasedManagement.entity.Action;
import com.roleManagement.rolebasedManagement.repository.ActionRepository;
import com.roleManagement.rolebasedManagement.service.ActionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ActionController.class})
public class ActionControllerTest {
    @MockBean
    ActionRepository actionRepository;
    @MockBean
    ActionService actionService;
    @Autowired
    ActionController actionController;
    @Test
    public void getAllActionTest(){
        when(actionService.listAllAction()).thenReturn(Stream.of(
                        new Action("Create","This is create Action"),new Action("Read","this is read action")
                ).collect(Collectors.toList())
        );
        List<Action>actions=actionController.getAllAction();
        assertEquals(2, actions.size());
    }
    @Test
    public void addTest(){
        Action action=new Action();
        action.setActionName("Create");
        when(actionService.saveAction(action)).thenReturn(action);
        Action action1=actionController.add(action);
        assertEquals(action,actionService.saveAction(action));
    }
}
