<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>婚庆用品订单详情</title>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<script language="javascript" type="text/javascript">
$(document).ready(function(){
	 
});
</script>
<style type="text/css">
</style>
</head>
<body>
<div class="pageTitle">
	&nbsp;&nbsp;<img src="images/right1.gif" align="middle" /> &nbsp;<span id="MainTitle" style="color:white">婚庆用品订单详情</span>
</div>
<table width="800" align="center" cellpadding="0" cellspacing="0" style="margin-top:10px;margin-bottom:10px;">
  <tr> 
     <td height="24">
       <Table border="0" cellspacing="0" cellpadding="0" align="center" width="100%"> 
            <TR>
              <TD height="24" class="edittitleleft">&nbsp;</TD>
              <TD class="edittitle">婚庆用品订单详情</TD>
              <TD class="edittitleright">&nbsp;</TD>
            </TR>
        </TABLE>
     </td>
   </tr>
   <tr>
     <td height="1" bgcolor="#8f8f8f"></td>
   </tr>
   <tr>
     <td >
     <table width="100%" align="center" cellpadding="1" cellspacing="1" class="editbody">
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
     </table>
     </td>
   </tr> 
   <tr>
     <td>
       <table width="100%" align="center" cellpadding="0" cellspacing="0" class="editbody">
        <tr class="editbody">
          <td align="center" height="30">
          	<input type="button" id="editBtn" Class="btnstyle" value="返 回" onclick="window.history.back(-1);"/> 
          </td>
        </tr>
      </table>
     </td>
   </tr> 
</table>
</body>
</html>