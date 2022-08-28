package com.mycompany.myapp.common.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> {
    private int status;

    @JsonProperty("request_id")
    private String requestId;
    private int code;
    private String message;
    private Metadata metadata;
    private T data;

    public static <T> BaseResponse<T> ofSucceeded() {
        BaseResponse<T> response = new BaseResponse<>();
        response.status = 1;
        response.code = 200;
        response.message = "Success";
        response.initRequestID();
        return response;
    }

    public static <T> BaseResponse<T> ofSucceeded(T data) {
        BaseResponse<T> response = new BaseResponse<>();
        response.status = 1;
        response.code = 200;
        response.message = "Success";
        response.data = data;
        response.initRequestID();
        return response;
    }

    public static <T> BaseResponse<T> ofSucceeded(T data, Metadata meta) {
        BaseResponse<T> response = new BaseResponse<>();
        response.status = 1;
        response.code = 200;
        response.message = "Success";
        response.data = data;
        response.metadata = meta;
        response.initRequestID();
        return response;
    }

    public static <T> BaseResponse<T> ofFailed(int status, int code, String message) {
        BaseResponse<T> response = new BaseResponse<>();
        response.status = status;
        response.code = code;
        response.message = message;
        response.initRequestID();
        return response;
    }

    void initRequestID() {
        UUID uuid = UUID.randomUUID();
        requestId = uuid.toString();
    }
}
