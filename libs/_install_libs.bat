@echo off

echo Installing Aspose libraries...

call mvn install:install-file -Dpackaging=jar -Dversion=8.2.2   -DgroupId=com.aspose        -DartifactId=aspose-cells    		-Dfile=aspose.cells-8.2.2.jar
call mvn install:install-file -Dpackaging=jar -Dversion=3.0.0 	-DgroupId=com.aspose        -DartifactId=aspose-diagram    		-Dfile=aspose.diagram-3.0.0.jar
call mvn install:install-file -Dpackaging=jar -Dversion=4.6.0.0 -DgroupId=com.aspose        -DartifactId=aspose-email    		-Dfile=aspose.email-4.6.0.0.jar
call mvn install:install-file -Dpackaging=jar -Dversion=2.1.0.0 -DgroupId=com.aspose        -DartifactId=aspose-imaging  		-Dfile=aspose.imaging-2.1.0.0.jar
call mvn install:install-file -Dpackaging=jar -Dversion=9.5.2   -DgroupId=com.aspose        -DartifactId=aspose-pdf      		-Dfile=aspose.pdf-9.5.2.jar
call mvn install:install-file -Dpackaging=jar -Dversion=14.7.0  -DgroupId=com.aspose        -DartifactId=aspose-slides   		-Dfile=aspose.slides-14.7.0.jar
call mvn install:install-file -Dpackaging=jar -Dversion=7.2.0	-DgroupId=com.aspose        -DartifactId=aspose-tasks    		-Dfile=aspose.tasks-7.2.0.jar
call mvn install:install-file -Dpackaging=jar -Dversion=14.9.0 	-DgroupId=com.aspose        -DartifactId=aspose-words    		-Dfile=aspose.words-14.9.0.jar
call mvn install:install-file -Dpackaging=jar -Dversion=4.0     -DgroupId=com.microsoft.sqlserver   -DartifactId=sqljdbc4               -Dfile=sqljdbc4.jar

pause