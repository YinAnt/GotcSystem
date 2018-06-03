<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>个人中心 - 桂林海外旅游</title>

    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="x-ua-compatible" content="ie=edge">

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-reset.css" rel="stylesheet">

    <!--Animation css-->
    <link href="css/animate.css" rel="stylesheet">

    <!--Icon-fonts css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet"/>
    <link href="assets/ionicon/css/ionicons.min.css" rel="stylesheet"/>

    <!-- Plugins css -->
    <link href="assets/modal-effect/css/component.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/helper.css" rel="stylesheet">
</head>

<body>
<!-- 顶部横幅 -->
<!-- style.css -->
<div class="mytop-header">
    <!-- bootstrap.css -->
    <div class="container">
        <ul class="tp-hd-lft wow slideInLeft animated">
            <%--<li class="hm"><a href="welcome.jsp"><i class="fa fa-home"></i></a></li>--%>
            <%--<li class="prnt"><a id="welcome-user">${users.userName}&nbsp;&nbsp;您好，欢迎光临桂林海外旅游官网！</a></li>--%>
        </ul>
        <ul class="tp-hd-rgt wow slideInRight animated">
            <%--已登录--%>
            <li class="welc" id="welcome-user"></li>
            <li class="welc"><a id="welcome-person-info" href="personalInfo.jsp"></a></li>
            <li class="welc"><a id="welcome-order" href="ordersInfo.jsp"></a></li>
            <li class="welc"><a id="welcome-sign-out" onclick="signOut()"></a></li>
            <%--未登录--%>
            <li class="sig"><a id="welcome-text"></a></li>
            <li class="sig"><a id="welcome-register" href="register.jsp"></a></li>
            <li class="sigi"><a id="welcome-sign-in" href="login.jsp"></a></li>
        </ul>
    </div>
</div>
<!-- end top-header -->

<!-- 头部标题栏 -->
<div class="myheader">
    <div class="container">
        <div class="logo wow slideInLeft animated">
            <a href="welcome.jsp">GuiLin <span>桂林海外旅游</span></a>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<!-- end header -->

<!--  导航栏 -->
<div class="footer-btm wow fadeInLeft animated">
    <div class="container">
        <div class="navigation">
            <nav class="navbar navbar-default">
                <!-- 缩放状态下的列表框 -->
                <!-- <div class="navbar-header">
                  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                  </button>
                </div> -->
                <!-- 导航栏 -->
                <div class="collapse navbar-collapse nav-wil" id="bs-example-navbar-collapse-1">
                    <nav class="cl-effect-1">
                        <ul class="nav navbar-nav">
                            <li><a href="welcome.jsp">首页</a></li>
                            <li><a href="scenicArea.jsp">桂林景点</a></li>
                            <li><a href="customize.jsp">定制旅游</a></li>
                            <li><a href="touristAttractions.jsp">导游介绍</a></li>
                            <%--<li><a href="welcome.jsp">景点门票</a></li>--%>
                            <li><a href="travelGuides.jsp">旅游攻略</a></li>
                            <li><a href="#" data-toggle="modal" data-target="#con-WriteUs-modal">联系客服</a></li>
                            <div class="clearfix"></div>
                        </ul>
                    </nav>
                </div><!-- /.navbar-collapse -->
            </nav>
        </div>
    </div>
</div>
<!-- end footer-btm -->

<%--个人中心--%>
<div class="container">
    <div class="personal-info">
        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-md-12">
                                <h3 class="panel-title">个人中心</h3>
                            </div>
                        </div>
                    </div>
                    <div class="panel-body">
                        <form class="form-horizontal" role="form">
                            <div class="modal-body">
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="person-info-userName" class="col-sm-3 control-label">用户名</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" id="person-info-userName"
                                                       value="${users.userName}" disabled="">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="person-info-userAlias" class="col-sm-3 control-label">姓名</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" id="person-info-userAlias"
                                                       value="">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="person-info-tel" class="col-sm-3 control-label">联系电话</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" id="person-info-tel" value="">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="person-info-email" class="col-sm-3 control-label">邮箱</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" id="person-info-email" value="">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="person-info-oldpassword"
                                                   class="col-sm-3 control-label">旧密码</label>
                                            <div class="col-sm-9">
                                                <input type="password" class="form-control" id="person-info-oldpassword"
                                                       onclick="clearTip()" value="">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="person-info-password"
                                                   class="col-sm-3 control-label">修改密码</label>
                                            <div class="col-sm-9">
                                                <input type="password" class="form-control" id="person-info-password"
                                                       onclick="clearTip()" value="">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="person-info-repassword"
                                                   class="col-sm-3 control-label">确认密码</label>
                                            <div class="col-sm-9">
                                                <input type="password" class="form-control" id="person-info-repassword"
                                                       onclick="clearTip()" value="">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <p id="psw-tip" style="color: red;"></p>
                                </div>
                            </div>
                            <div class="row text-center">
                                <button type="button" class="btn btn-success" onclick="sbmChangePersonInfo()">提交
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div> <!-- End row -->
        <div class="clearfix"></div>
    </div>
</div>
<%--end personal info--%>

<!-- 回到顶部 -->
<div style="height:60px;"></div>
<!-- end back to top -->

<!-- 页脚横幅 -->
<div class="copy-right">
    <div class="container">
        <p class="wow zoomIn animated" data-wow-delay=".2s">© 2018 桂林海外旅游 . All Rights Reserved | Design by Ant.</p>
    </div>
</div>
<!-- end copyright -->

<!-- 联系我们 模态框 type,id,placeholder-->
<div id="con-WriteUs-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title ">联系我们</h4>
            </div>

            <form class="form-horizontal" role="form">
                <div class="modal-body">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="WriteUs-field-1" class="col-sm-3 control-label">姓名</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" id="WriteUs-field-1">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="WriteUs-field-2" class="col-sm-3 control-label">邮箱</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" id="WriteUs-field-2">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="WriteUs-field-3" class="col-sm-3 control-label">电话</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" id="WriteUs-field-3">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="WriteUs-field-4" class="col-sm-3 control-label">类型</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" id="WriteUs-field-4">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <!-- TODO 描述+文本框 比例不协调 -->
                                <label for="WriteUs-field-5" class="col-sm-2 control-label">描述</label>
                                <div class="col-sm-10">
                                    <textarea class="form-control" rows="5" id="WriteUs-field-5"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-white" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-success" data-dismiss="modal">提交</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- end write us -->


<!-- js placed at the end of the document so the pages load faster -->
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/wow.min.js"></script>

<!-- 回到顶部 -->
<script src="js/scrolltopcontrol.js"></script>

<!-- 页面加载时过渡动画，使用wow.js插件，wow.js依赖于animate.css -->
<script src="js/wow.min.js"></script>
<script>
    new WOW().init();

    function getChangeInfoJsonData() {
        var json = {
            "userName": $("#person-info-userName").val(),
            "userAlias": $("#person-info-userAlias").val(),
            "userTel": $("#person-info-tel").val(),
            "userEmail": $("#person-info-email").val(),
            "userPassword": $("#person-info-password").val(), // 旧密码
            "userNoteTag": $("#person-info-oldpassword").val() //新密码
        };
        return json;
    }

    function clearTip() {
        document.getElementById('psw-tip').innerHTML = "";
    }

    function sbmChangePersonInfo() {
        // 先验证两个密码是否相同
        var psw = $("#person-info-password").val();
        var rePsw = $("#person-info-repassword").val();
        if (psw != rePsw || psw == "" || psw == null) {
            // 提示两次输入不一致
            document.getElementById('psw-tip').innerHTML = "两次输入的密码不一致";
            return;
        }
        // 再提交数据
        $.ajax({
            type: "post",
            url: "changePersonInfo.action",
            data: JSON.stringify(getChangeInfoJsonData()),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                location.reload();
            },
            error: function (data) {

            }
        });
    }

    function GetJsonData() {
        // 注意引号
        var json = {
            "userName": '${users.userName}'
        };
        return json;
    }

    // 页面加载完成时
    window.onload = $(function () {
        var welcUsr = ${users.userName eq null};
        if (welcUsr) {
            document.getElementById('welcome-text').innerHTML = "您好，欢迎来到桂林海外旅游公司官网";
            document.getElementById('welcome-register').innerHTML = "&nbsp;&nbsp;注册&nbsp;";
            document.getElementById('welcome-sign-in').innerHTML = "&nbsp;/&nbsp;登录&nbsp;";
        } else {
            var t = '${users.userName}';
            document.getElementById('welcome-user').innerHTML = "<i class=\"fa fa-bookmark\"></i>&nbsp;&nbsp;" + t + "&nbsp;&nbsp;&nbsp;";
            document.getElementById('welcome-order').innerHTML = "&nbsp;&nbsp;<i class=\"fa fa-cog\"></i>&nbsp;我的订单&nbsp;&nbsp;";
            document.getElementById('welcome-person-info').innerHTML = "&nbsp;&nbsp;<i class=\"fa fa-user\"></i>&nbsp;个人中心&nbsp;&nbsp;";
            document.getElementById('welcome-sign-out').innerHTML = "&nbsp;&nbsp;<i class=\'fa fa-sign-out\'></i>&nbsp;退出登录&nbsp;";
        }

        // 获取个人信息
        $.ajax({
            type: "post",
            url: "showPersonInfo.action",
            data: JSON.stringify(GetJsonData()),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                var obj = eval(data);
                var val = obj.user;
                $("#person-info-email").val(val.userEmail);
                $("#person-info-userAlias").val(val.userAlias);
                $("#person-info-tel").val(val.userTel);
            },
            error: function (data) {

            }
        });
    });

    function signOut() {
        window.location.href = "login.jsp";
    }

</script>
</body>
</html>