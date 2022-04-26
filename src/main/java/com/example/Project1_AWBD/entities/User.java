package com.example.Project1_AWBD.entities;



import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name cannot be null")
    private String lastName;

    @NotNull(message = "Name cannot be null")
    private String firstName;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private java.util.Date birthDate;

    @NotEmpty(message = "Please enter a user name")
    private String  username;

    @NotEmpty(message = "Please enter the password")
    private String  password;
    private Integer enabled;

}
