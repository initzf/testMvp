package com.love.imvp.mode;

import java.io.Serializable;

/**
 * 作者：zf on 2016/6/12 14:37
 * 邮箱：initzf@126.com
 */
public class PolicyStatus implements Serializable {

    /**
     * errCode : 10000
     * errFlag : 1
     * errMsg :
     * list : {"totalScore":20300,"currScore":20300,"policyStatus":2,"premium":2000}
     */

    private int errCode;
    private int errFlag;
    private String errMsg;
    /**
     * totalScore : 20300
     * currScore : 20300
     * policyStatus : 2
     * premium : 2000
     */

    private ListEntity list;

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

    public ListEntity getList() {
        return list;
    }

    public void setList(ListEntity list) {
        this.list = list;
    }

    public static class ListEntity {
        private int totalScore;
        private int currScore;
        private int policyStatus;
        private int premium;

        public int getTotalScore() {
            return totalScore;
        }

        public void setTotalScore(int totalScore) {
            this.totalScore = totalScore;
        }

        public int getCurrScore() {
            return currScore;
        }

        public void setCurrScore(int currScore) {
            this.currScore = currScore;
        }

        public int getPolicyStatus() {
            return policyStatus;
        }

        public void setPolicyStatus(int policyStatus) {
            this.policyStatus = policyStatus;
        }

        public int getPremium() {
            return premium;
        }

        public void setPremium(int premium) {
            this.premium = premium;
        }
    }
}
