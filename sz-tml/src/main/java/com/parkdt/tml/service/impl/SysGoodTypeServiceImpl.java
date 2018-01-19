package com.parkdt.tml.service.impl;

import com.parkdt.tml.domain.SysGoodType;
import com.parkdt.tml.mapper.SysGoodTypeMapper;
import com.parkdt.tml.service.SysGoodTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("sysGoodTypeService")
@Transactional(value = "txManager1", rollbackFor = Exception.class)
public class SysGoodTypeServiceImpl implements SysGoodTypeService {

    @Autowired
    private SysGoodTypeMapper sysGoodTypeMapper;

    @Override
    public List<SysGoodType> getAllSysGoodType() {
        return sysGoodTypeMapper.getAllSysGoodType();
    }

    @Override
    public SysGoodType getById(Long id) {
        return sysGoodTypeMapper.selectByPrimaryKey(id);
    }
}
