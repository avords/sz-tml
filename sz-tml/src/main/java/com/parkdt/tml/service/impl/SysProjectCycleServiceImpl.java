package com.parkdt.tml.service.impl;

import com.parkdt.tml.domain.SysProjectCycle;
import com.parkdt.tml.mapper.SysProjectCycleMapper;
import com.parkdt.tml.service.SysProjectCycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2018/1/25.
 */
@Service("sysProjectCycleService")
public class SysProjectCycleServiceImpl implements SysProjectCycleService {
    @Autowired
    private SysProjectCycleMapper sysProjectCycleMapper;
    @Override
    public List<SysProjectCycle> getAll() {
        return sysProjectCycleMapper.getAll();
    }
}
