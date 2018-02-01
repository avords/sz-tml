package com.parkdt.tml.weChat.message.fromMessage.event;

import com.parkdt.tml.weChat.OpenIdToShopIdMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class UnsubscribeEvent extends Event {

    private Logger logger = LoggerFactory.getLogger(EventMessageFactory.class);

    public UnsubscribeEvent(Map<String, String> param) {
        super(param);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String build() {
        // TODO Auto-generated method stub

        OpenIdToShopIdMap.remove(this.getFromUserName());

        logger.info("UnsubscribeEvent成功。");
        logger.info("FromUserName: " + this.getFromUserName());
        return super.build();
    }

}
