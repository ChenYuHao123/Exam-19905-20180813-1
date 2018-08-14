<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<script src="html/bootstrap.min.css"></script>
		<script src="html/bootstrap.min.js"></script>
		<script src="html/jquery3.3.1.js"></script>
		<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<meta charset="utf-8" />
		<style>
			body{
				background: url(images/bg.jpg);
			}
		</style>
	</head>
	<body>
		<!--列表主体-->
		<div class="container" style="width: 80%;padding-top: 80px;">
			<div class="container">
				<h1>电影租赁系统首页</h1>
				<div class="row" style="width: 93%;">
					<div class="col-md-2" style=" box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
					</div>
					<div class="col-md-8" style=" box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;height: 400px;">
						<div class="col-md-5" style="padding-left: 17%;">
							<div style="width: 440px; border: 1px solid #E7E7E7; padding: 20px 0 20px 30px; border-radius: 5px; margin-top: 60px; background: #fff;">
								<font>登录</font>USER LOGIN
								<div>&nbsp;</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<input type="button"  onclick="location.href='login.jsp'" height="80px" width="100px" value="登陆" name="submit"
										   	style="background:  height: 35px; width: 100px;;">
								</div>
							</div>
							<div style="width: 300px; border: 0; padding: 20px 0 20px 30px; border-radius: 0px; margin-top: 60px; background: #fff;">
								<font>电影列表</font>
								<div>&nbsp;</div>
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<input type="button"  onclick="location.href='film.jsp'" height="80px" width="100px" value="操作" name="submit"
										   	style="background:  height: 35px; width: 100px;;">
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-2" style=" box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
					</div>
				</div>	
			</div>
		</div>
	</body>
</html>