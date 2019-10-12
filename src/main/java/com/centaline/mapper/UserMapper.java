package com.centaline.mapper;

import com.centaline.pojo.CustomOrders;
import com.centaline.pojo.Orders;
import com.centaline.pojo.QueryVO;
import com.centaline.pojo.User;

import java.util.List;

/**
 * Created by zhangpan on 2019/10/11.
 */
public interface UserMapper {
	public User findUserById(Integer id);
	// 动态代理形式中，如果返回结果集为List,那么mabatis会在生成实现类的时候，会自动调用selectList方法
	public List<User> findUserByUserName(String name);

	public void insertUser(User user);

	public List<User> findUserByVo(QueryVO queryVO);

	public Integer findUserCount();

	public List<User> findUserByUserNameAndSex(User user);

	public List<User> findUserByIds(QueryVO queryVO);

	public List<CustomOrders> findOrderAndUser1();

	public List<Orders> findOrderAndUser2();

	public List<User> findUserAndOrders();

}
