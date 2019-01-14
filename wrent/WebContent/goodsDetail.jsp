<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>婚庆用品详情</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/product.css">
<link rel="stylesheet" type="text/css" href="css/message.css">
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script language="javascript" type="text/javascript" src="admin/My97DatePicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript">
 $(document).ready(function(){
	 
	 //点击预定
	 var user_id = "${userFront.user_id}";
	 var num = /^\d+$/;
	 $("#addCard").bind('click',function(){
		 if(user_id==''){
			 alert('请先登录');
			 return;
		 }
		 if(!num.exec($("#goods_count").val())){
			 alert('租赁数量必须为数字');
			 return;
		 }
		 if($("#orders_date1").val()=='' || $("#orders_date2").val()==''){
			 alert('租赁起止不能为空');
			 return;
		 }
		 var aQuery = $("#info").serialize();
		$.post('page_addCard.action',aQuery,
			function(responseObj) {
					if(responseObj.success) {	
						 window.location.href='page_listCard.action';
					}else  if(responseObj.err.msg){
						 alert('失败：'+responseObj.err.msg);
					}else{
						 alert('失败：服务器异常！');
					}	
		 },'json');
	 });
}); 
</script>
<style type="text/css">
 body,td,div
 {
   font-size:12px;
 }
 
</style>
</head>
<body>
<jsp:include page="top.jsp"></jsp:include>
<div id="middleBg">
	<!--  产品检索介绍 -->
	 <div id="product_info">
			<div class="productShow">
					<div class="title">${goods.goods_name}</div>
					<div class="typehr"></div>
					<div class="pictext">
							<div class="pic"><img src="images/goodss/${goods.goods_pic}" width="250px" height="250px"/></div>
							<div class="text">
									<form name="info" id="info" action="page_addCard.action" method="post">
									<input type="hidden" name="goods_id" id="goods_id" value="${goods.goods_id}"/>
									<input type="hidden" name="goods_name" id="goods_name" value="${goods.goods_name}"/>
									<input type="hidden" name="goods_price" id="goods_price" value="${goods.goods_price}"/>
									<input type="hidden" name="goods_yj" id="goods_price2" value="${goods.goods_price2}"/>
									<input type="hidden" name="goods_price2" id="goods_price2" value="${goods.goods_price2}"/>
									<div class="textTop" style="height:210px;line-height:30px;">
											物品类别：<span style="color:black">${goods.goods_type_name}</span>
											<br/>租金：<span style="color:black">￥${goods.goods_price} 元/天</span>
											<br/>租赁押金：<span style="color:black">￥${goods.goods_yj} 元</span>
											<br/>日违约金：<span style="color:black">￥${goods.goods_price2} 元/天</span>
											<br/>参考库存：<span style="color:black">${goods.goods_count}（以实际租赁为准）</span>
											<br/>租赁数量：<input type="text" id="goods_count" name="goods_count" value="1" style="width:80px"/>
											<br/>租赁起止：<input type="text" id="orders_date1" name="orders_date1" style="width:100px" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'%y-%M-{%d+1}'})"/>-<input type="text" id="orders_date2" name="orders_date2" style="width:100px" onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM-dd',minDate:'%y-%M-{%d+1}'})"/>
									</div>
									<div class="textBtn">
										<img id="addCard" src="images/addCard.png" style="border:none;cursor:pointer;vertical-align:middle" />&nbsp;&nbsp;
									</div>
									</form>
							</div>
					</div>
					<div class="typehr"></div>
					<div class="title">物品详情介绍</div>
					<div class="typehr"></div>
					<div class="intro">
						${goods.goods_descShow}
					</div>
					
			</div>

			 
			
	 </div>
	 <!--  产品检索 -->
	 
</div>
<jsp:include page="bottom.jsp"></jsp:include>
<script type="text/javascript">
var goods_id = "${goods.goods_id}";
</script>
</body>
</html>