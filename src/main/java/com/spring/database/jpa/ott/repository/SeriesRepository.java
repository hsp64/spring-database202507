package com.spring.database.jpa.ott.repository;

import com.spring.database.jpa.ott.entity.Series;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeriesRepository
    extends JpaRepository<Series, Long> {
}
