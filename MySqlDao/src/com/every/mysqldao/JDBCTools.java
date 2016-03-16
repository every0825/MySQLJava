package com.every.mysqldao;

import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/**
 * 
 * @author Every
 * 数据库测打开关闭以及操作语句
 *
 */
public class JDBCTools
{
	//驱动、连接、数据库的用户名、密码
	public static String driver;
	public static String url;
	public static String name;
	public static String password;
	
	//数据库执行语句
	public static String insertSql = "insert into students(id,age,name,sex)values(?,?,?,?);"; //插入数据语句
	public static String deleteSql = "delete from students where id=?;";                      //删除id=？处的数据语句
	public static String updateSql = "update students set age=?,name=?,sex=? where id =?;";   //更新id=？处的数据语句
	public static String querySingalSql = "select * from students where id=?;";               //查询id=？处的数据语句 
	public static String queryallSql = "select * from students;";                             //查询所有数据语句

	static
	{
		Properties properties = new Properties();      //建立属性对象
		Reader reader;                                 //新建读对象
		try
		{
			reader = new FileReader("src\\config.propreties"); //将配置文件里的数据读出来
			properties.load(reader);                           //加载到属性中
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		driver = properties.getProperty("driver");            //这里的几个字段要用引号，这是配置文件中的字段
		url = properties.getProperty("url");
		name = properties.getProperty("name");
		password = properties.getProperty("password");
	}

	/*
	 * 加载数据库驱动，获取数据库连接
	 */
	public static Connection openDB()
	{
		try
		{
			Class.forName(driver);
			return DriverManager.getConnection(url, name, password);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
    /*
     * 关闭对应连接的数据库
     */
	public static void closeDB(Connection connection)
	{
		if (connection != null)
		{
			try
			{
				connection.close();
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}
