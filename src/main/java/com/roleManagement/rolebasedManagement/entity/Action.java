package com.roleManagement.rolebasedManagement.entity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "action")
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//   @Pattern(regexp = "^[A-Z]\\d[a-z]$",message = "Enter valid Action name")
    @NotNull(message = "Name is mandatory")
    private String actionName;
    private String actionDesc;
    @Override
    public String toString() {
        return "Action{" +
                "id=" + id +
                ", actionName='" + actionName + '\'' +
                ", actionDesc='" + actionDesc + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Action action = (Action) o;
        return id.equals(action.id) && actionName.equals(action.actionName) && actionDesc.equals(action.actionDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, actionName, actionDesc);
    }

    public Action(String actionName, String actionDesc) {
        this.actionName = actionName;
        this.actionDesc = actionDesc;
    }

    public String getActionDesc() {
        return actionDesc;
    }

    public void setActionDesc(String actionDesc) {
        this.actionDesc = actionDesc;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void add(Action action) {
         this.add(action);

    }
}