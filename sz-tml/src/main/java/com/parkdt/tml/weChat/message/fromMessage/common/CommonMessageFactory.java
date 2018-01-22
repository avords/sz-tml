package com.parkdt.tml.weChat.message.fromMessage.common;

import java.util.Map;


public class CommonMessageFactory {

    /**
     * 创建回复消息
     *
     * @param param
     * @return
     */
    public static String createMessage(Map<String, String> param) {
        return "";
//		Message fromMessage = null;
//		fromMessage = new Message();
//		fromMessage.setFromUserName(param.get("FromUserName"));
//		fromMessage.setToUserName(param.get("ToUserName"));
//		String MsgType = param.get("MsgType");
//		if(MsgType.equals(MessageType.MESSAGE_TYPE_TEXT)) {
//			return new TextMessage(param).build(fromMessage);
//		} else {
//			List<Article> Articles = ArticlesFactory.subscribeArticle(null);
//			ToNewsMessage toNewsMessage = new ToNewsMessage();
//			toNewsMessage.exchangeUser(fromMessage);
//			toNewsMessage.setArticles(Articles);
//			return toNewsMessage.build();
//		}

    }

}
