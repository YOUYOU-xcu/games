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
</head>
<body>

<div class="panel admin-panel">
  <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>增加商品</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="${path}/a/addProduct" enctype="multipart/form-data">
      <div class="form-group">
        <div class="label">
          <label>商品名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="proname" data-validate="required:请输入商品名称" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>商品编号：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="prosn" data-validate="required:请输入编号，例如P001" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>商品价格：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="proprice" data-validate="required:请输入商品价格" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>商品数量：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="pronum" data-validate="required:请输入商品数量" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>商品图片：</label>
        </div>
        <div class="field">
          <input type="file" name="image" class="button bg-blue margin-left" id="proimg" value="+ 浏览上传"  style="float:left;">
          <div class="tipss">图片尺寸：500*500</div>
        </div>
      </div>
<%--      <div class="form-group">
        <div class="label">
          <label>商品描述：</label>
        </div>
        <div class="field">
          <textarea class="input" name="desc" style=" height:90px;" disabled></textarea>
          <div class="tips"></div>
        </div>
      </div>--%>
      <div class="form-group">
        <div class="label">
          <label>商品全称：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="profullname" data-validate="required:请输入商品全称" />
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>商品单位：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" value="" name="unit" data-validate="required:请输入单位，例如个、件……" />
          <div class="tips"></div>
        </div>
      </div>

      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>

</body></html>