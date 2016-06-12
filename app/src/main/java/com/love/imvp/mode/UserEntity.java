package com.love.imvp.mode;

import java.io.Serializable;

/**
 * 作者：zf on 2016/6/12 11:23
 * 邮箱：initzf@126.com
 */
public class UserEntity implements Serializable{

    private int errCode;
    private int errFlag;
    private String errMsg;
    private int userid;
    private String session;

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public int getErrFlag() {
        return errFlag;
    }

    public void setErrFlag(int errFlag) {
        this.errFlag = errFlag;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }


    @Override
    public String toString() {
        return "UserEntity{" +
                "errCode=" + errCode +
                ", errFlag=" + errFlag +
                ", errMsg='" + errMsg + '\'' +
                ", userid=" + userid +
                ", session='" + session + '\'' +
                '}';
    }
}
