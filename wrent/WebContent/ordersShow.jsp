<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>我的订单信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/store.css">
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
	 <jsp:include page="leftMenu.jsp"></jsp:include>
	 <!--  购物车 -->
	 <div id="product_info">
			<div class="title">个人中心  &gt;&gt;  我的订单信息</div>
			<div style="margin-top:5px">
				 <table class="ptable" style="margin-bottom:5px;">
					<tr class="head_text">
				         <td width="" align="center">订单编号</td>
					     <td width="100" align="center">物品名称</td>
					     <td width="" align="center">租赁数量</td>
					     <td width="100" align="center">租赁起止</td>
					     <td width="" align="center">联系电话</td>
					     <td width="" align="center">订单总额</td>
					     <td width="" align="center">当前状态</td>
					     <td width="" align="center">操作</td>
					</tr>
					<c:if test="${orderss!=null && fn:length(orderss)>0}">
   					<c:forEach items="${orderss}" var="orders" varStatus="status">
					   <tr> 
					     <td width="" align="center">${orders.orders_no}</td>
					     <td width="" align="center">${orders.goods_name}</td>
					     <td width="" align="center">${orders.goods_count}</td>
					     <td width="" align="center">${orders.orders_date1}至${orders.orders_date2}</td>
					     <td width="" align="center">${orders.user_phone}&nbsp;</td>
					     <td width="" align="center">${orders.goods_money}</td>
					     <td width="" align="center">${orders.orders_flagDesc}</td>
					     <td width="" align="center" style="line-height:25px">
					       <a href="page_queryMyOrders.action?orders_id=${orders.orders_id}">查看</a>
					       <c:if test="${orders.orders_flag==2}">
					       <br/><a id="finishOrders_${orders.orders_id}" href="javascript:void(0)">归还</a>
					       </c:if>
					     </td>
					   </tr> 
					    </c:forEach>
					   </c:if>
					   <c:if test="${orderss==null && fn:length(orderss)==0}">
					   <tr>
					     <td height="60" colspan="11" align="center"><b>&lt;不存在物品订单信息&gt;</b></td>
					   </tr>
					   </c:if>
				 </table>
			</div>
			<div class="pages">
				<jsp:include page="page.jsp"></jsp:include>
			</div>
		</div>
	 <!--  购物车 -->
</div>
<jsp:include page="bottom.jsp"></jsp:include>
<script language="javascript" type="text/javascript">
	function GoPage()
	{
	  var pagenum=document.getElementById("goPage").value;
	  var patten=/^\d+$/;
	  if(!patten.exec(pagenum))
	  {
	    alert("页码必须为大于0的数字");
	    return false;
	  }
	  window.location.href="page_listMyOrderss.action?pageNo="+pagenum;
	}
	function ChangePage(pagenum)
	{
		window.location.href="page_listMyOrderss.action?pageNo="+pagenum;
	}
	
	$(document).ready(function(){
		$("a[id^='finishOrders']").bind('click',function(){
		    if(confirm('确认归还吗!?'))
		    {
		    	var orders_id=$(this).attr('id').split('_')[1];
		    	var aQuery = {
						'orders_id':orders_id
				};  
				$.post('page_finishOrders.action',aQuery,
					function(responseObj) {
							if(responseObj.success) {	
								 alert('归还成功！请等待确认');
								 window.location.reload();
							}else  if(responseObj.err.msg){
								 alert('归还失败：'+responseObj.err.msg);
							}else{
								 alert('归还失败：服务器异常！');
							}	
				},'json');
		    }
		 });
		
	});
	 
</script>
</body>
</html>