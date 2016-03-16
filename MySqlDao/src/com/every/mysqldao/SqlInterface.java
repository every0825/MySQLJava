package com.every.mysqldao;

import java.util.List;

/**
 * 
 * @author Every 数据库的方法接口
 */
public interface SqlInterface
{
	public void insertData(Students students); // 插入数据

	public void deleteDataById(long id); // 删除数据

	public void updateData(Students students); // 更新数据

	public Students querySingalDataById(long id);// 查询单个数据

	public List<Students> queryDate(); // 查询所有数据
}
