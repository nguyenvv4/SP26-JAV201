package com.example.jav201.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "Users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "pw")
    private String password;

    @Column(name = "Fullname")
    private String fullName;

    @Column(name = "Email")
    private String email;

    @Column(name = "Admin")
    private Boolean admin;

}
