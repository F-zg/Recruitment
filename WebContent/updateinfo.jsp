<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
 <%
 String path = request.getContextPath();
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<!DOCTYPE HTML>
<html>
<head>
<title>Forms</title>
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
<script src="js/css3clock.js"></script>
<!--Easy Pie Chart-->
<!--skycons-icons-->
<script src="js/skycons.js"></script>
<!--//skycons-icons-->
<base href="<%=basePath%>">
</head> 
<body>
 <div class="page-container">
   <!--/content-inner-->
	<div class="left-content">
	   <div class="inner-content">
		<!-- header-starts -->
			<div class="header-section">
						<!--menu-right-->
						
							<div class="clearfix"></div>	
							<!--//profile_details-->
						</div>
						<!--//menu-right-->
					<div class="clearfix"></div>
				</div>

						<!-- //header-ends -->
							<!--//outer-wp-->
								<div class="outter-wp">
											<!--/sub-heard-part-->
											 <div class="sub-heard-part">
													   <ol class="breadcrumb m-b-0">
															<li><a href="userindex.jsp">Home</a></li>
															<li class="active">Forms</li>
														</ol>
											</div>	
											<!--/sub-heard-part-->	
												<!--/forms-->
													<div class="forms-main">
														<h2 class="inner-tittle">用户信息修改</h2>
															<div class="graph-form">
																	<div class="form-body">
																		<form action="updateUserServlet" method="post"> 
																			<div class="form-group"> 
																				<label for="exampleInputEmail1">用户名</label> 
																				<input type="text"  name="username" class="form-control" id="" placeholder="用户名"> 
																			</div> 
																			
																			<div class="form-group"> 
																				<label for="exampleInputPassword1">密码</label> 
																				<input type="password"  name="password"  class="form-control" id="" placeholder="密码"> 
																			</div>
																			
																			<div class="form-group"> 
																				<label for="exampleInputPassword1">出生日期</label> 
																				<input type="date"  name="borndate" class="form-control" id="" placeholder="出生日期"> 
																			</div>
																																																									
																			<div class="form-group"> 
																				性别：<input type="radio" name="gender" value="男"> 男
                                                                                      <input type="radio" name="gender" value="女"> 女
																			</div> 
																			
																			<div class="form-group"> 
																				<label for="exampleInputPassword1">城市</label> 
																				<input type="text"   name="city" class="form-control" id="" placeholder="城市"> 
																			</div>
																			
																			<div class="form-group"> 
																				<label for="exampleInputPassword1">手机</label> 
																				<input type="text"  name="telephone"  class="form-control" id="" placeholder="手机"> 
																			</div>
																			
																			<div class="form-group"> 
																				<label for="exampleInputPassword1">邮箱</label> 
																				<input type="email" name="email"  class="form-control" id="" placeholder="邮箱"> 
																			</div>
																			
																			<div class="form-group"> 
																				<label for="exampleInputPassword1">地址</label> 
																				<input type="text"  name="address" class="form-control" id="" placeholder="地址"> 
																			</div>
																			<input type="submit"  value="提交" class="btn btn-default" />
																		</form> 
																	</div>
															</div>																
														</div> 										   
												</div>
											<!--//outer-wp-->
									 <!--footer section start-->
										<footer>
										   <p>Copyright &copy; 2016.Chinasofti International All rights reserved.</p>
										</footer>
									<!--footer section end-->
	</div>
</div>
			
<!--js -->
<script src="js/jquery.nicescroll.js"></script>
<script src="js/scripts.js"></script>

<!-- Bootstrap Core JavaScript -->
   <script src="js/bootstrap.min.js"></script>
</body>
</html>