package com.roleManagement.rolebasedManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "permission")
public class Permission {
    @Id
    @Column(name = "permission_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "permission_name", nullable = false, length = 50)
    @Pattern(regexp = "^[A-Z]\\d[a-z]$",message = "Enter valid permission name")
    private String permissionName;

    public Permission(String permissionName) {
        this.permissionName = permissionName;
    }

    @JsonIgnore
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(name="configrolepermission",
            joinColumns = @JoinColumn(name="permission_id"),
            inverseJoinColumns = @JoinColumn(name="role_id")
    )
    private Set<Role> roles=new HashSet<Role>();
    @ManyToOne
    @JoinColumn(name = "action_id")
    private Action action;
    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;

    public void addPermission(Role role) {
        this.roles.add(role);
    }


    public void addPermissionName(String s) {
    }
}