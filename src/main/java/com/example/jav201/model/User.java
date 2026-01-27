package com.example.jav201.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

//    @OneToMany(mappedBy = "idUser")
//    List<Favorite> favorites;

}
