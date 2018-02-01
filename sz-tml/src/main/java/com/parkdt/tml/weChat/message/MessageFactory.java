package com.parkdt.tml.weChat.message;

import com.parkdt.tml.weChat.message.fromMessage.common.CommonMessageFactory;
import com.parkdt.tml.weChat.message.fromMessage.event.EventMessageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class MessageFactory {

    private static Logger logger = LoggerFactory.getLogger(MessageFactory.class);

    public static String createMessage(Map<String, String> param) {
        String msgType = param.get("MsgType");

        logger.info(" MsgType = " + msgType);
        if (msgType.equals(MessageType.MESSAGE_TYPE_EVENT)) {
            return EventMessageFactory.createMessage(param);
        } else {
            return CommonMessageFactory.createMessage(param);
        }
    }

}
