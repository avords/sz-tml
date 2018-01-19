package com.parkdt.tml.service.impl;

import com.parkdt.tml.domain.ProjectAnnex;
import com.parkdt.tml.domain.ProjectDelivery;
import com.parkdt.tml.domain.ProjectInformation;
import com.parkdt.tml.domain.ProjectModule;
import com.parkdt.tml.mapper.ProjectAnnexMapper;
import com.parkdt.tml.mapper.ProjectDeliveryMapper;
import com.parkdt.tml.mapper.ProjectInformationMapper;
import com.parkdt.tml.mapper.ProjectModuleMapper;
import com.parkdt.tml.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/15.
 */
@Service("projectService")
@Transactional(value = "txManager1", rollbackFor = Exception.class)
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectInformationMapper projectInformationMapper;
    @Autowired
    private ProjectDeliveryMapper projectDeliveryMapper;
    @Autowired
    private ProjectModuleMapper projectModuleMapper;
    @Autowired
    private ProjectAnnexMapper projectAnnexMapper;
    @Override
    public List<ProjectInformation> getAllProject() {
        return projectInformationMapper.getAllProject();
    }

    @Override
    public List<ProjectInformation> getProjectByParam(Map<String, Object> params) {
        return projectInformationMapper.getProjectByParam(params);
    }

    @Override
    public List<Map> queryBySql(String sql, Map params) {
        if(params==null){
            params = new HashMap<String,Object>();
        }
        params.put("sql",sql);
        return projectInformationMapper.queryBySql(params);
    }

    @Override
    public List<Map> queryProjectDelivery(Map params) {
        return projectDeliveryMapper.queryProjectDelivery(params);
    }

    @Override
    public ProjectDelivery getProjectDelivery(Long projectDeliveryId) {
        ProjectDelivery projectDelivery = projectDeliveryMapper.selectByPrimaryKey(projectDeliveryId);
        Short type = projectDelivery.getType();
        Long objectId = projectDelivery.getObjectId();
        ProjectInformation projectInformation = null;
        if(type==0){//一级项目
            projectInformation = projectInformationMapper.selectByPrimaryKey(objectId);
        }else if(type==1){//二级项目
            ProjectModule projectModule = projectModuleMapper.selectByPrimaryKey(objectId);
            Long projectId = projectModule.getProjectId();
            projectInformation = projectInformationMapper.selectByPrimaryKey(projectId);
        }
        if(projectInformation!=null) {
            //得到项目附件
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("projectId", projectInformation.getId());
            List<ProjectAnnex> projectAnnexes = projectAnnexMapper.selectByParams(params);
            projectInformation.setProjectAnnexes(projectAnnexes);
            projectDelivery.setProjectInformation(projectInformation);
        }
        return projectDelivery;
    }
}
