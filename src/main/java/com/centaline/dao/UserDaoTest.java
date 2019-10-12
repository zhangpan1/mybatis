package com.centaline.dao;

import com.centaline.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * Created by zhangpan on 2019/10/11.
 */
public class UserDaoTest {
	private SqlSessionFactory factory;

	/**
	 * 在测试方法前 执行这个方法
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception{
		// 通过流 将核心配置文件读取进来
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 通过核心配置文件 输入流来创建会话工厂
		factory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	@Test
	public void testFindUserById() throws Exception{
		// 将初始化的工厂注入到实现类中
	/*	UserDao userDao = new UserDaoImpl(factory);
		User user = userDao.findUserById(1);
		System.out.println(user);*/
	}

}
