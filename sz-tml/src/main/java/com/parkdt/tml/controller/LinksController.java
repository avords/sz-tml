package com.parkdt.tml.controller;

import com.parkdt.tml.domain.OffiContent;
import com.parkdt.tml.domain.OffiDesign;
import com.parkdt.tml.domain.SysAreasExpertise;
import com.parkdt.tml.domain.SysGoodType;
import com.parkdt.tml.service.BannerService;
import com.parkdt.tml.service.ContentService;
import com.parkdt.tml.service.DesignService;
import com.parkdt.tml.service.ProjectService;
import com.parkdt.tml.service.SysAreasExpertiseService;
import com.parkdt.tml.service.SysCityService;
import com.parkdt.tml.service.SysGoodTypeService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guojianhua on 2018/01/09.
 * <p>
 * index 立可平台 资源中心
 */
@Controller
@RequestMapping(value = "/links")
public class LinksController extends BaseController{

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private ProjectService projectService;
    @Autowired
    private SysCityService sysCityService;

    @Autowired
    private ContentService contentService;
    @Autowired
    private BannerService bannerService;
    @Autowired
    private DesignService designService;
    @Autowired
    private SysGoodTypeService sysGoodTypeService;
    @Autowired
    private SysAreasExpertiseService sysAreasExpertiseService;

    @RequestMapping("Resources")
    public String Resources(Model model, HttpServletRequest req) {

        //得到所有领域
        List<SysAreasExpertise> sysAreasExpertises = sysAreasExpertiseService.getAllSysAreasExpertise();
        //得到所有类型
        List<SysGoodType> sysGoodTypes = sysGoodTypeService.getAllSysGoodType();
        //得到所有的项目导入方
        //List<Map> projectImports = projectService.queryBySql("select distinct company_id,company_name from t_project_importer_info",null);
        try {
            Date startDate = getRelType(req.getParameter("startDate"), Date.class);
            Date endDate = getRelType(req.getParameter("endDate"), Date.class);
            boolean isOne = false;
            String oneStr = req.getParameter("oneStr");
            if (oneStr == null || "".equals(oneStr)) {
                oneStr = "1";
            }
            if ("1".equals(oneStr)) {
                isOne = true;
            }
            model.addAttribute("oneStr", oneStr);
            Long fieldId = getRelType(req.getParameter("fieldId"), Long.class);
            Long designTypeId = getRelType(req.getParameter("designTypeId"), Long.class);
            Double startOutputValue = getRelType(req.getParameter("startOutputValue"), Double.class);
            Double endOutputValue = getRelType(req.getParameter("endOutputValue"), Double.class);
            Long companyId = getRelType(req.getParameter("companyId"), Long.class);

            Map params = new HashMap();
            String companyName = req.getParameter("companyName");

            if (companyName == null) {
                companyName = "资源中心";
                params.put("companyName", companyName);
            } else {
                if (!companyName.equals("")) {
                    params.put("companyName", companyName);
                }
            }

            params.put("startDate", startDate);
            params.put("endDate", endDate);
            params.put("isOne", isOne);
            params.put("fieldId", fieldId);
            params.put("designTypeId", designTypeId);
            params.put("startOutputValue", startOutputValue);
            params.put("endOutputValue", endOutputValue);
            params.put("companyId", companyId);

            if (StringUtils.isBlank(req.getParameter("search"))) {
                params.put("companyName", "资源中心");
                model.addAttribute("companyName", "资源中心");
            }
            params.put("currentTime",new Date());
            params.put("memberId",getMemberId());
            
            List<Map> projectDeliverys = projectService.queryProjectDelivery(params);
            model.addAttribute("sysAreasExpertises", sysAreasExpertises);
            model.addAttribute("sysGoodTypes", sysGoodTypes);
            model.addAttribute("projectDeliverys", projectDeliverys);
            //model.addAttribute("projectImports",projectImports);
            model.addAttribute("companyName", companyName);
            model.addAttribute("fieldId", fieldId);
            model.addAttribute("designTypeId", designTypeId);
            model.addAttribute("startOutputValue", req.getParameter("startOutputValue"));
            model.addAttribute("endOutputValue", req.getParameter("endOutputValue"));
            model.addAttribute("companyId", companyId);
            model.addAttribute("startDate", req.getParameter("startDate"));
            model.addAttribute("endDate", req.getParameter("endDate"));
        } catch (Exception e) {
            LOGGER.error(e.toString());
        }
        return "resCenter";
    }

    private <T> T getRelType(String str, Class<T> c) throws Exception {
        if (str == null || str.trim().equals("")) {
            return null;
        } else {
            if (c == Long.class) {
                return (T) Long.valueOf(str);
            } else if (c == Date.class) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                return (T) sdf.parse(str);
            } else if (c == Integer.class) {
                return (T) Integer.valueOf(str);
            } else if (c == Double.class) {
                return (T) Double.valueOf(str);
            }
        }
        return null;
    }

    @RequestMapping("about")
    public String about(Model model, HttpServletRequest req) {
        //立可设计
        OffiContent content1 = contentService.getContentByContentId(458L);
        List<OffiDesign> allDesign = designService.getAllOffiDesign();
        model.addAttribute("sheji", content1);
        model.addAttribute("designList", allDesign);
        //立可科技
        OffiContent content2 = contentService.getContentByContentId(925L);
        model.addAttribute("keji", content2);
        //立可空间
        OffiContent content3 = contentService.getContentByContentId(930L);
        model.addAttribute("kongjian", content3);

        return "aboutLike";
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

    @RequestMapping("join")
    public String join(Model model, HttpServletRequest req) {
        OffiContent content2 = contentService.getContentByContentId(1263L);
        model.addAttribute("join", content2);
        return "join";
    }
}
