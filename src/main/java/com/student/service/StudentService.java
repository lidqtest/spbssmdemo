package com.student.service;
import java.util.List;
import java.util.Map;

import com.student.pojo.Student;

import entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface StudentService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<Student> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(Student student);
	
	
	/**
	 * 修改
	 */
	public void update(Student student);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public Student findOne(int id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(int [] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(Student student, int pageNum,int pageSize);

	/**
	 * 分页测试
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPageTest();
	/**
	 * 下拉框查询
	 * @return
	 */
	public List<Map> selectOptionList();
	
}
