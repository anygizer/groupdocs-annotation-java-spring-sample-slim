package com.groupdocs.spring.slim.data.dao;


import com.groupdocs.annotation.data.DaoFactory;
import com.groupdocs.annotation.data.dao.interfaces.IAnnotationDao;
import com.groupdocs.annotation.data.tables.interfaces.IAnnotation;
import com.groupdocs.annotation.exception.AnnotationException;
import com.groupdocs.spring.slim.data.entity.CMISAnnotation;
import org.apache.chemistry.opencmis.client.api.*;
import org.apache.chemistry.opencmis.client.runtime.SessionFactoryImpl;
import org.apache.chemistry.opencmis.commons.PropertyIds;
import org.apache.chemistry.opencmis.commons.SessionParameter;
import org.apache.chemistry.opencmis.commons.data.PropertyData;
import org.apache.chemistry.opencmis.commons.enums.BindingType;

import java.util.*;

public class CMISAnnotationDao implements IAnnotationDao {
    private static final String SERVICE_URL = "http://localhost:8080/alfresco/api/-default-/public/cmis/versions/1.1/atom";

    private Session session;

    private String getServiceUrl() {
        return SERVICE_URL;
    }

    private String getPassword() {
        return "admin";
    }

    private String getUser() {
        return "admin";
    }

    private Session getSession() {
        if (this.session == null) {
            // default factory implementation
            SessionFactory factory = SessionFactoryImpl.newInstance();
            Map<String, String> parameter = new HashMap<String, String>();

            // user credentials
            parameter.put(SessionParameter.USER, getUser());
            parameter.put(SessionParameter.PASSWORD, getPassword());

            // connection settings
            parameter.put(SessionParameter.ATOMPUB_URL, getServiceUrl());
            parameter.put(SessionParameter.BINDING_TYPE, BindingType.ATOMPUB.value());

            List<Repository> repositories = factory.getRepositories(parameter);

            this.session = repositories.get(0).createSession();
        }
        return this.session;
    }

    private String getCMISPropertyName(String propertyName) {
        return "groupdocs:" + propertyName;
    }

    @Override
    public void createTableIfNotExists() throws AnnotationException {

    }

    @Override
    public IAnnotation selectBy(List<String> fieldNames, Object... fieldValues) throws AnnotationException {
        Session session = getSession();
        String whereClause = "";
        List<Object> fValues = Arrays.asList(fieldValues);
        for (int i = 0; i < fieldNames.size(); i++) {
            whereClause += " " + getCMISPropertyName(fieldNames.get(i)) + "=" + fValues.get(i);
        }
        String queryString = "SELECT * FROM " + CMISAnnotation.OBJECT_TYPE_ID_ANNOTATION + " WHERE" + whereClause;
        // Obtain first element by the just formed criteria
        QueryResult qResult = session.query(queryString, false).iterator().next();
        PropertyData<?> propData = qResult.getPropertyById(PropertyIds.OBJECT_ID);
        String objectId = (String) propData.getFirstValue();
        CmisObject obj = session.getObject(session.createObjectId(objectId));

        IAnnotation iAnnotation = new CMISAnnotation(obj.getProperties());

        return iAnnotation;
    }

    @Override
    public List<IAnnotation> selectAllBy(List<String> fieldNames, Object... fieldValues) throws AnnotationException {
        Session session = getSession();
        String whereClause = "";
        List<Object> fValues = Arrays.asList(fieldValues);
        for (int i = 0; i < fieldNames.size(); i++) {
            whereClause += " " + getCMISPropertyName(fieldNames.get(i)) + "=" + fValues.get(i);
        }
        String queryString = "SELECT * FROM " + CMISAnnotation.OBJECT_TYPE_ID_ANNOTATION + " WHERE" + whereClause;
        // Obtain first element by the just formed criteria
        List<IAnnotation> iAnnotations = new LinkedList<IAnnotation>();
        ItemIterable<QueryResult> queryResults = session.query(queryString, false);
        for (QueryResult qResult : queryResults) {
            PropertyData<?> propData = qResult.getPropertyById(PropertyIds.OBJECT_ID);
            String objectId = (String) propData.getFirstValue();
            CmisObject obj = session.getObject(session.createObjectId(objectId));
            IAnnotation iAnnotation = new CMISAnnotation(obj.getProperties());
            iAnnotations.add(iAnnotation);
        }
        return iAnnotations;
    }

    @Override
    public int insert(IAnnotation iAnnotation) {
        Session session = getSession();

        HashMap<String, Object> annProp = new CMISAnnotation(iAnnotation).getCMISObject();

        // Create annotation object
        ObjectId annId = session.createItem(annProp, session.getRootFolder());

        return 0;
    }

    @Override
    public int update(IAnnotation iAnnotation) {
        return 0;
    }

    @Override
    public int delete(IAnnotation iAnnotation) {
        return 0;
    }
}