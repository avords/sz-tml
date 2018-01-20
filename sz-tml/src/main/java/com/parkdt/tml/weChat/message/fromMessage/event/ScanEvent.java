package com.parkdt.tml.weChat.message.fromMessage.event;

import com.parkdt.tml.weChat.message.artice.Article;
import com.parkdt.tml.weChat.message.artice.ArticlesFactory;

import java.util.List;
import java.util.Map;


public class ScanEvent extends Event {

    /**
     * 事件KEY值，是一个32位无符号整数，即创建二维码时的二维码scene_id
     */
    private String EventKey;

    /**
     * 二维码的ticket，可用来换取二维码图片
     */
    private String Ticket;

    public ScanEvent(Map<String, String> param) {
        super(param);
        EventKey = param.get("EventKey");
        Ticket = param.get("Ticket");
    }

    @Override
    public List<Article> responseArticles() {
        // TODO Auto-generated method stub
        return ArticlesFactory.subscribeArticle(EventKey);
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
