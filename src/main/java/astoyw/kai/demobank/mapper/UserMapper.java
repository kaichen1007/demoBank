package astoyw.kai.demobank.mapper;

import astoyw.kai.demobank.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author chenkai
* @description 针对表【user(用户信息表)】的数据库操作Mapper
* @createDate 2022-07-01 14:29:53
* @Entity astoyw.kai.demobank.model.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




