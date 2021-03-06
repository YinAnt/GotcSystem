<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>旅游攻略 - 桂林海外旅游</title>

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

<%--旅游攻略--%>
<div class="container">
    <div class="travel-guide" id="div-travel-guide">

    </div>
</div>
<%--end 旅游攻略--%>

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
<%--手风琴折叠--%>
<%--<script src="assets/bootstrap-collapse/bootstrap-collapse.js"></script>--%>
<!-- 回到顶部 -->
<script src="js/scrolltopcontrol.js"></script>
<!-- 页面加载时过渡动画，使用wow.js插件，wow.js依赖于animate.css -->
<script src="js/wow.min.js"></script>
<script src="js/dataFormat.js" type="text/javascript"></script>
<script type="text/javascript" src="js/json3.3.2.js"></script>
<script>
    new WOW().init();

    // 加载头部标签信息
    function getHeadText() {
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
    }

    // 加载旅游攻略
    function getAncGuide() {
        $.ajax({
            type: "get",
            url: "showAncGuide.action",
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                // alert("success");
                var obj = eval(data);
                var maxNum = obj.announce.length;
                // var maxNum = (obj.announce.length > 6 ? 6 : obj.scenic.length);
                for (var i = 0; i < maxNum; i++) {
                    var val = obj.announce[i];
                    var date = new Date(val.ancCreateTime);
                    var text1 = '<div class="row">';
                    var text2 = '<h4>' + val.ancTitle + '</h4>' + '<h6> 发布者：&nbsp;' + val.ancPosterName + '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;发布时间：&nbsp;' + date.format("yyyy-mm-dd") + '</h6>';
                    var text3 = '<p>' + val.ancContent + '</p>';
                    var text4 = '</div><hr>';
                    var divGuide = document.getElementById("div-travel-guide");
                    divGuide.innerHTML = divGuide.innerHTML + text1 + text2 + text3 + text4;
                }
            },
            error: function () {
            }
        });
    }

    // 页面加载完成时
    window.onload = $(function () {
        getHeadText();  // 加载头部标签信息
        getAncGuide();  // 加载旅游攻略
    });

    function signOut() {
        window.location.href = "login.jsp";
    }

</script>
</body>
</html>