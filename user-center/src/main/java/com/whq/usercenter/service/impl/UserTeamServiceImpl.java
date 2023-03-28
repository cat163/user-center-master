package com.whq.usercenter.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.whq.usercenter.model.domain.UserTeam;
import com.whq.usercenter.service.UserTeamService;
import com.whq.usercenter.mapper.UserTeamMapper;
import org.springframework.stereotype.Service;

/**
* @author 35029
* @description 针对表【user_team(用户队伍关系)】的数据库操作Service实现
* @createDate 2023-02-13 20:32:16
*/
@Service
public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeam>
    implements UserTeamService{

}




