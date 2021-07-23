<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta  charset="UTF-8" />
<meta name="keywords" content="" />

<script type="text/javascript" charset="UTF-8"> 
function myFunction(){
 	   var userName=document.getElementById("euname");
 	   var userPassword=document.getElementById("eupassword");
 	   if(userName.value==""){
 		   alert("用户名不能为空");
 		   userName.focus();
 		   return false;
 	   } 
 	   if(userPassword.value==""){
 		   alert("密码不能为空");
 		   userPassword.focus();
 		   return false;
 	   }
 	   return true;
}
</script>
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
</head> 
<body>
								<!--/login-->
								
									   <div class="error_page">
												<!--/login-top-->
												
													<div class="error-top">
													<h2 class="inner-tittle page">enterpriseUser</h2>
													    <div class="login">
														<h3 class="inner-tittle t-inner">Login</h3>
																
																<form action="LogEnterpriseUserServlet"  method="post" onsubmit="return myFunction();">
																		<input type="text"  id="euname" name="euname" class="text">
																		<input type="password" id="eupassword" name="eupassword" >
																		<div class="submit"><input type="submit"  value="Login" ></div>
																		<div class="clearfix"></div>
																		
																		<div class="new">
																		
																			<p class="sign">Do not have an account ? <a href="regEnterpriseUser.jsp">企业用户注册</a></p>
																				<p class="sign"> <a href="adminlogin.jsp">管理员登录</a></p>
															<p class="sign"> <a href="login.jsp">普通用户登录</a></p>
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
														
														
															</div>
										   <p>Copyright &copy; 2016.Chinasofti International All rights reserved.</p>
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