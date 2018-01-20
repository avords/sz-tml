package com.parkdt.tml.weChat.message;

import com.parkdt.tml.weChat.message.artice.Article;
import com.parkdt.tml.weChat.message.artice.ArticlesFactory;

import java.util.List;

public class Message {

    /**
     * 接收方帐号（收到的OpenID)
     */
    private String ToUserName;

    /**
     * 发送方微信号
     */
    private String FromUserName;

    /**
     * 消息类型
     */
    private String MsgType;

    /**
     * 生成该消息的回复信息
     *
     * @return
     */
    public List<Article> responseArticles() {
        return ArticlesFactory.subscribeArticle(null);
    }

    /**
     * 创建回复消息
     *
     * @return
     */
    public String build() {
//    	return ToMessageFactory.subscribeTextMessage(this);
        return "";
    }

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

}
