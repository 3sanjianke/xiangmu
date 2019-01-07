<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.shop.utils.RandomValidateCode" %>
<%@include file="/common/common.jspf" %>
<%
  //  String msg = (String)session.getAttribute("loginMsg");

%>
<html lang="en">
<head>
    <title>登陆界面</title>
    <link href="${APP_PATH }/style/alogin.css" rel="stylesheet" type="text/css" />
<style>
     span {
        text-decoration:none;
        font-size:12px;
        color:#288bc4;
        padding-left:10px;
    }
</style>
<script type="text/javascript">
		
</script>
</head>
<form id="form1">
    <div class="Main">
        <ul>
            <li class="top"></li>
            <li class="top2"></li>
            <li class="topA"></li>
            <li class="topB"><span>
                <img src="images/login/logo.gif" alt="" style="" />
            </span></li>
            <li class="topC"></li>
            <li class="topD">
                <ul class="login">
                    <li>
                        <span class="left">账 号：</span> <span style="left">
                           <input id="username" type="text" name="username" class="txt" />                      
                        </span>
                    </li>
                    <li>
                        <span class="left">密 码：</span> <span style="left">
                            <input id="password" type="password" name="password" class="txt" />  
                        </span>
                    </li>
                    <li> 
                        <span class="left">校 验：</span> 
                        <span style="left">
                           <input id="yanzen" type="text" class="txtCode" name="yanzen"/>  
                        </span>   
                        <span>
                           <img src="${APP_PATH }/checkCode.do" alt="" width="85" height="22" class="passcode" style="height:22px;cursor:pointer;" onclick="this.src=this.src+'?'">
                        </span>       
                    </li>                   
                    <li>
                        <span class="left" id="msg"></span>                       
                    </li>     
                </ul>
            </li>
            <li class="topE"></li>
            <li class="middle_A"></li>
            <li class="middle_B"></li>
            <li class="middle_C">
            <span class="btn">
                <img alt="" src="images/login/btnlogin.gif" onclick="run()" />
            </span>
            </li>
            <li class="middle_D"></li>
            <li class="bottom_A"></li>
            <li class="bottom_B">
            </li>
        </ul>
    </div>
    </form>
    <script type="text/javascript">
          function run(){
        	 alert($("#form1").serialize());
        	 $.ajax({
        		 url:'${APP_PATH}/login.do',
        		 type:"post",
        		 data:$("#form1").serialize(),
        		 success:function(result){
        			 
        			 if(result.code==100){
        				
        				 alert(result.message);
        				 window.location.href = "${APP_PATH}/index.do";
        			 }else if(result.code==200){
        				 
        				 alert(result.message);
        			 }else{
        				
        				 alert(result.message);
        			 }
        		 }
        	 });
          }
    </script>
</body>
</html>