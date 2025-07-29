package com.spring.database.jpa.ott.repository;

import com.spring.database.jpa.ott.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository
        extends JpaRepository<Episode, Long> {
}
