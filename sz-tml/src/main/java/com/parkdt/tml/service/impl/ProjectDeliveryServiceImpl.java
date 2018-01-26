package com.parkdt.tml.service.impl;

import com.parkdt.tml.mapper.ProjectDeliveryMapper;
import com.parkdt.tml.service.ProjectDeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/1/26.
 */
@Service("projectDeliveryService")
public class ProjectDeliveryServiceImpl implements ProjectDeliveryService {
    @Autowired
    private ProjectDeliveryMapper projectDeliveryMapper;
    @Override
    public Integer updatePVById(Long id) {
        return projectDeliveryMapper.updatePVById(id);
    }

    @Override
    public Integer updateClaimeNumById(Long id) {
        return projectDeliveryMapper.updateClaimeNumById(id);
    }
}
