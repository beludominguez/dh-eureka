package com.dh.series.configuartion;

import io.github.resilience4j.core.IntervalFunction;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RetryConfiguration {

    @Bean
    RetryRegistry retryRegistry() {
        // Definimos la funcion de re-intentos, para no hacer muchas pegadas al servicio al instante,
        // defini una configuracion exponencial y con un maximo de 10 intentos, de esa forma se van a
        // reintentar 10 veces pero en un periodo de tiempo mas largo para no sobrecargar a los sistemas
        RetryConfig retryConfig = RetryConfig.custom()
                .maxAttempts(10)
                .intervalFunction(IntervalFunction.ofExponentialBackoff(300, 1.5D))
                .failAfterMaxAttempts(true)
                .build();

        return RetryRegistry.of(retryConfig);
    }
}
