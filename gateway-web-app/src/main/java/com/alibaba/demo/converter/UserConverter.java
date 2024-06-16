package com.alibaba.demo.converter;

import com.alibaba.demo.domain.customer.User;
import com.alibaba.demo.dto.data.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class UserConverter  implements BaseConverter<User, UserDTO> {
}
