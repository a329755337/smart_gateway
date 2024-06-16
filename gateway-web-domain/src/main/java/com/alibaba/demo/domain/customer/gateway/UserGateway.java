package com.alibaba.demo.domain.customer.gateway;

import com.alibaba.demo.domain.customer.User;

public interface UserGateway {
    User getByById(String customerId,String str);

    User getByById(String userName);

}
