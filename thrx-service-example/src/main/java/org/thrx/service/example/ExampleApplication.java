package org.thrx.service.example;

import static org.eclipse.jetty.servlets.CrossOriginFilter.ALLOWED_HEADERS_PARAM;
import static org.eclipse.jetty.servlets.CrossOriginFilter.ALLOWED_METHODS_PARAM;
import static org.eclipse.jetty.servlets.CrossOriginFilter.ALLOWED_ORIGINS_PARAM;
import static org.eclipse.jetty.servlets.CrossOriginFilter.ALLOW_CREDENTIALS_PARAM;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.ws.rs.client.Client;

import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.thrx.service.base.health.ExampleHealthCheck;
import org.thrx.service.example.client.ExternalServiceResource;
import org.thrx.service.example.resources.ExampleServiceResource;

import io.dropwizard.Application;
import io.dropwizard.client.JerseyClientBuilder;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;

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
    	 bootstrap.addBundle(new SwaggerBundle<ExampleConfiguration>() {
    	        @Override
    	        protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(ExampleConfiguration configuration) {
    	            return configuration.swaggerBundleConfiguration;
    	        }
    	    });
    }

    private static final String GOOD_ORIGIN = "allowed_host";
    private static final String BAD_ORIGIN = "denied_host";
    
    @Override
    public void run(ExampleConfiguration configuration,Environment environment) {
       
       FilterRegistration.Dynamic filter = environment.servlets().addFilter("CORSFilter", CrossOriginFilter.class);
       filter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, environment.getApplicationContext().getContextPath() + "*");
       filter.setInitParameter(ALLOWED_METHODS_PARAM, "OPTIONS,GET,PUT,POST,DELETE,HEAD");
       filter.setInitParameter(ALLOWED_HEADERS_PARAM, "X-Requested-With,Content-Type,Accept,Origin");
       filter.setInitParameter(ALLOWED_ORIGINS_PARAM, "*");
       filter.setInitParameter(ALLOW_CREDENTIALS_PARAM, "true");
       
       
       environment.healthChecks().register("base", new ExampleHealthCheck());
       environment.jersey().register(new ExampleServiceResource());
       final Client client = new JerseyClientBuilder(environment).using(configuration.getJerseyClientConfiguration())
             .build(getName());
       environment.jersey().register(new ExternalServiceResource(client));

    }
}