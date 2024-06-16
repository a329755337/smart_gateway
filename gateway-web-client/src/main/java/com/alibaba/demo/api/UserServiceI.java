package com.alibaba.demo.api;

import com.alibaba.demo.dto.data.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserServiceI  extends UserDetailsService {
    UserDTO queryUser(String userName, String userName1);

    UserDTO queryUser(String userName);
}
