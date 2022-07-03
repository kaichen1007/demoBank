package astoyw.kai.demobank.controller;

import astoyw.kai.demobank.request.UserReq;
import astoyw.kai.demobank.service.UserService;
import astoyw.kai.demobank.tools.JsonData;
import astoyw.kai.demobank.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author chenKai
 * @date 2022年07月01日 14:31
 */
@Api(tags = "用户控制类")
@RestController
@RequestMapping("/admin/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("得到用户全部列表")
    @GetMapping("/userList")
    public JsonData getList(){
        List<UserVO> userVOList = userService.getList();
        return JsonData.buildSuccess(userVOList);
    }

    @ApiOperation("添加用户")
    @PostMapping("save_user")
    public JsonData saveUser(@ApiParam(value = "用户实体类") @RequestBody UserReq userReq){
        JsonData jsonData = userService.save(userReq);
        return jsonData;

    }


}
