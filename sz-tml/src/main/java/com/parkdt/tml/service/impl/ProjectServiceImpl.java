package com.parkdt.tml.service.impl;

import com.parkdt.tml.domain.ProjectAnnex;
import com.parkdt.tml.domain.ProjectClaimRecord;
import com.parkdt.tml.domain.ProjectDelivery;
import com.parkdt.tml.domain.ProjectImporterInfo;
import com.parkdt.tml.domain.ProjectInformation;
import com.parkdt.tml.domain.ProjectInformationTemp;
import com.parkdt.tml.domain.ProjectModule;
import com.parkdt.tml.domain.SysGoodType;
import com.parkdt.tml.domain.SysTypeInfo;
import com.parkdt.tml.mapper.*;
import com.parkdt.tml.service.ProjectService;
import com.parkdt.tml.service.SysGoodTypeService;
import com.parkdt.tml.service.SysTypeInfoService;
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
    private ProjectBaseInformationMapper projectBaseInformationMapper;
    @Autowired
    private ProjectInformationMapper projectInformationMapper;
    @Autowired
    private ProjectDeliveryMapper projectDeliveryMapper;
    @Autowired
    private ProjectModuleMapper projectModuleMapper;
    @Autowired
    private ProjectAnnexMapper projectAnnexMapper;
    @Autowired
    private SysGoodTypeService sysGoodTypeService;
    @Autowired
    private ProjectClaimRecordMapper projectClaimRecordMapper;
    @Autowired
    private ProjectImporterInfoMapper projectImporterInfoMapper;
    @Autowired
    private ProjectInformationTempMapper projectInformationTempMapper;
    @Autowired
    private SysTypeInfoService sysTypeInfoService;

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
        if (params == null) {
            params = new HashMap<String, Object>();
        }
        params.put("sql", sql);
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
        if (type == 0) {//一级项目
            projectInformation = projectInformationMapper.selectByPrimaryKey(objectId);
        } else if (type == 1) {//二级项目
            ProjectModule projectModule = projectModuleMapper.selectByPrimaryKey(objectId);
            Long projectId = projectModule.getProjectId();
            projectInformation = projectInformationMapper.selectByPrimaryKey(projectId);
        }
        if (projectInformation != null) {
            //得到项目附件
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("projectId", projectInformation.getId());
            List<ProjectAnnex> projectAnnexes = projectAnnexMapper.selectByParams(params);
            projectInformation.setProjectAnnexes(projectAnnexes);
            projectDelivery.setProjectInformation(projectInformation);
            //得到项目类型
            SysGoodType sysGoodType = sysGoodTypeService.getById(projectInformation.getDesignTypeId());
            SysTypeInfo acquisitionType = sysTypeInfoService.getById(projectInformation.getAcquisitionTypeId());
            projectInformation.setAcquisitionType(acquisitionType);
            projectInformation.setSysGoodType(sysGoodType);
        }
        return projectDelivery;
    }

    @Override
    public boolean isClaimed(Long projectDeliveryId, Long memberId) {
        Map map = new HashMap();
        map.put("projectDeliveryId", projectDeliveryId);
        map.put("memberId", memberId);
        Long count = projectClaimRecordMapper.getCountByParam(map);
        return count > 0 ? true : false;
    }

    @Override
    public void saveProjectClaimeRecord(ProjectClaimRecord projectClaimRecord) {
        projectClaimRecordMapper.insertSelective(projectClaimRecord);
    }

    @Override
    public List<Map> queryProjectByMemberId(Long memberId) {
        return projectBaseInformationMapper.queryProjectByMemberId(memberId);
    }

    @Override
    public List<Map> queryProjectClaimByMemberId(Long memberId) {
        return projectClaimRecordMapper.queryProjectClaimByMemberId(memberId);
    }

    @Override
    public List<Map> queryProjectList(Map params) {
        return projectInformationMapper.queryProjectList(params);
    }

    @Override
    public Long getImportCompanyIdByMemberId(Long memberId) {
        ProjectImporterInfo projectImporterInfo = projectImporterInfoMapper.getImportCompanyIdByMemberId(memberId);
        if(projectImporterInfo!=null){
            return projectImporterInfo.getCompanyId();
        }
        return null;
    }

    @Override
    public int saveProjectInformationTemp(ProjectInformationTemp projectInformationTemp) {
        return projectInformationTempMapper.insertSelective(projectInformationTemp);
    }

    @Override
    public ProjectImporterInfo getImportInfoByCompanyId(Long companyId) {
        List<ProjectImporterInfo> projectImporterInfos = projectImporterInfoMapper.getImportInfoByCompanyId(companyId);
        if(projectImporterInfos!=null&&projectImporterInfos.size()>0){
            return projectImporterInfos.get(0);
        }
        return null;
    }


}
