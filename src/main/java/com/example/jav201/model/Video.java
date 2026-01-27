package com.example.jav201.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Videos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Video {

    @Id
    @Column(name = "Id")
    private String id;

    @Column(name = "Title")
    private String title;

    @Column(name = "Poster")
    private String poster;

    @Column(name = "Description")
    private String description;

    @Column(name = "Active")
    private Integer active;

    @Column(name = "Views")
    private Integer views;

//    @OneToMany(mappedBy = "idVideo")
//    private List<Favorite> favorites;


}
