package com.every.mysqldao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * ���ݿ������ɾ���� ����ķ���
 * @author Every
 *
 */
public class ImplementSqlInterface implements SqlInterface
{
	/*
	 * (non-Javadoc)
	 * @see com.every.mysqldao.SqlInterface#insertData(com.every.mysqldao.Students)
	 * ��������
	 */
	@Override
	public void insertData(Students students)
	{
		Connection connection = JDBCTools.openDB();
		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(JDBCTools.insertSql);
			preparedStatement.setLong(1, students.getId());
			preparedStatement.setInt(2, students.getAge());
			preparedStatement.setString(3, students.getName());
			preparedStatement.setString(4, students.getSex());
			preparedStatement.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCTools.closeDB(connection);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.every.mysqldao.SqlInterface#deleteDataById(long)
	 * ɾ������
	 */
	@Override
	public void deleteDataById(long id)
	{
		Connection connection = JDBCTools.openDB();
		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(JDBCTools.deleteSql);
			preparedStatement.setLong(1, id);
			preparedStatement.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCTools.closeDB(connection);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.every.mysqldao.SqlInterface#updateData(com.every.mysqldao.Students)
	 * ��������
	 */
	@Override
	public void updateData(Students students)
	{
		Connection connection = JDBCTools.openDB();
		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(JDBCTools.updateSql);
			preparedStatement.setLong(4, students.getId());
			preparedStatement.setInt(1, students.getAge());
			preparedStatement.setString(2, students.getName());
			preparedStatement.setString(3, students.getSex());
			preparedStatement.executeUpdate();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCTools.closeDB(connection);
		}
	}
/*
 * (non-Javadoc)
 * @see com.every.mysqldao.SqlInterface#querySingalDataById(long)
 * ��ѯ��������
 */
	@Override
	public Students querySingalDataById(long id)
	{
		Connection connection = JDBCTools.openDB();
		Students students = new Students();
		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(JDBCTools.querySingalSql);
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next())
			{
				int age = resultSet.getInt(2);
				String name = resultSet.getString(3);
				String sex = resultSet.getString(4);
				students.setId(id);
				students.setAge(age);
				students.setName(name);
				students.setSex(sex);
			}
			return students;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCTools.closeDB(connection);
		}
		return null;
	}
/*
 * (non-Javadoc)
 * @see com.every.mysqldao.SqlInterface#queryDate()
 * ��ѯ��������
 */
	@Override
	public List<Students> queryDate()
	{
		Connection connection = JDBCTools.openDB();

		try
		{
			PreparedStatement preparedStatement = connection.prepareStatement(JDBCTools.queryallSql);
			ResultSet resultSet = preparedStatement.executeQuery();
			List<Students> list = new ArrayList<>();
			while (resultSet.next())
			{
				long id = resultSet.getLong(1);
				int age = resultSet.getInt(2);
				String name = resultSet.getString(3);
				String sex = resultSet.getString(4);
				Students students = new Students();
				students.setId(id);
				students.setAge(age);
				students.setName(name);
				students.setSex(sex);
				list.add(students);
			}
			return list;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			JDBCTools.closeDB(connection);
		}
		return null;
	}

}
