package com.parkdt.tml.weChat.message.fromMessage.common;

import com.parkdt.tml.utils.StringKit;
import com.parkdt.tml.weChat.message.Message;
import com.parkdt.tml.weChat.message.toMessage.ToMessageFactory;

import java.util.Map;

public class TextMessage extends Message {

    /**
     * 文本消息内容
     */
    private String Content;

    public TextMessage(Map<String, String> param) {
        Content = param.get("Content");
    }

    public String build(Message fromMessage) {
        if (StringKit.isEmpty(Content)) {
            return ToMessageFactory.newsMessage(fromMessage);
        } else {
            if (Content.equals("1")) {

//				List<NameValuePair> param = new ArrayList<NameValuePair>();
//				param.add(new BasicNameValuePair("orderId", orderId));
//				param.add(new BasicNameValuePair("orderState", state));
//				String result = HttpPostClient.doHttpPost(Config.getPlatPath(), "ordUpdateOrdState.mas", param);
//				System.out.println(result);
//				
                return ToMessageFactory.receiveOrderSuccessTextMessage(fromMessage);
            } else if (Content.equals("0")) {
                return ToMessageFactory.receiveOrderFailTextMessage(fromMessage);
            } else {
                return ToMessageFactory.newsMessage(fromMessage);
            }
        }
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

}
