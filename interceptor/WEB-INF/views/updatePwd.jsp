<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="org.shop.pojo.User" %>
<%@include file="/common/common.jspf" %>
<%
     User user = (User)session.getAttribute("user");
     String str;
     if(user==null){
    	  str = "未登陆";
     }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
		<link rel="stylesheet" href="css/Site.css" />
		<link rel="stylesheet" href="css/zy.all.css" />
		<link rel="stylesheet" href="css/font-awesome.min.css" />
		<link rel="stylesheet" href="css/amazeui.min.css" />
		<link rel="stylesheet" href="css/admin.css" />
</head>
	<body>
			<div class="am-cf admin-main" style="padding-top: 0px;">
			<!-- content start -->
			
	<div class="am-cf admin-main" style="padding-top: 0px;">
		<!-- content start -->
		<div class="admin-content">
			<div class="admin-content-body">
				
				<div class="am-g">
					<div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">
						
					</div>
					<div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4"
						style="padding-top: 30px;">
						<form class="am-form am-form-horizontal"
							action="user/addUser1Submit.action" method="post" id="form1">
						
							<div class="am-form-group">
								<label for="user-name" class="am-u-sm-3 am-form-label">
								原密码</label>
								<div class="am-u-sm-9">
									<input type="password" id="yuanpass" required
										placeholder="原密码" name="yuanpass">
										<small>原密码...</small>
								</div>
							</div>
							<div class="am-form-group">
								<label for="user-name" class="am-u-sm-3 am-form-label">
								新密码</label>
								<div class="am-u-sm-9">
									<input type="password" id="xinpass" required
										placeholder="新密码" name="xinpass">
										<small>新密码...</small>
								</div>
							</div>
							<div class="am-form-group">
								<label for="user-name" class="am-u-sm-3 am-form-label">
								确认密码</label>
								<div class="am-u-sm-9">
									<input type="password" id="quepass" required
										placeholder="确认密码" name="quepass">
										<small>确认密码...</small>
								</div>
							</div>
							<div class="am-form-group">
								<div class="am-u-sm-9 am-u-sm-push-3">
								  <!--   <input type="reset" class="btn btn-danger" value="重置" /> -->
									<input type="button" class="am-btn am-btn-success" value="修改" id="btn" />
									<input type="reset" class="btn btn-danger" value="重置" />
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<footer class="admin-content-footer">
			<hr>
			<p class="am-padding-left"></p>
			</footer>
		</div>
		<!-- content end -->
	</div>
	 <script type="text/javascript">
	      
	      var username = "<%=user.getUsername() %>";
	      var password = "<%=user.getPassword() %>";
	      $("#btn").click(function(){
	    	  /* alert(username);
	    	  alert(password); */
	    	  var yuanpass = $("#yuanpass").val();
	    	  var xinpass = $("#xinpass").val();
	    	  var quepass = $("#quepass").val();
	    	//  alert(password);
	    	//  alert(yuanpass+"||"+xinpass+"||"+quepass);
	    	  if(yuanpass!=password){
	    		  alert("原密码错误");
	    		  return false;
	    	  }
	    	  if(xinpass!=quepass){
	    		  alert("确认密码错误");
	    		  return false;
	    	  }
	    	 /// alert(yuanpass+"||"+xinpass+"||"+quepass);
	    	  $.ajax({
	    		  url:"${APP_PATH}/update.do",
	    		  type:"post",
	    		  data:"username="+username+"&password="+xinpass,
	    		  success:function(result){
	    			  if(result.code==100){
	    				  alert("修改成功，请重新登陆");
	    				  parent.window.location.href="${APP_PATH}/tologin.do";
	    			  }else{
	    				  alert("修改失败，请联系管理员");
	    			  }
	    			//  parent.window.location.href="${APP_PATH}/tologin";
	    		  }
	    	  }); 
	      });
	 </script>
	</body>
</html>
