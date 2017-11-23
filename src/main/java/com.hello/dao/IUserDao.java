package com.hello.dao;

import com.hello.model.User;

/**
 * project helloSSM
 * authod wuyanhui
 * datetime 2017/11/23 16:17
 * desc
 */
public interface IUserDao {
    User selectUser(long id);
}
