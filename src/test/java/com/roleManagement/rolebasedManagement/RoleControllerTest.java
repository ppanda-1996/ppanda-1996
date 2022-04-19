package com.roleManagement.rolebasedManagement;

import com.roleManagement.rolebasedManagement.entity.Permission;
import com.roleManagement.rolebasedManagement.entity.Role;
import com.roleManagement.rolebasedManagement.pojo.RoleRequest;
import com.roleManagement.rolebasedManagement.repository.PermissionRepository;
import com.roleManagement.rolebasedManagement.repository.RoleRepository;
import com.roleManagement.rolebasedManagement.controller.RoleController;
import com.roleManagement.rolebasedManagement.service.RoleService;
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
@ContextConfiguration(classes = {RoleController.class})
public class RoleControllerTest {
    @MockBean
    RoleService roleService;
    @MockBean
    PermissionService permissionService;
    @MockBean
    RoleRepository roleRepository;
    @MockBean
    PermissionRepository permissionRepository;
    @Autowired
    RoleController roleController;
    @Test
    public void addTest(){
        Role role=new Role("Admin");
        Permission permission=new Permission("Aws.Read");
        role.setRoleName(role.getRoleName());
        role.getPermission()
        .add(new Permission(permission.getPermissionName()));
        when(roleService.saveRole(new RoleRequest())).thenReturn(role);
        Role roles=roleController.add(new RoleRequest());
        assertEquals(role,roles);

    }
    @Test
    public void getAllRoleTest(){
        Role r1=new Role("Admin");
        Role r2=new Role("Manager");
        Role r3=new Role("User");
        when(roleService.listAllRole()).thenReturn(Stream.of(r1,r2,r3
                ).collect(Collectors.toList())
        );
        List<Role>roles=roleController.getAllRole();
        assertEquals(3, roles.size());




    }

}
