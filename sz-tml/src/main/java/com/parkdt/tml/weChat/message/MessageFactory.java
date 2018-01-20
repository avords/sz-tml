package com.parkdt.tml.weChat.message;

import com.parkdt.tml.weChat.message.fromMessage.common.CommonMessageFactory;
import com.parkdt.tml.weChat.message.fromMessage.event.EventMessageFactory;

import java.util.Map;

public class MessageFactory {

    public static String createMessage(Map<String, String> param) {
		String msgType = param.get("MsgType");
		System.out.println();
		System.out.println(" MsgType = " + msgType);
		if(msgType.equals(MessageType.MESSAGE_TYPE_EVENT)) {
			return EventMessageFactory.createMessage(param);
		} else {
			return CommonMessageFactory.createMessage(param);
		}
	}
    
}
