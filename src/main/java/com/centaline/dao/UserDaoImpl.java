package com.centaline.dao;

import com.centaline.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * Created by zhangpan on 2019/10/11.
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {
	@Override
	public User findUserById(Integer id) {
		//sqlSesion是线程不安全的,所以它的最佳使用范围在方法体内
		SqlSession openSession = this.getSqlSession();
		User user = openSession.selectOne("test.findUserById", id);
		//整合后会话归spring管理,所以不需要手动关闭.
		//openSession.close();
		return user;
	}

	@Override
	public User findUserByUserName(String name) {
		// sqlSession 是线程不安全的额，所以它是线程不安全的，所以它的最佳使用范围在方法体内
		SqlSession openSession = this.getSqlSession();
		User user = openSession.selectOne("test.findUserByUserName",name);
		return user;
	}
}
