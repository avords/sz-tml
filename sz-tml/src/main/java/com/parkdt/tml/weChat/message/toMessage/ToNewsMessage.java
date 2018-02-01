package com.parkdt.tml.weChat.message.toMessage;

import com.parkdt.tml.weChat.message.artice.Article;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ToNewsMessage extends ToMessage {

    private Logger logger = LoggerFactory.getLogger(ToNewsMessage.class);
    private int ArticleCount;

    private List<Article> Articles;

    public ToNewsMessage() {
        super();
        setMsgType("news");
    }

    @Override
    public String build() {
        Document doc = DocumentHelper.createDocument();
        Element root = doc.addElement("xml");
        Element ToUserName = root.addElement("ToUserName");
        ToUserName.addCDATA(this.getToUserName());

        Element FromUserName = root.addElement("FromUserName");
        FromUserName.addCDATA(this.getFromUserName());

        Element CreateTime = root.addElement("CreateTime");
        CreateTime.addCDATA(this.getCreateTime() + "");

        Element MsgType = root.addElement("MsgType");
        MsgType.addCDATA(this.getMsgType());

        Element ArticleCount = root.addElement("ArticleCount");
        ArticleCount.addCDATA(String.valueOf(Articles.size()));


        Element ArticlesList = root.addElement("Articles");
        for (Article article : Articles) {
            Element item = ArticlesList.addElement("item");

            Element Title = item.addElement("Title");
            Title.addCDATA(article.getTitle());

            Element Description = item.addElement("Description");
            Description.addCDATA(article.getDescription());

            Element PicUrl = item.addElement("PicUrl");
            PicUrl.addCDATA(article.getPicUrl());

            Element Url = item.addElement("Url");
            Url.addCDATA(article.getUrl());
        }

        logger.info(doc.getRootElement().asXML());
        return doc.getRootElement().asXML();
    }

    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }

    public List<Article> getArticles() {
        return Articles;
    }

    public void setArticles(List<Article> articles) {
        Articles = articles;
    }

}
