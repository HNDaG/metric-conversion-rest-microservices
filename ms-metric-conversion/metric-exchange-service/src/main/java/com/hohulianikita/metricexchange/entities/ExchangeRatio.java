package com.hohulianikita.metricexchange.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ExchangeRatio {
    @Id
    private Long id;

    @Column(name = "metric_from")
    private String from;

    @Column(name = "metric_to")
    private String to;

    @Column(precision = 20, scale = 10)
    private BigDecimal ratioMultiple;
    private String environment;

    public ExchangeRatio(Long id, String from, String to, BigDecimal ratioMultiple) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.ratioMultiple = ratioMultiple;
    }
}
