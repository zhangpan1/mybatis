package com.centaline;

import com.centaline.dao.UserDao;
import com.centaline.mapper.UserMapper;
import com.centaline.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhangpan on 2019/10/12.
 */
public class SpringTest2 {
	private ApplicationContext applicationContext;
	@Before
	public void setUp(){
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@Test
	public void testFindUserById(){
		// 获取UserDao对象，getBean中的字符串 实在ApplicationContext.xml中 声明的
		UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
		User user = userMapper.findUserById(1);
		System.out.println(user);

	}

}
