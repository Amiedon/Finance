
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String msg;
    String from = (String) request.getAttribute("from");
    switch (from)
    {
        case "register":
            msg = "您已成功注册，请登录邮箱激活账号";break;
        case "login":
            msg = "用户名或密码错误，请重新输入！";break;
        case "activate_true":
            msg = "您已激活，请返回登录！";break;
        case "activate_false":
            msg = "激活不成功，请重新激活！";break;
        default:
            msg = "未知错误，请返回登录！";
    }
%>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SMART-Monitor</title>

    <script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="../js/login.js"></script>
    <link href="../css/login.css" rel="stylesheet" type="text/css">



</head>

<body style="zoom: 1;">
<h1>校园金融</h1>
<h2 align="center"><%=msg%></h2>
<h3 style="margin-left: 640px"><a href="<%=path%>/html/login.jsp">返回登录</a></h3>
<div class="copyright jianyi"></div>
</body>

</html>