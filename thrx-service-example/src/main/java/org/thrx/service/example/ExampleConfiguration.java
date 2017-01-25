package org.thrx.service.example;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.dropwizard.client.HttpClientConfiguration;
import io.dropwizard.client.JerseyClientConfiguration;

public class ExampleConfiguration extends Configuration {
   @Valid
   @NotNull
   @JsonProperty
   private JerseyClientConfiguration jerseyClient = new JerseyClientConfiguration();

   //@JsonProperty("jerseyClient")
   public JerseyClientConfiguration getJerseyClientConfiguration() {
       return jerseyClient;
   }
   
   //@JsonProperty("jerseyClient")
   public void setJerseyClientConfiguration(JerseyClientConfiguration jerseyClient) {
      this.jerseyClient = jerseyClient;
   }
   
   // for httpClient instead of jearsy
   @Valid
   @NotNull
   private HttpClientConfiguration httpClient = new HttpClientConfiguration();

   @JsonProperty("httpClient")
   public HttpClientConfiguration getHttpClientConfiguration() {
       return httpClient;
   }

   @JsonProperty("httpClient")
   public void setHttpClientConfiguration(HttpClientConfiguration httpClient) {
       this.httpClient = httpClient;
   }
   
   
}