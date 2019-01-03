<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@include file="/common/common.jspf" %>
<%
	List<String> listFenlei = new ArrayList<String>();
	listFenlei = (List<String>)application.getAttribute("listFenlei");
	List<String> listShop = new ArrayList<String>();
	listShop = (List<String>)application.getAttribute("listShop");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<!-- ------------------按钮绑事件 -->
  <script type="text/javascript">
      $(function(){
    	  
    	  $("#name_btn").click(function(){
	    		 alert("名称查询");
	    		 var text = $("#name_msg").val();
	    		 var msg = "shopName";
	    		 $.ajax({
	    			 url:"${APP_PATH}/yujin/selectOne.do",
	    			 type:"post",
	    			 data:"shopName="+text,
	    			 success:function(result){
	    				 if(result.code==100){
	    					 zhizuobiaogeByKey(result,msg);
	    					 alert("查询成功");
	    				 }else{
	    					 alert("查询失败，没有此分类");
	    				 }
	    			 }
	    		 });
	    	 });
    	  $("#fenlei_btn").click(function(){
	    		 alert("分类查询");
	    		
	    		 var text = $("#fenlei_msg").val();
	    		 var msg = "shopFenlei";
	    		 $.ajax({
	    			 url:"${APP_PATH}/yujin/selectOne.do",
	    			 type:"post",
	    			 data:"shopFenlei="+text,
	    			 success:function(result){
	    				 if(result.code==100){
	    					 zhizuobiaogeByKey(result,msg);
	    					 alert("查询成功");
	    				 }else{
	    					 alert("查询失败，没有此分类");
	    				 }
	    			 }
	    		 });
	    	 });
    	 
    	  $("#lianhe_btn").click(function(){
	    		 alert("联合查询");
	    		
	    		 var text1 = $("#name_msg1").val();
	    		 var text2 = $("#fenlei_msg1").val();
	    		
	    		 $.ajax({
	    			 url:"${APP_PATH}/yujin/selectOne.do",
	    			 type:"post",
	    			 data:"shopName="+text1 + "&shopFenlei="+text2,
	    			 success:function(result){
	    				 if(result.code==100){
	    					 zhizuobiaogeByKey(result);
	    					 alert("查询成功");
	    				 }else{
	    					 alert("查询失败，没有此分类");
	    				 }
	    			 }
	    		 });
	    	 });
      });
      /**
       * 待条件查询的表格
      **/
      function zhizuobiaogeByKey(result,msg){
	    	 var list = result.extend.pageInfo.list;
 			//清空之前的信息
 	    	$("#td").empty();
 			//遍历显示数据		    			
 			$.each(list,function(i,item){
 				var yujinId = item.yujinId;
 				var shopName = item.shopName;
 				var shopFenlei = item.shopFenlei;
 				var beizhu = item.beizhu;
 				var yujingShuliang = item.yujingShuliang;
 				//创建标签
 				var Tr = $("<tr></tr>");
 				var yujinIdTd = $("<td></td>").append(yujinId);
 				var shopNameTd = $("<td></td>").append(shopName);
 				var shopFenleiTd = $("<td></td>").append(shopFenlei);
 				var yujingShuliangTd = $("<td></td>").append(yujingShuliang);
 				var beizhuTd = $("<td></td>").append(beizhu);
 				var btnTd = $("<td></td>");
 				var btnG = $('<button type="button" class="btn btn-warning"></button>').append("编辑");
 				var btnS = $('<button type="button" class="btn btn-danger"></button>').append("删除");
                 btnTd.append(btnG).append(" ").append(btnS);
 				$("#td").append(Tr).append(yujinIdTd).append(shopNameTd).append(shopFenleiTd).append(yujingShuliangTd).append(beizhuTd).append(btnTd);
 			});
 			//分页信息
 			$("#fenyexx").empty();//清空分页信息 
 			var pageNum = result.extend.pageInfo.pageNum; //当前页
 			var pages = result.extend.pageInfo.pages; //总页数
 			var total = result.extend.pageInfo.total; //总记录数 
 			$("#fenyexx").append($("<strong></strong>").append("当前第"+pageNum+"页，总共"+pages+"页，总共"+total+"条记录"));
 			//分页条信息
 			$("#fenyetiao").empty(); //清空分页条信息 
 		    var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
 		    var firstLi = $("<li></li>").append($("<a></a>").append("&laquo;").attr("href","#"));
 		    if(!result.extend.pageInfo.hasPreviousPage){
 		    	//添加禁用状态
 		    	firstPageLi.addClass("disabled");
 		    	firstLi.addClass("disabled");
 		    }else{
 		    	//添加翻页事件
 			    firstPageLi.click(function(){
 			    	to_page(1);
 			    });
 			    firstLi.click(function(){
 			    	to_page(result.extend.pageInfo.pageNum-1);
 			    });
 		    }
 		    var ul = $("<ul></ul>").addClass("pagination").append(firstPageLi).append(firstLi);
 		    $.each(result.extend.pageInfo.navigatepageNums,function(index,item){
 		    	var li = $("<li></li>").append($("<a></a>").append(item).attr("href","#"));
 		    	//添加激活状态
 		    	if(item==result.extend.pageInfo.pageNum){
 		    		li.addClass("active");
 		    	}
 		    	li.click(function(){
 		    		to_page(item);
 		    	});
 		    	ul.append(li);
 		    });
 		    var lastLi = $("<li></li>").append($("<a></a>").append("&raquo;").attr("href","#"));
 		    var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
 		     
 		    if(!result.extend.pageInfo.hasNextPage){
 		    	//禁用状态
 		    	lastLi.addClass("disabled");
 		    	lastPageLi.addClass("disabled");
 		    }else{
 		    	//添加翻译点击事件
 		    	lastLi.click(function(){
 			    	to_page(result.extend.pageInfo.pageNum+1);
 			    });
 			    lastPageLi.click(function(){
 			    	to_page(result.extend.pageInfo.pages);
 			    });
 		    }
 		    ul.append(lastLi).append(lastPageLi);
 		    var nav = $("<nav></nav>").append(ul);
 		    $("#fenyetiao").append(nav);
	     }
  </script>
       <ul id="myTab" class="nav nav-tabs">
		   
		    <li class="active"><a href="#see" data-toggle="tab" style="font-size: 14px;"><strong>预警管理</strong></a></li>
	        <li><a href="#add" data-toggle="tab" style="font-size: 14px;"><strong>添加预警</strong></a></li>
		</ul>
		<div id="myTabContent" class="tab-content">

		    <div class="tab-pane fade in active" id="see">
		        <%-- <iframe src="${APP_PATH }/fenlei/seebase" width="100%" height="100%" style="border:0px;padding:0px;margin:0px"></iframe> --%>
		          <div class="row">
			             <strong><p>单条件查询</p></strong>
			      </div>
			      <div class="row">
			              <div class="input-group col-md-10 col-md-offset-1" style="margin-top:0px positon:relative">
						       
						       <input type="text" class="form-control"placeholder="请输入商品名称" id="name_msg"/>
						       <span class="input-group-btn">
						           <button class="btn btn-primary" id="name_btn">名称查询</button>
						       </span>
						       <input type="text" class="form-control"placeholder="请输入商品分类" id="fenlei_msg"/>
						       <span class="input-group-btn">
						            <button class="btn btn-primary" id="fenlei_btn">分类查询</button>
						       </span>
						       
						 </div>
					</div>
					<div class="row">
			              <strong>多条件联合查询</strong>
			          </div>
					<div class="row">
			              <div class="input-group col-md-10 col-md-offset-1" style="margin-top:0px positon:relative">
						       <div class="input-group ">
									
									<span class="input-group-addon">名称</span>
									<input type="text" class="form-control" placeholder="twitterhandle" id="name_msg1" />
									<span class="input-group-addon">分类</span>
									<input type="text" class="form-control" placeholder="twitterhandle" id="fenlei_msg1" />
									
							   </div>
						 </div>
					</div>
					<div class="row">
			              <div class="input-group col-md-10 col-md-offset-1" style="margin-top:0px positon:relative">
						       <div class="input-group">
									<button type="button" class="btn btn-primary" id="lianhe_btn">联合查询</button>	
							   </div>
						 </div>
					</div>
					<hr style="height:5px;border:none;border-top:5px ridge green;" />
					<div class="row">
						  <div class="col-md-8"><strong>库存管理</strong></div>
						  <div class="col-md-10 col-md-offset-1">
						         <table class="table table-bordered">
								    <thead>
								         <tr>
								             <td>预警编号</td>
								             <td>商品名称</td>
								             <td>商品分类</td>
								             <td>预警数量</td>
								             <td>操作</td>
								         </tr>
								    </thead>
								    <tbody id="td">
								        
								    </tbody>
								</table> 
						  </div>
					</div>
					<div class="row">
						  <div class="col-md-4" id="fenyexx">
						      <!-- 分页信息 -->
						  </div>
						  <div class="col-md-4 col-md-offset-4" id="fenyetiao">
						      
						  </div>			  
					</div>
		    </div>
		    <div class="tab-pane fade" id="add">
		     
		        <form class="form-horizontal" id="form1">
					  <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">预警编号</label>
					    <div class="col-sm-5">
					      <input type="text" class="form-control" id="yujinId" placeholder="编号" name="yujinId">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="inputPassword3" class="col-sm-2 control-label">商品名称</label>
					    <div class="col-sm-5">
					      <select class="form-control" id="shopName" placeholder="名称" name="shopName">
					           <c:forEach items="<%=listShop %>" var="user">
					               <option>${user }</option>
					           </c:forEach>
					      </select>
					    </div>
					  </div>
					   <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">商品分类</label>
					    <div class="col-sm-5">
					       <select class="form-control" id="shopFenlei"  name="shopFenlei">
					           <c:forEach items="<%=listFenlei %>" var="user">
					                <option value="${user }">${user }</option>
					           </c:forEach>
					      </select>
					    </div>
					  </div>
					   <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">预警数量</label>
					    <div class="col-sm-5">
					      <input type="text" class="form-control" id="yujingShuliang" placeholder="请输入预警数量" name="yujingShuliang">
					    </div>
					  </div>
					  <div class="form-group">
					    <label for="inputEmail3" class="col-sm-2 control-label">备       注</label>
					    <div class="col-sm-5">
					      <textarea class="form-control" rows="5" placeholder="250字以内。。。" id="beizhu" name="beizhu"></textarea>
					    </div>
					  </div>
					   <div class="form-group">
					    <div class="col-sm-2 col-md-offset-4">
					        <button type="button" class="btn btn-primary" id="tijiao">保存</button>
					        <input type="reset" class="btn btn-warning" value="重置"></input>
					    </div>
					  </div>
					</form>
		    </div>    
		</div>
		<!-- 修改模态框 -->
		 <div class="modal fade" tabindex="-1" role="dialog" id="upd_model">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title">预警修改</h4>
		      </div>
		      <div class="modal-body">
		        <form class="form-horizontal" id="upd_form">
				  <div class="form-group">
				    <label for="inputEmail3" class="col-sm-2 control-label" >预警编号</label>
				    <div class="col-sm-10">
				       <p class="form-control-static" id="upd_yujinId"></p>
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputPassword3" class="col-sm-2 control-label">商品名称</label>
				    <div class="col-sm-10">
				       <p class="form-control-static" id="upd_yujinName"></p>
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputPassword3" class="col-sm-2 control-label">商品分类</label>
				    <div class="col-sm-10">
				      <p class="form-control-static" id="upd_yujinFenlei"></p>
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputPassword3" class="col-sm-2 control-label">预警数量</label>
				    <div class="col-sm-10">
				        <input type="text" class="form-control" id="upd_Shuliang" placeholder="请输入预警数量" name="yujingShuliang">
				    </div>
				  </div>
				</form>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		        <button type="button" class="btn btn-primary" id="upd_btn_yujin">保存</button>
		      </div>
		    </div><!-- /.modal-content -->
		  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
		<!-- ---------------------------------------------js---------------------------- -->
		
		<script type="text/javascript">
		     $(function(){
		    	 to_page(1);
		    	/*  $("#id_btn").click(function(){
		    		 alert(111);
		    	 }); */
		     });
		     
		     //添加数据
		     
		     $("#tijiao").click(function(){
		    	 alert("保存数据");
		    	 $.ajax({
		    		 url:"${APP_PATH}/yujin/insert.do",
		    		 type:'post',
		    		 data:$("#form1").serialize(),
		    		 success:function(result){
		    			 if(result.code==100){
		    				 alert("添加成功");
		    				 window.location.href="${APP_PATH}/yujin/main.do";
		    			 }else{
		    				 var str = result.message;
		    				 alert(str);
		    				/*  alert("添加失败，请将系统异常告知管理员");
		    				 window.location.href="${APP_PATH}/yujin/main.do"; */
		    			 }
		    		 }
		    	 });
		     });
		     /***
		                *     显示数据 
		      */
		     function to_page(pn){
		    	 $.ajax({
		    		 url:'${APP_PATH}/yujin/selectAll.do',
		    		 type:'post',
		    		 data:"pn="+pn,
		    		 success:function(result){
                         
		    		    zhizuobiaoge(result);
		    		 }
		    	 });	    	 
		     }
		     /**
		      * 所有数据的制作表格
		     **/
		     function zhizuobiaoge(result){
		    	 var list = result.extend.pageInfo.list;
	    			//清空之前的信息
	    	    	$("#td").empty();
	    			//遍历显示数据		    			
	    			$.each(list,function(i,item){
	    				var yujinId = item.yujinId;
	    				var shopName = item.shopName;
	    				var shopFenlei = item.shopFenlei;
	    				var beizhu = item.beizhu;
	    				var yujingShuliang = item.yujingShuliang;
	    				//创建标签
	    				var Tr = $("<tr></tr>");
	    				var yujinIdTd = $("<td></td>").append(yujinId);
	    				var shopNameTd = $("<td></td>").append(shopName);
	    				var shopFenleiTd = $("<td></td>").append(shopFenlei);
	    				var beizhuTd = $("<td></td>").append(beizhu);
	    				var yujinShuliangTd = $("<td></td>").append(yujingShuliang);
	    				var btnTd = $("<td></td>");
	    				var btnG = $('<button type="button" class="btn btn-warning"></button>').append("编辑").attr("yujinId",yujinId);
	    				btnG.click(function(){
	    					alert("编辑");
	    					$.ajax({
	    						url:"${APP_PATH}/yujin/selectOne.do",
	    						type:"post",
	    						data:"yujinId="+yujinId,
	    						success:function(result){
	    							console.log(result);
	    							if(result.code==100){
	    								var list = result.extend.pageInfo.list;
	    								$.each(list,function(i,item){
	    									var yujinId = item.yujinId;
	    									var shopName = item.shopName;
	    									var shopFenlei = item.shopFenlei;
	    									var yujingShuliang = item.yujingShuliang;
	    									//先清空再填写
	    									$("#upd_yujinId").empty();
			    		                    $("#upd_yujinId").append(yujinId);
			    		                    $("#upd_yujinName").empty();
			    		                    $("#upd_yujinName").append(shopName);
			    		                    $("#upd_yujinFenlei").empty();
			    		                    $("#upd_yujinFenlei").append(shopFenlei);
			    		                    $("#upd_Shuliang").empty();
			    		                    $("#upd_Shuliang").val(yujingShuliang);
			    		                    $("#upd_btn_yujin").attr("yujinId",yujinId);
			    		                    //打开模态框
	    									$('#upd_model').modal({
	    			    						 backdrop:"static"
	    			    					 });
	    								});
	    							}else{
	    								alert("修改失败，请将系统异常告知管理员");
	    							}
	    						}
	    					});
	    					/* $('#upd_model').modal({
	    						 backdrop:"static"
	    					 }); */
	    				});
	    				var btnS = $('<button type="button" class="btn btn-danger"></button>').append("删除").attr("yujinId",yujinId);
	    				btnS.click(function(){
	    					alert("删除");
	    					var str1 = btnS.attr("yujinId");
	    					alert(str1);
	    					$.ajax({
	    						url:"${APP_PATH}/yujin/delete.do",
	    						type:'post',
	    						data:"yujinId="+yujinId,
	    						success:function(result){
	    							if(result.code==100){
	    								alert("删除成功");
	    								window.location.href="${APP_PATH}/yujin/main.do";
	    							}else{
	    								alert("删除失败，请将系统异常告知管理员");
	    							}
	    						}
	    					});
	    				});
	                    btnTd.append(btnG).append(" ").append(btnS);
	    				$("#td").append(Tr).append(yujinIdTd).append(shopNameTd).append(shopFenleiTd).append(yujinShuliangTd).append(beizhuTd).append(btnTd);
	    			});
	    			//分页信息
	    			$("#fenyexx").empty();//清空分页信息 
	    			var pageNum = result.extend.pageInfo.pageNum; //当前页
	    			var pages = result.extend.pageInfo.pages; //总页数
	    			var total = result.extend.pageInfo.total; //总记录数 
	    			$("#fenyexx").append($("<strong></strong>").append("当前第"+pageNum+"页，总共"+pages+"页，总共"+total+"条记录"));
	    			//分页条信息
	    			$("#fenyetiao").empty(); //清空分页条信息 
	    		    var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
	    		    var firstLi = $("<li></li>").append($("<a></a>").append("&laquo;").attr("href","#"));
	    		    if(!result.extend.pageInfo.hasPreviousPage){
	    		    	//添加禁用状态
	    		    	firstPageLi.addClass("disabled");
	    		    	firstLi.addClass("disabled");
	    		    }else{
	    		    	//添加翻页事件
	    			    firstPageLi.click(function(){
	    			    	to_page(1);
	    			    });
	    			    firstLi.click(function(){
	    			    	to_page(result.extend.pageInfo.pageNum-1);
	    			    });
	    		    }
	    		    var ul = $("<ul></ul>").addClass("pagination").append(firstPageLi).append(firstLi);
	    		    $.each(result.extend.pageInfo.navigatepageNums,function(index,item){
	    		    	var li = $("<li></li>").append($("<a></a>").append(item).attr("href","#"));
	    		    	//添加激活状态
	    		    	if(item==result.extend.pageInfo.pageNum){
	    		    		li.addClass("active");
	    		    	}
	    		    	li.click(function(){
	    		    		to_page(item);
	    		    	});
	    		    	ul.append(li);
	    		    });
	    		    var lastLi = $("<li></li>").append($("<a></a>").append("&raquo;").attr("href","#"));
	    		    var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
	    		     
	    		    if(!result.extend.pageInfo.hasNextPage){
	    		    	//禁用状态
	    		    	lastLi.addClass("disabled");
	    		    	lastPageLi.addClass("disabled");
	    		    }else{
	    		    	//添加翻译点击事件
	    		    	lastLi.click(function(){
	    			    	to_page(result.extend.pageInfo.pageNum+1);
	    			    });
	    			    lastPageLi.click(function(){
	    			    	to_page(result.extend.pageInfo.pages);
	    			    });
	    		    }
	    		    ul.append(lastLi).append(lastPageLi);
	    		    var nav = $("<nav></nav>").append(ul);
	    		    $("#fenyetiao").append(nav);
		     }
		     //修改点击事件
		     $("#upd_btn_yujin").click(function(){
		    	 /* alert("daf"); */
		    	 alert("提交数据");
		    	 var yujinId = $("#upd_btn_yujin").attr("yujinId");
		    	 var shopName = $("#upd_yujinName").text();
		    	 var shopFenlei = $("#upd_yujinFenlei").text();
		    	 var yujingShuliang = $("#upd_Shuliang").val();
		    	 $.ajax({
		    		 url:"${APP_PATH}/yujin/update.do",
		    		 data:"yujinId="+yujinId+"&shopName="+shopName+"&shopFenlei="+shopFenlei+"&yujingShuliang="+yujingShuliang,
		    		 type:'post',
		    		 success:function(result){
		    			 if(result.code==100){
		    				 alert("修改成功");
		    				 window.location.href="${APP_PATH}/yujin/main.do";
		    			 }else{
		    				 alert("修改失败，请将系统异常告知管理员");
		    				 window.location.href="${APP_PATH}/yujin/main.do";
		    			 }
		    		 }
		    	 });
		     });
		     
		     
		     $("#shopName").change(function(){
		    	   var shopName = $("#shopName").val();
		    	   $.ajax({
		    		   url:"${APP_PATH}/chuku/selectByName.do",
		    		   type:"post",
		    		   data:"shopName="+shopName,
		    		   success:function(result){
		    			   
		    			   console.log(result);
		    			   if(result.code==100){
			    				 var test= result.extend.map.fenlei;
			    				 var shuliang=result.extend.map.shuliang;
			    				
			    				// alert(test+"||"+shuliang);
			    				 $("#shopFenlei").find("option[value='"+test+"']").prop('selected',true);
			    				 //显示当前剩余数量
			    				// $("#shuliang11").html("sdaf");
			    				 $("#shuliang11").empty();
			    				 $("#shuliang11").append("剩余"+shuliang);
		    			   }else{
			    				   alert("软件发生异常，请联系管理员");
			    				   window.location.href="${APP_PATH}/top.do";
		    			   }
		    		   }
		    	   });
		     });
		</script>
</body>
</html>