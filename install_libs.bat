@echo off

echo Installing GroupDocs libsraries...

call mvn install:install-file -Dpackaging=jar -Dversion=3.2.5.RELEASE       -DgroupId=org.springframework           -DartifactId=spring-webmvc  	  		  -Dfile=libs/spring-webmvc-3.2.5.RELEASE.jar
call mvn install:install-file -Dpackaging=jar -Dversion=3.2.5.RELEASE       -DgroupId=org.springframework           -DartifactId=spring-tx  	  		      -Dfile=libs/spring-tx-3.2.5.RELEASE.jar
call mvn install:install-file -Dpackaging=jar -Dversion=1.2                 -DgroupId=javax.servlet                 -DartifactId=jstl  	  		              -Dfile=libs/jstl-1.2.jar
call mvn install:install-file -Dpackaging=jar -Dversion=2.3.1               -DgroupId=javax.servlet.jsp             -DartifactId=javax.servlet.jsp-api  	  -Dfile=libs/javax.servlet.jsp-api-2.3.1.jar
call mvn install:install-file -Dpackaging=jar -Dversion=1.7.5               -DgroupId=org.slf4j                     -DartifactId=slf4j-api  	  		      -Dfile=libs/slf4j-api-1.7.5.jar
call mvn install:install-file -Dpackaging=jar -Dversion=1.0.13              -DgroupId=ch.qos.logback                -DartifactId=logback-classic  	  		  -Dfile=libs/logback-classic-1.0.13.jar
call mvn install:install-file -Dpackaging=jar -Dversion=0.1.8               -DgroupId=com.urbanmania                -DartifactId=spring-property-annotations  -Dfile=libs/spring-property-annotations-0.1.8.jar
call mvn install:install-file -Dpackaging=jar -Dversion=2.2.4               -DgroupId=com.google.code.gson          -DartifactId=gson  	  		              -Dfile=libs/gson-2.2.4.jar
call mvn install:install-file -Dpackaging=jar -Dversion=2.4                 -DgroupId=commons-io                    -DartifactId=commons-io  	  		      -Dfile=libs/commons-io-2.4.jar
call mvn install:install-file -Dpackaging=jar -Dversion=1.4                 -DgroupId=commons-codec                 -DartifactId=commons-codec  	  		  -Dfile=libs/commons-codec-1.4.jar

call mvn install:install-file -Dpackaging=jar -Dversion=2.1.1               -DgroupId=org.atmosphere                -DartifactId=atmosphere-runtime  	  	  -Dfile=libs/atmosphere-runtime-2.1.1.jar
call mvn install:install-file -Dpackaging=jar -Dversion=20090211            -DgroupId=org.json                      -DartifactId=json  	  		              -Dfile=libs/json-20090211.jar
call mvn install:install-file -Dpackaging=jar -Dversion=2.1.4               -DgroupId=com.fasterxml.jackson.core    -DartifactId=jackson-annotations  	  	  -Dfile=libs/jackson-annotations-2.1.4.jar
call mvn install:install-file -Dpackaging=jar -Dversion=2.1.4               -DgroupId=com.fasterxml.jackson.core    -DartifactId=jackson-databind  	  		  -Dfile=libs/jackson-databind-2.1.4.jar
call mvn install:install-file -Dpackaging=jar -Dversion=2.1.4               -DgroupId=com.fasterxml.jackson.core    -DartifactId=jackson-core  	  		      -Dfile=libs/jackson-core-2.1.4.jar
call mvn install:install-file -Dpackaging=jar -Dversion=3.7.2               -DgroupId=org.xerial                    -DartifactId=sqlite-jdbc  	  		      -Dfile=libs/sqlite-jdbc-3.7.2.jar

call mvn install:install-file -Dpackaging=jar -Dversion=4.0.1.0             -DgroupId=com.aspose                    -DartifactId=email  	  		          -Dfile=libs/aspose.email-4.0.1.0.jar
call mvn install:install-file -Dpackaging=jar -Dversion=8.0.0               -DgroupId=com.aspose                    -DartifactId=cells  	  		          -Dfile=libs/aspose.cells-8.0.0.jar
call mvn install:install-file -Dpackaging=jar -Dversion=2.1.0.0             -DgroupId=com.aspose                    -DartifactId=imaging  	  		          -Dfile=libs/aspose.imaging-2.1.0.0.jar
call mvn install:install-file -Dpackaging=jar -Dversion=9.0.0               -DgroupId=com.aspose                    -DartifactId=pdf  	  		              -Dfile=libs/aspose.pdf-9.0.0.jar
call mvn install:install-file -Dpackaging=jar -Dversion=8.4.0               -DgroupId=com.aspose                    -DartifactId=slides  	  		          -Dfile=libs/aspose.slides-8.4.0.jar
call mvn install:install-file -Dpackaging=jar -Dversion=14.3.0              -DgroupId=com.aspose                    -DartifactId=words  	  		          -Dfile=libs/aspose.words-14.3.0.jar

call mvn install:install-file -Dpackaging=jar -Dversion=2.0.0               -DgroupId=com.groupdocs                 -DartifactId=viewer  	  		          -Dfile=libs/viewer-2.0.0-final.jar
call mvn install:install-file -Dpackaging=jar -Dversion=1.1.0				-DgroupId=com.groupdocs					-DartifactId=annotation					  -Dfile=libs/annotation-1.1.0.jar

pause
