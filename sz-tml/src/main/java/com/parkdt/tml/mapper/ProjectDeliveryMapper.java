package com.parkdt.tml.mapper;

import com.parkdt.tml.domain.ProjectDelivery;

public interface ProjectDeliveryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProjectDelivery record);

    int insertSelective(ProjectDelivery record);

    ProjectDelivery selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProjectDelivery record);

    int updateByPrimaryKey(ProjectDelivery record);
}