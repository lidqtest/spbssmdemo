package com.student.service.impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.student.dao.StudentMapper;
import com.student.pojo.Student;
import com.student.pojo.StudentExample;
import com.student.pojo.StudentExample.Criteria;
import com.student.service.StudentService;
import entity.PageResult;
/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<Student> findAll() {
		return studentMapper.selectByExample(null);
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Student student) {
		studentMapper.insert(student);		
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Student student){
		studentMapper.updateByPrimaryKey(student);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Student findOne(int id){
		return studentMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(int[] ids) {
		for(int id:ids){
			studentMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(Student student, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		StudentExample example=new StudentExample();
		Criteria criteria = example.createCriteria();
		// 设置条件:
		if(student.getName()!=null && student.getName().length()>0){
			criteria.andNameLike("%"+student.getName()+"%");
		}
		
		if(student.getAge()!=null ){
			criteria.andAgeEqualTo(student.getAge());
		}
		
		Page<Student> page= (Page<Student>)studentMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}
		/**
		 * 按分页查询测试
		 */
		@Override
		public PageResult findPageTest() {
			PageHelper.startPage(1, 1);
			System.out.println("开始findPageTest");
			List<Student> listStudent=studentMapper.selectByExample(null);
			System.out.println(listStudent);
			Page<Student> page= (Page<Student>)studentMapper.selectByExample(null);
			System.out.println(page);
			System.out.println("结束findPageTest");
			return null;
		}
		
		/**
		 * 按分页查询
		 * @pageNum 当前页
		 * @pageSize 每页记录数
		 * 
		 */

		@Override
		public PageResult findPage(int pageNum, int pageSize) {
			PageHelper.startPage(pageNum, pageSize);
			Page<Student> page=   (Page<Student>) studentMapper.selectByExample(null);
			return new PageResult(page.getTotal(),page.getResult());
		}

		@Override
		public List<Map> selectOptionList() {
			// TODO Auto-generated method stub
			return  studentMapper.selectOptionList();
		}
	
}
