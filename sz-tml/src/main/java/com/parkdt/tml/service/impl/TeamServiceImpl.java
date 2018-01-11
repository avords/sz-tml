package com.parkdt.tml.service.impl;

import com.parkdt.tml.domain.TeamBasicInformation;
import com.parkdt.tml.domain.TeamMember;
import com.parkdt.tml.mapper.TeamBasicInformationMapper;
import com.parkdt.tml.mapper.TeamMemberMapper;
import com.parkdt.tml.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/1/11.
 */
@Service("teamService")
@Transactional(value = "txManager1", rollbackFor = Exception.class)
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamBasicInformationMapper teamBasicInformationMapper;
    @Autowired
    private TeamMemberMapper teamMemberMapper;
    @Override
    public List<TeamBasicInformation> getAllTeamBasicInfo() {
        return teamBasicInformationMapper.getAllTeamBasicInfo();
    }

    @Override
    public TeamMember getTeamMemberByMemberId(Long memberId) {
        return null;
    }

    @Override
    public int deleteTeamMemberByMemberId(Long memberId) {
        return 0;
    }

    @Override
    public void saveTeamMember(TeamMember teamMember) {

    }

    @Override
    public TeamBasicInformation getByTeamId(Long teamId) {
        return teamBasicInformationMapper.selectByPrimaryKey(teamId);
    }
}
