<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册 - 桂林海外旅游公司</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <link href="css/bootstrap-reset.css" rel="stylesheet"/>

    <!--Animation css-->
    <link href="css/animate.css" rel="stylesheet"/>

    <!--Icon-fonts css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet"/>
    <link href="assets/ionicon/css/ionicons.min.css" rel="stylesheet"/>

    <!--Morris Chart CSS -->
    <link href="assets/morris/morris.css" rel="stylesheet"/>

    <!-- Custom styles for this template -->
    <link href="css/styleOA.css" rel="stylesheet"/>
    <link href="css/helper.css" rel="stylesheet"/>
</head>


<body>


<div class="wrapper-page animated fadeInDown">
    <div class="panel panel-color panel-primary">

        <div class="panel-heading">
            <h3 class="text-center"> 创建新账户 </h3>
        </div>
        <div class="row">
            <span id="tip" style="color: red; font-weight: bold"></span>
        </div>
        <form class="form-horizontal m-t-10" id="signupForm">
            <div class="row">
                <div class="form-group">
                    <div class="col-xs-6">
                        <input class="form-control" id="userName" name="userName" type="text" required=""
                               placeholder="登录名"
                               onblur="validateName()">
                    </div>
                    <div class="col-xs-6">
                        <input class="form-control" id="userAlias" name="userAlias" type="text" required=""
                               placeholder="姓名">
                    </div>
                </div>
            </div>


            <div class="row">
                <div class="form-group">
                    <div class="col-xs-6">
                        <input class="form-control" id="userPassword" name="userPassword" type="password" required=""
                               placeholder="密码">
                    </div>
                    <div class="col-xs-6">
                        <input class="form-control" id="Password2" name="Password2" type="password" required="" placeholder="确认密码">
                    </div>
                </div>
            </div>


            <div class="row">
                <div class="form-group">
                    <div class="col-xs-6">
                        <input class="form-control" id="userEmail" name="userEmail" type="text" required=""
                               placeholder="邮箱">
                    </div>
                    <div class="col-xs-6">
                        <input class="form-control" id="userTel" name="userTel" type="text" required=""
                               placeholder="电话">
                    </div>
                </div>
            </div>

            <div class="form-group ">
                <div class="col-xs-7">
                    <label class="cr-styled">
                        <input type="checkbox">
                        <i class="fa"></i>
                        我同意GOTC <strong><a href="#"> 服务协议 </a></strong>
                    </label>
                </div>
                <div class="col-sm-5 text-right">
                    已有账户？<a href="login.jsp">登录</a>
                </div>
            </div>

            <div class="form-group text-center">
                <div class="col-xs-12">
                    <button class="btn btn-purple w-md" type="submit">注册</button>
                </div>
            </div>
        </form>
    </div>
</div>


<!-- js placed at the end of the document so the pages load faster -->
<script src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery-1.8.2.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/pace.min.js"></script>
<script src="js/wow.min.js"></script>
<script src="js/jquery.nicescroll.js" type="text/javascript"></script>
<!--common script for all pages-->
<script src="js/jquery.app.js"></script>

<!--表单校验-->
<script src="assets/jquery.validate/jquery.validate.min.js"></script>
<script src="assets/jquery.validate/localization/messages_zh.js"></script>
<script src="assets/jquery.validate/form-validation-init-signUp.js"></script>

<script type="text/javascript" src="js/json3.3.2.js"></script>
<script type="text/javascript">

    // 验证是否重名
    function validateName() {
        $.ajax({
            type: "POST",
            url: 'checkName.action',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(GetUserNameJsonData()),
            dataType: "json",
            success: function (message) {
                var d = eval(message);
                $("#tip").text("" + d.tip + "");
            },
            error: function (message) {
                alert(message + ",提交数据失败！");
            }
        });
    }

    function GetUserNameJsonData() {
        var json = {
            "userName": $("#userName").val()
        };
        return json;
    }
</script>
</body>
</html>