@echo off

echo Installing GroupDocs libsraries...

call mvn install:install-file -Dpackaging=jar -Dversion=4.0.1.0             -DgroupId=com.aspose                    -DartifactId=email  	  		          -Dfile=libs/aspose.email-4.0.1.0.jar
call mvn install:install-file -Dpackaging=jar -Dversion=8.0.0               -DgroupId=com.aspose                    -DartifactId=cells  	  		          -Dfile=libs/aspose.cells-8.0.0.jar
call mvn install:install-file -Dpackaging=jar -Dversion=2.1.0.0             -DgroupId=com.aspose                    -DartifactId=imaging  	  		          -Dfile=libs/aspose.imaging-2.1.0.0.jar
call mvn install:install-file -Dpackaging=jar -Dversion=9.0.0               -DgroupId=com.aspose                    -DartifactId=pdf  	  		              -Dfile=libs/aspose.pdf-9.0.0.jar
call mvn install:install-file -Dpackaging=jar -Dversion=8.4.0               -DgroupId=com.aspose                    -DartifactId=slides  	  		          -Dfile=libs/aspose.slides-8.4.0.jar
call mvn install:install-file -Dpackaging=jar -Dversion=14.3.0              -DgroupId=com.aspose                    -DartifactId=words  	  		          -Dfile=libs/aspose.words-14.3.0.jar

call mvn install:install-file -Dpackaging=jar -Dversion=2.0.0               -DgroupId=com.groupdocs                 -DartifactId=viewer  	  		          -Dfile=libs/viewer-2.0.0-final.jar
call mvn install:install-file -Dpackaging=jar -Dversion=1.2.0				-DgroupId=com.groupdocs					-DartifactId=annotation					  -Dfile=libs/annotation-1.2.0.jar

pause
