package com.parkdt.tml.consist;

/**
 * Created by guojianhua on 2017/12/15.
 */
public class Constant {

    public static enum Device_State {
        NoIni("未知", 0),
        IN("在库", 1),
        OUT("已借用", 2),
        NOThis("无此设备", 3);

        private String cnName;
        private int code;

        Device_State(String name, int code) {
            this.cnName = name;
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        public String getCnName() {
            return cnName;
        }

        public static String getCnName(int code) {
            for (Device_State item : Device_State.values()) {
                if (item.getCode() == code) {
                    return item.getCnName();
                }
            }
            return null;
        }

        public static int getCode(String name) {
            for (Device_State item : Device_State.values()) {
                if (item.getCnName().equals(name)) {
                    return item.getCode();
                }
            }
            return 0;
        }
    }
}