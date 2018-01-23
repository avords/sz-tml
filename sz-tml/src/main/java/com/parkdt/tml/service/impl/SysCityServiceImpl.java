package com.parkdt.tml.service.impl;

import com.parkdt.tml.domain.SysCity;
import com.parkdt.tml.mapper.SysCityMapper;
import com.parkdt.tml.service.SysCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/1/23.
 */
@Service("sysCityService")
public class SysCityServiceImpl implements SysCityService {
    @Autowired
    private SysCityMapper sysCityMapper;
    @Override
    public List<SysCity> getAllProvince() {
        return sysCityMapper.getAllProvince();
    }

    @Override
    public List<SysCity> getAllCityByProvinceId(Long provinceId) {
        return sysCityMapper.getAllCityByProvinceId(provinceId);
    }
}
