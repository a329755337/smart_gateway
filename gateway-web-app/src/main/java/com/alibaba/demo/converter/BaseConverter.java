package com.alibaba.demo.converter;

public interface BaseConverter <DO,DTO>{

    DTO do2dto(DO param);
}
