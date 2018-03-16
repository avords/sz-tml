package com.parkdt.tml.service;

import com.parkdt.tml.domain.ProjectClaimRecord;
import com.parkdt.tml.domain.ProjectDelivery;
import com.parkdt.tml.domain.ProjectImporterInfo;
import com.parkdt.tml.domain.ProjectInformation;
import com.parkdt.tml.domain.ProjectInformationTemp;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/15.
 */
public interface ProjectService {
    List<ProjectInformation> getAllProject();

    List<ProjectInformation> getProjectByParam(Map<String, Object> params);
    
    List<Map> queryBySql(String sql, Map params);
    
    List<Map> queryProjectDelivery(Map params);
    
    ProjectDelivery getProjectDelivery(Long projectDeliveryId);

    boolean isClaimed(Long projectDeliveryId, Long memberId);

    void saveProjectClaimeRecord(ProjectClaimRecord projectClaimRecord);

    List<Map> queryProjectByMemberId(Long memberId);

    List<Map> queryProjectClaimByMemberId(Long memberId);

    List<Map> queryProjectList(Map params);
    
    Long getImportCompanyIdByMemberId(Long memberId);
    
    int saveProjectInformationTemp(ProjectInformationTemp projectInformationTemp);

    ProjectImporterInfo getImportInfoByMemberId(Long memberId);
}
