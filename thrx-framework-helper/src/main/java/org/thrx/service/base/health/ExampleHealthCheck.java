package org.thrx.service.base.health;

import com.codahale.metrics.health.HealthCheck;

public class ExampleHealthCheck extends HealthCheck {
   
   public ExampleHealthCheck() {
   }

   @Override
   protected Result check() throws Exception {
      return Result.healthy();
   }
}