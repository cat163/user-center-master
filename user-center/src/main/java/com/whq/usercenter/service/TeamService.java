package com.whq.usercenter.service;

import com.whq.usercenter.model.domain.Team;
import com.baomidou.mybatisplus.extension.service.IService;
import com.whq.usercenter.model.domain.User;
import com.whq.usercenter.model.dto.TeamQuery;
import com.whq.usercenter.model.request.TeamJoinRequest;
import com.whq.usercenter.model.request.TeamQuitRequest;
import com.whq.usercenter.model.request.TeamUpdateRequest;
import com.whq.usercenter.model.vo.TeamUserVO;

import java.util.List;

/**
* @author 35029
* @description 针对表【team(队伍)】的数据库操作Service
* @createDate 2023-02-13 20:30:34
*/
public interface TeamService extends IService<Team> {

    /**
     * 创建队伍
     * @param team
     * @param loginUser
     * @return
     */
    long addTeam(Team team, User loginUser);

    /**
     * 搜索队伍
     * @param teamQuery
     * @param isAdmin
     * @return
     */
    List<TeamUserVO> listTeam(TeamQuery teamQuery, boolean isAdmin);

    /**
     * 更新队伍
     * @param teamUpdateRequest
     * @param loginUser
     * @return
     */
    boolean updateTeam(TeamUpdateRequest teamUpdateRequest, User loginUser);

    /**
     * 加入队伍
     * @param teamJoinRequest
     * @param loginUser
     * @return
     */
    boolean joinTeam(TeamJoinRequest teamJoinRequest, User loginUser);

    /**
     * 退出队伍
     * @param teamQuitRequest
     * @param loginUser
     * @return
     */
    boolean quitTeam(TeamQuitRequest teamQuitRequest, User loginUser);

    /**
     * 删除（解散）队伍
     * @param id
     * @param loginUser
     * @return
     */
    boolean deleteTeamById(long id, User loginUser);
}
