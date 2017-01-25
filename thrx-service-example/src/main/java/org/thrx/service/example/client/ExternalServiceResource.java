package org.thrx.service.example.client;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ExternalServiceResource  {

   public class Employee {
      // TODO FIXME !!!!!
   }

   private Client client;
   public ExternalServiceResource(Client client) {
      // TODO Auto-generated constructor stub
   }
   
   @GET
   @Path("/employees/")
   public String getEmployees()
   {
       //Do not hard code in your application
       WebTarget webTarget = client.target("http://localhost:8080/employees");
       Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
       Response response = invocationBuilder.get();
       @SuppressWarnings("rawtypes")
       ArrayList employees = response.readEntity(ArrayList.class);
       return employees.toString();
   }
    
   @GET
   @Path("/employees/{id}")
   public String getEmployeeById(@PathParam("id") int id)
   {
       //Do not hard code in your application
       WebTarget webTarget = client.target("http://localhost:8080/employees/"+id);
       Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
       Response response = invocationBuilder.get();
       Employee employee = response.readEntity(Employee.class);
       return employee.toString();
   }
}
