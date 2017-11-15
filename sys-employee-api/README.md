# Testing APIKit with MUnit:  sys-employee-api
Illustrates an API implementation using Anypoint Studio's tooling for building REST APIs with RAML interfaces: APIkit. 

This example application takes a RAML file and maps it to an implementation of an API in Mule. This example implementation route the request according to the method which was used (GET, POST, PUT, DELETE) and is integrated against a SQL Server Testing Database provided by XOM. The main goal of the example is to show, how to test APIKit using [MUnit](https://docs.mulesoft.com/munit/v/1.3/using-munit-in-anypoint-studio).

## Pre-requisites

+ Your Network User (eg: SA/aalleva) should have access to XOM SQL Server Testing database:

```
db.server=web.na.xom.com
db.name=Mulesoft
```

## For running the proyect inside Anypoint Studio on Windows 64-bits

1. Download the SQL server JDBC drivers from [Microsoft](https://www.microsoft.com/en-us/download/details.aspx?id=55539)
2. Get the sqljdbc_auth.dll file from the auth/64 bit directory and install into your local Maven repository executing the following command:

`mvn install:install-file -DgroupId=com.microsoft.sqlserver -DartifactId=sqljdbc_auth -Dversion=6.2.2.jre8 -Dclassifier=ntamd64 -Dpackaging=dll -Dfile=sqljdbc_auth.dll`

3. Create a directory called **libs** at the root level of your mavenized Studio project and copy there the native library.
4. Change the Maven Settings to activate the studio profile:
	+ Go to Run -> Run Configurations...
	+ Select your mavenized project
	+ Go to the Maven Settings tab
	+ Enter the following argument: -Druntime=studio
5. Set the **java.library.path** VM argument for the MUnit Integration test:
	+ Go to Run -> Run Configurations...
	+ Select **sys-employee-integration-tests.xml** under MUnit
	+ Select **Arguments** tab
	+ Enter the following argument, pointing to the **libs** directory at the root level of your mavenized Studio project. 
	  Eg: `-Djava.library.path=C:\Users\aalleva\AnypointStudio\workspace\sys-employee-api\libs`
