<%--
Created by IntelliJ IDEA.
User: 张佑
Date: 2020/9/29 0029
Time: 16:16
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
  <link rel="stylesheet" href="${css}/pintuer.css">
  <link rel="stylesheet" href="${css}/admin.css">
  <script src="${js}/jquery.js"></script>
  <script src="${js}/pintuer.js"></script>

  <script>
    $(function () {

    $("#myForm").submit(function () {
      var renewpass = $("#renewpass").val();
      var newpass = $("#newpass").val();
      var mpass = $("#mpass").val();
      $.ajax({
        type:"POST",
        url:"${path}/a/updatePass",
        data:{renewpass:renewpass,mpass:mpass,newpass:newpass},
        success:function (result) {
          alert(result)
        },
        dataType:"text"
      })
    })

})

  </script>

</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><span class="icon-key"></span> 修改密码</strong></div>
  <div class="body-content">
    <form id="myForm" method="post" class="form-x" action="">
      <div class="form-group">
        <div class="label">
          <label>管理员帐号：</label>
        </div>
        <div class="field">
          <label style="line-height:33px;">
           ${admin.loginname}
          </label>
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label>原始密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" id="mpass" name="mpass" size="50" placeholder="请输入原始密码" data-validate="required:请输入原始密码" />
        </div>
      </div>      
      <div class="form-group">
        <div class="label">
          <label>新密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" id="newpass" name="newpass" size="50" placeholder="请输入新密码" data-validate="required:请输入新密码,length#>=5:新密码不能小于5位" />
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>确认新密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" id="renewpass" name="renewpass" size="50" placeholder="请再次输入新密码" data-validate="required:请再次输入新密码,repeat#newpass:两次输入的密码不一致" />
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit" onclick="submit()"> 提交</button>
          <div><span id="errorMsg">${errorMsg}</span></div>
        </div>
      </div>
    </form>
  </div>
</div>
</body></html>