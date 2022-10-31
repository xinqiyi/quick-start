package com.components.utils.response;


import com.components.utils.StringUtil;
import com.components.utils.exception.CommonResponseType;

import java.io.Serializable;
import java.util.Map;

/**
 * @author liuchaogang
 * @date 2017年4月12日
 */
public class CommonResponse implements Serializable{
    /**
     * @return
     */
    private static final long serialVersionUID = -8349696635548886541L;
    private String responseCode = CommonResponseCode.RC_SUCCESS.getResponseCode();

    private String responseMessage = CommonResponseCode.RC_SUCCESS.getResponseMessage();

    private String responseType;//ERROR,WARN

    private Map<String,Object> errorDataMap;//错误的map${name}${age}${tt}出错，这个是格式 map 记录name,age,tt的值；

    public Map<String, Object> getErrorDataMap() {
        return errorDataMap;
    }

    public void setErrorDataMap(Map<String, Object> errorDataMap) {
        this.errorDataMap = errorDataMap;
    }

    public String getResponseType() {
        if(StringUtil.isBlank(responseType) && !CommonResponseCode.RC_SUCCESS.getResponseCode().equals(responseCode)){
            responseType = CommonResponseType.ERROR.toString();
        }
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public CommonResponse() {
		super();
	}

	public CommonResponse(String responseCode, String responseMessage) {
		super();
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}

    public CommonResponse(CommonResponseCode commonResponseCode) {
        super();
        this.responseCode = commonResponseCode.getResponseCode();
        this.responseMessage = commonResponseCode.getResponseMessage();
    }


    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
}
