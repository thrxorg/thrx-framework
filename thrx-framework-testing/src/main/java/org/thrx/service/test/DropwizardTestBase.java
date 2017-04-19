package org.thrx.service.test;

import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.dropwizard.Configuration;
import io.dropwizard.testing.junit.DropwizardAppRule;

public abstract class DropwizardTestBase<T extends Configuration> {

   protected abstract DropwizardAppRule<T> getDropwizard();

   protected Client restClient;
   // private JerseyClient jerseyClient;
   private String adminBaseUrl;
   protected String baseUrl;

   protected Response restClientAdminGet(String string) {
      return restClient.target(adminBaseUrl+ string).request().get();
   }
   
   protected Response restClientGet(String string) {
      return restClient.target(baseUrl+ string).request().get();
   }

   public void setUp() {
      adminBaseUrl = "http://127.0.0.1:" + getDropwizard().getAdminPort() + getDropwizard().getEnvironment().getAdminContext().getContextPath();
      baseUrl = "http://127.0.0.1:" + getDropwizard().getLocalPort() + 
            getDropwizard().getEnvironment().getApplicationContext().getContextPath() +
            getDropwizard().getEnvironment().jersey().getResourceConfig().getUrlPattern().substring(0, getDropwizard().getEnvironment().jersey().getResourceConfig().getUrlPattern().length()-2);

      restClient = ClientBuilder.newClient();
      // jerseyClient = new JerseyClientBuilder().build();
   }

   public void tearDown() {
      restClient.close();
      // jerseyClient.close();
   }

   public String sysoutJsonResponseString(Response response) throws JsonProcessingException, IOException, JsonParseException, JsonMappingException {
      boolean bufferEntity = response.bufferEntity();
      String jsonString = response.readEntity(String.class);
      System.out.println("-------------------------------------------------------------");
      System.out.println(jsonString);
      ObjectMapper objectMapper = new ObjectMapper();
      String jsonStrFom = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectMapper.readValue(jsonString, Object.class));
      System.out.println(jsonStrFom);
      System.out.println("-------------------------------------------------------------");
      return jsonStrFom;
   }

}