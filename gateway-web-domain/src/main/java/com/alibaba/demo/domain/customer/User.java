package com.alibaba.demo.domain.customer;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private Integer id;


    private String userName;


    private String userPwd;


    private String email;


    private String englishName;


    private String chineseName;


    private Date birthday;


    private String gender;

    private Date createdTime;


    private Date updatedTime;


    private Integer isDelete;


    private Integer roleId;

    private Integer departmentId;


    private String jobTitle;
}
