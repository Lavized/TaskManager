package com.flex.taskmanager.domain;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
public class Role {

    @Id
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;


    public Role(String name) {
        this.name = name;
    }


}
