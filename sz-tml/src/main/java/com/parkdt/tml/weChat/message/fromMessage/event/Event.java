package com.parkdt.tml.weChat.message.fromMessage.event;

import com.parkdt.tml.weChat.message.Message;

import java.util.Map;

public class Event extends Message {

    private String Event;

    public Event(Map<String, String> param) {
        Event = param.get("Event");
    }

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

}
