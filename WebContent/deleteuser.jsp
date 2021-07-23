<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
 <%
 String path = request.getContextPath();
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
<!DOCTYPE HTML>
<html>
<head>
<title>Tables</title>
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

	<!-- lined-icons -->
<link rel="stylesheet" href="css/icon-font.min.css" type='text/css' />
	<!-- /js -->
<script src="js/jquery-1.10.2.min.js"></script>
<!-- //js-->
<base href="<%=basePath%>">
</head> 
<body>
   <div class="page-container">
   <!--/content-inner-->
	<div class="left-content">
	   <div class="inner-content">
		<!-- header-starts -->
			<div class="header-section">
						<!--//menu-right-->
					<div class="clearfix"></div>
				</div>
					<!-- //header-ends -->
						<!--outter-wp-->
							<div class="outter-wp">									
								  <!--//sub-heard-part-->
									<div class="graph-visual tables-main">
													<h3 class="inner-tittle two">用户信息列表</h3>
													<div class="graph">
															<div class="tables">
																<table class="table table-hover">
																	<thead>
																		<tr>
																			<th>username</th>
																			<th>password</th>
																			<th>sex</th> 
																			<th>email</th>
																			<th>address</th>
																			<th>operation</th>																			
																		</tr> 
																	</thead>
																	<c:forEach items="${requestScope.userinfos}" var="item">
																		<tbody>
																			<tr>
																				<th>${item.username}</th>
																				<td>${item.password}</td> 
																				<td>${item.gender}</td> 
																				<td>${item.email}</td>
																				<td>${item.address}</td>
																				<td><a class="deleteClass" href="${pageContext.request.contextPath }/deleteUserinfoServlet?userId=${item.userId}">删除</a></td>																			
																			</tr>
																		</tbody> 
																	</c:forEach> 
																</table>   	
															</div>												
													</div>													
										</div>
										<!--//graph-visual-->
									</div>
									<!--//outer-wp-->
									 <!--footer section start-->
										<footer>
										   <p>Copyright &copy; 2016.Chinasofti International All rights reserved.</p>
										</footer>
									<!--footer section end-->
								</div>
							</div>
				<!--//content-inner-->
			<!--/sidebar-menu-->
				<div class="sidebar-menu">
					<header class="logo">
					<a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span> </a> <a href="index.html"> <span id="logo"> <h1>Augment</h1></span> 
					<!--<img id="logo" src="" alt="Logo"/>--> 
				  </a> 
				</header>
			<div style="border-top:1px solid rgba(69, 74, 84, 0.7)"></div>
			<!--/down-->
							<div class="down">	
									  <a href="index.html"><img src="images/admin.jpg"></a>
									  <a href="index.html"><span class=" name-caret">Jasmin Leo</span></a>
									 <p>System Administrator in Company</p>
									<ul>
									<li><a class="tooltips" href="index.html"><span>Profile</span><i class="lnr lnr-user"></i></a></li>
										<li><a class="tooltips" href="index.html"><span>Settings</span><i class="lnr lnr-cog"></i></a></li>
										<li><a class="tooltips" href="index.html"><span>Log out</span><i class="lnr lnr-power-switch"></i></a></li>
										</ul>
									</div>
							   <!--//down-->
                           <div class="menu">
									<ul id="menu" >									
										 <li id="menu-academico" ><a href="#"><i class="fa fa-table"></i> <span>用户信息管理</span> <span class="fa fa-angle-right" style="float: right"></span></a>
										    <ul id="menu-academico-sub" >
												<li id="menu-academico-boletim" ><a href="${pageContext.request.contextPath }/listAllUserServlet?method="post">用户信息列表</a></li>
												<li id="menu-academico-boletim" ><a href="${pageContext.request.contextPath }/listAllUserForDeleteServlet?method="post">删除用户</a></li>
												<li id="menu-academico-boletim" ><a href="${pageContext.request.contextPath }/listAllUserForFreezeorReleaseServlet?method="post">冻结和解封用户</a></li>
											  </ul>																			
										</li>										 												
								  </ul>
								</div>
							  </div>
							  <div class="clearfix"></div>		
							</div>
							<script>
							var toggle = true;
										
							$(".sidebar-icon").click(function() {                
							  if (toggle)
							  {
								$(".page-container").addClass("sidebar-collapsed").removeClass("sidebar-collapsed-back");
								$("#menu span").css({"position":"absolute"});
							  }
							  else
							  {
								$(".page-container").removeClass("sidebar-collapsed").addClass("sidebar-collapsed-back");
								setTimeout(function() {
								  $("#menu span").css({"position":"relative"});
								}, 400);
							  }											
											toggle = !toggle;
										});
							</script>
<!--js -->
	<script src="js/jquery.nicescroll.js"></script>
	<script src="js/scripts.js"></script>
<!-- Bootstrap Core JavaScript -->
   <script src="js/bootstrap.min.js"></script>
</body>
</html>