package com.example.expensesaiapi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ApiResponse {

    private Integer status;
    private String message;
    private Object response;
    private Long timestamp;
    private Boolean errorType;

    public ApiResponse(Integer status, String message, Boolean errorType, Object response) {
        this.status = status;
        this.message = message;
        this.response = response;
        this.timestamp = System.currentTimeMillis();
        this.errorType = errorType;
    }

    public ApiResponse(Integer status, Boolean errorType, Object response) {
        this.status = status;
        this.message = "";
        this.response = response;
        this.timestamp = System.currentTimeMillis();
        this.errorType = errorType;
    }

    public ApiResponse(Integer status, String message, Boolean errorType) {
        this.status = status;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
        this.errorType = errorType;
    }

    public ApiResponse getApiResponse(Integer status, String message, Boolean errorType) {
        return new ApiResponse(status, message, errorType, null);
    }

    public ApiResponse getApiResponse(Integer status, String message, Boolean errorType, Object data) {
        return new ApiResponse(status, message, errorType, data);
    }

}
