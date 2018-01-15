package com.parkdt.tml.service.impl;

import com.parkdt.tml.domain.ProjectInformation;
import com.parkdt.tml.mapper.ProjectInformationMapper;
import com.parkdt.tml.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/15.
 */
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectInformationMapper projectInformationMapper;
    @Override
    public List<ProjectInformation> getAllProject() {
        return projectInformationMapper.getAllProject();
    }

    @Override
    public List<ProjectInformation> getProjectByParam(Map<String, Object> params) {
        return projectInformationMapper.getProjectByParam(params);
    }
}
