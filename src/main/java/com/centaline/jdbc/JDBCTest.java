package com.centaline.jdbc;



import java.sql.*;

/**
 * Created by zhangpan on 2019/10/10.
 * 1、加载数据库驱动
 * 2、创建并获取数据库链接
 * 3、创建jdbc statement对象
 * 4、设置sql语句
 * 5、设置sql语句中的参数(使用preparedStatement)
 * 6、通过statement执行sql并获取结果
 * 7、对sql执行结果进行解析处理
 * 8、释放资源(resultSet、preparedstatement、connection)
 */
public class JDBCTest {
	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			//加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");

			//通过驱动管理类获取数据库链接
			connection =  DriverManager.getConnection("jdbc:mysql://10.7.11.46:3306/mybatis?characterEncoding=utf-8", "root", "123456");
			//定义sql语句 ?表示占位符
			String sql = "select * from user where username = ?";
			//获取预处理statement
			preparedStatement = connection.prepareStatement(sql);
			//设置参数，第一个参数为sql语句中参数的序号（从1开始），第二个参数为设置的参数值
			preparedStatement.setString(1, "王五");
			//向数据库发出sql执行查询，查询出结果集
			resultSet =  preparedStatement.executeQuery();
			//遍历查询结果集
			while(resultSet.next()){
				System.out.println(resultSet.getString("id")+"  "+resultSet.getString("username"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//释放资源
			if(resultSet!=null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(preparedStatement!=null){
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(connection!=null){
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}
}
