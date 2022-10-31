package com.components.utils.request;



/**
 * Author : fanjun
 * Date   : 2018/10/20
 * Desc   :
 */
public class DataRequest<T> extends CommonRequest {
    /**
     * 请求参数
     */
    private T param;

    public DataRequest() {
    }

    public DataRequest(T param) {
        this.param = param;
    }

    public T getParam() {
        return param;
    }

    public void setParam(T param) {
        this.param = param;
    }
}
