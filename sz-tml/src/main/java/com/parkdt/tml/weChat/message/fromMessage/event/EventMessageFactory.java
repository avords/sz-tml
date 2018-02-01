package com.parkdt.tml.weChat.message.fromMessage.event;

import com.parkdt.tml.weChat.message.MessageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class EventMessageFactory {

    private static Logger logger = LoggerFactory.getLogger(EventMessageFactory.class);

    /**
     * 创建回复消息
     *
     * @param param
     * @return
     */
    public static String createMessage(Map<String, String> param) {
        Event eventMessage = null;
        String event = param.get("Event");

        logger.info("event = " + event);

        if (event.equals(MessageType.EVENT_TYPE_SUBSCRIBE)) {
            eventMessage = new SubscribeEvent(param);
        } else if (event.equals(MessageType.EVENT_TYPE_UNSUBSCRIBE)) {
            eventMessage = new UnsubscribeEvent(param);
        } else if (event.equals(MessageType.EVENT_TYPE_LOCATION)) {
            eventMessage = new LocationEvent(param);
        } else if (event.equals(MessageType.EVENT_TYPE_CLICK)) {
            eventMessage = new ClickEvent(param);
        } else if (event.equals(MessageType.EVENT_TYPE_VIEW)) {
            eventMessage = new ViewEvent(param);
        } else if (event.equals(MessageType.EVENT_TYPE_TEMPLATESENDJOBFINISH)) {
            eventMessage = new TemplateSendJobFinish(param);
        }

        logger.info("opendId = " + param.get("FromUserName"));
        eventMessage.setFromUserName(param.get("FromUserName"));
        eventMessage.setToUserName(param.get("ToUserName"));
        return eventMessage.build();
    }

}
