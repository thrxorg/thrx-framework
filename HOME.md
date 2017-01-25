# Base Service Descriptions

## thrx-framework

	aggregator for sub projects

## thrx-framework-bom

	dependency and version management
	
	include with maven to service project:
	----
	  <dependencyManagement>
      <dependencies>
         <dependency>
            <groupId>org.thrx.service</groupId>
            <artifactId>thrx-framework-bom</artifactId>
            <version>${thrx-framework.version}</version>
            <type>pom</type>
            <scope>import</scope>
         </dependency>
      </dependencies>
   </dependencyManagement>
   ----

## thrx-framework-helper
	only dropwizard framework helper lib	
	

## thrx-framework-testing
	only testing extentions for dropwizard framework

## thrx-framework-example

### services

#### exampleService
	 GET     /employees/ (org.thrx.service.example.client.ExternalServiceResource)
    GET     /employees/{id} (org.thrx.service.example.client.ExternalServiceResource)
    
    GET     /exampleService/status (org.thrx.service.example.resources.ExampleServiceResource)
    

#### Admin Services  

    POST    /tasks/log-level (io.dropwizard.servlets.tasks.LogConfigurationTask)
    
    example: 
    '''
    curl -X POST -d "logger=com.example.helloworld&level=INFO" http://localhost:20000/admin/tasks/log-level
    '''
    
    POST    /tasks/gc (io.dropwizard.servlets.tasks.GarbageCollectionTask)

	http://localhost:20000/admin/
	http://localhost:20000/admin/metrics
	http://localhost:20000/admin/ping
	http://localhost:20000/admin/threads
	http://localhost:20000/admin/healthcheck

### tests



