package com.alibaba.demo.user;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.demo.api.UserServiceI;
import com.alibaba.demo.converter.UserConverter;
import com.alibaba.demo.domain.customer.User;
import com.alibaba.demo.domain.customer.gateway.UserGateway;
import com.alibaba.demo.dto.data.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;



@Service
@CatchAndLog
public class UserServiceImpl implements UserServiceI {

    @Autowired
    private UserGateway userGateway;

    @Autowired
    private UserConverter userConverter;
    @Override
    public UserDTO queryUser(String userName, String userName1) {
        User byById = userGateway.getByById(userName, userName1);
        if (ObjectUtils.isEmpty(byById)){
            return new UserDTO();
        }
        UserDTO userDTO = userConverter.do2dto(byById);
        return userDTO;
    }

    @Override
    public UserDTO queryUser(String userName) {
        User byById = userGateway.getByById(userName);
        if (ObjectUtils.isEmpty(byById)){
            return new UserDTO();
        }
        UserDTO userDTO = userConverter.do2dto(byById);
        return userDTO;
    }
}