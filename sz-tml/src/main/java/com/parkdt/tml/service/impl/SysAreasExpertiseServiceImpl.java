package com.parkdt.tml.service.impl;

import com.parkdt.tml.domain.SysAreasExpertise;
import com.parkdt.tml.domain.SysGoodType;
import com.parkdt.tml.mapper.SysAreasExpertiseMapper;
import com.parkdt.tml.service.SysAreasExpertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("sysAreasExpertiseService")
@Transactional(value = "txManager1", rollbackFor = Exception.class)
public class SysAreasExpertiseServiceImpl implements SysAreasExpertiseService {

    @Autowired
    private SysAreasExpertiseMapper sysAreasExpertiseMapper;

    @Override
    public List<SysAreasExpertise> getAllSysAreasExpertise() {
        return sysAreasExpertiseMapper.getAllSysAreasExpertise();
    }
}
