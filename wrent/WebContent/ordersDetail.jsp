<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>查看订单详情</title>
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
			<div class="title">个人中心  &gt;&gt;  查看订单详情</div>
			<div style="margin-top:5px">
				 <form id="info" name="info" action="page_saveUserFront.action" method="post">    
				 <table class="ptable" style="margin-bottom:5px;">
					<tr>
			          <td width="150" align="right" style="padding-right:5px">订单编号：</td>
			          <td width="*">
			          	${orders.orders_no}
			          </td>
			        </tr> 
			        <tr>
			          <td align="right" style="padding-right:5px">用户姓名：</td>
			          <td>
			          	${orders.real_name}
			          </td>
			        </tr> 
			        <tr>
			          <td align="right" style="padding-right:5px">联系地址：</td>
			          <td>
			          	${orders.user_address}
			          </td>
			        </tr>
			        <tr>
			          <td align="right" style="padding-right:5px">联系电话：</td>
			          <td>
			          	${orders.user_phone}
			          </td>
			        </tr>
			        <tr>
			          <td align="right" style="padding-right:5px">物品名称：</td>
			          <td>
			          	${orders.goods_name}
			          </td>
			        </tr> 
			        <tr>
			          <td align="right" style="padding-right:5px">租金：</td>
			          <td>
			          	${orders.goods_price} 元/天
			          </td>
			        </tr> 
			        <tr>
			          <td align="right" style="padding-right:5px">租赁押金：</td>
			          <td>
			          	${orders.goods_yj} 元
			          </td>
			        </tr> 
			        <tr>
			          <td align="right" style="padding-right:5px">日违约金：</td>
			          <td>
			          	${orders.goods_price2} 元/天
			          </td>
			        </tr> 
			        <tr>
			          <td align="right" style="padding-right:5px">租赁数量：</td>
			          <td>
			          	${orders.goods_count}
			          </td>
			        </tr> 
			        <tr>
			          <td align="right" style="padding-right:5px">租赁起止：</td>
			          <td>
			          	${orders.orders_date1}至${orders.orders_date2}
			          </td>
			        </tr> 
			        <tr>
			          <td align="right" style="padding-right:5px">订单总额：</td>
			          <td>
			          	${orders.goods_money}
			          </td>
			        </tr> 
			        <tr>
			          <td align="right" style="padding-right:5px">实际归还：</td>
			          <td>
			          	${orders.orders_date3}
			          </td>
			        </tr> 
			        <tr>
			          <td align="right" style="padding-right:5px">缴纳罚金：</td>
			          <td>
			          	${orders.goods_money2}
			          </td>
			        </tr> 
			        <tr>
			          <td align="right" style="padding-right:5px">当前状态：</td>
			          <td>
			          	${orders.orders_flagDesc}
			          </td>
			        </tr> 
			        <tr class="">
			          <td align="center" height="30" colspan="4">
			            <input type="button" id="editBtn" Class="btnstyle" value="返 回" onclick="window.history.back(-1);"/> 
			          </td>
			        </tr>
				 </table>
				 </form>
			</div>
		</div>
	 <!--  购物车 -->
</div>
<jsp:include page="bottom.jsp"></jsp:include>
<script language="javascript" type="text/javascript">
	$(document).ready(function(){
		
	});	 
</script>
</body>
</html>