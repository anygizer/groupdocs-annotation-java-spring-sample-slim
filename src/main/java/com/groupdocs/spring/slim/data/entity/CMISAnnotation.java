package com.groupdocs.spring.slim.data.entity;

import com.groupdocs.annotation.data.tables.interfaces.IAnnotation;
import com.groupdocs.annotation.data.tables.interfaces.IReply;
import org.apache.chemistry.opencmis.client.api.Property;
import org.apache.chemistry.opencmis.commons.PropertyIds;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Ihor Mykhalevych on 2015-03-13.
 */
public class CMISAnnotation implements IAnnotation {
    public static final String OBJECT_TYPE_ID_ANNOTATION = "groupdocs:annotation";

    private int annotationSessionId;
    private int userId;
    private String guid;
    private int pageNumber;
    private Double markerLeft;
    private Double markerTop;
    private Double width;
    private Double height;
    private int type;
    private int access;
    private Date createdOn;
    private int textPosition;
    private int textLength;
    private String svgPath;
    private Double annotationLeft;
    private Double annotationTop;
    private String fieldText;
    private String fontFamily;
    private Float fontSize;
    private int fontColor;
    private int penWidth;
    private int penStyle;
    private int penColor;
    private Integer backgroundColor;
    private List<IReply> replies;
    private int id;

    private String getCMISPropertyName(String propertyName) {
        return "groupdocs:" + propertyName;
    }

    private String getIfNotNull(Object obj) {
        return obj == null ? null : obj.toString();
    }

    private Integer getEvenIfNull(Object obj) {
        return obj == null ? null : Integer.valueOf(obj.toString());
    }

    private void initFromCMISObjectProperties(HashMap<String, Object> annotation) {
        // IAnnotation properties
        this.setAnnotationSessionId(((BigInteger)annotation.get(getCMISPropertyName(this.ANNOTATION_SESSION_ID))).intValue());
        this.setGuid(getIfNotNull(annotation.get(getCMISPropertyName(this.GUID))));
        this.setUserId(((BigInteger)annotation.get(getCMISPropertyName(this.USER_ID))).intValue());
        this.setPageNumber(((BigInteger)annotation.get(getCMISPropertyName(this.PAGE_NUMBER))).intValue());
        this.setMarkerLeft(Double.valueOf(getIfNotNull(annotation.get(getCMISPropertyName(this.MARKER_LEFT)))));
        this.setMarkerTop(Double.valueOf(getIfNotNull(annotation.get(getCMISPropertyName(this.MARKER_TOP)))));
        this.setWidth(Double.valueOf(getIfNotNull(annotation.get(getCMISPropertyName(this.WIDTH)))));
        this.setHeight(Double.valueOf(getIfNotNull(annotation.get(getCMISPropertyName(this.HEIGHT)))));
        this.setType(((BigInteger) annotation.get(getCMISPropertyName(this.TYPE))).intValue());
        this.setAccess(((BigInteger)annotation.get(getCMISPropertyName(this.ACCESS))).intValue());
        this.setCreatedOn(((GregorianCalendar)annotation.get(getCMISPropertyName(this.CREATED_ON))).getTime());
        this.setTextPosition(((BigInteger)annotation.get(getCMISPropertyName(this.TEXT_POSITION))).intValue());
        this.setTextLength(((BigInteger)annotation.get(getCMISPropertyName(this.TEXT_LENGTH))).intValue());
        this.setSvgPath(getIfNotNull(annotation.get(getCMISPropertyName(this.SVG_PATH))));
        this.setAnnotationLeft(Double.valueOf(getIfNotNull(annotation.get(getCMISPropertyName(this.ANNOTATION_LEFT)))));
        this.setAnnotationTop(Double.valueOf(getIfNotNull(annotation.get(getCMISPropertyName(this.ANNOTATION_TOP)))));
        this.setFieldText(getIfNotNull(annotation.get(getCMISPropertyName(this.FIELD_TEXT))));
        this.setFontFamily(getIfNotNull(annotation.get(getCMISPropertyName(this.FONT_FAMILY))));
        this.setFontSize(Float.valueOf(getIfNotNull(annotation.get(getCMISPropertyName(this.FONT_SIZE)))));
        this.setFontColor(((BigInteger)annotation.get(getCMISPropertyName(this.FONT_COLOR))).intValue());
        this.setPenWidth(((BigInteger)annotation.get(getCMISPropertyName(this.PEN_WIDTH))).intValue());
        this.setPenStyle(((BigInteger)annotation.get(getCMISPropertyName(this.PEN_STYLE))).intValue());
        this.setPenColor(((BigInteger)annotation.get(getCMISPropertyName(this.PEN_COLOR))).intValue());
        this.setBackgroundColor(getEvenIfNull(annotation.get(getCMISPropertyName(this.BACKGROUND_COLOR))));
    }

    public CMISAnnotation() {}

    public CMISAnnotation(IAnnotation iAnnotation) {
        this.annotationSessionId = iAnnotation.getAnnotationSessionId();
        this.userId = iAnnotation.getUserId();
        this.guid = iAnnotation.getGuid();
        this.pageNumber = iAnnotation.getPageNumber();
        this.markerLeft = iAnnotation.getMarkerLeft();
        this.markerTop = iAnnotation.getMarkerTop();
        this.width = iAnnotation.getWidth();
        this.height = iAnnotation.getHeight();
        this.type = iAnnotation.getType();
        this.access = iAnnotation.getAccess();
        this.createdOn = iAnnotation.getCreatedOn();
        this.textPosition = iAnnotation.getTextPosition();
        this.textLength = iAnnotation.getTextLength();
        this.svgPath = iAnnotation.getSvgPath();
        this.annotationLeft = iAnnotation.getAnnotationLeft();
        this.annotationTop = iAnnotation.getAnnotationTop();
        this.fieldText = iAnnotation.getFieldText();
        this.fontFamily = iAnnotation.getFontFamily();
        this.fontSize = iAnnotation.getFontSize();
        this.fontColor = iAnnotation.getFontColor();
        this.penWidth = iAnnotation.getPenWidth();
        this.penStyle = iAnnotation.getPenStyle();
        this.penColor = iAnnotation.getPenColor();
        this.backgroundColor = iAnnotation.getBackgroundColor();
        this.replies = iAnnotation.getReplies();
        this.id = iAnnotation.getId();
    }

    public  CMISAnnotation(List<Property<?>> cmisObjectProperties) {
        HashMap<String, Object> annotation = new HashMap<String, Object>();
        for (Property<?> property : cmisObjectProperties) {
            annotation.put(property.getId(), property.getValue());
        }
        initFromCMISObjectProperties(annotation);
    }

    public CMISAnnotation(HashMap<String, Object> annotation) {
        initFromCMISObjectProperties(annotation);
    }

    public HashMap<String, Object> getCMISObject() {
        HashMap<String, Object> annProp = new HashMap<String, Object>();
        annProp.put(PropertyIds.NAME , this.getGuid());
        annProp.put(PropertyIds.OBJECT_TYPE_ID, "I:" + OBJECT_TYPE_ID_ANNOTATION);

        // IAnnotation properties
        annProp.put(getCMISPropertyName(this.ANNOTATION_SESSION_ID), this.getAnnotationSessionId());
        annProp.put(getCMISPropertyName(this.GUID), this.getGuid());
        annProp.put(getCMISPropertyName(this.USER_ID), this.getUserId());
        annProp.put(getCMISPropertyName(this.PAGE_NUMBER), this.getPageNumber());
        annProp.put(getCMISPropertyName(this.MARKER_LEFT), this.getMarkerLeft());
        annProp.put(getCMISPropertyName(this.MARKER_TOP), this.getMarkerTop());
        annProp.put(getCMISPropertyName(this.WIDTH), this.getWidth());
        annProp.put(getCMISPropertyName(this.HEIGHT), this.getHeight());
        annProp.put(getCMISPropertyName(this.TYPE), this.getType());
        annProp.put(getCMISPropertyName(this.ACCESS), this.getAccess());
        annProp.put(getCMISPropertyName(this.CREATED_ON), this.getCreatedOn());
        annProp.put(getCMISPropertyName(this.TEXT_POSITION), this.getTextPosition());
        annProp.put(getCMISPropertyName(this.TEXT_LENGTH), this.getTextLength());
        annProp.put(getCMISPropertyName(this.SVG_PATH), this.getSvgPath());
        annProp.put(getCMISPropertyName(this.ANNOTATION_LEFT), this.getAnnotationLeft());
        annProp.put(getCMISPropertyName(this.ANNOTATION_TOP), this.getAnnotationTop());
        annProp.put(getCMISPropertyName(this.FIELD_TEXT), this.getFieldText());
        annProp.put(getCMISPropertyName(this.FONT_FAMILY), this.getFontFamily());
        annProp.put(getCMISPropertyName(this.FONT_SIZE), this.getFontSize());
        annProp.put(getCMISPropertyName(this.FONT_COLOR), this.getFontColor());
        annProp.put(getCMISPropertyName(this.PEN_WIDTH), this.getPenWidth());
        annProp.put(getCMISPropertyName(this.PEN_STYLE), this.getPenStyle());
        annProp.put(getCMISPropertyName(this.PEN_COLOR), this.getPenColor());
        annProp.put(getCMISPropertyName(this.BACKGROUND_COLOR), this.getBackgroundColor());

        return annProp;
    }

    @Override
    public int getAnnotationSessionId() {
        return annotationSessionId;
    }

    @Override
    public void setAnnotationSessionId(int annotationSessionId) {
        this.annotationSessionId = annotationSessionId;
    }

    @Override
    public int getUserId() {
        return userId;
    }

    @Override
    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String getGuid() {
        return guid;
    }

    @Override
    public void setGuid(String guid) {
        this.guid = guid;
    }

    @Override
    public int getPageNumber() {
        return pageNumber;
    }

    @Override
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public Double getMarkerLeft() {
        return markerLeft;
    }

    @Override
    public void setMarkerLeft(Double markerLeft) {
        this.markerLeft = markerLeft;
    }

    @Override
    public Double getMarkerTop() {
        return markerTop;
    }

    @Override
    public void setMarkerTop(Double markerTop) {
        this.markerTop = markerTop;
    }

    @Override
    public Double getWidth() {
        return width;
    }

    @Override
    public void setWidth(Double width) {
        this.width = width;
    }

    @Override
    public Double getHeight() {
        return height;
    }

    @Override
    public void setHeight(Double height) {
        this.height = height;
    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public void setType(int type) {
        this.type = type;
    }

    @Override
    public int getAccess() {
        return access;
    }

    @Override
    public void setAccess(int access) {
        this.access = access;
    }

    @Override
    public Date getCreatedOn() {
        return createdOn;
    }

    @Override
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public int getTextPosition() {
        return textPosition;
    }

    @Override
    public void setTextPosition(int textPosition) {
        this.textPosition = textPosition;
    }

    @Override
    public int getTextLength() {
        return textLength;
    }

    @Override
    public void setTextLength(int textLength) {
        this.textLength = textLength;
    }

    @Override
    public String getSvgPath() {
        return svgPath;
    }

    @Override
    public void setSvgPath(String svgPath) {
        this.svgPath = svgPath;
    }

    @Override
    public Double getAnnotationLeft() {
        return annotationLeft;
    }

    @Override
    public void setAnnotationLeft(Double annotationLeft) {
        this.annotationLeft = annotationLeft;
    }

    @Override
    public Double getAnnotationTop() {
        return annotationTop;
    }

    @Override
    public void setAnnotationTop(Double annotationTop) {
        this.annotationTop = annotationTop;
    }

    @Override
    public String getFieldText() {
        return fieldText;
    }

    @Override
    public void setFieldText(String fieldText) {
        this.fieldText = fieldText;
    }

    @Override
    public String getFontFamily() {
        return fontFamily;
    }

    @Override
    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    @Override
    public Float getFontSize() {
        return fontSize;
    }

    @Override
    public void setFontSize(Float fontSize) {
        this.fontSize = fontSize;
    }

    @Override
    public int getFontColor() {
        return fontColor;
    }

    @Override
    public void setFontColor(int fontColor) {
        this.fontColor = fontColor;
    }

    @Override
    public int getPenWidth() {
        return penWidth;
    }

    @Override
    public void setPenWidth(int penWidth) {
        this.penWidth = penWidth;
    }

    @Override
    public int getPenStyle() {
        return penStyle;
    }

    @Override
    public void setPenStyle(int penStyle) {
        this.penStyle = penStyle;
    }

    @Override
    public int getPenColor() {
        return penColor;
    }

    @Override
    public void setPenColor(Integer penColor) {
        this.penColor = penColor;
    }

    @Override
    public Integer getBackgroundColor() {
        return backgroundColor;
    }

    @Override
    public void setBackgroundColor(Integer backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @Override
    public List<IReply> getReplies() {
        return replies;
    }

    @Override
    public void setReplies(List<IReply> list) {
        this.replies = replies;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
