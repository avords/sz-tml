package com.parkdt.tml.weChat.message.fromMessage.event;

import java.util.Map;

public class ViewEvent extends Event {

    /**
     * 事件KEY值，设置的跳转URL
     */
    private String EventKey;

    public ViewEvent(Map<String, String> param) {
        super(param);
        EventKey = param.get("EventKey");
    }

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }

}
