package com.hohulianikita.metricconversion.controller;

import com.hohulianikita.metricconversion.entities.ConversionRatio;
import com.hohulianikita.metricconversion.proxy.ExchangeRatioProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
@RequestMapping("v1")
public class MetricConversionController {
    @Autowired
    private ExchangeRatioProxy proxy;

    @GetMapping("/metric-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public ConversionRatio calculateCurrencyConversionFeign(
            @PathVariable String from,
            @PathVariable String to,
            @PathVariable BigDecimal quantity
    ) {
        ConversionRatio conversionRatio = proxy.retrieveExchangeValue(from, to);

        return new ConversionRatio (conversionRatio.getId(),
                from, to, quantity,
                conversionRatio.getRatioMultiple(),
                quantity.multiply(conversionRatio.getRatioMultiple()),
                conversionRatio.getEnvironment() + " " + "FeignClient");
    }
}


