package com.parkdt.tml.service.impl;

import com.parkdt.tml.mapper.OffiBannerMapper;
import com.parkdt.tml.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("bannerService")
@Transactional(value = "txManager1", rollbackFor = Exception.class)
public class BannerServiceImpl implements BannerService {

    @Autowired
    private OffiBannerMapper offiBannerMapper;

}