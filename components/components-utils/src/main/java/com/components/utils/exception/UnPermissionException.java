package com.components.utils.exception;

import com.components.utils.response.CommonResponseCode;

/**
 * Created by Administrator on 2017/9/7.
 */
public class UnPermissionException extends  BusinessException {
    protected String permissionCode;

    @Deprecated
    public UnPermissionException() {
        super();
    }

    @Deprecated
    public UnPermissionException(String message, Throwable cause) {
        super(message, cause);
    }

    @Deprecated
    public UnPermissionException(Throwable cause) {
        super(cause);
    }

    @Deprecated
    public UnPermissionException(String errorCode,String msg) {
        super(errorCode,msg);
    }

    public UnPermissionException(String permissionCode) {
        super(CommonResponseCode.RC_NO_PERMISSION_ERROR.getResponseCode(),CommonResponseCode.RC_NO_PERMISSION_ERROR.getResponseMessage()+":" + permissionCode);
        this.permissionCode = permissionCode;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }
}
