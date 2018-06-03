<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>私人订制 - 桂林海外旅游</title>

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

    <link href="assets/sweet-alert/sweet-alert.min.css" rel="stylesheet">

    <!-- Plugins css -->
    <link href="assets/modal-effect/css/component.css" rel="stylesheet">
    <link href="assets/timepicker/bootstrap-timepicker.min.css" rel="stylesheet"/>
    <link href="assets/timepicker/bootstrap-datepicker.min.css" rel="stylesheet"/>
    <link href="assets/bootstrap-Multiselect/prettify.css" rel="stylesheet">
    <link href="assets/bootstrap-Multiselect/bootstrap-multiselect.css" rel="stylesheet">
    <link href="assets/fullcalendar/fullcalendar.css" rel="stylesheet"/>

    <!-- ION Slider -->
    <%--<link href="assets/ion-rangeslider/ion.rangeSlider.css" rel="stylesheet" type="text/css"/>--%>
    <%--<link href="assets/ion-rangeslider/ion.rangeSlider.skinFlat.css" rel="stylesheet" type="text/css"/>--%>

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

<!-- 定制旅游 -->
<div class="container">
    <div class="customize">
        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-md-12">
                                <h3 class="panel-title">开启私人订制之旅</h3>
                            </div>
                        </div>
                    </div>
                    <div class="panel-body">
                        <form class="form-horizontal" role="form" id="customizeForm">
                            <div class="modal-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="datepicker1" class="col-sm-2 control-label">预计出发时间*</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" placeholder="mm/dd/yyyy"
                                                       id="datepicker1" required="required">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="datepicker2" class="col-sm-2 control-label">预计返程时间*</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" placeholder="mm/dd/yyyy"
                                                       id="datepicker2" required="required">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label class="col-sm-2 control-label">预计出游人数</label>
                                            <div class="col-sm-7">
                                                <div class="col-md-6">
                                                    <label for="customAdult" class="col-sm-4 control-label"><h5>
                                                        成人</h5></label>
                                                    <div class="col-sm-7">
                                                        <select class="form-control" id="customAdult">
                                                            <option>0</option>
                                                            <option>1</option>
                                                            <option>2</option>
                                                            <option>3</option>
                                                            <option>4</option>
                                                            <option>5</option>
                                                            <option>6</option>
                                                            <option>7</option>
                                                            <option>8</option>
                                                            <option>9</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="col-md-6 text-right">
                                                    <label for="customChild" class="col-sm-4 control-label"><h5>
                                                        儿童</h5></label>
                                                    <div class="col-sm-7 ">
                                                        <select class="form-control" id="customChild">
                                                            <option>0</option>
                                                            <option>1</option>
                                                            <option>2</option>
                                                            <option>3</option>
                                                            <option>4</option>
                                                            <option>5</option>
                                                            <option>6</option>
                                                            <option>7</option>
                                                            <option>8</option>
                                                            <option>9</option>
                                                        </select>
                                                    </div>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="customMeal" class="col-sm-2 control-label">是否含餐</label>
                                            <div class="col-sm-3">
                                                <select class="form-control" id="customMeal">
                                                    <option>是</option>
                                                    <option>否</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="customLevel" class="col-sm-2 control-label">酒店等级</label>
                                            <div class="col-sm-3">
                                                <select class="form-control" id="customLevel">
                                                    <option>不安排住宿</option>
                                                    <option>一星</option>
                                                    <option>二星</option>
                                                    <option>三星</option>
                                                    <option>四星</option>
                                                    <option>五星</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="customBudget" class="col-sm-2 control-label">预算*</label>
                                            <%--<div class="col-sm-7"><input type="text" id="range_03"></div>--%>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" id="customBudget"
                                                       required="required">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="customAlais" class="col-sm-2 control-label">姓名*</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" id="customAlais"
                                                       required="required">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="customTel" class="col-sm-2 control-label">联系电话*</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" id="customTel"
                                                       required="required">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="customEmail" class="col-sm-2 control-label">邮箱*</label>
                                            <div class="col-sm-9">
                                                <input type="text" class="form-control" id="customEmail"
                                                       required="required">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label for="customNoteTag" class="col-sm-2 control-label">备注</label>
                                            <div class="col-sm-9">
                                                <textarea class="form-control" row="5" id="customNoteTag"
                                                          placeholder="特别想去的地方？心仪的导游？指定语言？写下来……"></textarea>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="row text-center">
                                <button type="button" class="btn btn-success" onclick="sbmPlaceOrder()">提交</button>
                                <%--<button type="submit" class="btn btn-success">提交</button>--%>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div> <!-- End row -->
        <div class="clearfix"></div>
    </div>
</div>
<!-- end custom -->


<!-- 回到顶部 -->
<div style="height:60px;"></div>
<!-- end back to top -->

<!-- 页脚横幅 -->
<div class="copy-right">
    <div class="container">
        <p class="wow zoomIn animated" data-wow-delay=".5s">© 2018 桂林海外旅游 . All Rights Reserved | Design by Ant.</p>
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
                                    <input type="text" class="form-control" id="WriteUs-field-1" >
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="WriteUs-field-2" class="col-sm-3 control-label">邮箱</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" id="WriteUs-field-2" >
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="WriteUs-field-3" class="col-sm-3 control-label">电话</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" id="WriteUs-field-3" >
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="setting-field-2" class="col-sm-3 control-label">类型</label>
                                <div class="col-sm-8">
                                    <input type="text" class="form-control" id="setting-field-2" >
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <!-- TODO 描述+文本框 比例不协调 -->
                                <label for="WriteUs-field-4" class="col-sm-2 control-label">描述</label>
                                <div class="col-sm-10">
                                    <textarea class="form-control" rows="5" id="WriteUs-field-4"
                                              ></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-white" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-success">提交</button>
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
<script src="js/jquery.min.js"></script>

<script src="assets/fullcalendar/moment.min.js"></script>
<script src="assets/fullcalendar/fullcalendar.min.js"></script>

<script src="assets/timepicker/bootstrap-timepicker.min.js"></script>
<script src="assets/timepicker/bootstrap-datepicker.js"></script>

<!--表单校验-->
<%--<script src="assets/jquery.validate/jquery.validate.min.js"></script>--%>
<%--<script src="assets/jquery.validate/localization/messages_zh.js"></script>--%>
<%--<script src="assets/jquery.validate/form-validation-init-addOrd.js"></script>--%>

<script src="assets/sweet-alert/sweet-alert.min.js"></script>
<%--<script src="assets/sweet-alert/sweet-alert.init.js"></script>--%>

<script src="js/dataFormat.js" type="text/javascript"></script>

<!-- 回到顶部 -->
<script src="js/scrolltopcontrol.js"></script>

<!-- 页面加载时过渡动画，使用wow.js插件，wow.js依赖于animate.css -->
<script src="js/wow.min.js"></script>
<script type="text/javascript">
    new WOW().init();

    jQuery(document).ready(function () {
        // Date Picker
        jQuery('#datepicker1').datepicker();
        jQuery('#datepicker2').datepicker();
    });

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

    // 页面加载完成时
    window.onload = $(function () {
        getHeadText();  // 加载头部标签信息

    });

    function signOut() {
        window.location.href = "login.jsp";
    }

    function GetPlaceOrderJsonData() {
        var json = {
            "startTimeStr": $("#datepicker1").val(),
            "endTimeStr": $("#datepicker2").val(),
            "ordAdultNum": $("#customAdult").val(),
            "ordChildNum": $("#customChild").val(),
            "ordMeal": $("#customMeal").val(),
            "ordBudget": $("#customBudget").val(),
            "ordAlias": $("#customAlais").val(),
            "ordEmail": $("#customEmail").val(),
            "ordTel": $("#customTel").val(),
            "ordUser": '${users.userName}',
            "ordNoteTag": $("#customNoteTag").val()
        };
        // alert("json：" + json.toString());
        return json;
    }

    function isNullOrEmpty(val) {
        if (val == null || val == "") {
            return true;
        }
        return false;
    }

    // 提交在线订单申请
    function sbmPlaceOrder() {
        // alert("在线申请");
        // 登录
        if ('${users.userName}' == null || '${users.userName}' == "") {
            sweetAlert(swal({
                    title: "提示",
                    text: "请先登录！",
                    showConfirmButton: true,
                    showCancelButton: true
                }, function () {
                    // 点击确定，跳转至登录界面
                    window.location.href = "login.jsp";
                }
            ));
            return;
        }
        var date1 = $("#datepicker1").val();
        var date2 = $("#datepicker2").val();
        var customBudget = $("#customBudget").val();
        var customAlais = $("#customAlais").val();
        var customEmail = $("#customEmail").val();
        var customTel = $("#customTel").val();
        var arr = new Array(6);
        arr = [date1, date2, customBudget, customAlais, customEmail, customTel];
        for (var i = 0; i < arr.length; i++) {
            if (isNullOrEmpty(arr[i])) {
                sweetAlert(swal({
                        title: "错误提示",
                        text: "字段没有填写完整！",
                        type: "error",
                        showConfirmButton: true
                    }
                ));
                return;
            }
        }

        // 时间验证
        var startDateStr = $("#datepicker1").val();
        var endDateStr = $("#datepicker2").val();
        var startArray = startDateStr.split("/"); // 日期格式：mm/dd/yyyy
        var endArray = endDateStr.split("/"); // 日期格式：mm/dd/yyyy
        var startDate = new Date(startArray[2], startArray[0], startArray[1]);
        var endDate = new Date(endArray[2], endArray[0], endArray[1]);
        // alert("1:"+startDate+","+endDate);
        if (startDate.getTime() >= endDate.getTime()) {
            sweetAlert(swal({
                    title: "错误提示",
                    text: "开始时间不得大于结束时间！",
                    type: "error",
                    showConfirmButton: true
                }
            ));
            return;
        }

        // 验证邮箱、电话是否为空

        $.ajax({
            type: "post",
            url: "addOrders.action",
            data: JSON.stringify(GetPlaceOrderJsonData()),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                // alert("success");
                // 提交成功 跳转我的订单查看
                window.location.href = "ordersInfo.jsp";
            },
            error: function (data) {
                // alert("error");
                sweetAlert(swal({
                        title: "错误提示",
                        text: "提交失败，请重试！",
                        type: "error",
                        showConfirmButton: true
                    }
                ));
            }
        });
    };

</script>

</body>
</html>