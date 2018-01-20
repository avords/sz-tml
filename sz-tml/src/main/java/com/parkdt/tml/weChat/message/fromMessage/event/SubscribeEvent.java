package com.parkdt.tml.weChat.message.fromMessage.event;

import com.parkdt.tml.weChat.message.toMessage.ToMessageFactory;

import java.util.Map;

public class SubscribeEvent extends Event {

    //qrscene_123123
    private String EventKey;

    private String Ticket;

    public SubscribeEvent(Map<String, String> param) {
        super(param);
        EventKey = param.get("EventKey");
        Ticket = param.get("Ticket");
    }

//	@Override
//	public List<Article> responseArticles() {
//		// TODO Auto-generated method stub
//		return ArticlesFactory.subscribeArticle(EventKey);
//	}

    @Override
    public String build() {
        System.out.println();
        System.out.println("订阅我。。。");

        return ToMessageFactory.subscribeTextMessage(this);
    }

    public String getTicket() {
        return Ticket;
    }

    public void setTicket(String ticket) {
        Ticket = ticket;
    }

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }

    //欢迎图文


}
