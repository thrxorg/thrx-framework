## ARCHIVED

old POC

# thrx-framework

my personal thrx microservice framework based on dropwizard

develop branch: [![Build Status](https://travis-ci.org/thrxorg/thrx-framework.svg?branch=develop)](https://travis-ci.org/thrxorg/thrx-framework)

master branch: [![Build Status](https://travis-ci.org/thrxorg/thrx-framework.svg?branch=master)](https://travis-ci.org/thrxorg/thrx-framework)

## Focus

Focus on rapid development of small and medium 
* web projects
* backend of mobile apps
* .... 

	Initialy developed for callenger.one

## Tooling

### in Use:	
* Dropwizard 
* ....

### to Evaluate
* [Spark - A micro framework](http://sparkjava.com/)
* [Apache Cassandra](https://cassandra.apache.org/)

## Development

Used services:
* Sources
** https://github.com/organizations/thrxorg
* Bintray
** https://bintray.com/thrxde
** https://bintray.com/thrxorg
** https://dl.bintray.com/thrxorg/public-maven-repo
* Building / CI
** https://travis-ci.org/
** https://gitter.im/TecTeamUlm

Documentations and Howto:
* https://github.com/bintray/bintray-examples
* https://oss.jfrog.org


### Build

Build the project with

    $ mvn install

### Run

Now you can run your webapp with:

    $ java -jar artifactId.jar

### Debug in eclipse

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
	
	rechte Maustaste:
	 -- Project Run As: / Debug As: Maven Test
	
Auf einen einzelnen Test:
	
	rechte Maustaste:
	/thrx-framework-example/src/test/java/org/thrx/service/example/test/ExampleServiceAdminTest.java
	Run As: / Debug As: JU junit Test
