package com.alibaba.demo.api;

import com.alibaba.demo.dto.data.UserDTO;


public interface UserServiceI  {
    UserDTO queryUser(String userName, String userName1);

    UserDTO queryUser(String userName);
}
