package com.flex.taskmanager.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TASKS")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String date;

    @NotEmpty
    private String startTime;

    @NotEmpty
    private String endTime;

    @NotEmpty
    private String description;

    @ManyToOne
    @JoinColumn(name = "USER_EMAIL")
    private User user;


    public Task(String date, String startTime, String endTime, String description, User user) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
        this.user = user;
    }

    public Task(String date, String startTime, String endTime, String description) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }


}
