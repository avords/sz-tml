package com.parkdt.tml.weChat.message.toMessage;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ToTextMessage extends ToMessage {

    private Logger logger = LoggerFactory.getLogger(ToTextMessage.class);

    private String Content;

    @Override
    public String build() {

        Document doc = DocumentHelper.createDocument();
        Element root = doc.addElement("xml");
        Element ToUserName = root.addElement("ToUserName");
        ToUserName.addCDATA(this.getToUserName());

        Element FromUserName = root.addElement("FromUserName");
        FromUserName.addCDATA(this.getFromUserName());

        Element MsgType = root.addElement("MsgType");
        MsgType.addCDATA(this.getMsgType());

        Element CreateTime = root.addElement("CreateTime");
        CreateTime.addCDATA(this.getCreateTime() + "");

        Element Content = root.addElement("Content");
        Content.addCDATA(this.getContent());

        logger.info(doc.getRootElement().asXML());
        return doc.getRootElement().asXML();
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

}
