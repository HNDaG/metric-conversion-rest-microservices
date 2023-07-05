package com.hohulianikita.metricexchange.dao;


import com.hohulianikita.metricexchange.entities.ExchangeRatio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExchangeRatioRepository extends JpaRepository<ExchangeRatio, Long> {
    Optional <ExchangeRatio> findByFromAndTo(String from, String to);
}