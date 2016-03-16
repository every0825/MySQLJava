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
 * ���ݿ��򿪹ر��Լ��������
 *
 */
public class JDBCTools
{
	//���������ӡ����ݿ���û���������
	public static String driver;
	public static String url;
	public static String name;
	public static String password;
	
	//���ݿ�ִ�����
	public static String insertSql = "insert into students(id,age,name,sex)values(?,?,?,?);"; //�����������
	public static String deleteSql = "delete from students where id=?;";                      //ɾ��id=�������������
	public static String updateSql = "update students set age=?,name=?,sex=? where id =?;";   //����id=�������������
	public static String querySingalSql = "select * from students where id=?;";               //��ѯid=������������� 
	public static String queryallSql = "select * from students;";                             //��ѯ�����������

	static
	{
		Properties properties = new Properties();      //�������Զ���
		Reader reader;                                 //�½�������
		try
		{
			reader = new FileReader("src\\config.propreties"); //�������ļ�������ݶ�����
			properties.load(reader);                           //���ص�������
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		driver = properties.getProperty("driver");            //����ļ����ֶ�Ҫ�����ţ����������ļ��е��ֶ�
		url = properties.getProperty("url");
		name = properties.getProperty("name");
		password = properties.getProperty("password");
	}

	/*
	 * �������ݿ���������ȡ���ݿ�����
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
     * �رն�Ӧ���ӵ����ݿ�
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
