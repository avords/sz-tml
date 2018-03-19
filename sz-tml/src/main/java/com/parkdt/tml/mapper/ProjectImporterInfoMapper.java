package com.parkdt.tml.mapper;

import com.parkdt.tml.domain.ProjectImporterInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectImporterInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProjectImporterInfo record);

    int insertSelective(ProjectImporterInfo record);

    ProjectImporterInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProjectImporterInfo record);

    int updateByPrimaryKey(ProjectImporterInfo record);

    ProjectImporterInfo getImportCompanyIdByMemberId(Long memberId);

    List<ProjectImporterInfo> getImportInfoByCompanyId(Long companyId);
}