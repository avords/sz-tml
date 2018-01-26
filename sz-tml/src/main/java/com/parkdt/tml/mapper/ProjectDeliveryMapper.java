package com.parkdt.tml.mapper;

import com.parkdt.tml.domain.ProjectDelivery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProjectDeliveryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProjectDelivery record);

    int insertSelective(ProjectDelivery record);

    ProjectDelivery selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProjectDelivery record);

    int updateByPrimaryKey(ProjectDelivery record);

    List<Map> queryProjectDelivery(Map params);

    Integer updatePVById(Long id);
    
    Integer updateClaimeNumById(Long id);
}