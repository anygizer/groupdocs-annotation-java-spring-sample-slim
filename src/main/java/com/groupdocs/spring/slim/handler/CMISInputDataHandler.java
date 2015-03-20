package com.groupdocs.spring.slim.handler;

import com.groupdocs.spring.slim.EncodeUtils;
import com.groupdocs.viewer.config.ServiceConfiguration;
import com.groupdocs.viewer.domain.GroupDocsFileDescription;
import com.groupdocs.viewer.handlers.input.InputDataHandler;
import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.chemistry.opencmis.client.api.Repository;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.client.api.SessionFactory;
import org.apache.chemistry.opencmis.client.runtime.SessionFactoryImpl;
import org.apache.chemistry.opencmis.commons.SessionParameter;
import org.apache.chemistry.opencmis.commons.enums.BindingType;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* CMIS input data handler
*/
public class CMISInputDataHandler extends InputDataHandler {
    private static final String CMIS_SERVICE_URL = "http://localhost:8080/alfresco/api/-default-/public/cmis/versions/1.1/atom";

    public static final String CMIS_USER_NAME = "cmisUserName";
    public static final String CMIS_USER_PASSWORD = "cmisUserPassword";

    private Session session = null;
    private String basePath = null;

    public CMISInputDataHandler(ServiceConfiguration serviceConfiguration) {
        basePath = serviceConfiguration.getRootDir();
    }

    protected Session getSession() {
        if (this.session == null) {
            // default factory implementation
            SessionFactory factory = SessionFactoryImpl.newInstance();
            Map<String, String> parameter = new HashMap<String, String>();

            // user credentials
            parameter.put(SessionParameter.USER, getCmisUserName());
            parameter.put(SessionParameter.PASSWORD, getCmisUserPassword());

            // connection settings
            parameter.put(SessionParameter.ATOMPUB_URL, CMIS_SERVICE_URL);
            parameter.put(SessionParameter.BINDING_TYPE, BindingType.ATOMPUB.value());
            List<Repository> repositories = factory.getRepositories(parameter);
            this.session = repositories.get(0).createSession();
        }
        return this.session;
    }

    private HttpSession getCurrentSession() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getSession();
    }

    private String getCmisUserName() {
        return getCurrentSession().getAttribute(CMIS_USER_NAME).toString();
    }

    private String getCmisUserPassword() {
        return getCurrentSession().getAttribute(CMIS_USER_PASSWORD).toString();
    }

    protected Document getCMISDocument(String guid) {
        String cmisId = EncodeUtils.decodeBase64String(guid);
        return (Document) getSession().getObject(cmisId);
    }

    @Override
    public List<GroupDocsFileDescription> getFileDescriptionList(String directory) {
        return new ArrayList<>();
    }

    @Override
    public GroupDocsFileDescription getFileDescription(String guid) throws Exception {
        //Create file description object
        GroupDocsFileDescription fileDescription = new GroupDocsFileDescription();
        fileDescription.setGuid(guid);

        Document doc = getCMISDocument(guid);
        fileDescription.setName(doc.getName());
        fileDescription.setLastModified(doc.getLastModificationDate().getTimeInMillis());
        fileDescription.setSize(doc.getContentStreamLength());
        return fileDescription;
    }

    @Override
    public InputStream getFile(String guid) {
        try {
            // Check if this is request for the cached file (hotfix valid for the GroupDocs.Annotation v1.8.2)
            return new FileInputStream(com.groupdocs.viewer.h.a.d(guid));
        }
        catch (Exception ex) {
        }
        Document doc = getCMISDocument(guid);
        return doc.getContentStream().getStream();
    }

    @Override
    public String saveFile(InputStream inputStream, String fileName, Integer timeToLive, String encryptedKey) throws IOException {
        //Generate file ID
        String guid = EncodeUtils.encodeBase64String(fileName);
        //Save file
        File saveFile = new File(basePath + "/" + fileName);
        FileOutputStream outputStream = new FileOutputStream(saveFile);
        IOUtils.copy(inputStream, outputStream);
        return guid;
    }
}
