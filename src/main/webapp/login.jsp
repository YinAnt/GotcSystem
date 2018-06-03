<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <!-- TODO 头部图标 -->
    <link rel="shortcut icon" href="img/favicon_1.ico">
    <title>登录 - 桂林海外旅游公司</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <link href="css/bootstrap-reset.css" rel="stylesheet"/>

    <!--Animation css-->
    <link href="css/animate.css" rel="stylesheet"/>

    <!--Icon-fonts css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet"/>
    <link href="assets/ionicon/css/ionicons.min.css" rel="stylesheet"/>

    <!--Morris Chart CSS -->
    <link rel="stylesheet" href="assets/morris/morris.css"/>

    <!-- Custom styles for this template -->
    <link href="css/styleOA.css" rel="stylesheet"/>
    <link href="css/helper.css" rel="stylesheet"/>
</head>

<body>
<div class="wrapper-page animated fadeInDown">
    <div class="panel panel-color panel-primary">
        <div class="panel-heading">
            <h3 class="text-center m-t-10">用户登录</h3>
        </div>
        <%--<form class="form-horizontal m-t-40" role="form">--%>
        <div class="form-horizontal m-t-40">
            <div class="form-group ">
                <div class="col-xs-12">
                    <input class="form-control" name="userName" type="text" placeholder="用户名" id="userName">
                </div>
            </div>
            <div class="form-group ">
                <div class="col-xs-12">
                    <input class="form-control" name="userPassword" type="password" placeholder="密码" id="userPassword">
                </div>
            </div>

            <div class="form-group ">
                <div class="col-xs-6">
                    <label class="cr-styled">
                        <input type="checkbox" checked><i class="fa"></i>记住密码
                    </label>
                </div>
                <div class="col-xs-6 text-right">
                    <a href="">忘记密码?&nbsp&nbsp</a>
                    <a href="register.jsp">注册</a>
                </div>
            </div>

            <div class="form-group text-center">
                <div class="col-xs-12">
                    <button type="button" class="btn btn-purple w-md" onclick="dologin()">登录</button>
                </div>
            </div>
        </div>
        <%--</form>--%>
    </div>
</div>


<!-- js placed at the end of the document so the pages load faster -->
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/pace.min.js"></script>
<script src="js/wow.min.js"></script>
<script src="js/jquery.nicescroll.js" type="text/javascript"></script>

<!--common script for all pages-->
<script src="js/jquery.app.js"></script>


<script type="text/javascript">

    // 清除session
    <%session.invalidate();%>

    function GetJsonData() {
        var json = {
            "userName": $("#userName").val(),
            "userPassword": $("#userPassword").val()
        };
        return json;
    }

    //提交
    function dologin() {
        $.ajax({
            type: "post",
            url: "login.action",
            data: JSON.stringify(GetJsonData()),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                var obj = eval(data);
                var val = obj.users;
                if (val.userType == 1 || val.userType == 3) {
                    window.location.href = "home.jsp";
                } else {
                    // 访客跳转欢迎页
                    window.location.href = "welcome.jsp";
                }

            },
            error: function (data) {
            }
        });
    }
</script>

</body>
</html>