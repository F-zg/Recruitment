<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Forms</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>

<!-- 采用绝对路径导入jquery文件 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.10.2.min.js"></script>
	
<script type="text/javascript">
	$(function() {
		//提示用户登录失败
        if(!${empty requestScope.msg}){
            alert("${requestScope.msg}");
        }
/* 		
		//验证非空，并提交查询请求
		$("#submit").click(function() {
							//验证输入框是否为空
							var username = $("#username").val();
							var password = $("#password").val();
							var vrcode = $("#vrcode").val();
							if (username == "") {
								alert("请输入用户名");
								return false;
							} else if (password == "") {
								alert("请输入密码");
								return false;
							} else {
								//javascript语言提供了一个location地址栏对象
								//它有一个属性href,可以获取浏览器中地址栏地址
								location.href = "${pageContext.request.contextPath }/manager/homeCostServlet?action=login&username="
										+ username + "&password=" + password+"&vrcode="+vrcode;
							}
						});

		$(document).ready(function () {
			//这里在url中加时间是因为让url变化
			$("#checkImg").attr("src","${pageContext.request.contextPath }/manager/homeCostServlet?action=getCheckNumber&time="+new Date().getTime());
			}); */
	});
</script>
<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Graph CSS -->
<link href="css/font-awesome.css" rel="stylesheet">
<!-- jQuery -->
<link
	href='https://fonts.googleapis.com/css?family=Roboto:700,500,300,100italic,100,400'
	rel='stylesheet' type='text/css'>
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
</head>
<body>
	<div class="page-container">
		<!--/content-inner-->
		<div class="left-content">
			<div class="inner-content">
				<!-- header-starts -->
				<div class="header-section">
					<!--menu-right-->
					<div class="top_menu">
						<div class="main-search">
							<form>
								<input type="text" value="Search" onFocus="this.value = '';"
									onBlur="if (this.value == '') {this.value = 'Search';}"
									class="text" /> <input type="submit" value="" />
							</form>
							<div class="close">
								<img src="images/cross.png" />
							</div>
						</div>
						<div class="srch">
							<button></button>
						</div>
						<script type="text/javascript">
							$('.main-search').hide();
							$('button').click(function() {
								$('.main-search').show();
								$('.main-search text').focus();
							});
							$('.close').click(function() {
								$('.main-search').hide();
							});
						</script>
						<!--/profile_details-->
						<div class="profile_details_left">
							<ul class="nofitications-dropdown">
								<li class="dropdown note dra-down">
									<div id="dd" class="wrapper-dropdown-3" tabindex="1">
										<span>Italy</span>
										<ul class="dropdown">
											<li><a class="deutsch">France</a></li>
											<li><a class="english"> Italy</a></li>
											<li><a class="espana">Brazil</a></li>
											<li><a class="russian">Usa</a></li>
										</ul>
									</div> <script type="text/javascript">
										function DropDown(el) {
											this.dd = el;
											this.placeholder = this.dd
													.children('span');
											this.opts = this.dd
													.find('ul.dropdown > li');
											this.val = '';
											this.index = -1;
											this.initEvents();
										}
										DropDown.prototype = {
											initEvents : function() {
												var obj = this;

												obj.dd.on('click', function(
														event) {
													$(this).toggleClass(
															'active');
													return false;
												});

												obj.opts
														.on(
																'click',
																function() {
																	var opt = $(this);
																	obj.val = opt
																			.text();
																	obj.index = opt
																			.index();
																	obj.placeholder
																			.text(obj.val);
																});
											},
											getValue : function() {
												return this.val;
											},
											getIndex : function() {
												return this.index;
											}
										}

										$(function() {

											var dd = new DropDown($('#dd'));

											$(document)
													.click(
															function() {
																// all dropdowns
																$(
																		'.wrapper-dropdown-3')
																		.removeClass(
																				'active');
															});

										});
									</script>
								</li>
								<li class="dropdown note"><a href="#"
									class="dropdown-toggle" data-toggle="dropdown"
									aria-expanded="false"><i class="fa fa-envelope-o"></i> <span
										class="badge">3</span></a>


									<ul class="dropdown-menu two first">
										<li>
											<div class="notification_header">
												<h3>You have 3 new messages</h3>
											</div>
										</li>
										<li><a href="#">
												<div class="user_img">
													<img src="images/1.jpg" alt="">
												</div>
												<div class="notification_desc">
													<p>Lorem ipsum dolor sit amet</p>
													<p>
														<span>1 hour ago</span>
													</p>
												</div>
												<div class="clearfix"></div>
										</a></li>
										<li class="odd"><a href="#">
												<div class="user_img">
													<img src="images/in.jpg" alt="">
												</div>
												<div class="notification_desc">
													<p>Lorem ipsum dolor sit amet</p>
													<p>
														<span>1 hour ago</span>
													</p>
												</div>
												<div class="clearfix"></div>
										</a></li>
										<li><a href="#">
												<div class="user_img">
													<img src="images/in1.jpg" alt="">
												</div>
												<div class="notification_desc">
													<p>Lorem ipsum dolor sit amet</p>
													<p>
														<span>1 hour ago</span>
													</p>
												</div>
												<div class="clearfix"></div>
										</a></li>
										<li>
											<div class="notification_bottom">
												<a href="#">See all messages</a>
											</div>
										</li>
									</ul></li>

								<li class="dropdown note"><a href="#"
									class="dropdown-toggle" data-toggle="dropdown"
									aria-expanded="false"><i class="fa fa-bell-o"></i> <span
										class="badge">5</span></a>

									<ul class="dropdown-menu two">
										<li>
											<div class="notification_header">
												<h3>You have 5 new notification</h3>
											</div>
										</li>
										<li><a href="#">
												<div class="user_img">
													<img src="images/in.jpg" alt="">
												</div>
												<div class="notification_desc">
													<p>Lorem ipsum dolor sit amet</p>
													<p>
														<span>1 hour ago</span>
													</p>
												</div>
												<div class="clearfix"></div>
										</a></li>
										<li class="odd"><a href="#">
												<div class="user_img">
													<img src="images/in5.jpg" alt="">
												</div>
												<div class="notification_desc">
													<p>Lorem ipsum dolor sit amet</p>
													<p>
														<span>1 hour ago</span>
													</p>
												</div>
												<div class="clearfix"></div>
										</a></li>
										<li><a href="#">
												<div class="user_img">
													<img src="images/in8.jpg" alt="">
												</div>
												<div class="notification_desc">
													<p>Lorem ipsum dolor sit amet</p>
													<p>
														<span>1 hour ago</span>
													</p>
												</div>
												<div class="clearfix"></div>
										</a></li>
										<li>
											<div class="notification_bottom">
												<a href="#">See all notification</a>
											</div>
										</li>
									</ul></li>
								<li class="dropdown note"><a href="#"
									class="dropdown-toggle" data-toggle="dropdown"
									aria-expanded="false"><i class="fa fa-tasks"></i> <span
										class="badge blue1">9</span></a>
									<ul class="dropdown-menu two">
										<li>
											<div class="notification_header">
												<h3>You have 9 pending task</h3>
											</div>
										</li>
										<li><a href="#">
												<div class="task-info">
													<span class="task-desc">Database update</span><span
														class="percentage">40%</span>
													<div class="clearfix"></div>
												</div>
												<div class="progress progress-striped active">
													<div class="bar yellow" style="width: 40%;"></div>
												</div>
										</a></li>
										<li><a href="#">
												<div class="task-info">
													<span class="task-desc">Dashboard done</span><span
														class="percentage">90%</span>
													<div class="clearfix"></div>
												</div>

												<div class="progress progress-striped active">
													<div class="bar green" style="width: 90%;"></div>
												</div>
										</a></li>
										<li><a href="#">
												<div class="task-info">
													<span class="task-desc">Mobile App</span><span
														class="percentage">33%</span>
													<div class="clearfix"></div>
												</div>
												<div class="progress progress-striped active">
													<div class="bar red" style="width: 33%;"></div>
												</div>
										</a></li>
										<li><a href="#">
												<div class="task-info">
													<span class="task-desc">Issues fixed</span><span
														class="percentage">80%</span>
													<div class="clearfix"></div>
												</div>
												<div class="progress progress-striped active">
													<div class="bar  blue" style="width: 80%;"></div>
												</div>
										</a></li>
										<li>
											<div class="notification_bottom">
												<a href="#">See all pending task</a>
											</div>
										</li>
									</ul></li>
								<div class="clearfix"></div>
							</ul>
						</div>
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
							<li><a href="indexEnterpriseuser.jsp">Home</a></li>s
							<li class="active">${ empty requestScope.reinformation.reid ? "AddReinformation":"ModifyReinformation" }</li>
						</ol>
					</div>
					<!--/sub-heard-part-->
					<a href="javascript:history.back(-1)">返回上一页</a>
					<!--/forms-->
					<div class="forms-main">
						<h2 class="inner-tittle">${ empty requestScope.reinformation.reid ? "添加岗位":"修改岗位信息" }</h2>
						<div class="graph-form">
							<div class="form-body">
								<form action="${pageContext.request.contextPath }/AddReinformationServlet" method="get">
								<input type="hidden" id="reid" name="reid"
				value="${ empty requestScope.reinformation.reid ? "-1":requestScope.reinformation.reid }">
									<div class="form-group">
										<label for="exampleInputEmail1">职位名称</label> <input
											type="text" class="form-control" name="rePositionName" value="${requestScope.reinformation.rePositionName}" placeholder="职位名称">
									</div>

									<div class="form-group">
										<label for="exampleInputPassword1">薪资</label> <input
											type="text" class="form-control" name="reSalary" value="${requestScope.reinformation.reSalary}" placeholder="薪资">
									</div>

									<div class="form-group">
										<label for="exampleInputPassword1">所在城市</label> <input
											type="text" class="form-control" name="reCity" value="${requestScope.reinformation.reCity}" placeholder="所在城市">
									</div>

									<div class="form-group">
										<label for="exampleInputPassword1">详细地址</label> <input
											type="text" class="form-control" name="reArea" value="${requestScope.reinformation.reArea}" placeholder="详细地址">
									</div>

									<div class="form-group">
										<label for="exampleInputPassword1">工作经验</label> <input
											type="text" class="form-control" name="reWorkYears" value="${requestScope.reinformation.reWorkYears}" placeholder="工作经验">
									</div>

									<div class="form-group">
										<label for="exampleInputPassword1">最低学历</label> <input
											type="text" class="form-control" name="reEducation" value="${requestScope.reinformation.reEducation}" placeholder="最低学历">
									</div>

									<div class="form-group">
										<label for="exampleInputPassword1">招聘人数</label> <input
											type="text" class="form-control" name="rePersonNum" value="${requestScope.reinformation.rePersonNum}" placeholder="招聘人数">
									</div>

									<div class="form-group">
										<label for="exampleInputPassword1">公司福利</label> <input
											type="text" class="form-control" name="reLightPoint" value="${requestScope.reinformation.reLightPoint}" placeholder="公司福利">
									</div>

									<div class="form-group">
										<label for="exampleInputPassword1">职位要求</label> <input
											type="text" class="form-control" name="reJobDesc" value="${requestScope.reinformation.reJobDesc}" placeholder="职位要求">
									</div>

									<div class="form-group">
										<label for="exampleInputPassword1">工作部门</label> <input
											type="text" class="form-control" name="reDepartment" value="${requestScope.reinformation.reDepartment}" placeholder="工作部门">
									</div>

									<div class="form-group">
										<label for="exampleInputPassword1">专业要求</label> <input
											type="text" class="form-control" name="reProfessional" value="${requestScope.reinformation.reProfessional}" placeholder="专业要求">
									</div>
																											<div class="form-group">
									<label for="exampleInputPassword1">直属上司</label> <input
											type="text" class="form-control" name="reReportPerson" value="${requestScope.reinformation.reReportPerson}" placeholder="直属上司">
									</div>
																											<div class="form-group">
									<label for="exampleInputPassword1">下属人数</label> <input
											type="text" class="form-control" name="reSubordinates" value="${requestScope.reinformation.reSubordinates}" placeholder="下属人数">
									</div>
									
									<label for="exampleInputPassword1">公司</label> <input
											type="text" class="form-control" name="eid" value="${requestScope.reinformation.e.eid}" placeholder="公司">
									</div>

									<input type="submit" id="submit" value="提交" class="btn btn-default" />
								</form>
							</div>

						</div>

					</div>
					<!--//forms-->
				</div>
				<!--//outer-wp-->
				<!--footer section start-->
				
				<!--footer section end-->
			</div>
		</div>
		<!--//content-inner-->
		<!--/sidebar-menu-->
	
		<div class="clearfix"></div>
	</div>
	<script>
		var toggle = true;

		$(".sidebar-icon").click(
				function() {
					if (toggle) {
						$(".page-container").addClass("sidebar-collapsed")
								.removeClass("sidebar-collapsed-back");
						$("#menu span").css({
							"position" : "absolute"
						});
					} else {
						$(".page-container").removeClass("sidebar-collapsed")
								.addClass("sidebar-collapsed-back");
						setTimeout(function() {
							$("#menu span").css({
								"position" : "relative"
							});
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