package com.every.mysqldao;

public class Students
{
	private long id; // ѧ��
	private int age; // ����
	private String name;// ����
	private String sex; // �Ա�

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	@Override
	public String toString()
	{
		return id + "," + age + "," + name + "," + sex;

	}
}
