package com.hohulianikita.metricconversion.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ConversionRatio {
    private Long id;
    private String from;
    private String to;
    private BigDecimal quantity;
    private BigDecimal ratioMultiple;
    private BigDecimal totalCalculatedAmount;
    private String environment;

}
