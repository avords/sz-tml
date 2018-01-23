package com.parkdt.tml.service;

import com.parkdt.tml.domain.SysCity;

import java.util.List;

/**
 * Created by Administrator on 2018/1/23.
 */
public interface SysCityService {
    List<SysCity> getAllProvince();
    List<SysCity> getAllCityByProvinceId(Long provinceId);
}
