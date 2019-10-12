package com.centaline;

import com.centaline.dao.UserDao;
import com.centaline.dao.UserDaoImpl;
import com.centaline.mapper.UserMapper;
import com.centaline.pojo.CustomOrders;
import com.centaline.pojo.Orders;
import com.centaline.pojo.QueryVO;
import com.centaline.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangpan on 2019/10/11.
 */
public class UserMapperTest {
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
		SqlSession openSession = factory.openSession();
		//通过getMapper方法来实例化接口
		UserMapper mapper = openSession.getMapper(UserMapper.class);

		User user = mapper.findUserById(1);
		System.out.println(user);
	}
	@Test
	public void testfindUserByUserName() throws Exception{
		// 将初始化的工厂注入到实现类中
		SqlSession openSession = factory.openSession();
		//通过getMapper方法来实例化接口
		UserMapper mapper = openSession.getMapper(UserMapper.class);

		List<User> users = mapper.findUserByUserName("王");
		System.out.println(users);
	}
	@Test
	public void testinsertUser() throws Exception{
		// 将初始化的工厂注入到实现类中
		SqlSession openSession = factory.openSession();
		//通过getMapper方法来实例化接口
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		User user = new User();
		user.setUsername("张.");
		user.setBirthday(new Date());
		user.setAddress("北京天安门");
		user.setSex("1");
		mapper.insertUser(user);
		openSession.commit();
	}

	@Test
	public void testfindUserByVo() throws Exception{
		// 将初始化的工厂注入到实现类中
		SqlSession openSession = factory.openSession();
		//通过getMapper方法来实例化接口
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		QueryVO queryVO = new QueryVO();
		User user = new User();
		user.setUsername("张.");
		user.setSex("1");
		queryVO.setUser(user);
		List<User> list = mapper.findUserByVo(queryVO);
		System.out.println(list);

	}
	@Test
	public void testfindUserCount() throws Exception{
		// 将初始化的工厂注入到实现类中
		SqlSession openSession = factory.openSession();
		//通过getMapper方法来实例化接口
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		Integer i = mapper.findUserCount();
		System.out.println(i);

	}
	@Test
	public void testfindUserByUserNameAndSex() throws Exception{
		// 将初始化的工厂注入到实现类中
		SqlSession openSession = factory.openSession();
		//通过getMapper方法来实例化接口
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		User user = new User();
		user.setUsername("王");
		user.setSex("1");
		List<User> userList = mapper.findUserByUserNameAndSex(user);
		System.out.println(userList);

	}
	@Test
	public void testfindUserByIds() throws Exception{
		// 将初始化的工厂注入到实现类中
		SqlSession openSession = factory.openSession();
		//通过getMapper方法来实例化接口
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		QueryVO vo = new QueryVO();
		List ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(2);
		ids.add(28);
		ids.add(22);
		vo.setIds(ids);
		List<User> userList = mapper.findUserByIds(vo);
		System.out.println(userList);

	}
	@Test
	public void testfindOrderAndUser1() throws Exception{
		// 将初始化的工厂注入到实现类中
		SqlSession openSession = factory.openSession();
		//通过getMapper方法来实例化接口
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		List<CustomOrders> customOrders = mapper.findOrderAndUser1();
		System.out.println(customOrders);

	}
	@Test
	public void testfindOrderAndUser2() throws Exception{
		// 将初始化的工厂注入到实现类中
		SqlSession openSession = factory.openSession();
		//通过getMapper方法来实例化接口
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		List<Orders> orders = mapper.findOrderAndUser2();
		System.out.println(orders);

	}
	@Test
	public void testfindUserAndOrders() throws Exception{
		// 将初始化的工厂注入到实现类中
		SqlSession openSession = factory.openSession();
		//通过getMapper方法来实例化接口
		UserMapper mapper = openSession.getMapper(UserMapper.class);
		List<User> users = mapper.findUserAndOrders();
		System.out.println(users);

	}
}
