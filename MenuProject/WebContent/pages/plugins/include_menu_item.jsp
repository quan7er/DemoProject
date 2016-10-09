<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/pages/plugins/include_static_head.jsp"%>
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="upload/emp/nophoto.png" class="img-circle"
					alt="User Image">
			</div>
			<div class="pull-left info">
				<p>李兴华</p>
			</div> 
		</div>
		<!-- /.search form -->
		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header"><i class="fa fa-slack"></i> 企业人事管理系统</li>
			<li class="${param.role=='member' ? 'active' : ''} treeview"><a href="<%=basePath%>pages/index.jsp"> <i
					class="fa fa-folder-open"></i> <span>权限管理</span> <i
					class="fa fa-angle-left pull-right"></i>
			</a>
				<ul class="treeview-menu"> 
					<li class="${param.action=='member:add' ? 'active' : ''}"><a href="pages/back/member/member_add.jsp"><i class="fa fa-circle-o"></i>
							增加管理员</a></li>
					<li class="${param.action=='member:list' ? 'active' : ''}"><a href="MemberServlet/list"><i class="fa fa-circle-o"></i>
							管理员列表</a></li>
				</ul></li>
			<li class="${param.role=='admin' || param.role=='dept' ? 'active' : ''} treeview"><a href="<%=basePath%>pages/index.jsp"> <i class="fa  fa-folder-open"></i>
					<span>部门管理</span> <i class="fa fa-angle-left pull-right"></i>
			</a>
				<ul class="treeview-menu">
					<li class="${param.action=='dept:list' ? 'active' : ''}"><a href="DeptServlet/list"><i
							class="fa fa-circle-o"></i> 部门列表</a></li>
				</ul></li>
			<li class="${param.role=='emp' ? 'active' : ''} treeview"><a href="<%=basePath%>pages/index.jsp"> <i class="fa  fa-folder-open"></i>
					<span>雇员管理</span> <i class="fa fa-angle-left pull-right"></i>
			</a>
				<ul class="treeview-menu">
					<li class="${param.action=='emp:add' ? 'active' : ''}"><a href="pages/back/emp/emp_add.jsp"><i
							class="fa fa-circle-o"></i> 雇员入职</a></li>
					<li class="${param.action=='emp:list' ? 'active' : ''}"><a href="pages/back/emp/emp_list.jsp"><i
							class="fa fa-circle-o"></i> 在职雇员列表</a></li>
					<li class="${param.action=='emp:list' ? 'active' : ''}"><a href="pages/back/emp/emp_list_out.jsp"><i
							class="fa fa-circle-o"></i> 离职雇员列表</a></li>
				</ul></li>
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>