<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%-- <%
	String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%> --%>
<!DOCTYPE HTML>
<html>
<head>
<title>Tables</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript">
	
	
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 





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
<!-- /js -->
<script src="js/jquery-1.10.2.min.js"></script>
<!-- //js-->
<%-- <base href="<%=basePath%>"> --%>
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
				<!--outter-wp-->
				<div class="outter-wp">
					<!--sub-heard-part-->
					<div class="sub-heard-part">
						<ol class="breadcrumb m-b-0">
							<li><a href="adminindex.jsp">Home</a></li>
							<li class="active">Tables</li>
						</ol>
					</div>
					<!--//sub-heard-part-->
					<div class="graph-visual tables-main">
						<h3 class="inner-tittle two">企业信息表</h3>
						<div class="graph">
							<div class="tables">
								<table class="table table-hover">
									<thead>
										<tr>
											<th>企业id</th>
											<th>企业名称</th>
											<th>企业介绍</th>
											<th>所属类别</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${requestScope.page.data }" var="e">
											<tr>
												<td>${e.eid}</td>
												<td>${e.ename}</td>
												<td><textarea disabled="disabled">${e.eintro}</textarea></td>
												<td>${e.intustry}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<P style="text-align: center">

									<a
										href="<%= request.getContextPath()%>/enterpriseInfoPagesServelt?action=selectEnterpriseinfoByPage&currentPage=${page.prev()}"><button>上一页</button></a>

									<span>${page.currentPage}页/${page.getTotalPages()}页</span> <a
										href="<%= request.getContextPath()%>/enterpriseInfoPagesServelt?action=selectEnterpriseinfoByPage&currentPage=${page.next()}"><button>下一页</button></a>
								</P>
							</div>
						</div>

						<!--//graph-visual-->
					</div>
					<!--//outer-wp-->
					<!--footer section start-->
					<footer>
						<p>Copyright &copy; 2016.Chinasofti International All rights
							reserved.</p>
					</footer>
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