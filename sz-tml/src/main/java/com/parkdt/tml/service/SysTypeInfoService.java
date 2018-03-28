package com.parkdt.tml.service;

import com.parkdt.tml.domain.SysTypeInfo;

import java.util.List;

/**
 * Created by Administrator on 2018/1/25.
 */
public interface SysTypeInfoService {
    List<SysTypeInfo> getByTypeId(Long typeId);
    
    SysTypeInfo getById(Long id);
}
