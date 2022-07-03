package astoyw.kai.demobank.service;

import astoyw.kai.demobank.model.User;
import astoyw.kai.demobank.request.UserReq;
import astoyw.kai.demobank.tools.JsonData;
import astoyw.kai.demobank.vo.UserVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author chenkai
* @description 针对表【user(用户信息表)】的数据库操作Service
* @createDate 2022-07-01 14:29:53
*/
public interface UserService{

    /**
     * 拿到用户全部列表
     * @return
     */
    List<UserVO> getList();

    /**
     * 添加用户
     * @param userReq
     * @return
     */
    JsonData save(UserReq userReq);
}
