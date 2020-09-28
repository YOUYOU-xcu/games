<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'product.jsp' starting page</title>
    
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
			#context{
				margin: 0px auto;
				width: 100%;
				height: 100%;
			}
			#goods{
				width: 100%;
				
			}
			#main_img{
				width: 300px;
				height: 300px;
			}
			#goods_name{
				font-size: 20px;
				
			}
			#goods>div{
				float: left;
				margin-left: 50px;
			}
			#price{
				font-size: 20px;
				font-style: normal;
				color: red;
				margin-left: 10px;
			}
			#goods_info{
				width: 500px;
			}
			p{
				margin-top: 10px;
			}
			#div_price{
				margin-top: 50px;
				width: 500px;
				background-color: aliceblue;
				font-size: 10px;
				
			}
			#other{
				margin-top: 50px;
			}
			#cart{
				width: 170px;
				height: 60px;
				margin-top: 20px;
				background-color: orangered;
				color: #ccc;
			}
			.img{
				width:65px;
				height:60px;
				margin-left: 3px;
			}
		</style>
		<script type="text/javascript" src="${js}/jquery.min.js"></script>
  </head>
  
  <body>
   	<div id="context">
   
   	<a href="${path}">回到首页</a>|<a href="${path}/u/cartList">浏览购物车</a>
			<div id="goods">
				<div id="goods_img">
					<img src="${upload}/${product.proimg}" id="main_img" /><br>
					<img onclick="changeImg(this)" src="${upload}/${product.proimg}"   class="img">
<%--					<c:forEach items="${product.list}" var="img">
						<img onclick="changeImg(this)" src="${upload}/${img.uuidname}"   class="img">
					</c:forEach>--%>
				</div>
				<div id="goods_info">
					<p id="goods_name">${product.profullname}</p>
					<div id="div_price">
						售价:<span id="price">${product.proprice}</span> <a href="#">降价通知</a>
						单位:<span>${product.unit}</span>
					</div>
					<div id="edit">
						<input type="hidden" value="${product.id}" id="proId"/>
						<input type="button" id="addcart" value="加入购物车" onclick="addCart()"/>
					</div>
				</div>
			</div>
		</div>
  </body>
  <script type="text/javascript">
	  function addCart() {
		 var proId = $("#proId").attr("value");
		  // alert(proId)
		  $.ajax({
			  url:"${path}/u/addCart",
			  type:"GET",
			  data:{"proId":proId},
			  success:function (result) {
			  	if (result=="failure"){
			  		alert("您还未登录，请先登录！")
					location.href="${path}/user/login.jsp"
				}else {
			  		alert("您已成功添加此商品")
				}
			  },
			  datatype:"text"
		  });
	  }

  </script>
</html>
