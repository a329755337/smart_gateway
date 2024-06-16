package com.alibaba.demo.user;


import com.alibaba.demo.converter.UserDOConverter;
import com.alibaba.demo.domain.customer.User;
import com.alibaba.demo.domain.customer.gateway.UserGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
public class UserGatewayImpl implements UserGateway {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDOConverter userDOConverter;
    public User getByById(String customerId,String str){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(customerId).andUserPwdEqualTo(str);
        List<UserDO> userDOS = userMapper.selectByExample(userExample);
        if (CollectionUtils.isEmpty(userDOS)){
            return null;
        }
        User user = userDOConverter.do2dto(userDOS.get(0));
        return user;
    }

    @Override
    public User getByById(String userName) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserNameEqualTo(userName);
        List<UserDO> userDOS = userMapper.selectByExample(userExample);
        if (CollectionUtils.isEmpty(userDOS)){
            return null;
        }
        User user = userDOConverter.do2dto(userDOS.get(0));
        return user;
    }
}
