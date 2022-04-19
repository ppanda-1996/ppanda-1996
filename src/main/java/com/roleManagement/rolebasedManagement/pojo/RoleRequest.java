package com.roleManagement.rolebasedManagement.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleRequest {
    public String roleName;
    public Set<String> permission;

}
