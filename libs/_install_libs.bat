@echo off

echo Installing GroupDocs libsraries...

call mvn install:install-file -Dpackaging=jar -Dversion=8.2.1   -DgroupId=com.aspose        -DartifactId=aspose-cells    		-Dfile=aspose.cells-8.2.1.jar
call mvn install:install-file -Dpackaging=jar -Dversion=4.5.0.0 -DgroupId=com.aspose        -DartifactId=aspose-email    		-Dfile=aspose.email-4.5.0.0.jar
call mvn install:install-file -Dpackaging=jar -Dversion=2.1.0.0 -DgroupId=com.aspose        -DartifactId=aspose-imaging  		-Dfile=aspose.imaging-2.1.0.0.jar
call mvn install:install-file -Dpackaging=jar -Dversion=9.5.1   -DgroupId=com.aspose        -DartifactId=aspose-pdf      		-Dfile=aspose.pdf-9.5.1.jar
call mvn install:install-file -Dpackaging=jar -Dversion=14.6.1  -DgroupId=com.aspose        -DartifactId=aspose-slides   		-Dfile=aspose.slides-14.6.1.jar
call mvn install:install-file -Dpackaging=jar -Dversion=14.8.0 	-DgroupId=com.aspose        -DartifactId=aspose-words    		-Dfile=aspose.words-14.8.0.jar
call mvn install:install-file -Dpackaging=jar -Dversion=2.3.0   -DgroupId=com.aspose        -DartifactId=aspose-diagram    		-Dfile=aspose.diagram-2.3.0.jar
call mvn install:install-file -Dpackaging=jar -Dversion=4.0     -DgroupId=com.microsoft.sqlserver -DartifactId=sqljdbc4         -Dfile=sqljdbc4.jar

call mvn install:install-file -Dpackaging=jar -Dversion=2.5.0	-DgroupId=com.groupdocs		-DartifactId=groupdocs-viewer		-Dfile=groupdocs-viewer-2.5.0.jar
call mvn install:install-file -Dpackaging=jar -Dversion=1.7.0	-DgroupId=com.groupdocs		-DartifactId=groupdocs-annotation	-Dfile=groupdocs-annotation-1.7.0.jar

pause
