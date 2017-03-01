
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>SMART-Monitor</title>

    <script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="../js/login.js"></script>
    <link href="../css/login.css" rel="stylesheet" type="text/css">

    <script>
        function checkall(form) {

            var email = form.email.value;
            var pattern = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
            var email_flag = pattern.test(email);

            //用户名不能为空
            if ($('#user').val() == "") {
                $('#user').focus().css({
                    border: "1px solid red",
                    boxShadow: "0 0 2px red"
                });
                $('#userCue').html("User can not be none");

                return false;
                //return true;
            }

            //用户名在4-16个字符之间
            if ($('#user').val().length < 4 || $('#user').val().length > 16) {
                $('#user').focus().css({
                    border: "1px solid red",
                    boxShadow: "0 0 2px red"
                });
                $('#userCue').html("User needs 4-16 chars");
                return false;

            }

            //验证密码
            if ($('#passwd').val().length < 6) {
                $('#passwd').focus();
                $('#userCue').html("Password need more than 6 chars");
                return false;
            }
            if ($('#passwd2').val() != $('#passwd').val()) {
                $('#passwd2').focus();
                $('#userCue').html("Password confirm failed");
                return false;
            }
            //验证电子邮箱
            if(!email_flag){
                $('#email').focus().css({
                    border: "1px solid red",
                    boxShadow: "0 0 2px red"
                });
                $('#userCue').html("Email failed");
                return false;
            }
        }
    </script>

    <script>
        function checklog() {

            if ($('#u').val() == "") {
                $('#u').focus().css({
                    border: "1px solid red",
                    boxShadow: "0 0 2px red"
                });
                $('#login_tips').html("User can not be none");

                return false;
            }

            if ($('#p').val() == "") {
                $('#p').focus().css({
                    border: "1px solid red",
                    boxShadow: "0 0 2px red"
                });
                $('#login_tips').html("Password can not be none");
                return false;
            }
        }
    </script>
</head>

<body style="zoom: 1;">
    <h1>校园金融</h1>

    <div class="login" style="margin-top:50px;">

        <div class="header">
            <div class="switch" id="switch">
                <a class="switch_btn_focus" id="switch_qlogin" href="javascript:void(0);" tabindex="7">LOGIN</a>
                <a class="switch_btn" id="switch_login" href="javascript:void(0);" tabindex="8">REGISTER</a>
                <div class="switch_bottom" id="switch_bottom" style="position: absolute; width: 50px; left: 0px;"></div>
            </div>
        </div>


        <div class="web_qr_login" id="web_qr_login" style="display: block; height: 235px;">

            <!--登录-->
            <div class="web_login" id="web_login">


                <div class="login-box">
                    <div class="login_form">
                        <form name="loginform" action="<%= path%>/servlet/LoginAction" accept-charset="utf-8" id="login_form" method="post" class="loginForm" lpchecked="1" onsubmit="return checklog()">
                            <div class="cue" id="login_tips"></div>
                            <div class="uinArea" id="uinArea">
                                <label class="input-tips" for="u">User</label>
                                <div class="inputOuter" id="uArea">

                                    <input type="text" id="u" name="username" class="inputstyle">
                                </div>
                            </div>
                            <div class="pwdArea" id="pwdArea">
                                <label class="input-tips" for="p">Password</label>
                                <div class="inputOuter" id="pArea">

                                    <input type="password" id="p" name="userpwd" class="inputstyle">
                                </div>
                            </div>

                            <div style="padding-left:50px;margin-top:20px;">
                                <input type="submit" id="monitor_login111" value="Login" style="width:150px;" class="button_blue"></div>
                        </form>
                    </div>

                </div>

            </div>
            <!--登录end-->
        </div>

        <!--注册-->
        <div class="qlogin" id="qlogin" style="display: none;">

            <div class="web_login">
                <form name="form2" action="<%= path%>/servlet/RegisterAction" accept-charset="utf-8" method="post" _lpchecked="1" onsubmit="return checkall(this)">
                    <input type="hidden" name="to" value="reg">
                    <input type="hidden" name="did" value="0">
                    <ul class="reg_form" id="reg-ul">
                        <div id="userCue" class="cue"></div>
                        <li>

                            <label for="user" class="input-tips2">User</label>
                            <div class="inputOuter2">
                                <input type="text" id="user" name="user" maxlength="16" class="inputstyle2">
                            </div>

                        </li>

                        <li>
                            <label for="passwd" class="input-tips2">Password</label>
                            <div class="inputOuter2">
                                <input type="password" id="passwd" name="passwd" maxlength="16" class="inputstyle2">
                            </div>

                        </li>
                        <li>
                            <label for="passwd2" class="input-tips2">Confirm</label>
                            <div class="inputOuter2">
                                <input type="password" id="passwd2" name="" maxlength="16" class="inputstyle2">
                            </div>

                        </li>

                        <li>
                            <label for="email" class="input-tips2">Email</label>
                            <div class="inputOuter2">
                                <input type="text" id="email" name="email" maxlength="16" class="inputstyle2">
                            </div>
                        </li>
                        <li>
                            <div class="inputArea">
                                <input type="submit" id="reeg" style="margin-top:10px;margin-left:85px;" class="button_blue" value="Register">
                            </div>
                        </li>
                        <div class="cl"></div>
                    </ul>
                </form>


                </div>


            </div>
            <!--注册end-->
        </div>
        <div class="copyright jianyi"></div>

</body>

</html>