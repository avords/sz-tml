package com.parkdt.tml.weChat.message.fromMessage.event;

import com.parkdt.tml.weChat.OpenIdToShopIdMap;
import com.parkdt.tml.weChat.message.artice.Article;
import com.parkdt.tml.weChat.message.artice.ArticlesFactory;
import com.parkdt.tml.weChat.message.toMessage.ToMessageFactory;

import java.util.List;
import java.util.Map;


public class ClickEvent extends Event {

    /**
     * 事件KEY值，与自定义菜单接口中KEY值对应
     */
    private String EventKey;

    public ClickEvent(Map<String, String> param) {
        super(param);
        EventKey = param.get("EventKey");
    }

    @Override
    public List<Article> responseArticles() {
        // TODO Auto-generated method stub
        return ArticlesFactory.clickMenuArticle(EventKey);
    }

    @Override
    public String build() {
        System.out.println("EventKey = " + EventKey);

        if (EventKeySet.MERCHANT_IN.equals(EventKey)) {
            return ToMessageFactory.merchantInTextMessage(this);
        }

        if (EventKeySet.OPENID_UNBIND.equals(EventKey)) {
            OpenIdToShopIdMap.remove(this.getFromUserName());

            return ToMessageFactory.openIdUnbindSuccessTextMessage(this);
        }

        return ToMessageFactory.subscribeTextMessage(this);
    }

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }

}
