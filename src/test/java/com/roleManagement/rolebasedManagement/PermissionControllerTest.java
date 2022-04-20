package com.roleManagement.rolebasedManagement;
import com.roleManagement.rolebasedManagement.controller.PermissionController;
import com.roleManagement.rolebasedManagement.entity.Action;
import com.roleManagement.rolebasedManagement.entity.Permission;
import com.roleManagement.rolebasedManagement.entity.Resource;
import com.roleManagement.rolebasedManagement.pojo.PermissionRequest;
import com.roleManagement.rolebasedManagement.repository.ActionRepository;
import com.roleManagement.rolebasedManagement.repository.PermissionRepository;
import com.roleManagement.rolebasedManagement.repository.ResourceRepository;
import com.roleManagement.rolebasedManagement.service.PermissionService;
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
@ContextConfiguration(classes = {PermissionController.class})
public class PermissionControllerTest {
    @MockBean
    PermissionRepository permissionRepository;
    @MockBean
    ActionRepository actionRepository;
    @MockBean
    ResourceRepository resourceRepository;
    @MockBean
    private PermissionService permissionService;
    @Autowired
    PermissionController permissionController;

    @Test
    public void simple2(){
        Permission p1= new Permission("Aws.Read");
        Permission p2= new Permission("Devportal.Update");
        when(permissionService.listAllPermission()).thenReturn(Stream.of(p1,p2
                ).collect(Collectors.toList())
        );
        List<Permission>permissions=permissionController.getAllPermission();
        assertEquals(2, permissions.size());

    }
    @Test
    public void addTest() {
        Permission permission=new Permission();
        Action action = new Action("Delete", "This is Delete action");
        Resource resource = new Resource("Gui", "This is Gui resource");
        permission.setPermissionName(action.getActionName() + "." + resource.getResourceName());
        when(permissionService.savePermission(new PermissionRequest())).thenReturn(permission);
        Permission permissions=permissionController.add(new PermissionRequest());
      assertEquals(permission,permissions);
    }
}
