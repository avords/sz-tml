package com.parkdt.tml.service;

import com.parkdt.tml.domain.SysGoodType;

import java.util.List;

public interface SysGoodTypeService {

    List<SysGoodType> getAllSysGoodType();
    
    SysGoodType getById(Long id);
}
