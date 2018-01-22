package com.parkdt.tml.weChat.message.toMessage;


import com.parkdt.tml.weChat.message.Message;

import java.io.Writer;
import java.util.Date;

public class ToMessage extends Message {

    private long CreateTime;

    public void exchangeUser(Message fromMessage) {
        this.setFromUserName(fromMessage.getToUserName());
        this.setToUserName(fromMessage.getFromUserName());
    }

    public ToMessage() {
        setCreateTime(new Date().getTime());
    }


    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

}
