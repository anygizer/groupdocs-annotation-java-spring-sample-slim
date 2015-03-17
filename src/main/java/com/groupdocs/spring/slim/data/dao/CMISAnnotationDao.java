package com.groupdocs.spring.slim.data.dao;


import com.groupdocs.annotation.common.Utils;
import com.groupdocs.annotation.data.DaoFactory;
import com.groupdocs.annotation.data.dao.interfaces.IAnnotationDao;
import com.groupdocs.annotation.data.dao.interfaces.IDocumentDao;
import com.groupdocs.annotation.data.dao.interfaces.ISessionDao;
import com.groupdocs.annotation.data.tables.interfaces.IAnnotation;
import com.groupdocs.annotation.data.tables.interfaces.IDocument;
import com.groupdocs.annotation.data.tables.interfaces.ISession;
import com.groupdocs.annotation.exception.AnnotationException;
import com.groupdocs.spring.slim.data.entity.CMISAnnotation;
import org.apache.chemistry.opencmis.client.api.*;
import org.apache.chemistry.opencmis.client.runtime.SessionFactoryImpl;
import org.apache.chemistry.opencmis.commons.SessionParameter;
import org.apache.chemistry.opencmis.commons.enums.BindingType;

import java.util.*;

/**
 * Created by Ihor Mykhalevych on 2015-03-13.
 */
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
    public void createTableIfNotExists() throws AnnotationException {}

    private ItemIterable<QueryResult> queryBy(List<String> fieldNames, Object... fieldValues) {
        Session session = getSession();
        String whereClause = "";
        List<Object> fValues = Arrays.asList(fieldValues);
        for (int i = 0; i < fieldNames.size(); i++) {
            String propertyName = fieldNames.get(i);
            Object propertyValue = fValues.get(i);
            if(propertyName.equals(IAnnotation.ANNOTATION_SESSION_ID)) {
                propertyName = CMISAnnotation.ANNOTATION_DOCUMENT_GUID;
                try (DaoFactory daoFactory = DaoFactory.create()) {
                    ISessionDao sessionDao = daoFactory.getSessionDao();
                    IDocumentDao documentDao = daoFactory.getDocumentDao();
                    ISession iSession = sessionDao.selectBy(Arrays.asList(ISession.ID), propertyValue);
                    IDocument document = documentDao.selectBy(Arrays.asList(IDocument.ID), iSession.getDocumentId());
                    // Get document guid
                    propertyValue = document.getDocumentName();
                } catch (Exception e) {
                    Utils.err(this.getClass(), e);
                }
            }
            whereClause += " " + getCMISPropertyName(propertyName) + "='" + propertyValue + "'";
        }
        String queryString = "SELECT * FROM " + CMISAnnotation.OBJECT_TYPE_ID_ANNOTATION + " WHERE" + whereClause;
        return session.query(queryString, false);
    }

    @Override
    public IAnnotation selectBy(List<String> fieldNames, Object... fieldValues) throws AnnotationException {
        QueryResult qResult = queryBy(fieldNames, fieldValues).iterator().next();
        IAnnotation iAnnotation = new CMISAnnotation(qResult.getProperties());
        return iAnnotation;
    }

    @Override
    public List<IAnnotation> selectAllBy(List<String> fieldNames, Object... fieldValues) throws AnnotationException {
        // Obtain first element by the just formed criteria
        List<IAnnotation> iAnnotations = new LinkedList<IAnnotation>();
        ItemIterable<QueryResult> queryResults = queryBy(fieldNames, fieldValues);
        for (QueryResult qResult : queryResults) {
            IAnnotation iAnnotation = new CMISAnnotation(qResult.getProperties());
            iAnnotations.add(iAnnotation);
        }
        return iAnnotations;
    }

    @Override
    public int insert(IAnnotation iAnnotation) {
        Session session = getSession();

        CMISAnnotation cmisAnnotation = new CMISAnnotation(iAnnotation);

        // add document GUID here to be stored in the CMIS repo
        try (DaoFactory daoFactory = DaoFactory.create()) {
            ISessionDao sessionDao = daoFactory.getSessionDao();
            IDocumentDao documentDao = daoFactory.getDocumentDao();
            ISession iSession = sessionDao.selectBy(Arrays.asList(ISession.ID), iAnnotation.getAnnotationSessionId());
            IDocument document = documentDao.selectBy(Arrays.asList(IDocument.ID), iSession.getDocumentId());
            cmisAnnotation.setAnnotationDocumentGuid(document.getDocumentName());
        } catch (Exception e) {
            Utils.err(this.getClass(), e);
        }

        HashMap<String, Object> annProp = cmisAnnotation.getCMISObject();

        // Create annotation object
        ObjectId annId = session.createItem(annProp, session.getRootFolder());

        return 0;
    }

    @Override
    public int update(IAnnotation iAnnotation) {
        Session session = getSession();
        CMISAnnotation cmisAnnotation = (CMISAnnotation) iAnnotation;
        ObjectId objectId = session.createObjectId(cmisAnnotation.getCmisObjectId());
        session.getObject(objectId).updateProperties(cmisAnnotation.getCMISObject());
        return 0;
    }

    @Override
    public int delete(IAnnotation iAnnotation) {
        Session session = getSession();
        session.delete(session.createObjectId(((CMISAnnotation)iAnnotation).getCmisObjectId()));
        return 0;
    }
}
