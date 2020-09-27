<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
	
			*{
				margin: 0px auto;
				padding: 0px;
			}
			
			html,body{
				width: 1024px;
				height: 768px;
			}
			
			#content{
				margin: 20px auto;
			}
			
			table{
				margin-top:20px ;
			}
			
			td{
				width: 260px;
				height:160px ;
				text-align: center;
			}
			
			img{
				width: 160px;
				height: 140px;
			}
			
			th{
				background-color: darkcyan;
			}
			
			input{
				width: 28px;
			}
			
			input[type='text']{
				text-align: center;
			}
			
			#allChk{
				text-align: left;
				height: 80px;
			}
			
			#td{
				height: 80px;
			}
			
			#div{
				width:260px ;
				height: 80px;
				line-height: 80px;
				background-color: red;
				font-size: 20px;
				color: #F0F8FF;
				border-radius: calc(15px);
			}
		</style>
		<script type="text/javascript" src="<%=path%>/js/jquery.min.js"></script>
		<script>
			// var numReg=/^([1-9][0-9]*){1,3}$/;
			$(function(){
				//计算小计 页面加载时计算
				// 数量*单价=小计
				function  countTotal(){//计算小计方法
					var trArr=$("tbody").children();
					for (var i=0;i<trArr.length;i++) {
						//数量 alert(trArr.eq(i).children().eq(3).children().eq(1).val())
						// 单价  alert(trArr.eq(i).children().eq(2).children().eq(0).text())
						trArr.eq(i).children().eq(4).children().eq(0).text((trArr.eq(i).children().eq(2).children().eq(0).text()*1*trArr.eq(i).children().eq(3).children().eq(1).val()*1).toFixed(2));
					}
				}
				
				function countSum(){//计算总价
					var trArr=$("tbody").children();
					var sum=0;
					for(var i=0;i<trArr.length;i++){
						if(trArr.eq(i).children().eq(0).children().eq(0).prop("checked")){
							sum+=(trArr.eq(i).children().eq(4).children().eq(0).text()*1);
						}
						
					}
					$("#sum").text(sum.toFixed(2))
				}
				
				countTotal();
				countSum();//计算总价

				$("#allChk").click(function(){
					var chkArr=$(".chk");
					for (var i=0;i<chkArr.length;i++) {
						chkArr.eq(i).prop("checked",$("#allChk").prop("checked"))
					}
					countSum();
				});
				
				$(".chk").click(function(){
					countSum();
				})
			})
		</script>
  </head>
  
  <body>
    <div id="content">
			<table border="1" cellpadding="0" cellspacing="0">
				<thead>
				<tr>
					<th><input type="checkbox" id="allChk"/>全选</th>
					<th>商品</th>
					<th>单价</th>
					<th>数量</th>
					<th>小计</th>
					<th>操作</th>
				</tr>
				</thead>
				<tbody>
					<form action="${path}/u/createOrder" method="post">
					<c:forEach items="${cartList}" var="cart">
					<tr>
						<td><input type="checkbox" class="chk" name="cartIds" value="${cart.id}"/></td>
						<td><img src="${upload}/${cart.goodsimg}"/><span>${cart.goodsname}</span></td>
						<td><span class="price">${cart.price}</span></td>
						<td><input type="button" value="-"/><input type="text" value="${cart.num}"  class="inNum"/><input type="button" value="+" class="addNum"/><input type="hidden" value="${cart.id}"/></td>
						<td><span class="subtotal"></span></td>
						<td><a href="#">删除</a></td>
					</tr>
					</c:forEach>
					
				</tbody>
				<tfoot>
				<tr>
					<td colspan="5" >总计:<span id="sum">0.00</span></td>
					<td id="td"><input type="submit" value="结算"/></td>
				</tr>
				</form>
				</tfoot>
			</table>
		</div>
  </body>
</html>
