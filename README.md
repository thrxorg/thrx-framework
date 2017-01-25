# Build

Build the project with

    $ mvn install

# Run

Now you can run your webapp with:

    $ java -jar artifactId.jar

# Debug in eclipse

	Java Launch:
	
		Project: 			thrx-service-example
		Main class: 		org.thrx.service.example.ExampleApplication
		Program arguments: 		server src\main\resources\config.yml
	
	oder:
	
		https://github.com/Tasktop/dropwizard-tools


	Evtl. muss in der Eclipse die debug Konfiguration angepasst werden: 
		Suspend execution on uncaugt Exceptions 
	darf nicht an sein sonnst gibt es beim starten probleme beim laden der externen dependencies

# Debug/Run Tests in eclipse

	Auf das ganze Projekt:
	
	 -- Project Run As: / Debug As: Maven Test
	
	Auf einen einzelnen Test:
	
	/thrx-framework-example/src/test/java/org/thrx/service/example/test/ExampleServiceAdminTest.java

	rechte Maustaste:

	Run As: / Debug As: JU junit Test