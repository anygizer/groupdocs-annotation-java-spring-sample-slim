@echo off

echo Installing GroupDocs libsraries...

call mvn install:install-file -Dpackaging=jar -Dversion=8.1.1   -DgroupId=com.aspose        -DartifactId=aspose-cells    		-Dfile=aspose.cells-8.1.1.jar
call mvn install:install-file -Dpackaging=jar -Dversion=4.3.0.0 -DgroupId=com.aspose        -DartifactId=aspose-email    		-Dfile=aspose.email-4.3.0.0.jar
call mvn install:install-file -Dpackaging=jar -Dversion=2.1.0.0 -DgroupId=com.aspose        -DartifactId=aspose-imaging  		-Dfile=aspose.imaging-2.1.0.0.jar
call mvn install:install-file -Dpackaging=jar -Dversion=9.1.0   -DgroupId=com.aspose        -DartifactId=aspose-pdf      		-Dfile=aspose.pdf-9.1.0.jar
call mvn install:install-file -Dpackaging=jar -Dversion=8.4.0   -DgroupId=com.aspose        -DartifactId=aspose-slides   		-Dfile=aspose.slides-8.4.0.jar
call mvn install:install-file -Dpackaging=jar -Dversion=14.6.0 	-DgroupId=com.aspose        -DartifactId=aspose-words    		-Dfile=aspose.words-14.6.0.jar

call mvn install:install-file -Dpackaging=jar -Dversion=2.3.0	-DgroupId=com.groupdocs		-DartifactId=groupdocs-viewer		-Dfile=viewer-2.3.0-final.jar
call mvn install:install-file -Dpackaging=jar -Dversion=1.6.0	-DgroupId=com.groupdocs		-DartifactId=groupdocs-annotation	-Dfile=annotation-1.6.0-slim.jar

pause
