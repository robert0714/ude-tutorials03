package com.iisigroup.jtd.ude.tutorials03.utils;
 

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

public class UrlUtil {
	private  static final Logger LOGGER = LoggerFactory.getLogger(UrlUtil.class);
	
	private UrlUtil(){}
	
    public static String encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();

        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        String result =null;
        try {
        	result = UriUtils.encodePathSegment(pathSegment, enc);
        	pathSegment = result;
        } catch (UnsupportedEncodingException e) {
        	LOGGER.error(e.getMessage(), e);
        }

        return result;
    }
}
