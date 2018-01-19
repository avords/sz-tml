package com.parkdt.tml.consist;

/**
 * Created by guojianhua on 2017/12/15.
 */
public class Constant {
    //用户角色
    public static final int USER_ROLE_EVERYMAN=1;//普通人
    public static final int USER_ROLE_DESIGNER=2;//设计师
    public static final int USER_ROLE_PROJECT_MANAGER=3;//项目经理
    public static final int USER_ROLE_PROJECT_PUBLISHER=4;//项目导入方

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


    public static enum Project_status{
        //项目状态（2采编中2、4认领中、5进行中6、已完成、7已取消、8已暂停）
    }

    public static enum Claim_status{
        //状态(0待审核1已审核2审核失败,3已取消)
    }

}
