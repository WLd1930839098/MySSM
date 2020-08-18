<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="${pageContext.request.contextPath}/img/user2-160x160.jpg"
					class="img-circle" alt="User Image">
			</div>
			<div class="pull-left info">
				<a href="#"><i class="fa fa-circle text-success"></i>${user.name} 在线</a>
			</div>
		</div>

		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">菜单</li>
			<li id="admin-index">
				<a href="/pages/main.jsp">
					<i class="fa fa-dashboard"></i>
					<span>首页</span>
				</a>
			</li>

			<li class="treeview">
				<a href="#">
					<i class="fa fa-cogs"></i>
					<span>系统管理</span>
					<span class="pull-right-container">
					<i class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">
					<li id="system-setting">
						<a href="${pageContext.request.contextPath}/user/findAllUsers.do?type=2">
							<i class="fa fa-circle-o"></i>
							用户管理
						</a>
					</li>
					<li id="system-setting1">
						<a href="${pageContext.request.contextPath}/role/findAllRoles.do">
							<i class="fa fa-circle-o"></i>
							角色管理
						</a>
					</li>
					<li id="system-books">
						<a href="${pageContext.request.contextPath}/book/findAll.do">
							<i class="fa fa-circle-o"></i>
							书库
						</a>
					</li>
					<li id="system-borrow">
						<a href="${pageContext.request.contextPath}/borrow/findAll.do">
							<i class="fa fa-circle-o"></i>
							借阅记录
						</a>
					</li>

				</ul>
			</li>
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>