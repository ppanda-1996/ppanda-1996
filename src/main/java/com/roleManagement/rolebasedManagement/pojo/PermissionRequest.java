package com.roleManagement.rolebasedManagement.pojo;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PermissionRequest {
    public String actionName;
    public String resourceName;

}
