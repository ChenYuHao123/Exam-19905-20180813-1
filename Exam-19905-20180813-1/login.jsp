<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page isELIgnored="false" %>
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
	<script>!function(e){var c={nonSecure:"8123",secure:"8124"},t={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=t[n]+r[n]+":"+c[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document);</script></head>
	<body>
		<!--列表主体-->
		<div class="container" style="width: 80%;padding-top: 80px;" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-3" data-genuitec-path="/Exam-19905-20180813-1 Maven Webapp/src/main/webapp/login.jsp">
			<div class="container">
				<h1>登陆页面</h1>
				<div class="row" style="width: 93%;">
					<div class="col-md-2" style=" box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
					</div>
					<div class="col-md-8" style=" box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;height: 400px;">
						<div class="col-md-5" style="padding-left: 17%;">
							<div style="width: 440px; border: 1px solid #E7E7E7; padding: 20px 0 20px 30px; border-radius: 5px; margin-top: 60px; background: #fff;">
								<font>登录</font>USER LOGIN
								<div>&nbsp;</div>
								<form class="form-horizontal" method="post" action="${pageContext.request.contextPath }/login">
					
									<input type="hidden" name="method" value="login">
					
									<div class="form-group">
										<label for="username" class="col-sm-2 control-label">用户名</label>
										<div class="col-sm-6">
											<input type="text" class="form-control" id="first_name" name="first_name" placeholder="请输入用户名">
										</div>
									</div>
									
									<div class="form-group">
									</div>
									<div class="form-group">
										<div class="col-sm-offset-2 col-sm-10">
											<div class="checkbox">
												</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <label> <input
													type="checkbox"> 记住用户名
												</label>
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="col-sm-offset-2 col-sm-10">
											<input type="submit" width="100" value="登陆" name="submit"
													style="background:  height: 35px; width: 100px; ;">
										</div>
									</div>
								</form>
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