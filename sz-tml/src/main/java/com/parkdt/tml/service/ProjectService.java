package com.parkdt.tml.service;

import com.parkdt.tml.domain.ProjectInformation;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/1/15.
 */
public interface ProjectService {
    List<ProjectInformation> getAllProject();

    List<ProjectInformation> getProjectByParam(Map<String, Object> params);
}
