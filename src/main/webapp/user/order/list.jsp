<%--
  Created by IntelliJ IDEA.
  User: 张佑
  Date: 2020/9/28 0028
  Time: 8:56
--%>
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
      /*  // var numReg=/^([1-9][0-9]*){1,3}$/;
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
        })*/
    </script>


</head>

<body>
<a href="${path}">回到首页</a>
<div id="content">
<%--    <c:if test="${empty cartList}">--%>
<%--        您还没有创建过订单……--%>
<%--    </c:if>--%>
<%--    <c:if test="${not empty cartList}">--%>
        <table border="1" cellpadding="0" cellspacing="0">
            <thead>
            <tr>
<%--                <th><input type="checkbox" id="allChk"/>全选</th>--%>
                <th>商品id</th>
                <th>所属用户</th>
                <th>订单号</th>
                <th>订单总价</th>
                <th>创建时间</th>
                <th>订单状态</th>
<%--                <th>操作</th>--%>
            </tr>
            </thead>
            <tbody>
<%--                <c:forEach items="${orderList}" var="order">--%>
                <tr>
                    <td>123456</td>
                    <td>张三</td>
                    <td>dagfkjgfg45541313</td>
                    <td>6668元</td>
                    <td><%=new Date()%></td>
                    <td>未支付</td>
                </tr>
                <tr>
                    <td>22</td>
                    <td>33</td>
                    <td>44</td>
                    <td>55</td>
                    <td>66</td>
                </tr>
<%--                </c:forEach>--%>
            </tbody>
            <tfoot>

            </tfoot>
        </table>
<%--    </c:if>--%>
</div>
</body>


</html>

