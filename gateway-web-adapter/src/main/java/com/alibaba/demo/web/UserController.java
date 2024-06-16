package com.alibaba.demo.web;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.demo.api.UserServiceI;
import com.alibaba.demo.dto.data.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class UserController {



    @Autowired
    private UserServiceI userServiceI;

    @RequestMapping("getUser")
    public MultiResponse<UserDTO> queryUser(@RequestParam("userName") String userName, @RequestParam("userPwd")String userPwd){
      UserDTO userDTO =  userServiceI.queryUser(userName,userPwd);

      return MultiResponse.of(Arrays.asList(userDTO));
    }
}
