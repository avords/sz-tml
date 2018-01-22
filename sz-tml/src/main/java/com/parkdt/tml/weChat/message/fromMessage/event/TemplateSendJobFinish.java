package com.parkdt.tml.weChat.message.fromMessage.event;

import java.util.Map;

public class TemplateSendJobFinish extends Event {

    private String Status;

    public TemplateSendJobFinish(Map<String, String> param) {
        super(param);
        Status = param.get("Status");
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

}
