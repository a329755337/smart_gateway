package com.alibaba.demo.user;

import com.alibaba.cola.catchlog.CatchAndLog;
import com.alibaba.demo.api.UserServiceI;
import com.alibaba.demo.converter.UserConverter;
import com.alibaba.demo.domain.customer.User;
import com.alibaba.demo.domain.customer.gateway.UserGateway;
import com.alibaba.demo.dto.data.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserDTO user = queryUser(userName);
        List<GrantedAuthority> authorities = new ArrayList<>();
        if(user!=null){

            return new org.springframework.security.core.userdetails.User(
                    user.getUserName(),user.getUserPwd(),authorities);
        }else {
            throw new UsernameNotFoundException("用户名不存在");
        }
    }
}
