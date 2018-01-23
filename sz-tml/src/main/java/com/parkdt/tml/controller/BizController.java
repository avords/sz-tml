package com.parkdt.tml.controller;

import com.parkdt.tml.consist.Constant;
import com.parkdt.tml.service.ProjectService;
import com.parkdt.tml.vo.ProjectBaseInformationVo;
import com.parkdt.tml.vo.ProjectClaimRecordVo;
import com.parkdt.tml.vo.ProjectDeliveryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by guojianhua on 2018/01/09.
 * <p>
 * 我参与的 我发布的
 */
@Controller
@RequestMapping(value = "/biz")
public class BizController extends BaseController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping("publish")
    public String publish(Model model, HttpServletRequest req) {

        Long memberId = getMemberId();

        List<ProjectBaseInformationVo> projectDeliverys = new ArrayList<>();
        //我发布的
        List<Map> deliveryMap = projectService.queryProjectByMemberId(memberId);

        for (Map<String, Object> m : deliveryMap) {

            ProjectBaseInformationVo baseInformationVo = new ProjectBaseInformationVo();

            String id = m.get("id").toString();
            String project_status = m.get("project_status").toString();
            String project_name = m.get("project_name").toString();

            baseInformationVo.setId(Long.parseLong(id));
            baseInformationVo.setProjectStatusStr(Constant.Project_status.getCnName(Integer.parseInt(project_status)));
            baseInformationVo.setProjectName(project_name);

            ProjectDeliveryVo deliveryVo = new ProjectDeliveryVo();

            String image = m.get("image") == null ? "" : m.get("image").toString();
            deliveryVo.setImage(image);
            baseInformationVo.setProjectDeliveryVo(deliveryVo);

            projectDeliverys.add(baseInformationVo);
        }

        model.addAttribute("projectDeliverys", projectDeliverys);
        return "publishList";
    }

    @RequestMapping("take")
    public String take(Model model, HttpServletRequest req) {

        Long memberId = getMemberId();

        //我参与的
        List<Map> ClaimMap = projectService.queryProjectClaimByMemberId(memberId);

        List<ProjectClaimRecordVo> claimRecordVos = new ArrayList<>();

        for (Map<String, Object> m : ClaimMap) {

            ProjectClaimRecordVo claimRecordVo = new ProjectClaimRecordVo();

            String id = m.get("id").toString();
            String status = m.get("status").toString();
            claimRecordVo.setId(Long.parseLong(id));
            claimRecordVo.setStatusStr(Constant.Claim_status.getCnName(Integer.parseInt(status)));

            ProjectDeliveryVo deliveryVo = new ProjectDeliveryVo();
            String image = m.get("image") == null ? "" : m.get("image").toString();
            deliveryVo.setImage(image);
            claimRecordVo.setProjectDeliveryVo(deliveryVo);

            ProjectBaseInformationVo baseInformationVo = new ProjectBaseInformationVo();
            String project_status = m.get("project_status").toString();
            String project_name = m.get("project_name").toString();

            baseInformationVo.setProjectStatusStr(Constant.Project_status.getCnName(Integer.parseInt(project_status)));
            baseInformationVo.setProjectName(project_name);
            claimRecordVo.getProjectDeliveryVo().setProjectBaseInformationVo(baseInformationVo);

            claimRecordVos.add(claimRecordVo);
        }

        model.addAttribute("projectClaims", claimRecordVos);
        return "takeList";
    }
}
