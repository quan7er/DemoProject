<%@ page pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String Url = basePath + request.getAttribute("url") ;
%>
<div>
	<div>${msg}</div>
	<div><span id="mytime">5</span>秒后跳转到<a href="<%=Url%>" >首页</a>！</div>
</div>
<script type="text/javascript" src="js/util.js"></script>
<script type="text/javascript">
	var goUrl = "<%=Url%>" ;
	goTime() ;
</script>