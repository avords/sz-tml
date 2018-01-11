package com.parkdt.tml.service;

import com.parkdt.tml.domain.TeamBasicInformation;
import com.parkdt.tml.domain.TeamMember;

import java.util.List;

/**
 * Created by Administrator on 2018/1/11.
 */
public interface TeamService {
    /**
     * 得到所有的团队信息
     * @return
     */
    List<TeamBasicInformation> getAllTeam();

    /**
     * 通过memberId得到所属团队
     * @param memberId
     * @return
     */
    TeamMember getTeamMemberByMemberId(Long memberId);

    /**
     * 通过memberId删除TeamMember
     * @param memberId
     * @return
     */
    int deleteTeamMemberByMemberId(Long memberId);

    /**
     * 保存所属团队
     * @param teamMember
     */
    void saveTeamMember(TeamMember teamMember);
}
