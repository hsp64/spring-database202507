package com.spring.database.jpa.ott.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString(exclude = {"series"})
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "tbl_episodes")
public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "episode_id")
    private Long id;

    @Column(name = "episode_number", nullable = false)
    private int episodeNumber;

    @Column(name = "episode_title", nullable = false)
    private String title;

    @Column(name = "episode_duration")
    private int duration;

    @Column(name = "episode_view_count", nullable = false)
    private int viewCount = 0;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "series_id")
    private Episode episode;
}
