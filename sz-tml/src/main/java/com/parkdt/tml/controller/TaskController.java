package com.parkdt.tml.controller;

import com.parkdt.tml.domain.PersonalLoginInfo;
import com.parkdt.tml.domain.ProjectClaimRecord;
import com.parkdt.tml.domain.ProjectDelivery;
import com.parkdt.tml.domain.SysAreasExpertise;
import com.parkdt.tml.domain.SysCity;
import com.parkdt.tml.domain.SysGoodType;
import com.parkdt.tml.service.ProjectService;
import com.parkdt.tml.service.SysAreasExpertiseService;
import com.parkdt.tml.service.SysCityService;
import com.parkdt.tml.service.SysGoodTypeService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guojianhua on 2018/01/09.
 *
 * 任务发布 任务报名 任务报名详情页
 */
@Controller
@RequestMapping(value = "/task")
public class TaskController extends BaseController{
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskController.class);
    @Autowired
    private ProjectService projectService;
    @Autowired
    private SysGoodTypeService sysGoodTypeService;
    @Autowired
    private SysAreasExpertiseService sysAreasExpertiseService;
    @Autowired
    private SysCityService sysCityService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }
    
    @RequestMapping("publish")
    public String publish(Model model, HttpServletRequest req) {
        Map<String, Object> params = new HashMap<>();
        params.put("memberId",getMemberId());
        //得到所有类型
        List<SysGoodType> sysGoodTypes = sysGoodTypeService.getAllSysGoodType();
        List<SysCity> provinces = sysCityService.getAllProvince();
        List<SysCity> citys = new ArrayList<>();
        model.addAttribute("sysGoodTypes",sysGoodTypes);
        model.addAttribute("provinces",provinces);
        model.addAttribute("citys",citys);
        List<Map> projectInformations = new ArrayList<>();
        try {
            Long designTypeId = getRelType(req.getParameter("designTypeId"),Long.class);
            Long provinceId = getRelType(req.getParameter("provinceId"),Long.class);
            Long cityId = getRelType(req.getParameter("cityId"),Long.class);
            if(provinceId!=null){
                citys = sysCityService.getAllCityByProvinceId(provinceId);
                model.addAttribute("citys",citys);
            }
            String projectName = req.getParameter("projectName");
            if(designTypeId!=null){
                params.put("designTypeId",designTypeId);
            }
            if(StringUtils.isNotBlank(projectName)){
                params.put("projectName",projectName);
            }
            if(provinceId!=null){
                params.put("provinceId",provinceId);
            }
            if(provinceId!=null){
                params.put("cityId",cityId);
            }
            
            projectInformations = projectService.queryProjectList(params);
            
            model.addAttribute("designTypeId", StringUtils.isNotBlank(req.getParameter("designTypeId"))?Long.valueOf(req.getParameter("designTypeId")):null);
            model.addAttribute("projectName",req.getParameter("projectName"));
            model.addAttribute("provinceId",provinceId);
            model.addAttribute("cityId",cityId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addAttribute("projectInformations",projectInformations);
        return "taskPublishList";
    }
    @RequestMapping("createPublish")
    public String createPublish(Model model, HttpServletRequest req) {

        Long memberId = getMemberId();
        return "createPublish";
    }

    @RequestMapping("enter")
    public String enter(Model model, HttpServletRequest req) {
        PersonalLoginInfo user = (PersonalLoginInfo) req.getSession().getAttribute("user");
        if(user==null||user.getRoleId()!=2){
            return "redirect:/auth/myPublish";
        }
        //得到所有领域
        List<SysAreasExpertise> sysAreasExpertises = sysAreasExpertiseService.getAllSysAreasExpertise();
        //得到所有类型
        List<SysGoodType> sysGoodTypes = sysGoodTypeService.getAllSysGoodType();
        //得到所有的项目导入方
        List<Map> projectImports = projectService.queryBySql("select distinct company_id,company_name from t_project_importer_info",null);
        try {
            Date startDate = getRelType(req.getParameter("startDate"), Date.class);
            Date endDate = getRelType(req.getParameter("endDate"), Date.class);
            boolean isOne = false;
            String oneStr = req.getParameter("oneStr");
            if(oneStr==null||"".equals(oneStr)){
                oneStr = "1";
            }
            if("1".equals(oneStr)){
                isOne = true;
            }
            model.addAttribute("oneStr",oneStr);
            Long fieldId = getRelType(req.getParameter("fieldId"),Long.class);
            Long designTypeId = getRelType(req.getParameter("designTypeId"),Long.class);
            Double startOutputValue = getRelType(req.getParameter("startOutputValue"),Double.class);
            Double endOutputValue = getRelType(req.getParameter("endOutputValue"),Double.class);
            Long companyId = getRelType(req.getParameter("companyId"),Long.class);
            
            Map params = new HashMap();
            params.put("startDate",startDate);
            params.put("endDate",endDate);
            params.put("isOne",isOne);
            params.put("fieldId",fieldId);
            params.put("designTypeId",designTypeId);
            params.put("startOutputValue",startOutputValue);
            params.put("endOutputValue",endOutputValue);
            params.put("companyId",companyId);
            List<Map> projectDeliverys = projectService.queryProjectDelivery(params);
            model.addAttribute("sysAreasExpertises",sysAreasExpertises);
            model.addAttribute("sysGoodTypes",sysGoodTypes);
            model.addAttribute("projectDeliverys",projectDeliverys);
            model.addAttribute("projectImports",projectImports);
            
            model.addAttribute("fieldId", fieldId);
            model.addAttribute("designTypeId", designTypeId);
            model.addAttribute("startOutputValue",req.getParameter("startOutputValue"));
            model.addAttribute("endOutputValue",req.getParameter("endOutputValue"));
            model.addAttribute("companyId",companyId);
            model.addAttribute("startDate",req.getParameter("startDate"));
            model.addAttribute("endDate",req.getParameter("endDate"));
        }catch (Exception e){
            LOGGER.error(e.toString());
        }
        return "taskEnter";
    }

    @RequestMapping("detail/{projectDeliveryId}")
    public String taskDetail(Model model, HttpServletRequest req, @PathVariable Long projectDeliveryId) {

        Long memberId = getMemberId();

        ProjectDelivery projectDelivery = projectService.getProjectDelivery(projectDeliveryId);
        model.addAttribute("projectDelivery",projectDelivery);
        return "taskEnterDetail";
    }
    @RequestMapping("saveClaime")
    public String saveClaime(ProjectClaimRecord projectClaimRecord,Model model, HttpServletRequest req) {

        //判断此人是否认领
        Long memberId=getMemberId();
        projectClaimRecord.setMemberId(memberId);
        projectClaimRecord.setCreateTime(new Date());
        projectClaimRecord.setStatus((short) 0);
        boolean isClaimed = projectService.isClaimed(projectClaimRecord.getProjectDeliveryId(),memberId);
        //保存认领记录
        if(!isClaimed){
            projectService.saveProjectClaimeRecord(projectClaimRecord);   
        }
        return "redirect:/task/detail/"+projectClaimRecord.getProjectDeliveryId();
    }
    @RequestMapping("getCitys")
    @ResponseBody
    public List<SysCity> getCitys(ProjectClaimRecord projectClaimRecord,Model model, HttpServletRequest req) {
        String provinceIdStr = req.getParameter("provinceId");
        if(StringUtils.isBlank(provinceIdStr)){
            return new ArrayList<>();
        }
        return sysCityService.getAllCityByProvinceId(Long.valueOf(provinceIdStr));
    }
    
    private <T> T getRelType(String str,Class<T> c) throws Exception {
        if(str==null||str.trim().equals("")){
            return null;
        }else{
            if(c==Long.class){
                return (T) Long.valueOf(str);
            }else if(c==Date.class){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                return (T) sdf.parse(str);
            }else if(c==Integer.class){
                return (T) Integer.valueOf(str);
            }else if(c==Double.class){
                return (T) Double.valueOf(str);
            }
        }
        return null;
    }
}
