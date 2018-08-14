<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%
    request.setCharacterEncoding("UTF-8");
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="UTF-8">
		<title>登陆页</title>
		<link rel="stylesheet" href="html/bootstrap.min.css">
		<!--<script src="html/bootstrap.min.css"></script>-->
		<script src="html/jquery3.3.1.js"></script>
		<script src="html/bootstrap.min.js"></script>
		<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<style>
			body{
				background: url(images/bg.jpg);
			}
		</style>
	</head>
	<body>
		<!--  描述：导航条        -->
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
					<a class="navbar-brand" href="#">电影列表</a>
				</div>
		
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">新增电影 <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<form method="post" action="${pageContext.request.contextPath }/film?method=newFilm">
									<tr id="newItem">
										<td><input class="${film.film_id }" type="text" value="新建电影" disabled="true" style="width: 100px;
					                          text-align: center;"></td>
					                     <td><input name="newTitle"  type="text" placeholder="请输入标题" style="width: 100px;
					                          text-align: center;"></td>
					                     <td><input name="newDescription"  type="text" placeholder="请输入内容" style="width: 100px;
					                          text-align: center;"></td>
					                     <td><select name="newLanguage">
					                     	  <c:forEach items="${sessionScope.list_l}" var="language"> 
											 	 <option value="${language}">${language}</option>
											  </c:forEach>
											</select>
										 </td> 
					                     <td><input type="submit" value="确认"></td>    
									</tr>
								</form>
							</ul>
						</li>
					</ul>
					<form method="post" action="${pageContext.request.contextPath }/film?method=search" class="navbar-form navbar-left">
						<div class="form-group">
							<input name="getItem" type="text" class="form-control" placeholder="按电影id搜索">
						</div>
						<button type="submit" class="btn btn-default">搜索</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<div style="padding-top:14px;font-size: 20px;padding-right:20px;">
							<c:if test="${!empty customer }">
								<li><a href="#">欢迎您,${customer.first_name}</a></li>
							</c:if>
						</div>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
		<!--  描述：导航条结束        -->
		
		<!--列表主体-->
		<div class="container"  style="width: 100%; padding-top: 80px;">
			<div class="container">
				<h1>电影列表</h1>
				<div class="row" style="width: 93%;">
					<div class="col-md-2" style=" box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
					</div>
					<div class="col-md-12" style=" box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
						<table   class="table" style="text-align: center;">
							<thead>
								<tr style="">
									<th>&nbsp&nbsp&nbsp&nbsp&nbsp film_id</th>
									<th>&nbsp&nbsp&nbsp&nbsp&nbsp title</th>
									<th>&nbsp&nbsp&nbsp&nbsp&nbsp description</th>
									<th>&nbsp&nbsp&nbsp&nbsp&nbsp language</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${list}" var="film">
								<tr>
									<td><input class="${film.film_id }" id="film.film_id" type="text" value="${film.film_id }" disabled="true" style="width: 50px;
				                          text-align: center;"></td>
									<td><input class="${film.film_id }" id="film.title" type="text" value="${film.title }" disabled="true" style="width: 176px;
				                          text-align: center;"></td>
				                    <td>
				                    	<textarea clos="200"  rows="5" warp="virtual" placeholder="内容介绍"
											input class="${film.film_id }" id="description" type="text" value="" disabled="true" style=" width: 220px;
				                         	 text-align: center;">${film.description }</textarea>
				                    	
				                    </td>
									<td><input class="${film.film_id }" id="language" type="text" value="${film.language }" disabled="true" style="width: 90px;
				                          text-align: center;">
				                    </td>
									<td>
										<a onclick="deleteItem(${film.film_id })" >删除,</a>&nbsp;
										<a href="#" onclick="edit(${film.film_id})">修改,</a>&nbsp;
										<br>
										<a onclick="resure(${film.film_id})">确认！</a>&nbsp;
									</td>
								</tr>
							</c:forEach>
							<form method="post" action="${pageContext.request.contextPath }/film?method=newFilm">
								<tr id="newItem">
									<td><input class="${item.TODO_ITEM_ID }" id="item.TODO_ITEM_ID" type="text" value="新建事项" disabled="true" style="width: 100px;
				                          text-align: center;"></td>
				                     <td><input name="newTitle" id="item.TODO_ITEM_ID" type="text" placeholder="请输入标题" style="width: 100px;
				                          text-align: center;"></td>
				                     <td><input name="newContent" id="item.TODO_ITEM_ID" type="text" placeholder="请输入内容" style="width: 100px;
				                          text-align: center;"></td>
				                     <td><input name="newPriority" id="item.TODO_ITEM_ID" type="text" placeholder="请输入优先级" style="width: 100px;
				                          text-align: center;"></td> 
				                     <td><input type="submit" value="确认"></td>    
								</tr>
							</form>
							</tbody>
						</table>
					</div>
					<!--<div class="col-md-1" style=" box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
					</div>  -->
				</div>
			</div>
		</div>
		<script type="text/javascript">
			$(function(){
				$("#editItem").hide();
				$("#newItem").hide();
			})
			
			function edit(id){
					//alert($(".language"))
					$("#dropdown-menu").show();
					$(".language").hide();
					var arr = document.getElementsByClassName(id);
					for(var i=1;i<arr.length;i++){
						arr[i].removeAttribute('disabled');
					}
			}
			
			
			function deleteItem(id){
				if(window.confirm("确定删除序号为"+id+"事项吗？")){
					window.location.href='http://localhost:8080/Exam-19905-20180813-1/film?method=delete&id='+id;
				}
			}
			
			function resure(id){
				var film_id = document.getElementsByClassName(id)[0].value;
				var title = document.getElementsByClassName(id)[1].value;
				var description = document.getElementsByClassName(id)[2].value;
				var language = document.getElementsByClassName(id)[3].value;
				window.location.href ='http://localhost:8080/Exam-19905-20180813-1/film?method=edit&film_id='+film_id+'&title='+title+'&description='+description+'&language='+language;
			}
		</script>
	</body>
</html>

