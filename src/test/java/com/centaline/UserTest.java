package com.centaline;

import com.centaline.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangpan on 2019/10/10.
 */
public class UserTest {
	@Test
	public void testFindUserById() throws Exception{
		// 通过流 将核心配置文件读取进来
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 通过核心配置文件 输入流来创建会话工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂创建会话
		SqlSession openSession = factory.openSession();
		User user = openSession.selectOne("test.findUserById",1);
		System.out.println(user);
		openSession.close();
	}

	@Test
	public void testFindUserByUserName() throws Exception{
		// 通过流 将核心配置文件读取进来
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 通过核心配置文件 输入流来创建会话工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂创建会话
		SqlSession openSession = factory.openSession();
		List<User> userlist = openSession.selectList("test.findUserByUserName","王");
		System.out.println(userlist);
		openSession.close();
	}

	@Test
	public void testInsertUser() throws Exception{
		// 通过流 将核心配置文件读取进来
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 通过核心配置文件 输入流来创建会话工厂
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		// 通过工厂创建会话
		SqlSession openSession = factory.openSession();
		User user = new User();
		user.setUsername("赵四");
		user.setBirthday(new Date());
		user.setAddress("北京昌平");
		user.setSex("1");
		openSession.insert("test.insertUser",user);
		// 提交事务（Mybatis会自动开启事务，但是他不知道何时提交，所以需要手动提交事务）
		openSession.commit();
		openSession.close();
	}

}
