package com.love.imvp.mode;

import java.util.List;

/**
 * 作者：zf on 2016/6/14 16:41
 * 邮箱：initzf@126.com
 */
public class cxcxc {

    private List<GpsEntity> gps;

    public List<GpsEntity> getGps() {
        return gps;
    }
    public void setGps(List<GpsEntity> gps) {
        this.gps = gps;
    }

    public static class GpsEntity {
        private String lat;
        private String lng;

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }
    }
}
