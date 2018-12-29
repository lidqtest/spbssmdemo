//服务层
app.service('studentService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('../student/findAll');		
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('../student/findPage?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('../student/findOne?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('../student/add',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../student/update',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('../student/delete?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('../student/search?page='+page+"&rows="+rows, searchEntity);
	}
	//下拉列表数据
	this.selectOptionList=function(){
		return $http.get('../student/selectOptionList');
	}
});
