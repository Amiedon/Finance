<%--
  Created by IntelliJ IDEA.
  User: Amie
  Date: 2017/2/28
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
%>
<html>
<head>
  <title>用户注册</title>
  <style type="text/css">
    body{
      margin: 0px;font-size: 12px;
    }
    .box{
      border: 1px solid #D1DEB2; width: 150px; height: 20px;
    }
    .div1{
      background-image: url(img/background.jpg);
      height: 600px;
      width: 803px;
      padding-left:20px;
      padding-top:220px;
      text-align:left;
    }
  </style>
  <script type="text/javascript">
    function reg(form) {
      var email = form.email.value;
      var pattern = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
      var email_flag = pattern.test(email);
      if(form.username.value == "") {
        alert("用户名不能为空");
        return false;
      }
      if(form.password.value == ""){
        alert("密码不能为空！");
        return false;
      }
      if(form.repassword.value == ""){
        alert("确认密码不能为空！");
        return false;
      }
      if(form.password.value != form.repassword.value){
        alert("两次密码输入不一致！");
        return false;
      }
      if(!email_flag){
        alert("电子邮箱格式不正确！");
        return false;
      }
    }
  </script>
</head>
<body>
<div align="center">
  <div class="div1">
    <form action="<%= path%>/servlet/RegisterAction" method="post" onsubmit="return reg(this)"><%--RegServlet--%>
      <table align="center" border="0px" width="500px">
        <tr>
          <td align="right" width="30%">用户名</td>
          <td> <input type="text" name="username" class="box"></td>
        </tr>
        <tr>
          <td align="right">密 码：</td>
          <td><input type="password" name="password" class="box"></td>
        </tr>
        <tr>
          <td align="right">确认密码：</td>
          <td><input type="password" name="repassword" class="box"></td>
        </tr>
        <tr>
          <td align="right">邮 箱：</td>
          <td><input type="text" name="email" class="box"></td>
        </tr>
        <tr>
          <td colspan="2" align="center" height="40">
            <input type="submit" value="注 册">
            <input type="reset" value="重 置">
          </td>
        </tr>
      </table>
    </form>
  </div>
</div>
</body>
</html>
