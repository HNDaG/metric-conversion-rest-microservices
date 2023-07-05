# Project Name

Metric Converter

## Overview

This project provides a set of microservices that enable metric exchange and conversion. It includes a Naming Server (Eureka) for service discovery, a Metric Exchange service that provides exchange ratios for metrics, a Metric Conversion service that converts quantities between metrics, and a Tracing system (Zipkin) for monitoring and tracing requests.

## Project Structure

The project is structured as follows:

- **Naming Server (Eureka):** This component provides naming and service discovery capabilities for the microservices.

- **Metric Exchange:** This service provides exchange ratios for metrics. It allows you to retrieve the exchange ratio between two metrics.

- **Metric Conversion:** This service converts the desired quantity of one metric to another. It calculates the converted value based on the provided conversion parameters.

- **Tracing system (Zipkin):** This component enables monitoring and tracing of requests across the microservices.

## Launching the Project

To launch the project, follow these steps:

1. Clone the project repository:
```
git clone https://github.com/HNDaG/metric-conversion-rest-microservices.git
```
```
cd <project-directory>
```
2. Rebuild project

3. Build images and run the Docker Compose command:
```
docker-compose up
```
## Request Structure

- GET http://localhost:8765/{version}/metric-exchange/from/{from}/to/{to}

- GET http://localhost:8765/{version}/metric-conversion-feign/from/{from}/to/{to}/quantity/{quantity}


{from} - metric to be converted from
{to} - metric to be converted to
{quantity} - quantity of {from} metric
{version} - versioning was realized using URL. Currently only v1 is available.

## Response Structure

- GET http://localhost:8765/{version}/metric-exchange/from/{from}/to/{to}

    {
        "id": 1,
        "from": "{from}",
        "to": "{to}",
        "ratioMultiple": 0.621371,
        "environment": "8000"
    }


- GET http://localhost:8765/{version}/metric-conversion/from/{from}/to/{to}/quantity/{quantity}

    {
        "id": 1,
        "from": "{from}",
        "to": "{to}",
        "quantity": 10,
        "ratioMultiple": 25.4,
        "totalCalculatedAmount": 254,
        "environment": "8000 FeignClient"
    }


## URLs

Api-gateway:
- [http://localhost:8765/v1/metric-exchange/from/km/to/mile]
- [http://localhost:8765/v1/metric-conversion-feign/from/inch/to/mm/quantity/10]

Metric Exchange:
- [http://localhost:8000/v1/metric-exchange/from/km/to/mile]

Metric Conversion:
- [http://localhost:8100/v1/metric-conversion-feign/from/inch/to/mm/quantity/10]

Eureka:
- [http://localhost:8761/]

Zipkin:
- [http://localhost:9411/zipkin]

## Images

- `nikitahohulia/metric-converter-metric-conversion-service:0.0.1-SNAPSHOT`
- `nikitahohulia/metric-converter-api-gateway:0.0.1-SNAPSHOT`
- `nikitahohulia/metric-converter-metric-exchange-service:0.0.1-SNAPSHOT`
- `nikitahohulia/metric-converter-naming-server:0.0.1-SNAPSHOT`
