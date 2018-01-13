package com.parkdt.tml.service.impl;

import com.parkdt.tml.domain.OffiContent;
import com.parkdt.tml.mapper.OffiContentMapper;
import com.parkdt.tml.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("contentService")
@Transactional(value = "txManager1", rollbackFor = Exception.class)
public class ContentServiceImpl implements ContentService {

    @Autowired
    private OffiContentMapper OffiContentMapper;

    @Override
    public List<OffiContent> getContentByPartId(Long part_id) {
        return OffiContentMapper.getContentByPartId(part_id);
    }

    @Override
    public OffiContent getContentByContentId(Long id) {
        return OffiContentMapper.selectByPrimaryKey(id);
    }
}
