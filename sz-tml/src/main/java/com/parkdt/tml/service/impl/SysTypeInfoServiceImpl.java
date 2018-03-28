package com.parkdt.tml.service.impl;

import com.parkdt.tml.domain.SysTypeInfo;
import com.parkdt.tml.mapper.SysTypeInfoMapper;
import com.parkdt.tml.service.SysTypeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/1/25.
 */
@Service("sysTypeInfoService")
public class SysTypeInfoServiceImpl implements SysTypeInfoService {
    @Autowired
    private SysTypeInfoMapper sysTypeInfoMapper;
    @Override
    public List<SysTypeInfo> getByTypeId(Long typeId) {
        return sysTypeInfoMapper.getByTypeId(typeId);
    }

    @Override
    public SysTypeInfo getById(Long id) {
        return sysTypeInfoMapper.selectByPrimaryKey(id);
    }
}
