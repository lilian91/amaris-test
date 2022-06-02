package com.amaris.java_test.sharedkernel;

import org.springframework.http.HttpStatus;

public class Response {


    private HttpStatus httpStatus;
    private String message = "Success";
    private Object result;
    private Boolean error = false;

    public Response(HttpStatus httpStatus, Object result) {
        this.result = result;
        this.httpStatus = httpStatus;
    }

    public Response(HttpStatus httpStatus, String message, Boolean error) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.error = error;
    }

    public Response(HttpStatus httpStatus, String message, Object result, Boolean error) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.result = result;
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public Boolean isError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }


    @Override
    public String toString() {
        return "Response{" +
                "result=" + result +
                ", error=" + error +
                ", message='" + message + '\'' +
                '}';
    }
}
