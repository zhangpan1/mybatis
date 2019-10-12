package com.centaline.dao;

import com.centaline.pojo.User;

/**
 * Created by zhangpan on 2019/10/11.
 */
public interface UserDao {
	public User findUserById(Integer id);
	public User findUserByUserName(String name);
}
