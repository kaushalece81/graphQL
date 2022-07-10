package com.example.pst.dc.admin.gateway.util;

import java.io.IOException;
import java.util.Base64;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class Base64Utils.
 */
@Slf4j
public class Base64Util {

    private Base64Util() {
    }

    /**
     * This method encodes input Content model into Base64 string format
     *
     * @param contentModel
     * @return String
     * @throws JsonProcessingException
     */
    public static String encode(ContentModel contentModel) throws JsonProcessingException {
        log.debug("Base64Util encode method input value = {}", contentModel);
        ObjectMapper mapperObj = new ObjectMapper();
        return Base64.getEncoder().encodeToString(mapperObj.writeValueAsBytes(contentModel));
    }

    /**
     * This method decodes Base64 string format to Content model
     * @param value
     * @return ContentModel
     * @throws IOException
     */
    public static ContentModel decode(String value) throws IOException  {
        log.debug("Base64Util decode method input value = {}", value);
        ContentModel contentModel = null;
        ObjectMapper objectMapper = new ObjectMapper();
        contentModel = objectMapper.readValue(Base64.getDecoder().decode(value), ContentModel.class);
        return contentModel;
    }
}
