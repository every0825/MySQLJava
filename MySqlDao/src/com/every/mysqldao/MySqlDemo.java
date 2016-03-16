package com.every.mysqldao;

import java.util.List;

public class MySqlDemo
{

	public static void main(String[] args)
	{
		ImplementSqlInterface implementSqlInterface = new ImplementSqlInterface();
		// Students students = new Students();
		// students.setId(141040110);
		// students.setAge(23);
		// students.setName("³ÂÐ¡Çï");
		// students.setSex("Å®");
		// implementSqlInterface.insertData(students);
		// implementSqlInterface.deleteDataById(141040110);
		// implementSqlInterface.updateData(students);
		// Students students =
		// implementSqlInterface.querySingalDataById(141040110);
		// System.out.println(students.getId() + "," + students.getAge() + "," +
		// students.getName() + "," + students.getSex());
		List<Students> list = implementSqlInterface.queryDate();
		System.out.println(list);
	}

}
