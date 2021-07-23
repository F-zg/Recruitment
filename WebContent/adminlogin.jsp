<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
 <%
 String path = request.getContextPath();
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
     <!DOCTYPE HTML>
<html>
<head>
<title>AdminLogin</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
 <!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Graph CSS -->
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- jQuery -->
<link href='https://fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400' rel='stylesheet' type='text/css'>
<!-- lined-icons -->
<link rel="stylesheet" href="css/icon-font.min.css" type='text/css' />
<!-- //lined-icons -->
<script src="js/jquery-1.10.2.min.js"></script>
<!--clock init-->
<base href="<%=basePath%>">
</head> 
<body>
								<!--/login-->
								
									   <div class="error_page">
												<!--/login-top-->
												
													<div class="error-top">
													<h2 class="inner-tittle page">管理员登录</h2>
													    <div class="login">
														<h3 class="inner-tittle t-inner">Login</h3>												
																<form action="logAdminServlet" method="post">
																		<input type="text" class="text" value="E-mail address" name=adminname  onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'E-mail address';}" >
																		<input type="password" value="Password" onfocus="this.value = '';" name=adminpassword  onblur="if (this.value == '') {this.value = 'Password';}">
																		<div class="submit"><input type="submit" onclick="myFunction()" value="Login"   id="btn_sub" name="login"></div>
																		<div class="clearfix"></div>
																		
																		<div class="new">
																			<p class="sign"> <a href="#"></a></p>
																			<div class="clearfix"></div>
																		</div>
																</form>
														</div>														
													</div>																										
												<!--//login-top-->
										   </div>						
										  	<!--//login-->
										    <!--footer section start-->
										<div class="footer">
												<div class="error-btn">
															<a class="read fourth" href="login.jsp">普通用户登录</a>
															<p class="sign"> <a href="logenterpriseUser.jsp">企业用户登录</a></p>
															</div>
										</div>
									<!--footer section end-->
									<!--/404-->
<!--js -->
<script src="js/jquery.nicescroll.js"></script>
<script src="js/scripts.js"></script>
<!-- Bootstrap Core JavaScript -->
   <script src="js/bootstrap.min.js"></script>
</body>
</html>