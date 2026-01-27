package com.example.jav201.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "Favorites")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Favorite {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "VideoId")
    private Video idVideo;

    @ManyToOne
    @JoinColumn(name = "UserId")
    private User idUser;

    @Column(name = "LikeDate")
    private Date likeDate;

    @Override
    public String toString() {
        return "Favorite{" +
                "id=" + id +
                ", idVideo=" + idVideo +
                ", idUser=" + idUser +
                ", likeDate=" + likeDate +
                '}';
    }
}
