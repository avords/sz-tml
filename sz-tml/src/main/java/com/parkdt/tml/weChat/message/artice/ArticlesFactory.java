package com.parkdt.tml.weChat.message.artice;

import com.parkdt.tml.config.WeChatConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


public class ArticlesFactory {
    private static Logger logger = LoggerFactory.getLogger(ArticlesFactory.class);

    /**
     * 订阅时推送的图文消息
     *
     * @param EventKey
     * @return
     */
    public static List<Article> emptyArticle(String EventKey) {
        return subscribeArticle(EventKey);
    }

    /**
     * 订阅时推送的图文消息
     *
     * @param EventKey
     * @return
     */
    public static List<Article> subscribeArticle(String EventKey) {
        List<Article> Articles = new ArrayList<Article>();
        Article article = new Article();
        article.setPicUrl(WeChatConfig.getWebUrl() + "img/receiveOrderLogo.png");

        logger.info("receiveOrderLogo.png");
        Articles.add(article);
        return Articles;
    }

    /**
     * 点击菜单时推送的图文消息
     *
     * @param EventKey
     * @return
     */
    public static List<Article> clickMenuArticle(String EventKey) {
//		List<Article> Articles = new ArrayList<Article>();
//		
//		return Articles;
        return subscribeArticle(EventKey);
    }

    /**
     * 点击菜单时推送的文本消息
     *
     * @param Content
     * @return
     */
    public static List<Article> textArticle(String Content) {
        return subscribeArticle(Content);
    }

}
