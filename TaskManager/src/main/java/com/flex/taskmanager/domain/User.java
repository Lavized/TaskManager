package com.flex.taskmanager.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "USERS")
public class User {

    @Id
    @Email
    @NotEmpty
    @Column(name = "EMAIL", unique = true)
    private String email;

    @NotEmpty
    @Column(name = "NAME")
    private String name;

    @NotEmpty
    @Size(min = 4)
    @Column(name = "PASSWORD")
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> tasks;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES",joinColumns = {
            @JoinColumn(name = "USER_EMAIL",referencedColumnName = "EMAIL")
    }, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_NAME",referencedColumnName = "NAME")
    })
    private List<Role> roles;



    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }


    public @Email @NotEmpty String getEmail() {
        return email;
    }
}
