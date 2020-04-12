package com.skywalker.pocs.springbootprometheus;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;
import java.time.Duration;

import static java.util.Objects.requireNonNull;

@Configuration
public class Config {

  @Bean
  public Clock clock() {
    return Clock.systemUTC();
  }

  @Bean
  public Timer timer(MeterRegistry meterRegistry) {
    requireNonNull(meterRegistry, "meterRegistry is required and missing.");

    return Timer.builder("test_timer")
        .publishPercentileHistogram()
        .sla(Duration.ofMillis(1000))
        .minimumExpectedValue(Duration.ofMillis(1))
        .maximumExpectedValue(Duration.ofMillis(1000))
        .register(meterRegistry);
  }
}
