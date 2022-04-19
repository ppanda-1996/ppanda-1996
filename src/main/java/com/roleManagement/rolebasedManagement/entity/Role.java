package com.roleManagement.rolebasedManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "role")
public class Role {
    @Id
    @Column(name = "role_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "role_name", nullable = false, length = 50)
    public String roleName;
    @JsonIgnore
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="configrolepermission",
     joinColumns = @JoinColumn(name="role_id"),
            inverseJoinColumns = @JoinColumn(name="permission_id")
    )
    private Set<Permission>permission=new HashSet<>();

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Set<Permission> getPermission() {
        return permission;
    }
    public void setPermission(Set<Permission> permission) {
        this.permission = permission;
    }


    public void addPermission(Permission permission) {
        this.permission.add(permission);
    }
}