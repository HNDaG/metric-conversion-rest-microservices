package com.hohulianikita.metricconversion.proxy;


import com.hohulianikita.metricconversion.entities.ConversionRatio;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="metric-exchange")
public interface ExchangeRatioProxy {
    @GetMapping("/v1/metric-exchange/from/{from}/to/{to}")
    public ConversionRatio retrieveExchangeValue(
            @PathVariable String from,
            @PathVariable String to);
}
