package com.love.imvp.mode;

import java.util.List;

/**
 * 作者：zf on 2016/6/14 10:15
 * 邮箱：initzf@126.com
 */
public class CZPV {

    private String accessTime;
    private String app;
    private DataEntity data;
    private String leaveTime;
    private String prePVID;
    private String pvid;
    private String ubt_client_type;
    private String ubt_client_version;
    private String uid;

    public String getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(String accessTime) {
        this.accessTime = accessTime;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public String getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getPrePVID() {
        return prePVID;
    }

    public void setPrePVID(String prePVID) {
        this.prePVID = prePVID;
    }

    public String getPvid() {
        return pvid;
    }

    public void setPvid(String pvid) {
        this.pvid = pvid;
    }

    public String getUbt_client_type() {
        return ubt_client_type;
    }

    public void setUbt_client_type(String ubt_client_type) {
        this.ubt_client_type = ubt_client_type;
    }

    public String getUbt_client_version() {
        return ubt_client_version;
    }

    public void setUbt_client_version(String ubt_client_version) {
        this.ubt_client_version = ubt_client_version;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public static class DataEntity {
        private AndroidEntity android;

        public AndroidEntity getAndroid() {
            return android;
        }

        public void setAndroid(AndroidEntity android) {
            this.android = android;
        }

        public static class AndroidEntity {
            private String version;
            private List<ClickEntity> click;

            public String getVersion() {
                return version;
            }

            public void setVersion(String version) {
                this.version = version;
            }

            public List<ClickEntity> getClick() {
                return click;
            }

            public void setClick(List<ClickEntity> click) {
                this.click = click;
            }

            public static class ClickEntity {
                private String id;
                private String time;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getTime() {
                    return time;
                }

                public void setTime(String time) {
                    this.time = time;
                }
            }
        }
    }
}
