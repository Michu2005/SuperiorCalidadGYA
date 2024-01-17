package com.gruposuperior.calidad.manofactura.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.data.annotation.Transient;
import org.springframework.http.HttpStatus;

public class ResponseDTO<T> {
    private T data;
    @JsonIgnore
    private HttpStatus httpStatus;
    @Transient
    private int code;

    public ResponseDTO() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public int getCode() {
        return httpStatus.value();
    }

}
