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
  <a href="${path}">回到首页</a>
    <div id="content">
		<c:if test="${empty cartList}">
			购物车空空如也……
		</c:if>
		<c:if test="${not empty cartList}">
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
					<form id="form" action="" method="post" onsubmit="return submitCheck()">
					<c:forEach items="${cartList}" var="cart">
					<tr>
						<td><input type="checkbox" class="chk" name="cartIds" value="${cart.id}"/></td>
						<td><img src="${upload}/${cart.proimg}"/><span>${cart.profullname}</span></td>
						<td><span class="price">${cart.price}</span></td>
						<td>
							<input type="button" value="-" class="downOne"/>
							<input type="text" value="${cart.num}" class="cartNum" disabled/>
							<input type="button" value="+" onclick="addOne(${cart.product})"/>
                            <input type="hidden" value="${cart.id}" class="cartId"/>
							<input type="hidden" value="${cart.product}" class="proId"/>
						</td>
						<td><span class="subtotal"></span></td>
						<td><a href="javascript:deleteCartOne(${cart.id});">删除</a></td>
					</tr>
					</c:forEach>
				</tbody>
				<tfoot>
				<tr>
					<td colspan="5" >总计:<span id="sum" name="sum">0.00</span></td>
					<td id="td"><input type="submit" id="submit" value="结算"/></td>
<%--					<td id="clear"><a href="javascript:deleteCartAll();">清空购物车</a></td>--%>
				</tr>
				</form>

				</tfoot>
			</table>
		</c:if>
		</div>
  </body>

  <script>

	   function submitCheck(){
		   var tol=$("#sum").text()
		   if (tol==0){
			   alert("请先选择商品进行结算")
			   return false;
		   }else {
			   var duoxuan = $("input[name='cartIds']:checked").map(function () {
				   return $(this).val();
			   }).get().join(',');

			   var f = document.getElementsByTagName("form")[0];
			   f.action="${path}/u/createOrder?sum="+tol+"&duoxuan="+duoxuan;
		   }
	   }

	  //减少一个商品

       $(".downOne").click(function () {
           var cartNum = $(this).parent().children(".cartNum").val();
           var cartId = $(this).parent().children(".cartId").val();
           var proId = $(this).parent().children(".proId").val();

           // alert("购物车"+cartId+"的商品+"+proId+"+的数量为："+cartNum)

           if (cartNum==1){
               //判断商品数量是否为1，询问用户是否需要执行删除操作
               deleteCartOne(cartId);
               return ;
           }else {//数量不为1，正常减1
               if (confirm("您确定要减少一个此商品吗？")){
                   location.href="${path}/u/downCartOne?proId="+proId;
               }
           }
       })


	  //增加一个商品
	  function addOne(proId) {
		  if (confirm("您确定要再次添加此商品吗？")){
			  location.href="${path}/u/addCartOne?proId="+proId;
		  }
	  }

	  function deleteCartOne(cartId) {
		  if (confirm("您确定要删除此商品吗？")){
			  location.href="${path}/u/deleteCartOne?cartId="+cartId;
		  }
	  }

	  function deleteCartAll() {
		  if (confirm("您确定要删除所有商品吗？")){
			  location.href="${path}/u/deleteCartAll";
		  }
	  }

  </script>

</html>
