package com.hohulianikita.metricexchange.controller;

import com.hohulianikita.metricexchange.entities.ExchangeRatio;
import com.hohulianikita.metricexchange.services.ExchangeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@Slf4j
public class ExchangeController {

    @Autowired
    private ExchangeService service;

    @Autowired
    private Environment environment;

    @GetMapping("/metric-exchange/from/{from}/to/{to}")
    public ExchangeRatio retrieveExchangeValue(
            @PathVariable String from,
            @PathVariable String to) {

        log.info("retrieveExchangeValue called with {} to {}", from, to);

        ExchangeRatio exchangeRatio
                = service.getExchangeRatioBidirectional(from, to);

        if(exchangeRatio ==null) {
            throw new RuntimeException
                    ("Unable to Find data for " + from + " to " + to);
        }

        String port = environment.getProperty("local.server.port");
        exchangeRatio.setEnvironment(port);

        return exchangeRatio;

    }
}
