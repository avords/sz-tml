package com.parkdt.tml.controller;

import com.parkdt.tml.domain.OffiContent;
import com.parkdt.tml.domain.OffiDesign;
import com.parkdt.tml.service.BannerService;
import com.parkdt.tml.service.ContentService;
import com.parkdt.tml.service.DesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by guojianhua on 2018/01/09.
 * <p>
 * index 立可平台 资源中心
 */
@Controller
@RequestMapping(value = "/links")
public class LinksController {

    @Autowired
    private ContentService contentService;
    @Autowired
    private BannerService bannerService;

    @Autowired
    private DesignService designService;

    @RequestMapping("index")
    public String index(Model model, HttpServletRequest req) {
        return "index";
    }

    @RequestMapping("platform")
    public String platform(Model model, HttpServletRequest req) {
        //功能
        List<OffiContent> gnList = contentService.getContentByPartId(2L);
        model.addAttribute("gnList", gnList);
        //价格
        List<OffiContent> jgList = contentService.getContentByPartId(3L);
        model.addAttribute("jgList", jgList);
        //下载
        List<OffiContent> xzList = contentService.getContentByPartId(5L);
        model.addAttribute("xzList", xzList);

        return "likePlatfom";
    }

    @RequestMapping("Resources")
    public String Resources(Model model, HttpServletRequest req) {
        return "resCenter";
    }

    @RequestMapping("about")
    public String about(Model model, HttpServletRequest req) {
        //立可设计
        OffiContent content1 = contentService.getContentByContentId(458L);
        List<OffiDesign> allDesign = designService.getAllOffiDesign();
        model.addAttribute("sheji", content1);
        model.addAttribute("designList", allDesign);
        //立可科技
        OffiContent content2 = contentService.getContentByContentId(1059L);
        model.addAttribute("keji", content2);
        //立可空间
        OffiContent content3 = contentService.getContentByContentId(1061L);
        model.addAttribute("kongjian", content3);

        return "aboutLike";
    }
}
