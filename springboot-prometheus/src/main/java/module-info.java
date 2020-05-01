module com.skywalker.pocs.springbootprometheus {
  exports com.skywalker.pocs.springbootprometheus;

  requires spring.boot.autoconfigure;
  requires spring.boot;
  requires spring.context;
  requires micrometer.core;
  requires com.google.common;
}
