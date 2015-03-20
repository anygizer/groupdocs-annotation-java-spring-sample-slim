package com.groupdocs.spring.slim;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;

/**
 * Created by Ihor Mykhalevych
 */
public class EncodeUtils {
    public static String encodeBase64String(String raw) {
        return StringUtils.newStringUtf8(Base64.encodeBase64(raw.getBytes(), false));
    }

    public static String decodeBase64String(String encoded){
        return StringUtils.newStringUtf8(Base64.decodeBase64(StringUtils.getBytesUtf8(encoded)));
    }
}
