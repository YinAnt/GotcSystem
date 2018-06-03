<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>旅游线路展示 - 桂林海外旅游公司</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-reset.css" rel="stylesheet">

    <!--Animation css-->
    <link href="css/animate.css" rel="stylesheet">

    <!--Icon-fonts css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet"/>
    <link href="assets/ionicon/css/ionicons.min.css" rel="stylesheet"/>

    <link href="assets/timepicker/bootstrap-timepicker.min.css" rel="stylesheet"/>
    <link href="assets/timepicker/bootstrap-datepicker.min.css" rel="stylesheet"/>

    <link href="assets/bootstrap-Multiselect/prettify.css" rel="stylesheet">
    <link href="assets/bootstrap-Multiselect/bootstrap-multiselect.css" rel="stylesheet">

    <link href="assets/fullcalendar/fullcalendar.css" rel="stylesheet"/>

    <!-- Custom styles for this template -->
    <link href="css/styleOA.css" rel="stylesheet">
    <link href="css/helper.css" rel="stylesheet">
</head>
<body>


<!-- Aside Start-->
<aside class="left-panel collapsed">

    <!-- brand -->
    <div class="logo">
        <a href="home.jsp" class="logo-expanded">
            <i class="ion-social-buffer"></i>
            <span class="nav-label">GOTC - CMS</span>
        </a>
    </div>
    <!-- / brand -->

    <!-- Navbar Start -->
    <nav class="navigation">
        <ul class="list-unstyled">
            <li class="active"><a href="home.jsp"><i class="ion-home"></i> <span class="nav-label">首页</span></a></li>
            <li class="has-submenu"><a href="#"><i class="ion-star"></i> <span class="nav-label">考勤管理</span></a>
                <ul class="list-unstyled">
                    <li><a href="attendance.jsp">签到情况</a></li>
                    <li><a href="calendar.jsp">我的日报</a></li>
                    <li><a href="leaveManage.jsp">请假管理</a></li>
                </ul>
            </li>
            <li class="has-submenu"><a href="#"><i class="ion-clipboard"></i> <span class="nav-label">调度管理</span>
                <!-- TODO 新消息提醒 -->
                <%--<span class="badge bg-success">New</span></a>--%>
                <ul class="list-unstyled">
                    <li><a href="ordersManage.jsp">订单列表</a></li>
                    <li><a href="vehicleDistribution.jsp">车辆分配</a></li>
                    <li><a href="hotelArrangement.jsp">酒店安排</a></li>
                    <li><a href="ticketReservtion.jsp">门票预订</a></li>
                </ul>
            </li>
            <li class="has-submenu"><a href="#"><i class="ion-calculator"></i> <span class="nav-label">财务管理</span></a>
                <ul class="list-unstyled">
                    <li><a href="ordersBillManage.jsp">月度订单总额</a></li>
                </ul>
            </li>
            <li class="has-submenu"><a href="#"><i class="ion-person"></i> <span class="nav-label">用户管理</span></a>
                <ul class="list-unstyled">
                    <li><a href="userManage.jsp">用户</a></li>
                    <%--<li><a href="roleManage.jsp">角色</a></li>--%>
                    <%--<li><a href="menuManage.jsp">菜单</a></li>--%>
                </ul>
            </li>
            <li class="has-submenu">
                <a href="#"><i class="ion-compose"></i><span class="nav-label">公告</span>
                    <!-- TODO 新通知提醒 -->
                    <%--<span class="badge bg-purple">1</span></a>--%>
                    <ul class="list-unstyled">
                        <li><a href="announce.jsp">公告</a></li>
                    </ul>
            </li>

            <li class="has-submenu"><a href="#"><i class="ion-folder"></i> <span class="nav-label">资料库</span></a>
                <ul class="list-unstyled">
                    <li><a href="contacts.jsp">通讯录</a></li>
                    <li><a href="dataBank.jsp">知识库</a></li>
                </ul>
            </li>
        </ul>
    </nav>
</aside>
<!-- Aside Ends-->


<!--Main Content Start -->
<section class="content">

    <!-- Header -->
    <header class="top-head container-fluid">
        <button type="button" class="navbar-toggle pull-left">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>

        <!-- Left navbar -->
        <nav class=" navbar-default" role="navigation">
            <ul class="nav navbar-nav navbar-right top-menu top-right-menu">
                <li class="dropdown text-center">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                        <span class="username">当前用户：${employee.empName} </span> <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu pro-menu fadeInUp animated" tabindex="5003"
                        style="overflow: hidden; outline: none;">
                        <li><a href="#" data-toggle="modal" data-target="#con-setting-modal"><i class="fa fa-cog"></i>
                            个人信息</a></li>
                        <li><a href="#" data-toggle="modal" data-target="#con-password-modal"><i class="fa fa-cog"></i>
                            修改密码</a></li>
                        <li><a href="login.jsp"><i class="fa fa-sign-out"></i> 退出登录</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
    </header>
    <!-- Header Ends -->


    <!-- Page Content Start -->
    <!-- ================== -->

    <div class="wraper container-fluid">
        <div class="page-title">
            <h3 class="title">旅游线路展示</h3>
        </div>
        <div class="clearfix"></div>

        <!-- 用户订单情况展示 -->
        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-body p-t-0">
                        <div class="row">
                            <div class="col-md-6">
                                <label for="con-ord-time" class="col-md-3">预计出行时间</label>
                                <p class="col-md-9" id="con-ord-time"></p>
                            </div>
                            <div class="col-md-6">
                                <label for="con-ord-no" class="col-md-3">订单号</label>
                                <p class="col-md-9" id="con-ord-no"></p>
                            </div>

                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label for="con-ord-number" class="col-md-3">出行人数</label>
                                <p class="col-md-9" id="con-ord-number"></p>
                            </div>
                            <div class="col-md-6">
                                <label for="con-ord-tel" class="col-md-3">联系电话</label>
                                <p class="col-md-9" id="con-ord-tel"></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label for="con-ord-budget" class="col-md-3">预算</label>
                                <p class="col-md-9" id="con-ord-budget"></p>
                            </div>
                            <div class="col-md-6">
                                <label for="con-ord-email" class="col-md-3">邮箱</label>
                                <p class="col-md-9" id="con-ord-email"></p>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <label for="con-ord-meal" class="col-md-3">含餐</label>
                                <p class="col-md-9" id="con-ord-meal"></p>
                            </div>
                            <div class="col-md-6">
                                <div class="col-md-6">
                                    <div class="form-group text-left">
                                        <label for="password-field-1" class="col-md-3">导游</label>
                                        <div class="col-md-9">
                                            <select class="form-control" id="ord-agent">

                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="password-field-1" class="col-md-3">配车</label>
                                        <div class="col-md-9">
                                            <select class="form-control" id="ord-seat">
                                                <option>否</option>
                                                <option>是</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-10">
                                <label for="con-ord-describe" class="col-md-2">描述</label>
                                <p class="col-md-10" id="con-ord-describe"></p>
                            </div>
                            <div class="col-md-2 text-right">
                                <button id="sbmOrd" type="button" class="btn btn-success" onclick="sbmOrd()">
                                    确认
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <%--时间轴--%>
        <div class="row">
            <div class="col-sm-12">
                <ul class="timeline" id="timeline-ul">

                </ul>
            </div>
        </div>

        <div class="row">
            <div class="text-center col-md-12">
                <button id="addScenic" type="button" class="btn btn-success" data-toggle="modal"
                        data-target="#con-scenic-modal"><i class="fa  fa-plus"></i>&nbsp;景区
                </button>
                <button id="addHotel" type="button" class="btn btn-success" data-toggle="modal"
                        data-target="#con-hotel-modal"><i class="fa  fa-plus"></i>&nbsp;酒店
                </button>
            </div>
        </div>

        <!-- page end-->

    </div>
    <!-- Page Content Ends -->
    <!-- ================== -->


    <!-- Footer Start -->
    <footer class="footer">
        2018 © GOTC - CMS.
    </footer>
    <!-- Footer Ends -->

</section>
<!-- Main Content Ends -->

<%--TODO 添加酒店模态框--%>
<div id="con-hotel-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title">添加酒店</h4>
            </div>
            <form class="form-horizontal" role="form">
                <div class="modal-body">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="datepicker1" class="col-sm-4 control-label">入住日期</label>
                                <div class="col-sm-8">
                                    <div class="input-group">
                                        <input type="text" class="form-control" placeholder="mm/dd/yyyy"
                                               id="datepicker3">
                                        <span class="input-group-addon"><i
                                                class="glyphicon glyphicon-calendar"></i></span>
                                    </div><!-- input-group -->
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="datepicker1" class="col-sm-4 control-label">离店日期</label>
                                <div class="col-sm-8">
                                    <div class="input-group">
                                        <input type="text" class="form-control" placeholder="mm/dd/yyyy"
                                               id="datepicker4">
                                        <span class="input-group-addon"><i
                                                class="glyphicon glyphicon-calendar"></i></span>
                                    </div><!-- input-group -->
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="multiselect-hotel" class="col-sm-3 control-label">选择酒店/房型</label>
                                <div class="col-sm-9">
                                    <%--<select class="multiselect" multiple="multiple" id="multiselect">--%>
                                    <select class="multiselect" id="multiselect-hotel">
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-white" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-success" data-dismiss="modal" onclick="addHotelForOrder()">保存
                    </button>
                </div>
            </form>
        </div>
    </div>
</div><!-- con-hotel-modal end -->

<%--TODO 添加景点模态框--%>
<div id="con-scenic-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title">添加景点</h4>
            </div>
            <form class="form-horizontal" role="form">
                <div class="modal-body">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="datepicker1" class="col-sm-4 control-label">日期</label>
                                <div class="col-sm-8">
                                    <div class="input-group">
                                        <input type="text" class="form-control" placeholder="mm/dd/yyyy"
                                               id="datepicker1">
                                        <span class="input-group-addon"><i
                                                class="glyphicon glyphicon-calendar"></i></span>
                                    </div><!-- input-group -->
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="timepicker1" class="col-sm-4 control-label">开始时间</label>
                                <div class="col-sm-8">
                                    <div class="input-group col-sm-8">
                                        <div class="bootstrap-timepicker"><input id="timepicker1" type="text"
                                                                                 class="form-control"/></div>
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-time"></i></span>
                                    </div><!-- input-group -->
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="multiselect-scenic" class="col-sm-4 control-label">选择景区</label>
                                <div class="col-sm-8">
                                    <%--<select class="multiselect" multiple="multiple" id="multiselect">--%>
                                    <select class="multiselect" id="multiselect-scenic">
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="timepicker2" class="col-sm-4 control-label">结束时间</label>
                                <div class="col-sm-8">
                                    <div class="input-group col-sm-8">
                                        <div class="bootstrap-timepicker"><input id="timepicker2" type="text"
                                                                                 class="form-control"/></div>
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-time"></i></span>
                                    </div><!-- input-group -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-white" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-success" data-dismiss="modal" onclick="addScenicForOrder()">
                        保存
                    </button>
                </div>
            </form>
        </div>
    </div>
</div><!-- con-setting-modal end -->


<!-- TODO 个人信息 响应式模态框  label:for input text:id,placeholder-->
<div id="con-setting-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title">个人信息</h4>
            </div>
            <form class="form-horizontal" role="form">
                <div class="modal-body">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="setting-field-1" class="col-sm-2 control-label">姓名</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="setting-field-1"
                                           value="${employee.empName}" disabled="">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="setting-field-2" class="col-sm-2 control-label">性别</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="setting-field-2"
                                           value="${employee.empSex==1?'男':'女'}">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="setting-field-3" class="col-sm-2 control-label">工号</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="setting-field-3"
                                           value="${employee.empNo}" disabled="">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="setting-field-4" class="col-sm-2 control-label">部门</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="setting-field-4"
                                           value="${employee.empDeptName}" disabled="">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="setting-field-5" class="col-sm-2 control-label">电话</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="setting-field-5"
                                           value="${employee.empTel}">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="setting-field-6" class="col-sm-2 control-label">邮箱</label>
                                <div class="col-sm-9">
                                    <input type="email" class="form-control" id="setting-field-6"
                                           value="${employee.empEmail}">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-white" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-success">保存</button>
                </div>
            </form>
        </div>
    </div>
</div><!-- con-setting-modal end -->

<!-- TODO 修改密码 响应式模态框  label:for input text:id,placeholder-->
<div id="con-password-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title">修改密码</h4>
            </div>
            <form class="form-horizontal" role="form">
                <div class="modal-body">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="password-field-1" class="col-sm-2 control-label">旧密码</label>
                                <div class="col-sm-9">
                                    <input type="password" class="form-control" id="password-field-1"
                                           placeholder="password">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="password-field-2" class="col-sm-2 control-label">新密码</label>
                                <div class="col-sm-9">
                                    <input type="password" class="form-control" id="password-field-2"
                                           placeholder="password">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="password-field-3" class="col-sm-2 control-label">确认密码</label>
                                <div class="col-sm-9">
                                    <input type="password" class="form-control" id="password-field-3"
                                           placeholder="password">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-white" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-success">保存</button>
                </div>
            </form>
        </div>
    </div>
</div><!-- con-password-modal end -->

<!-- js placed at the end of the document so the pages load faster -->
<script src="js/jquery.js"></script>
<script src="js/pace.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/wow.min.js"></script>
<script src="js/jquery.nicescroll.js" type="text/javascript"></script>

<script src="js/jquery.app.js"></script>

<script src="assets/fullcalendar/moment.min.js"></script>
<script src="assets/fullcalendar/fullcalendar.min.js"></script>

<script src="assets/timepicker/bootstrap-timepicker.min.js"></script>
<script src="assets/timepicker/bootstrap-datepicker.js"></script>

<script src="assets/bootstrap-Multiselect/prettify.js" type="text/javascript"></script>
<script src="assets/bootstrap-Multiselect/bootstrap-multiselect.js" type="text/javascript"></script>

<script src="js/dataFormat.js" type="text/javascript"></script>
<script type="text/javascript" src="js/json3.3.2.js"></script>
<script type="text/javascript">
    // TODO 模态框关闭时清空记录 无效
    // bootstrap 2
    // $("#con-hotel-modal").on("hidden", function() {
    //     $(this).removeData("modal");
    // });
    // bootstrap 3
    // $("#con-hotel-modal").on("hidden.bs.modal", function() {
    //     $(this).removeData("bs.modal");
    // });


    // 为订单添加一景点服务
    function GetScenicJsonData() {
        var json = {
            "contOrdNo": $("#con-ord-no").text(),
            "contType": 1,
            "contScnNo": $("#multiselect-scenic").val(),
            "contScnDateStr": $("#datepicker1").val(),
            "contScnStartTime": $("#timepicker1").val(),
            "contScnEndTime": $("#timepicker2").val()
        };
        // alert("text:" + $("#con-ord-no").text());    // 获取<p>的内容用.text()
        return json;
    }

    function addScenicForOrder() {
        $.ajax({
            type: "post",
            url: "addContent.action",
            data: JSON.stringify(GetScenicJsonData()),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                // alert("success");
                // 注意，只添加节点不更新页面
                //获取到Ul列表
                var ul = document.getElementById("timeline-ul");
                var obj = eval(data);
                var val = obj.content;
                //创建元素Li
                var li = document.createElement("li");
                var date = new Date(val.contScnDate);
                var text1 = '<div class="timeline-badge success"></div><div class="timeline-panel">';
                var text2 = '<div class="timeline-heading"><h4 class="timeline-title">' + val.contScnName + '</h4><p><small class="text-muted">' + date.format('yyyy-mm-dd') + " " + val.contScnStartTime + " - " + val.contScnEndTime + '</small></p></div>';
                var text3 = '<div class="timeline-body text-left"><p>' + val.contDetails + '</p></div></div>';
                //向li中添加内容
                li.innerHTML = text1 + text2 + text3;
                //向ul追加元素li
                ul.appendChild(li);
            },
            error: function (data) {
            }
        });
    };

    // 为订单添加一酒店服务
    function GetHotelJsonData() {
        var json = {
            "contOrdNo": $("#con-ord-no").text(),
            "contType": 2,
            "contHtlNo": $("#multiselect-hotel").val(),
            "contHtlCheckInStr": $("#datepicker3").val(),
            "contHtlCheckOutStr": $("#datepicker4").val()
        };
        // alert("text:" + $("#con-ord-no").text());    // 获取<p>的内容用.text()
        return json;
    }

    // 添加酒店记录
    function addHotelForOrder() {
        $.ajax({
            type: "post",
            url: "addContent.action",
            data: JSON.stringify(GetHotelJsonData()),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                // alert("success");
                // 注意，只添加节点不更新页面
                //获取到Ul列表
                var ul = document.getElementById("timeline-ul");
                var obj = eval(data);
                var val = obj.content;
                //创建元素Li
                var li = document.createElement("li");
                li.setAttribute("class", "timeline-inverted");  // 时间轴右侧，左侧无需设置
                var startDate = new Date(val.contHtlCheckIn);
                var endDate = new Date(val.contHtlCheckOut);
                var text1 = '<div class="timeline-badge info"></div><div class="timeline-panel">';
                var text2 = '<div class="timeline-heading"><h4 class="timeline-title">' + val.contHtlName + '</h4><p><small class="text-muted">' + startDate.format('yyyy-mm-dd') + " - " + endDate.format('yyyy-mm-dd') + '</small></p></div>';
                var text3 = '<div class="timeline-body text-left"><p>' + val.contDetails + '</p></div></div>';
                //向li中添加内容
                li.innerHTML = text1 + text2 + text3;
                //向ul追加元素li
                ul.appendChild(li);
            },
            error: function (data) {
            }
        });
    }

    // 添加配车信息
    function addContForVhc() {
        var json = {
            "contType": 3,
            "contOrdNo": $("#con-ord-no").text()
        };
        $.ajax({
            type: "post",
            url: "addContent.action",
            data: JSON.stringify(json),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                document.getElementById('ord-seat').setAttribute("disabled", "");
            },
            error: function (data) {
                // alert("error");
            }
        });
    }

    // 添加责任人 导游
    function addOrdAgent() {
        // alert("addOrdAgent");
        var json = {
            "ordAgentName": $("#ord-agent").val(),
            "ordNo": $("#con-ord-no").text()
        };
        // alert("json:"+json);
        $.ajax({
            type: "post",
            url: "setOrdAgent.action",
            data: JSON.stringify(json),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                document.getElementById('ord-agent').setAttribute("disabled", "");
            },
            error: function (data) {
                // alert("error");
            }
        });
    }

    // 设置订单为已处理
    function setOrdHlded() {
        var json = {
            "ordNo": $("#con-ord-no").text()
        };
        $.ajax({
            type: "post",
            url: "setOrdHlded.action",
            data: JSON.stringify(json),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                // alert("success");
                document.getElementById('addScenic').setAttribute("disabled", "");
                document.getElementById('addHotel').setAttribute("disabled", "");
                document.getElementById('sbmOrd').setAttribute("disabled", "");
                window.location.href = "ordersManage.jsp";
            },
            error: function (data) {
                // alert("error");
            }
        });
    }

    // 确认提交
    function sbmOrd() {
        // alert("sbmAgentAndSeat");
        // alert("车val："+document.getElementById('ord-seat').value)
        if (document.getElementById('ord-seat').value == "是"){
            addContForVhc();    // 请求车辆（并没有分配车辆）
        }
        addOrdAgent();  // 分配导游
        setOrdHlded();  // 设置订单为已处理
    }

    // 页面加载完成时
    window.onload = $(function () {
        // 清空时间轴记录，id=timeline-ul
        // $('#timeline-ul li').each(function () {
        //     $(this).remove();
        // });

        // 导游复选框
        // $("#ord-agent").append('<option value="'+ key +'">' + key + '</option>');
        $.ajax({
            type: "get",
            url: "showAllEmpGuide.action",
            success: function (data) {
                // alert("success");
                var selectEmpGuide = document.getElementById("ord-agent");
                var obj = eval(data);
                for (var i = 0; i < obj.employee.length; i++) {
                    var val = obj.employee[i];
                    //创建元素Li
                    var option = document.createElement("option");
                    option.innerHTML = '<option value="' + val.empNo + '">' + val.empName + '</option>';
                    selectEmpGuide.append(option);
                }
            },
            error: function (data) {
            }
        });


        // 景区复选框
        $('#multiselect-scenic').multiselect({
            buttonWidth: 160,
            enableFiltering: true,
            maxHeight: 300,
            onChange: function (option, checked) {
                var values = [];
                $('#multiselect-scenic option').each(function () {
                    if ($(this).val() !== option.val()) {
                        values.push($(this).val());
                    }
                });
                $('#multiselect-scenic').multiselect('deselect', values);

                // 使选项最多选择1个
                // var selectedOptions = $('#multiselect-scenic option:selected');
                // if (selectedOptions.length >= 1) {
                //     // 限制其他选项.
                //     var nonSelectedOptions = $('#multiselect-scenic option').filter(function () {
                //         return !$(this).is(':selected');
                //     });
                //
                //     var dropdown = $('#multiselect-scenic').siblings('.multiselect-container');
                //     nonSelectedOptions.each(function () {
                //         var input = $('input[value="' + $(this).val() + '"]');
                //         input.prop('disabled', true);
                //         input.parent('li').addClass('disabled');
                //     });
                // }
                // else {
                //     // 恢复选项.
                //     var dropdown = $('#multiselect-scenic').siblings('.multiselect-container');
                //     $('#multiselect-scenic option').each(function () {
                //         var input = $('input[value="' + $(this).val() + '"]');
                //         input.prop('disabled', false);
                //         input.parent('li').addClass('disabled');
                //     });
                // }

            }
        });
        // 选择景点复选框 设置数据
        var scenicData = [
            {label: "象山公园", value: "4001"},
            {label: "叠彩山公园", value: "4002"},
            {label: "伏波公园", value: "4003"},
            {label: "芦笛岩", value: "4004"},
            {label: "七星公园", value: "4005"},
            {label: "穿山公园", value: "4006"},
            {label: "尧山景区", value: "4007"},
            {label: "靖江王城独秀峰", value: "4008"},
            {label: "日月双塔文化公园", value: "4009"},
            {label: "两江四湖", value: "4010"},
            {label: "西山景区", value: "4011"},
            {label: "桂林动物园", value: "4012"},
            {label: "世外桃源", value: "4013"},
            {label: "大榕树", value: "4014"},
            {label: "月亮山", value: "4015"},
            {label: "图腾古道", value: "4016"},
            {label: "蝴蝶泉", value: "4017"},
            {label: "聚龙潭奇石宫", value: "4018"},
            {label: "龙颈河漂流", value: "4019"},
            {label: "印象刘三姐大型山水演出", value: "4020"},
            {label: "银子岩", value: "4021"},
            {label: "漓江", value: "4022"},
            {label: "遇龙河", value: "4023"},
            {label: "十里画廊", value: "4024"},
            {label: "龙胜梯田", value: "4025"},
            {label: "资源八角寨", value: "4026"},
            {label: "资源天门山", value: "4027"},
            {label: "灵渠", value: "4028"},
            {label: "古东瀑布", value: "4029"},
            {label: "冠岩", value: "4030"},
            {label: "猫儿山", value: "4031"},
            {label: "乐满地主题公园", value: "4032"}
        ];
        $("#multiselect-scenic").multiselect('dataprovider', scenicData);


        // 酒店复选框
        $('#multiselect-hotel').multiselect({
            buttonWidth: 400,
            enableFiltering: true,
            maxHeight: 300,
            onChange: function (option, checked) {
                var values = [];
                $('#multiselect-hotel option').each(function () {
                    if ($(this).val() !== option.val()) {
                        values.push($(this).val());
                    }
                });
                $('#multiselect-hotel').multiselect('deselect', values);

                // 使选项最多选择1个
                // var selectedOptions = $('#multiselect-hotel option:selected');
                // if (selectedOptions.length >= 1) {
                //     // 限制其他选项.
                //     var nonSelectedOptions = $('#multiselect-hotel option').filter(function () {
                //         return !$(this).is(':selected');
                //     });
                //
                //     var dropdown = $('#multiselect-hotel').siblings('.multiselect-container');
                //     nonSelectedOptions.each(function () {
                //         var input = $('input[value="' + $(this).val() + '"]');
                //         input.prop('disabled', true);
                //         input.parent('li').addClass('disabled');
                //     });
                // }
                // else {
                //     // 恢复选项.
                //     var dropdown = $('#multiselect-hotel').siblings('.multiselect-container');
                //     $('#multiselect-hotel option').each(function () {
                //         var input = $('input[value="' + $(this).val() + '"]');
                //         input.prop('disabled', false);
                //         input.parent('li').addClass('disabled');
                //     });
                // }



            }
        });



        // 选择酒店复选框 设置数据
        var hotelData = [
            {label: "桂林大公馆酒店 亲子套间L", value: "5001"},
            {label: "桂林大公馆酒店 标准双人房（无早）", value: "5002"},
            {label: "阳朔象山国际大酒店 经典客房L(含早)", value: "5003"},
            {label: "阳朔象山国际大酒店 标准双人房（无早）", value: "5004"},
            {label: "维也纳酒店（机场路榕山店） 经典客房L(含早)", value: "5005"},
            {label: "维也纳酒店（机场路榕山店） 三人间L", value: "5006"},
            {label: "城市便捷酒店（机场大道红店） 经典客房L(含早)", value: "5007"},
            {label: "城市便捷酒店（机场大道红店） 三人间L", value: "5008"},
            {label: "维也纳酒店（桂林七星路店） 经典客房L(含早)", value: "5009"},
            {label: "维也纳酒店（桂林七星路店） 三人间L", value: "5010"},
            {label: "桂林王城国际青年旅舍 经典客房L(含早)", value: "5011"},
            {label: "桂林王城国际青年旅舍 三人间L", value: "5012"},
            {label: "汉庭酒店（伏波山公园店） 经典客房L(含早)", value: "5013"},
            {label: "汉庭酒店（伏波山公园店） 三人间L", value: "5014"},
            {label: "城市便捷酒店（桂林高新区万达店） 雅致大床房L", value: "5015"},
            {label: "城市便捷酒店（桂林高新区万达店） 三人间La", value: "5016"},
            {label: "阳朔西街口大酒店 雅致大床房L", value: "5017"},
            {label: "阳朔西街口大酒店 三人间L", value: "5018"},
            {label: "7天连锁酒店（桂林汽车总站东安街店） 雅致大床房L", value: "5019"},
            {label: "7天连锁酒店（桂林汽车总站东安街店） 三人间L", value: "5020"},
            {label: "桂林喜来登饭店 亲子套间L", value: "5021"},
            {label: "桂林喜来登饭店 标准双人房（无早）", value: "5022"},
            {label: "城市便捷酒店（桂林两江四湖店） 雅致大床房L", value: "5023"},
            {label: "城市便捷酒店（桂林两江四湖店） 商务双人间（无早）", value: "5024"},
            {label: "7天连锁酒店（兴安乐满地店） 雅致大床房L", value: "5025"},
            {label: "7天连锁酒店（兴安乐满地店） 商务双人间（无早）", value: "5026"},
            {label: "维也纳酒店（桂林火车站店） 雅致大床房L", value: "5027"},
            {label: "维也纳酒店（桂林火车站店） 商务双人间（无早）", value: "5028"},
            {label: "锦江之星（桂林七星路店） 雅致大床房L", value: "5029"},
            {label: "锦江之星（桂林七星路店） 商务双人间（无早）", value: "5030"},
            {label: "城市便捷酒店（桂林甲天下广场店） 雅致大床房L", value: "5031"},
            {label: "城市便捷酒店（桂林甲天下广场店） 商务双人间（无早）", value: "5032"},
            {label: "雅斯特酒店（桂林象山公园店） 雅致大床房L", value: "5033"},
            {label: "雅斯特酒店（桂林象山公园店） 商务双人间（无早）", value: "5034"},
            {label: "城市便捷酒店（桂林兴安店） 雅致大床房L", value: "5035"},
            {label: "城市便捷酒店（桂林兴安店） 商务双人间（无早）", value: "5036"},
            {label: "龙胜温泉度假中心酒店 标准双人房（无早）", value: "5037"},
            {label: "龙胜温泉度假中心酒店 商务双人间（无早）", value: "5038"},
            {label: "维也纳酒店（桂林象山公园店） 亲子套间L", value: "5039"},
            {label: "维也纳酒店（桂林象山公园店） 标准双人房（无早）", value: "5040"},
            {label: "桂林漓江大瀑布饭店 亲子套间L", value: "5041"},
            {label: "桂林漓江大瀑布饭店 标准双人房（无早）", value: "5042"},
            {label: "龙胜温泉度假中心酒店(桂林) 亲子套间L", value: "5043"},
            {label: "龙胜温泉度假中心酒店(桂林) 标准双人房（无早）", value: "5044"},
            {label: "桂林会展国际酒店 经典客房L(含早)", value: "5045"},
            {label: "桂林会展国际酒店 标准双人房（无早）", value: "5046"},
            {label: "维也纳酒店（七星万达广场店） 经典客房L(含早)", value: "5047"},
            {label: "维也纳酒店（七星万达广场店） 标准双人房（无早）", value: "5048"},
            {label: "维也纳酒店（桂林市府店） 经典客房L(含早)", value: "5049"},
            {label: "维也纳酒店（桂林市府店） 标准双人房（无早）", value: "5050"},
            {label: "维也纳国际酒店（桂林万象城店） 经典客房L(含早)", value: "5051"},
            {label: "维也纳国际酒店（桂林万象城店） 标准双人房（无早）", value: "5052"}
        ];
        $("#multiselect-hotel").multiselect('dataprovider', hotelData);

        // Time Picker
        jQuery('#timepicker1').timepicker({showMeridian: false});
        jQuery('#timepicker2').timepicker({showMeridian: false});

        // Date Picker
        jQuery('#datepicker1').datepicker();
        jQuery('#datepicker3').datepicker();
        jQuery('#datepicker4').datepicker();


        function GetContJsonData() {
            // 获取当前正在处理订单的订单号
            var ordManageNo = sessionStorage.getItem('ordManageNo');
            var json = {
                "contOrdNo": ordManageNo
            };
            return json;
        };
        // 加载订单内容的状态
        $.ajax({
            type: "post",
            url: "showContentByOrdNo.action",
            data: JSON.stringify(GetContJsonData()),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                var ul = document.getElementById("timeline-ul");
                var obj = eval(data);
                for (var i = 0; i < obj.content.length; i++) {
                    var val = obj.content[i];
                    //创建元素Li
                    var li = document.createElement("li");
                    if (val.contType == 1) {
                        // 景点
                        var date = new Date(val.contScnDate);
                        var text1 = '<div class="timeline-badge success"></div><div class="timeline-panel">';
                        var text2 = '<div class="timeline-heading"><h4 class="timeline-title">' + val.contScnName + '</h4><p><small class="text-muted">' + date.format('yyyy-mm-dd') + " " + val.contScnStartTime + " - " + val.contScnEndTime + '</small></p></div>';
                        var text3 = '<div class="timeline-body text-left"><p>' + val.contDetails + '</p></div></div>';
                        //向li中添加内容
                        li.innerHTML = text1 + text2 + text3;
                    } else if (val.contType == 2) {
                        // 酒店
                        li.setAttribute("class", "timeline-inverted");  // 时间轴右侧，左侧无需设置
                        var startDate = new Date(val.contHtlCheckIn);
                        var endDate = new Date(val.contHtlCheckOut);
                        var text1 = '<div class="timeline-badge info"></div><div class="timeline-panel">';
                        var text2 = '<div class="timeline-heading"><h4 class="timeline-title">' + val.contHtlName + '</h4><p><small class="text-muted">' + startDate.format('yyyy-mm-dd') + " - " + endDate.format('yyyy-mm-dd') + '</small></p></div>';
                        var text3 = '<div class="timeline-body text-left"><p>' + val.contDetails + '</p></div></div>';
                        //向li中添加内容
                        li.innerHTML = text1 + text2 + text3;
                    } else {

                    }
                    //向ul追加元素li
                    ul.appendChild(li);
                }
                // TODO 移除 当前正在处理的订单
                // sessionStorage.removeItem("ordManageNo");
            },
            error: function (data) {
                // alert("error");
            }
        });

        function GetOrdJsonData() {
            // 获取当前正在处理订单的订单号
            var ordManageNo = sessionStorage.getItem('ordManageNo');
            var json = {
                "ordNo": ordManageNo
            };
            return json;
        };
        // 加载待处理的订单记录
        $.ajax({
            type: "post",
            url: "findNowHldOrders.action",
            data: JSON.stringify(GetOrdJsonData()),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                var obj = eval(data);
                var val = obj.orders;
                // 日期处理 注意引用相关js
                var startTime = new Date(val.ordStartTime);
                var endTime = new Date(val.ordEndTime);
                var leaveTime = startTime.format('yyyy-mm-dd') + "至" + endTime.format('yyyy-mm-dd');
                var num = "成人" + val.ordAdultNum + ",儿童" + val.ordChildNum;

                document.getElementById("con-ord-time").innerHTML = leaveTime;
                document.getElementById("con-ord-no").innerHTML = val.ordNo;
                document.getElementById("con-ord-number").innerHTML = num;
                document.getElementById("con-ord-tel").innerHTML = (val.ordTel == null ? "" : val.ordTel);
                document.getElementById("con-ord-budget").innerHTML = (val.ordBudget == null ? "" : val.ordBudget);
                document.getElementById("con-ord-email").innerHTML = (val.ordEmail == null ? "" : val.ordEmail);
                document.getElementById("con-ord-meal").innerHTML = val.ordMeal;
                document.getElementById("con-ord-describe").innerHTML = (val.ordNoteTag == null ? "" : val.ordNoteTag);

                // TODO 移除 当前正在处理的订单
                // sessionStorage.removeItem("ordManageNo");
            },
            error: function (data) {
                // alert("error");
            }
        });
    });
</script>


</body>
</html>