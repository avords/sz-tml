package com.parkdt.tml.weChat.message;

public class MessageType {

    /**
     * 返回消息类型：文本
     */
    public static final String MESSAGE_TYPE_TEXT = "text";

    /**
     * 返回消息类型：音乐
     */
    public static final String MESSAGE_TYPE_MUSIC = "music";

    /**
     * 返回消息类型：图文
     */
    public static final String MESSAGE_TYPE_NEWS = "news";

    /**
     * 请求消息类型：图片
     */
    public static final String MESSAGE_TYPE_IMAGE = "image";

    /**
     * 请求消息类型：链接
     */
    public static final String MESSAGE_TYPE_LINK = "link";

    /**
     * 请求消息类型：地理位置
     */
    public static final String MESSAGE_TYPE_LOCATION = "location";

    /**
     * 请求消息类型：语音
     */
    public static final String MESSAGE_TYPE_VOICE = "voice";

    /**
     * 请求消息类型：事件推送
     */
    public static final String MESSAGE_TYPE_EVENT = "event";

    /**
     * 事件类型：subscribe(订阅)
     */
    public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";

    /**
     * 事件类型：unsubscribe(取消订阅)
     */
    public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";

    /**
     * 事件类型：CLICK(自定义菜单点击事件)
     */
    public static final String EVENT_TYPE_CLICK = "CLICK";

    /**
     * 事件类型：SCAN(已关注后的扫描事件)
     */
    public static final String EVENT_TYPE_SCAN = "SCAN";

    /**
     * 事件类型：SCAN(已关注后的扫描事件)
     */
    public static final String EVENT_TYPE_LOCATION = "LOCATION";

    /**
     * 事件类型：SCAN(已关注后的扫描事件)
     */
    public static final String EVENT_TYPE_VIEW = "VIEW";

    /**
     * 事件类型：TEMPLATESENDJOBFINISH(模板消息)
     */
    public static final String EVENT_TYPE_TEMPLATESENDJOBFINISH = "TEMPLATESENDJOBFINISH";

}
