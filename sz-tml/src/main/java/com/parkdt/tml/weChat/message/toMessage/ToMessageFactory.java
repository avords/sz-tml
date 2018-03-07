package com.parkdt.tml.weChat.message.toMessage;

import com.parkdt.tml.taskService.WeChatTokenService;
import com.parkdt.tml.weChat.message.Message;
import com.parkdt.tml.weChat.message.MessageType;
import com.parkdt.tml.weChat.message.artice.Article;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;


public class ToMessageFactory {

    private static Logger logger = LoggerFactory.getLogger(ToMessageFactory.class);

    /**
     * 关注时回复文本消息
     *
     * @param fromMessage
     * @return
     */
    public static String subscribeTextMessage(Message fromMessage) {
        ToTextMessage textMessage = new ToTextMessage();

        StringBuffer res = new StringBuffer();
        res.append("感谢关注\"teamlinks立可平台\",参与资源中心签到活动");
        res.append("\r\n");
        res.append("\r\n<a href=\"http://wei.yesaaa.cn/app/index.php?i=334&c=entry&rid=903&do=app_qd&m=meepo_xianchang\">点此进入</a>");
        //textMessage.setContent(res.toString());

        textMessage.setContent(WeChatTokenService.getSubscribeText());

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
