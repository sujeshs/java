package com.skywalker.pocs.springbootprometheus;

import io.micrometer.core.instrument.Timer;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.Instant;

import static com.google.common.util.concurrent.Uninterruptibles.sleepUninterruptibly;
import static java.time.Duration.between;
import static java.util.Objects.requireNonNull;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

@Service
public final class TestServiceImpl {

  private final Clock clock;
  private final Timer timer;

  public TestServiceImpl(Clock clock, Timer timer) {
    this.clock = requireNonNull(clock, "clock is required and missing.");
    this.timer = requireNonNull(timer, "timer is required and missing.");
  }

  public void executeLogic() {

    Instant startTime = clock.instant();

    sleepUninterruptibly(100, MILLISECONDS);

    timer.record(between(startTime, clock.instant()));

    System.out.println("startTime = " + startTime);
  }
}
