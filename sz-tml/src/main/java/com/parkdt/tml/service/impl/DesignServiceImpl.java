package com.parkdt.tml.service.impl;

import com.parkdt.tml.domain.OffiDesign;
import com.parkdt.tml.mapper.OffiDesignMapper;
import com.parkdt.tml.service.DesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("designService")
@Transactional(value = "txManager1", rollbackFor = Exception.class)
public class DesignServiceImpl implements DesignService {

    @Autowired
    private OffiDesignMapper offiDesignMapper;

    @Override
    public List<OffiDesign> getAllOffiDesign() {
        return offiDesignMapper.getAllOffiDesign();
    }
}
