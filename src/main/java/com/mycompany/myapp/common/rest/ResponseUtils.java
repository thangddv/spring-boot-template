package com.mycompany.myapp.common.rest;

import org.springframework.http.HttpHeaders;

public class ResponseUtils {
    final static String REQUEST_ID = "request_id";

    public static HttpHeaders genHeader(String requestId) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(REQUEST_ID, requestId);
        return headers;
    }
}
