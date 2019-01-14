<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品订单信息</title>
<link href="css/main.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
var tempClassName="";
function tr_mouseover(obj) 
{ 
	tempClassName=obj.className;
	obj.className="list_mouseover";
}
function tr_mouseout(obj)      
{ 
	obj.className=tempClassName;
}      
function CheckAll(obj) 
{
	var checks=document.getElementsByName("chkid");
    for (var i=0;i<checks.length;i++)
	{
	    var e = checks[i];
	    e.checked = obj.checked;
	}
    
}


function serch()
{
   document.info.action="Admin_listOrderssSum.action";
   document.getElementById("pageNo").value=1;
   document.info.submit();
}
function GoPage()
{
  var pagenum=document.getElementById("goPage").value;
  var patten=/^\d+$/;
  if(!patten.exec(pagenum))
  {
    alert("页码必须为大于0的数字");
    return false;
  }
  document.getElementById("pageNo").value=pagenum;
  document.info.action="Admin_listOrderssSum.action";
  document.info.submit();
}
function ChangePage(pagenum)
{
  document.getElementById("pageNo").value=pagenum;
  document.info.action="Admin_listOrderssSum.action";
  document.info.submit();
}
</script>
</head>
<body>
<div class="pageTitle">
	&nbsp;&nbsp;<img src="images/right1.gif" align="middle" /> &nbsp;<span id="MainTitle" style="color:white">租赁信息统计</span>
</div>
<form name="info" id="info" action="Admin_listOrderssSum.action" method="post">
<input type="hidden" name="pageNo" id="pageNo" value="${paperUtil.pageNo}"/>
<table width="95%" align="center" cellpadding="0" cellspacing="0">
  <tr><td colspan="2" height="10px">&nbsp;</td></tr>
  <tr>
    <td width="">租赁信息统计列表</td>
    <td width="" align="right">
             类别：
      <select id="goods_type_id" name="goods_type_id" class="selectstyle" style="width:100px;">
      	<option value="0">请选择</option>
      	<c:forEach items="${goodsTypes}" var="goodsType">
      	<option value="${goodsType.goods_type_id}" ${goodsType.goods_type_id==paramsOrders.goods_type_id?'selected':''}>${goodsType.goods_type_name}</option>
      	</c:forEach>
      </select>&nbsp;
            物品名称：
      <input type="text" name="goods_name" value="${paramsOrders.goods_name}" class="inputstyle" Style="width:100px;"/>&nbsp;
            月份起止：
      <input type="text" name="orders_month_min" value="${paramsOrders.orders_month_min}" class="inputstyle" Style="width:100px;"
      		onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM'})"/>
      &nbsp;- &nbsp;
      <input type="text" name="orders_month_max" value="${paramsOrders.orders_month_max}" class="inputstyle" Style="width:100px;"
      		onfocus="WdatePicker({skin:'whyGreen',dateFmt:'yyyy-MM'})"/>&nbsp;
      <input type="button" value="搜索" onclick="serch();" class="btnstyle"/>&nbsp;
    </td>
  </tr>
  <tr><td colspan="2" height="2px"></td></tr>  
</table>
<table width="95%" align="center" class="table_list" cellpadding="0" cellspacing="0">
   <tr class="listtitle">
     <td width="" align="center">序号</td>
     <td width="" align="center">物品名称</td>
     <td width="" align="center">租赁数量</td>
   </tr>
    <c:if test="${orderss!=null && fn:length(orderss)>0}">
   <c:forEach items="${orderss}" var="orders" varStatus="status">
   <tr class="list0" onmouseover="tr_mouseover(this)" onmouseout="tr_mouseout(this)"> 
     <td width="" align="center">${status.index+1+paramsOrders.start}</td>
     <td width="" align="center">${orders.goods_name}</td>
     <td width="" align="center">${orders.goods_count}</td>
   </tr> 
   </c:forEach>
   </c:if>
   <c:if test="${orderss==null || fn:length(orderss)==0}">
   <tr>
     <td height="60" colspan="12" align="center"><b>&lt;不存在租赁信息统计信息&gt;</b></td>
   </tr>
   </c:if>
</table>
<jsp:include page="page.jsp"></jsp:include>
</form> 
</body>
</html>