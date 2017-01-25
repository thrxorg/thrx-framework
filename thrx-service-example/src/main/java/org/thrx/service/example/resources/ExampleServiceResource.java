package org.thrx.service.example.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;

import org.thrx.service.base.api.StatusResult;
import org.thrx.service.example.util.Version;

@Path("/exampleService")
@Produces(MediaType.APPLICATION_JSON)
public class ExampleServiceResource {

   private static org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(ExampleServiceResource.class.getName());

   /**
    * Abfrage mit:
    * http://localhost:20000/application/exampleService/status
    */
   @GET
   @Timed
   @Path("status")
   public StatusResult status() {
      StatusResult result = new StatusResult();
      result.setStatus("OK");
      result.setVersion(Version.getinstance().getVersion()); 
      result.setSnapshot(Version.getinstance().getVersion().endsWith("SNAPSHOT"));
      result.setBuildTime(Version.getinstance().getBuildDay() + " - " +Version.getinstance().getBuildTime());
      return result;
   }
}