package com.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.demo.entity.User;
import com.demo.service.UserService;
import com.demo.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author janey
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-11-11 23:21:37
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




