<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
 <%
 String path = request.getContextPath();
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>
     <!DOCTYPE HTML>
<html>
<head>
<title>Home</title>
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
<script src="js/amcharts.js"></script>	
<script src="js/serial.js"></script>	
<script src="js/light.js"></script>	
<script src="js/radar.js"></script>	
<link href="css/barChart.css" rel='stylesheet' type='text/css' />
<link href="css/fabochart.css" rel='stylesheet' type='text/css' />
<!--clock init-->
<script src="js/css3clock.js"></script>
<!--Easy Pie Chart-->
<!--skycons-icons-->
<script src="js/skycons.js"></script>
<script src="js/jquery.easydropdown.js"></script>
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
						
						<!--//menu-right-->
					<div class="clearfix"></div>
				</div>
					<!-- //header-ends -->
						<div class="outter-wp">
								<!--custom-widgets-->
												
												<!--//custom-widgets-->
												<!--/candile-->
													<div class="candile"> 
															<div class="candile-inner">
																	<h3 class="sub-tittle">欢迎登录管理系统</h3>
															    <div id="center">
															    <div id="fig">														
																	<script type="text/javascript" src="js/protovis-d3.2.js"></script>
																	<script type="text/javascript" src="js/vix.js"></script>
															   </div>
														       </div>																				
															</div>															
														</div>
													<!--/candile-->												
												<div class="area-charts">
													<div class="col-md-6 panel-chrt">
													 <h3 class="sub-tittle dyna">Dynamic Speedometer </h3>
														<div id="wrapper">
																			<div id="left">
																				<div>
																					<label for='miles'>Miles:</label> <input type="text" name="miles" id="miles" />
																				</div>
																				<div>
																					<label for='kilometers'>Kilometers:</label> <input type="text" name="kilometers" id="kilometers" />
																				</div>
																				<p id="errmsg"></p>
																			</div>

																			<div id="gauge">
																				<div id="circle"></div>
																				<div id="numbers"></div>
																				<div id="mi-km"></div>
																				<div id="needle"></div>
																				</div>
																	</div>
															</div>
														<div class="col-md-6 tini-time-line">
														 <h3 class="sub-tittle">Time line </h3>
															<ul class="timeline">
																<li>
																  <div class="timeline-badge info"><i class="fa fa-smile-o"></i></div>
																  <div class="timeline-panel">
																	<div class="timeline-heading">
																	  <h4 class="timeline-title">Title</h4>
																	</div>
																	<div class="timeline-body">
																	  <p>Description...</p>
																	</div>
																  </div>
																</li>
																
																<li>
																  <div class="timeline-badge primary"><i class="fa fa-star-o"></i></div>
																  <div class="timeline-panel">
																	<div class="timeline-heading">
																	  <h4 class="timeline-title">Title</h4>
																	</div>
																	<div class="timeline-body">
																	  <p>Description...</p>
																	</div>
																  </div>
																</li>																																																
																<li>
																  <div class="timeline-badge danger"><i class="fa fa-times-circle-o"></i></div>
																  <div class="timeline-panel">
																	<div class="timeline-heading">
																	  <h4 class="timeline-title">Title</h4>
																	</div>
																	<div class="timeline-body">
																	  <p>Description...</p>
																	</div>
																  </div>
																</li>
																
																<li>
																  <div class="timeline-badge success"><i class="fa fa-check-circle-o"></i></div>
																  <div class="timeline-panel">
																	<div class="timeline-heading">
																	  <h4 class="timeline-title">Title</h4>
																	</div>
																	<div class="timeline-body">
																	  <p>Description...</p>
																	</div>
																  </div>
																</li>
															</ul>
														</div>
															<div class="clearfix"></div>		
													</div>
										<!--/bottom-grids-->		 
									<div class="bottom-grids">
										<div class="dev-table">    
											<div class="col-md-4 dev-col">                                    

                                            <div class="dev-widget dev-widget-transparent">
                                                <h2 class="inner one">Server Usage</h2>
                                                <p>Today server usage in percentages</p>                                        
                                                <div class="dev-stat"><span class="counter">68</span>%</div>                                                                                
                                                <div class="progress progress-bar-xs">
                                                    <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 50%;"></div>
                                                </div>                                        
                                                <p>We Todayly recommend you change your plan to <strong>Pro</strong>. Click here to get more details.</p>

                                                
                                            </div>

                                        </div>
                                        <div class="col-md-4 dev-col mid">                                    

                                            <div class="dev-widget dev-widget-transparent dev-widget-success">
                                                 <h3 class="inner">Today Earnings</h3>
                                                <p>This is Today earnings per last year</p>                                        
                                                <div class="dev-stat">$<span class="counter">75,332</span></div>                                                                                
                                                <div class="progress progress-bar-xs">
                                                    <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 79%;"></div>
                                                </div>                                        
                                                <p>We happy to notice you that you become an Elite customer, and you can get some custom sugar.</p>

                                                
                                            </div>

                                        </div>
                                        <div class="col-md-4 dev-col">                                    

                                            <div class="dev-widget dev-widget-transparent dev-widget-danger">
                                                 <h3 class="inner">Your Balance</h3>
                                                <p>All your earnings for this time</p>
                                                <div class="dev-stat">$<span class="counter">5,321</span></div>                                                                                
                                                <div class="progress progress-bar-xs">
                                                    <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 80%;"></div>
                                                </div>                                        
                                                <p>You can withdraw this money in end of each month. Also you can spend it on our marketplace.</p>
                                                
                                            </div>
                                        </div>
										<div class="clearfix"></div>		
										
										</div>
										</div>
									<!--//bottom-grids-->									
									</div>
									<!--/charts-inner-->
									</div>
										<!--//outer-wp-->
									</div>
									 <!--footer section start-->
										
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
									  <a ><img src="images/admin.jpg"></a>
									  <a ><span class=" name-caret">Hello!</span></a>
									 <p>Admin</p>
									<ul>
									<li><a class="tooltips" ><span>Profile</span><i class="lnr lnr-user"></i></a></li>
										<li><a class="tooltips" href="adminlogin.jsp"><span>Log out</span><i class="lnr lnr-power-switch"></i></a></li>
										</ul>
									</div>
							   <!--//down-->
                           <div class="menu">
									<ul id="menu" >
										 <li id="menu-academico" ><a ><i class="fa fa-file-text-o"></i> <span>会员信息管理</span> <span class="fa fa-angle-right" style="float: right"></span></a>
											 <ul id="menu-academico-sub" >
												<li id="menu-academico-boletim" ><a href="${pageContext.request.contextPath }/listAllUserServlet?method="post">用户信息列表</a></li>
												<li id="menu-academico-boletim" ><a href="${pageContext.request.contextPath }/listAllUserForDeleteServlet?method="post">删除用户</a></li>
												<li id="menu-academico-boletim" ><a href="${pageContext.request.contextPath }/listAllUserForFreezeorReleaseServlet?method="post">冻结和解封用户</a></li>
											  </ul>
										 </li>
										  <li id="menu-academico" ><a ><i class="fa fa-file-text-o"></i> <span>企业信息管理</span> <span class="fa fa-angle-right" style="float: right"></span></a>
											 <ul id="menu-academico-sub" >
												<li id="menu-academico-boletim" ><a	href="${pageContext.request.contextPath }/listEnterpriseInfoServlet">企业信息列表</a></li>
												<li id="menu-academico-boletim" ><a href="${pageContext.request.contextPath }/enterpriseInfoPagesServelt?currentPage=1">企业信息分页展示</a></li>
												<li id="menu-academico-boletim" ><a href="addEnterpriseInfo.jsp">企业信息添加</a></li>
												<li id="menu-academico-boletim" ><a href="${pageContext.request.contextPath }/ListAllEuserServlet">企业用户管理</a></li>
											  </ul>
										 </li>
										  <li id="menu-academico" ><a ><i class="fa fa-file-text-o"></i> <span>求职信息管理</span> <span class="fa fa-angle-right" style="float: right"></span></a>
											 <ul id="menu-academico-sub" >
												<li id="menu-academico-boletim" ><a href="${pageContext.request.contextPath }/ShowAlldeliveryServlet">求职信息列表</a></li>
												
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
<link rel="stylesheet" href="css/vroom.css">
<script type="text/javascript" src="js/vroom.js"></script>
<script type="text/javascript" src="js/TweenLite.min.js"></script>
<script type="text/javascript" src="js/CSSPlugin.min.js"></script>
<script src="js/jquery.nicescroll.js"></script>
<script src="js/scripts.js"></script>

<!-- Bootstrap Core JavaScript -->
   <script src="js/bootstrap.min.js"></script>
</body>
</html>