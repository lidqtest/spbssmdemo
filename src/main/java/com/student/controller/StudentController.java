package com.student.controller;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.pojo.Student;
import com.student.service.StudentService;

import entity.PageResult;
import entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<Student> findAll(){			
		return studentService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){	
		return studentService.findPage(page, rows);
	}
	/**
	 * 返回全部列表测试
	 * @return
	 */
	@RequestMapping("/findPageTest")
	public PageResult  findPageTest(){	
		return studentService.findPageTest();
	}
	
	/**
	 * 增加
	 * @param student
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody Student student){
		try {
			studentService.add(student);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	/**
	 * 修改
	 * @param student
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody Student student){
		try {
			studentService.update(student);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public Student findOne(int id){
		return studentService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(int [] ids){
		try {
			studentService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param brand
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody(required=false) Student student, int page, int rows  ){
		System.out.println("学生名称："+student.getName()+"  学生年龄："+student.getAge());
		return studentService.findPage(student, page, rows);		
	}
	/**
 * 查询下拉框
 * @param brand
 * @param page
 * @param rows
 * @return
 */	
	@RequestMapping("/selectOptionList")
	public List<Map> selectOptionList(){
		return studentService.selectOptionList();
	}
	
}
