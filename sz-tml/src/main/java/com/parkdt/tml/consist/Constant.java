package com.parkdt.tml.consist;

/**
 * Created by guojianhua on 2017/12/15.
 */
public class Constant {
    //用户角色
    public static final int USER_ROLE_EVERYMAN = 1;//普通人
    public static final int USER_ROLE_DESIGNER = 2;//设计师

    public static final int USER_ROLE_PROJECT_MANAGER = 3;//项目经理
    public static final int USER_ROLE_PROJECT_PUBLISHER = 4;//项目导入方

    public static final String SESSION_USER="userLogin";
    public static final String SESSION_OPEN_ID="openId";

    public static enum Project_status {
        //项目状态（2采编中2、4认领中、5进行中6、已完成、7已取消、8已暂停）

        采编中2("采编中2", 2),
        认领中("认领中", 4),
        进行中("进行中", 5),
        已完成("已完成", 6),
        已取消("已取消", 7),
        已暂停("已暂停", 8);

        private String cnName;
        private int code;

        Project_status(String name, int code) {
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
            for (Project_status item : Project_status.values()) {
                if (item.getCode() == code) {
                    return item.getCnName();
                }
            }
            return null;
        }

        public static int getCode(String name) {
            for (Project_status item : Project_status.values()) {
                if (item.getCnName().equals(name)) {
                    return item.getCode();
                }
            }
            return 0;
        }
    }

    public static enum Claim_status {
        //状态(0待审核1已审核2审核失败,3已取消)

        待审核("待审核", 0),
        已审核("已审核", 1),
        审核失败("审核失败", 2),
        已取消("已取消", 3);

        private String cnName;
        private int code;

        Claim_status(String name, int code) {
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
            for (Claim_status item : Claim_status.values()) {
                if (item.getCode() == code) {
                    return item.getCnName();
                }
            }
            return null;
        }

        public static int getCode(String name) {
            for (Claim_status item : Claim_status.values()) {
                if (item.getCnName().equals(name)) {
                    return item.getCode();
                }
            }
            return 0;
        }
    }

}
