package com.skywalker.pocs.springbootprometheus;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import static java.util.Objects.requireNonNull;

@SpringBootApplication
public class SpringbootPrometheusApplication {

  private final TestServiceImpl service;

  public SpringbootPrometheusApplication(TestServiceImpl service) {
    this.service = requireNonNull(service, "service is required and missing.");
  }

  public static void main(String... args) {
    ConfigurableApplicationContext context =
        new SpringApplicationBuilder()
            .sources(SpringbootPrometheusApplication.class)
            .build()
            .run(args);

    context.getBean(SpringbootPrometheusApplication.class).run();
  }

  private void run() {

    while (true) {
      service.executeLogic();
    }
  }
}
