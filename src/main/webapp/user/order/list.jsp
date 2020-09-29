<%--
  Created by IntelliJ IDEA.
  User: 张佑
  Date: 2020/9/28 0028
  Time: 8:56
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
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
    <script type="text/javascript" src="${path}/js/jquery.min.js"></script>

</head>

<body>
<a href="${path}">回到首页</a>
<div id="content">
    <c:if test="${empty orderList}">
        您还没有创建过订单……
    </c:if>
    <c:if test="${not empty orderList}">
       <table border="1" cellpadding="0" cellspacing="0">
            <thead>
            <tr>
                <th>订单号</th>
                <th>订单总价</th>
                <th>创建时间</th>
                <th>订单状态</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${orderList}" var="order">
                <tr>
                    <td>${order.sn}</td>
                    <td>${order.totalprice}元</td>
                    <td>${order.createdate}</td>
                    <c:if test="${order.status eq 0}">
                        <td><a href="javascript:void(0)" class="toPay" name="${order.sn}">
                            <font color="red">未支付，点击支付</font>
                            </a>
                        </td>
                    </c:if>
                    <c:if test="${order.status eq 1}">
                        <td><font color="green">已支付</font></td>
                    </c:if>
                </tr>
                </c:forEach>
            </tbody>
            <tfoot>
            </tfoot>
        </table>
    </c:if>
</div>
<script>
    $(".toPay").click(function () {
        var orderSn = $(this).attr("name");
        location.href="${path}/u/toPay?orderSn="+orderSn;
    })
</script>
</body>


</html>

