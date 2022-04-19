package com.roleManagement.rolebasedManagement.entity;
import lombok.*;

import javax.persistence.*;
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
    @Column(name = "action_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "action_name", nullable = false, length = 50)
    private String actionName;
    @Column(name = "action_desc", nullable = false, length = 50)
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
        this.id = id;
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