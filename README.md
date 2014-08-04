Groupdocs Slim Annotation for Java (Spring Sample) 1.5.0
===========================================

1. Download sample sources to any directory 
2. Install required libraries* (GroupDocs.Annotation, GroupDocs.Viewer, Aspose and other libs) into maven local repository. To help with this we provided all libs (see libs folder) and `install_libs.bat` file to install libs into maven local repository. 
3. Open file `src\main\resources\application.properties` and update configuration (for example update `groupdocs.viewer.filePath` to set the path to the storage folder, for example it can be `D:\\temp\\doc`). In this folder create `files` folder and paste some files into this directory (to see default file you should place `GroupDocs_Demo.doc` file into `files` directory, or update `/src/main/java/com/groupdocs/HomeController.java` file and change this line of code ` return index(model, request, response, "/files/GroupDocs_Demo.doc", null, userName);` to change the default file name).
4. Run file `run.bat` to start sample application using maven tomcat plugin. (or build the sample with maven `mvn clean package` and upload document-annotation.war into your tomcat, into `webapps` folder and start tomcat).
5. Open URL `http://127.0.0.1:8080/` (or `http://127.0.0.1:8080/document-annotation/` if you deployed annotation into tomcat with context, not as a ROOT`) in your browser, make sure before tomcat starting that port 8080 is free (you can change port number in your tomcat configuration).


*All dependencies are configured in POM.xml file, saved in `libs` folder and added in `install_libs.bat` file to easy install them into local maven repository.


More details about GroupDocs.Annotation for Java see here: http://groupdocs.com/java/document-annotation-library

###[Sign, Manage, Annotate, Assemble, Compare and Convert Documents with GroupDocs](http://groupdocs.com)
1. [Sign documents online with GroupDocs Signature](http://groupdocs.com/apps/signature)
2. [PDF, Word and Image Annotation with GroupDocs Annotation](http://groupdocs.com/apps/annotation)
3. [Online DOC, DOCX, PPT Document Comparison with GroupDocs Comparison](http://groupdocs.com/apps/comparison)
4. [Online Document Management with GroupDocs Dashboard](http://groupdocs.com/apps/dashboard)
5. [Doc to PDF, Doc to Docx, PPT to PDF, and other Document Conversions with GroupDocs Viewer](http://groupdocs.com/apps/viewer)
6. [Online Document Automation with GroupDocs Assembly](http://groupdocs.com/apps/assembly)

#### Created by [GroupDocs Marketplace Team]( http://groupdocs.com/marketplace/ ).
