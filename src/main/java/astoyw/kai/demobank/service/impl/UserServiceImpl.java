package astoyw.kai.demobank.service.impl;

import astoyw.kai.demobank.request.UserReq;
import astoyw.kai.demobank.tools.CommonUtil;
import astoyw.kai.demobank.tools.JsonData;
import astoyw.kai.demobank.vo.UserVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import astoyw.kai.demobank.model.User;
import astoyw.kai.demobank.service.UserService;
import astoyw.kai.demobank.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author chenkai
* @description 针对表【user(用户信息表)】的数据库操作Service实现
* @createDate 2022-07-01 14:29:53
*/
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;


    /**
     * 拿到用户全部列表
     * @return
     */
    @Override
    public List<UserVO> getList() {
        List<User> userList = userMapper.selectList(new QueryWrapper<User>()
                .lambda()
                .eq(User::getDelFlag, 0)
                .orderByDesc(User::getCreateTime));

        List<UserVO> userVOList = userList.stream().map(obj -> {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(obj, userVO);
            return userVO;
        }).collect(Collectors.toList());
        return userVOList;
    }

    @Override
    public JsonData save(UserReq userReq) {
        User user = new User();
        BeanUtils.copyProperties(userReq,user);
        String uuid = CommonUtil.generateUUID();
        user.setUuid(uuid);
        user.setCreateUserUuid(uuid);
        user.setCreateTime(new Date());
        user.setLastUpdateUserUuid(uuid);
        user.setLastUpdateTime(new Date());
        user.setDelFlag(0);
        int insert = userMapper.insert(user);
        if (insert == 1){
            return JsonData.buildSuccess();
        }
        return JsonData.buildCodeAndMsg(-1,"添加用户失败");
    }
}




