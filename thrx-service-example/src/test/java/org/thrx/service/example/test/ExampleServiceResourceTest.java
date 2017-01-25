package org.thrx.service.example.test;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import org.thrx.service.example.ExampleApplication;
import org.thrx.service.example.ExampleConfiguration;
import org.thrx.service.test.DropwizardTestBase;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;

public class ExampleServiceResourceTest extends DropwizardTestBase<ExampleConfiguration> {

   @ClassRule
   public static final DropwizardAppRule<ExampleConfiguration> dropwizard = new DropwizardAppRule<ExampleConfiguration>(ExampleApplication.class, ResourceHelpers.resourceFilePath("test-config.yml"));

   
   @Override
   @Before
   public void setUp() {
      super.setUp();
   }

   @Override
   @After
   public void tearDown() {
      super.tearDown();
   }

   @Test
   public void shouldGetStatus() throws Exception {
      Response response = restClientGet("/exampleService/status");
      assertEquals(200, response.getStatus());
      assertEquals("OK", response.getStatusInfo().getReasonPhrase() );
   }

   @Override
   protected DropwizardAppRule<ExampleConfiguration> getDropwizard() {
      return dropwizard;
   }


}