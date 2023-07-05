package com.hohulianikita.metricexchange.services;

import com.hohulianikita.metricexchange.dao.ExchangeRatioRepository;
import com.hohulianikita.metricexchange.entities.ExchangeRatio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Optional;

@Service
@Slf4j
public class ExchangeService {
    @Autowired
    private ExchangeRatioRepository repository;

    public ExchangeRatio getExchangeRatio(String from, String to) {
        Optional<ExchangeRatio> exchangeRatio = repository.findByFromAndTo(from, to);
        return exchangeRatio.orElse(null);
    }

    public ExchangeRatio getExchangeRatioBidirectional(String from, String to) {
        ExchangeRatio directRatio = getExchangeRatio(from, to);
        System.out.println("Direct " + directRatio);
        if (directRatio != null) {
            return directRatio;
        }

        ExchangeRatio invertRatio = getExchangeRatio(to, from);
        System.out.println("Inverse " + invertRatio);
        if (invertRatio != null) {
            BigDecimal inverseRatio = BigDecimal.ONE.divide(invertRatio.getRatioMultiple(), MathContext.DECIMAL128);
            return new ExchangeRatio(
                    invertRatio.getId(),
                    invertRatio.getTo(),
                    invertRatio.getFrom(),
                    inverseRatio,
                    invertRatio.getEnvironment()
            );
        }

        return null;
    }



}
