package com.parkdt.tml.weChat.message.toMessage;

import com.parkdt.tml.weChat.message.Message;
import com.parkdt.tml.weChat.message.MessageType;
import com.parkdt.tml.weChat.message.artice.Article;

import java.util.Date;
import java.util.List;


public class ToMessageFactory {

    /**
     * 关注时回复文本消息
     *
     * @param fromMessage
     * @return
     */
    public static String subscribeTextMessage(Message fromMessage) {
        ToTextMessage textMessage = new ToTextMessage();

        StringBuffer res = new StringBuffer();
        res.append("1.可以登录单店铺，多店铺，圈子。登录成功后会自动推送订单；");
//		res.append("/r/n");
//		res.append("登录成功后，回复对应数字可以确认订单");
//		res.append("/r/n");
        res.append("2.可以点击消息进入收单台，确认订单。");
        textMessage.setContent(res.toString());

        return textMessage(fromMessage, textMessage);
    }

    /**
     * 创建图文消息
     *
     * @return
     */
    public static String newsMessage(Message fromMessage) {
        ToNewsMessage toNewsMessage = new ToNewsMessage();
        toNewsMessage.exchangeUser(fromMessage);
        toNewsMessage.setCreateTime(new Date().getTime());
        toNewsMessage.setMsgType(MessageType.MESSAGE_TYPE_NEWS);

        List<Article> Articles = fromMessage.responseArticles();
        toNewsMessage.setArticles(Articles);

        return toNewsMessage.build();
    }

    /**
     * 回复接受订单成功消息
     *
     * @param fromMessage
     * @return
     */
    public static String receiveOrderSuccessTextMessage(Message fromMessage) {
        ToTextMessage textMessage = new ToTextMessage();
        textMessage.setContent("接受订单成功");

        return textMessage(fromMessage, textMessage);
    }

    /**
     * 回复接受订单失败消息
     *
     * @param fromMessage
     * @return
     */
    public static String receiveOrderFailTextMessage(Message fromMessage) {
        ToTextMessage textMessage = new ToTextMessage();
        textMessage.setContent("接受订单失败");

        return textMessage(fromMessage, textMessage);
    }

    /**
     * 回复接受订单成功消息
     *
     * @param fromMessage
     * @return
     */
    public static String refuseOrderSuccessTextMessage(Message fromMessage) {
        ToTextMessage textMessage = new ToTextMessage();
        textMessage.setContent("拒绝订单成功");
        return textMessage(fromMessage, textMessage);
    }

    /**
     * 回复接受订单失败消息
     *
     * @param fromMessage
     * @return
     */
    public static String refuseOrderFailTextMessage(Message fromMessage) {
        ToTextMessage textMessage = new ToTextMessage();
        textMessage.setContent("拒绝订单失败");
        return textMessage(fromMessage, textMessage);
    }

    /**
     * 回复接受订单失败消息
     *
     * @param fromMessage
     * @return
     */
    private static String textMessage(Message fromMessage, ToTextMessage textMessage) {
        if (fromMessage != null) {
            textMessage.exchangeUser(fromMessage);
        }
        textMessage.setCreateTime(new Date().getTime());
        textMessage.setMsgType(MessageType.MESSAGE_TYPE_TEXT);
        return textMessage.build();
    }

    /**
     * 回复商户入驻须知消息
     *
     * @param fromMessage
     * @return
     */
    public static String merchantInTextMessage(Message fromMessage) {
        ToTextMessage textMessage = new ToTextMessage();
        textMessage.setContent("商户入驻须知");
        return textMessage(fromMessage, textMessage);
    }

    /**
     * 回复绑定账号成功消息
     *
     * @param fromMessage
     * @return
     */
    public static String openIdUnbindSuccessTextMessage(Message fromMessage) {
        ToTextMessage textMessage = new ToTextMessage();
        textMessage.setContent("屏蔽订单消息成功");
        return textMessage(fromMessage, textMessage);
    }

    /**
     * 回复绑定账号失败消息
     *
     * @param fromMessage
     * @return
     */
    public static String openIdUnbindFailTextMessage(Message fromMessage) {
        ToTextMessage textMessage = new ToTextMessage();
        textMessage.setContent("屏蔽订单消息账号失败");
        return textMessage(fromMessage, textMessage);
    }

}
