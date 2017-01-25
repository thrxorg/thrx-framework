package org.thrx.service.example;

import javax.ws.rs.client.Client;

import org.thrx.service.base.health.ExampleHealthCheck;
import org.thrx.service.example.client.ExternalServiceResource;
import org.thrx.service.example.resources.ExampleServiceResource;
import io.dropwizard.Application;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ExampleApplication extends Application<ExampleConfiguration> {


    public static void main(String[] args) throws Exception {
        new ExampleApplication().run(args);
    }

    @Override
    public String getName() {
        return "example";
    }

    @Override
    public void initialize(Bootstrap<ExampleConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(ExampleConfiguration configuration,Environment environment) {
       environment.healthChecks().register("base", new ExampleHealthCheck());
       environment.jersey().register(new ExampleServiceResource());
       final Client client = new JerseyClientBuilder(environment).using(configuration.getJerseyClientConfiguration())
             .build(getName());
       environment.jersey().register(new ExternalServiceResource(client));

    }
}