<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>我的购物车</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/reg.css">
<link rel="stylesheet" type="text/css" href="css/info.css">
<script language="javascript" type="text/javascript" src=""></script>
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script language="javascript" type="text/javascript"> 
	 
	
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
<div id="middle">
	<div id="list">
		 <div class="nav">当前位置: 主页 > 我的购物车 </div>
		 <div class="list_info">
			 <table class="regTable">
			 	<tr class="theme">
					<td width="" align="center">物品名称</td>
				    <td width="" align="center">租金</td>
				    <td width="" align="center">租赁起止</td>
				    <td width="" align="center">租赁数量</td>
				    <td width="" align="center">订单总额</td>
				    <td width="" align="center">操作</td>
				</tr>
			 	<c:if test="${ordersDetails!=null && fn:length(ordersDetails)>0}">
   				<c:forEach items="${ordersDetails}" var="ordersDetail" varStatus="status">
				<tr>
     				<td width="" align="center">${ordersDetail.goods_name}</td>
					<td width="" align="center" id="goods_price-${ordersDetail.goods_id}">￥${ordersDetail.goods_price} 元/天</td>
     				<td width="" align="center">${ordersDetail.orders_date1} 至 ${ordersDetail.orders_date2}</td>
					<td width="" align="center">
						<input type="text" id="goods_count-${ordersDetail.goods_id}" value="${ordersDetail.goods_count}" style="width:80px"/>
					</td>
					<td width="" align="center" id="goods_money-${ordersDetail.goods_id}">￥${ordersDetail.goods_money}</td>
					<td width="" align="center">
						<a href="page_delGoodsFromCard.action?goods_id=${ordersDetail.goods_id}">删除</a>
					</td>
			    </tr> 
			    </c:forEach>
			    <tr>
					<td align="center" colspan="5">
						<input type="button" class="btnstyle" onclick="window.location.href='page_listGoodss.action'" value="继续浏览"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" id="clearBtn" class="btnstyle" value="清空购物车"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="button" id="addBtn" class="btnstyle" value="提交订单"/>
						
					</td>
				</tr>
				</c:if>
			    <c:if test="${ordersDetails==null || fn:length(ordersDetails)==0}">
			   <tr>
			     <td height="60" colspan="10" align="center"><b>&lt;不存在物品信息&gt;</b></td>
			   </tr>
			   </c:if>
		 	 </table>
		 </div>
	</div>
	<div id="Picture"></div>
</div>
<jsp:include page="bottom.jsp"></jsp:include>
<script language="javascript" type="text/javascript">
$(document).ready(function(){
	var num= /^\d+$/;
	var addBtn = $("#addBtn");
	var clearBtn = $("#clearBtn");
	//清空购物车
	clearBtn.bind("click",function(){
		if(confirm('确认清空购物车吗!?')){
	       window.location.href="page_clearCard.action";
	    }
	});
	
	//提交订单
	addBtn.bind("click",function(){
		$("input[id^='goods_count']").each(function(){
			var goods_count = $(this).val();
			if(!num.exec(goods_count)){
				alert('购物车内所有物品数量必须为大于0的数字！');
				return;
			}
			if(Number(goods_count)<=0){
				alert('购物车内所有物品数量不能为空！');
				return;
			}
			window.location.href="page_addOrdersShow.action";
		});
	});
	
	//修改购物车
	var temp_count=0;
	$("input[id^='goods_count']").focus(function(){
		temp_count = $(this).val();
	});
	$("input[id^='goods_count']").blur(function(){
		var goods_id = $(this).attr('id').split('-')[1];
		var goods_count = $(this).val();
		if(!num.exec(goods_count)){
			alert('购物车内所有物品数量必须为大于0的数字！');
			return;
		}
		if(Number(goods_count)!=Number(temp_count)){
			var aQuery = {
					'goods_id':goods_id,
					'goods_count':goods_count
			};  
			$.post('page_modifyCard.action',aQuery,
				function(responseObj) {
						if(responseObj.success) {	
							 //alert('修改成功！');
							 //var goods_price = Number($("#goods_price-"+goods_id).html().replace('￥','').replace(' 元/天',''));
							 //$("#goods_money-"+goods_id).html('￥'+Number(goods_count)*goods_price);
							 window.location.href="page_listCard.action";
						}else  if(responseObj.err.msg){
							 alert('失败：'+responseObj.err.msg);
						}else{
							 alert('失败：服务器异常！');
						}	
			 },'json');
		}
	});
});
</script>
</body>
</html>