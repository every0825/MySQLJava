package com.every.mysqldao;

import java.util.List;

/**
 * 
 * @author Every ���ݿ�ķ����ӿ�
 */
public interface SqlInterface
{
	public void insertData(Students students); // ��������

	public void deleteDataById(long id); // ɾ������

	public void updateData(Students students); // ��������

	public Students querySingalDataById(long id);// ��ѯ��������

	public List<Students> queryDate(); // ��ѯ��������
}
