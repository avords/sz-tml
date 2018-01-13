package com.parkdt.tml.service;

import com.parkdt.tml.domain.OffiContent;

import java.util.List;

public interface ContentService {

    List<OffiContent> getContentByPartId(Long part_id);

    OffiContent getContentByContentId(Long id);

}
