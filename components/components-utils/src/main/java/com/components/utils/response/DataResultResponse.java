package com.components.utils.response;


import com.components.utils.exception.BusinessException;

public class DataResultResponse<T> extends CommonResponse {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <V> DataResultResponse<V> fail(String message) {
        DataResultResponse<V> result = new DataResultResponse<>();
        result.setResponseCode(CommonResponseCode.RC_EXCEPTION_ERROR.getResponseCode());
        result.setResponseMessage(CommonResponseCode.RC_EXCEPTION_ERROR.getResponseMessage());
        return result;
    }

    public static <V> DataResultResponse<V> fail(String code, String message) {
        DataResultResponse<V> result = new DataResultResponse<>();
        result.setResponseCode(code);
        result.setResponseMessage(message);
        return result;
    }

    public static <V> DataResultResponse<V> ok(V data) {
        DataResultResponse<V> result = new DataResultResponse<>();
        result.setResponseCode(CommonResponseCode.RC_SUCCESS.getResponseCode());
        result.setResponseMessage(CommonResponseCode.RC_SUCCESS.getResponseMessage());
        result.setData(data);
        return result;
    }

    public static <V> DataResultResponse<V> ok(String message, V data) {
        DataResultResponse<V> result = new DataResultResponse<>();
        result.setResponseCode(CommonResponseCode.RC_SUCCESS.getResponseCode());
        result.setResponseMessage(message);
        result.setData(data);
        return result;
    }

    public static <V> DataResultResponse<V> ok(String code, String message, V data) {
        DataResultResponse<V> result = new DataResultResponse<>();
        result.setResponseCode(code);
        result.setResponseMessage(message);
        result.setData(data);
        return result;
    }

    public T getOkData() {
        if (!CommonResponseCode.RC_SUCCESS.getResponseCode().equals(this.getResponseCode())) {
            throw new BusinessException(this.getResponseCode(), this.getResponseMessage());
        } else {
            return this.getData();
        }
    }
}
