package com.spring.database.jpa.ott.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString(exclude = {"episode"})
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "tbl_series")
public class Series {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "series_id")
    private Long id;

    @Column(name = "series_name")
    private String name;

    @Column(name = "series_genre")
    private String genre;

    @Column(name = "series_release_Year")
    private int releaseYear;

    @Column(name = "series_director")
    private String director;

    // 에피소드 목록1:N 관계
    @OneToMany(mappedBy = "episodes")
    private List<Series> series = new ArrayList<>();




}
