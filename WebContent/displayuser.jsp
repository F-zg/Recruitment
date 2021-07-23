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
														<h2 class="inner-tittle">用户信息查看</h2>
															<div class="graph-form">
																	<div class="form-body">
																		<form action="displayUserinfo" method="post"> 
																		   <c:forEach items="${requestScope.userInfos}" var="item">
																			<div class="form-group"> 
																				<label for="exampleInputEmail1">用户名</label> 
																				<input type="text"  name="username" class="form-control" id="" placeholder=${item.username}> 
																			</div> 
																			
																			<div class="form-group"> 
																				<label for="exampleInputPassword1">密码</label> 
																				<input type="password"  name="password"  class="form-control" id="" placeholder=${item.password}> 
																			</div>
																			
																			<div class="form-group"> 
																				<label for="exampleInputPassword1">出生日期</label> 
																				<input type="text"  name="borndate" class="form-control" id="" placeholder=${item.borndate}> 
																			</div>
																																																									
																			<div class="form-group"> 
																				<label for="exampleInputPassword1">性别</label> 
																				<input type="text"  name="gender" class="form-control" id="" placeholder=${item.gender}> 
																			</div> 
																			
																			<div class="form-group"> 
																				<label for="exampleInputPassword1">省份</label> 
																				<input type="text"   name="city" class="form-control" id="" placeholder=${item.city}> 
																			</div>
																			
																			<div class="form-group"> 
																				<label for="exampleInputPassword1">手机</label> 
																				<input type="text"  name="telephone"  class="form-control" id="" placeholder=${item.telephone}> 
																			</div>
																			
																			<div class="form-group"> 
																				<label for="exampleInputPassword1">邮箱</label> 
																				<input type="email" name="email"  class="form-control" id="" placeholder=${item.email}> 
																			</div>
																			
																			<div class="form-group"> 
																				<label for="exampleInputPassword1">地址</label> 
																				<input type="text"  name="address" class="form-control" id="" placeholder=${item.address}> 
																			</div>
																			
																			<div class="form-group"> 
																				<label for="jianlistate">简历审核状态（“0”代表未审核，“1”代表已通过）</label> 
																				<input type="text"  name="jianlistate" class="form-control" id="" placeholder=${item.state}> 
																			</div>
																			<div class="form-group"> 
																				<label for="luyongstate">录用状态（“0”代表未审核，“1”代表已录用）</label> 
																				<input type="text"  name="luyongstate" class="form-control" id="" placeholder=${delivery.state}> 
																			</div>
																			<p style="font-size: 20px;"><a href="userindex.jsp" style=" color: lightblue;">返回</a></p>
																			<p style="font-size: 20px;"><a href="updateinfo.jsp" style=" color: lightblue;">点击进行修改</a></p>
																			 </c:forEach> 
																		</form> 
																	</div>
															</div>																
														</div> 										   
												</div>
											<!--//outer-wp-->
									 <!--footer section start-->
										
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