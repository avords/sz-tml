package com.parkdt.tml.weChat.message.fromMessage.event;

import com.parkdt.tml.weChat.OpenIdToShopIdMap;

import java.util.Map;

public class UnsubscribeEvent extends Event {

    public UnsubscribeEvent(Map<String, String> param) {
        super(param);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String build() {
        // TODO Auto-generated method stub

        OpenIdToShopIdMap.remove(this.getFromUserName());

        System.out.println("UnsubscribeEvent成功。");
        System.out.println("FromUserName: " + this.getFromUserName());
        return super.build();
    }

}
