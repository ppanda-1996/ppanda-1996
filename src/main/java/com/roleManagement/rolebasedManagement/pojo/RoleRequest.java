package com.roleManagement.rolebasedManagement.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleRequest {
    @NotNull(message = "Role name can not be blank")
    public String roleName;
    public Set<String> permission;

}
