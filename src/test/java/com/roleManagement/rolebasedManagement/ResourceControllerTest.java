package com.roleManagement.rolebasedManagement;
import com.roleManagement.rolebasedManagement.controller.ResourceController;
import com.roleManagement.rolebasedManagement.entity.Resource;
import com.roleManagement.rolebasedManagement.repository.ResourceRepository;
import com.roleManagement.rolebasedManagement.service.ResourceService;
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
@ContextConfiguration(classes = {ResourceController.class})
public class ResourceControllerTest {
    @MockBean
    ResourceRepository resourceRepository;
    @MockBean
    private ResourceService resourceService;
    @Autowired
    ResourceController resourceController;
    @Test
    public void getAllResourceTest(){
        when(resourceService.listAllResource()).thenReturn(Stream.of(
                        new Resource("Aws","This is Aws Resource"),
                new Resource("Devportal","this is Devportal Resource")
                ).collect(Collectors.toList())
        );
        List<Resource>resources=resourceController.getAllResource();
        assertEquals(2, resources.size());

    }
    @Test
    public void addTest(){
        Resource resource=new Resource("Gui","This is Gui resource");
        when(resourceService.saveResource(resource)).thenReturn(resource);
        Resource resource1=resourceController.add(resource);
        assertEquals(resource,resource1);
    }
}
