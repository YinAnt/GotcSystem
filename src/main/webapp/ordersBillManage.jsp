<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>订单列表 - 桂林海外旅游公司</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-reset.css" rel="stylesheet">

    <!--Animation css-->
    <link href="css/animate.css" rel="stylesheet">

    <!--Icon-fonts css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet"/>
    <link href="assets/ionicon/css/ionicons.min.css" rel="stylesheet"/>

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
        <div class="row">
            <div class="col-md-12">

                <ul class="nav nav-tabs">

                    <li class="active">
                        <a href="#monthOrdList" data-toggle="tab" aria-expanded="false">
                            <span class="visible-xs"><i class="fa fa-user"></i></span>
                            <span class="hidden-xs">待结算订单</span>
                        </a>
                    </li>
                    <li class="">
                        <a href="#OrdList" data-toggle="tab" aria-expanded="true">
                            <span class="visible-xs"><i class="fa fa-home"></i></span>
                            <span class="hidden-xs">已结算订单</span>
                        </a>
                    </li>
                </ul>

                <div class="tab-content">
                    <!-- 本月订单账单 -->
                    <div class="tab-pane active" id="monthOrdList">
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-md-11">
                                        <%--<h3 class="panel-title">待结算订单</h3>--%>
                                    </div>
                                    <div class="col-md-1 text-right">
                                        <button id="btn" type="button" class="btn btn-success">导出</button>
                                    </div>
                                </div>
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <div class="table-responsive">
                                            <table class="table table-hover" id="myTable">
                                                <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>订单号</th>
                                                    <th>用户名</th>
                                                    <th>创建时间</th>
                                                    <th>付款时间</th>
                                                    <th>订单总额</th>
                                                    <th>订单状态</th>
                                                    <th>责任人</th>
                                                </tr>
                                                </thead>
                                                <tbody>

                                                </tbody>
                                                <tfoot>

                                                </tfoot>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div><!--end  id="monthOrdList"-->

                    <div class="tab-pane" id="OrdList">
                        <!-- 历史订单 -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-md-11">
                                        <%--<h3 class="panel-title">已结算订单</h3>--%>
                                    </div>
                                    <div class="col-md-1 text-right">
                                        <button id="btn2" type="button" class="btn btn-success">导出</button>
                                    </div>
                                </div>
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-md-12 col-sm-12 col-xs-12">
                                        <div class="table-responsive">
                                            <table class="table table-hover" id="myTable2">
                                                <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>订单号</th>
                                                    <th>用户名</th>
                                                    <th>创建时间</th>
                                                    <th>付款时间</th>
                                                    <th>订单总额</th>
                                                    <th>订单状态</th>
                                                    <th>责任人</th>
                                                    <th>查看</th>
                                                </tr>
                                                </thead>
                                                <tbody>

                                                </tbody>
                                                <tfoot>

                                                </tfoot>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--end id="OrdList"-->

                </div><!--end  table-content -->
            </div>
        </div> <!-- End row -->
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
<!-- TODO 查看订单详情页 响应式模态框  label:for input text:id,placeholder-->
<div id="con-order-detail-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title">订单详情</h4>
            </div>
            <%--<form class="form-horizontal" role="form">--%>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="detail-field-1" class="col-sm-4 control-label">订单号</label>
                            <p class="col-md-8" id="detail-field-1"></p>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="detail-field-3" class="col-sm-4 control-label">用户名</label>
                            <p class="col-md-8" id="detail-field-3"></p>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="detail-field-2" class="col-sm-4 control-label">创建时间</label>
                            <p class="col-md-8" id="detail-field-2"></p>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="detail-field-4" class="col-sm-4 control-label">联系方式</label>
                            <p class="col-md-8" id="detail-field-4"></p>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="detail-field-5" class="col-sm-4 control-label">订单总额</label>
                            <p class="col-md-8" id="detail-field-5"></p>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="detail-field-11" class="col-sm-4 control-label">邮箱</label>
                            <p class="col-md-8" id="detail-field-11"></p>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="detail-field-10" class="col-sm-4 control-label">支付状态</label>
                            <p class="col-md-8" id="detail-field-10"></p>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="detail-field-8" class="col-sm-4 control-label">人数</label>
                            <p class="col-md-8" id="detail-field-8"></p>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="detail-field-6" class="col-sm-4 control-label">支付时间</label>
                            <p class="col-md-8" id="detail-field-6"></p>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="detail-field-9" class="col-sm-4 control-label">责任人</label>
                            <p class="col-md-8" id="detail-field-9"></p>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="form-group">
                            <label for="detail-field-7" class="col-sm-2 control-label">旅游时间</label>
                            <p class="col-md-10 text-left" id="detail-field-7"></p>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <table class="table table-hover" id="detail-table">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>品名</th>
                                        <th>价格</th>
                                    </tr>
                                    </thead>
                                    <tbody>

                                    </tbody>
                                    <tfoot>

                                    </tfoot>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%--</form>--%>
        </div>
    </div>
</div><!-- con-order-detail-modal end -->

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
<script src="js/bootstrap.min.js"></script>
<script src="js/pace.min.js"></script>
<script src="js/wow.min.js"></script>
<script src="js/jquery.nicescroll.js"></script>

<script src="js/jquery.app.js"></script>
<script src="js/jquery.table2excel.js" type="text/javascript"></script>
<script>
    // 导出excel
    $(function () {
        $("#btn").click(function () {
            $("#myTable").table2excel({
                exclude: ".noExl",
                name: "Excel Document Name",
                filename: "待处理订单" + new Date().format("yyyymmdd"),
                exclude_img: true,
                exclude_links: true,
                exclude_inputs: true
            });
        });

        $("#btn2").click(function () {
            $("#myTable2").table2excel({
                exclude: ".noExl",
                name: "Excel Document Name",
                filename: "已结算订单" + new Date().format("yyyymmdd"),
                exclude_img: true,
                exclude_links: true,
                exclude_inputs: true
            });
        });
    });
</script>

<script src="js/dataFormat.js" type="text/javascript"></script>
<script type="text/javascript" src="js/json3.3.2.js"></script>
<script type="text/javascript">


    // // 点击处理按钮，处理订单
    // function handleOrder(i) {
    //     sessionStorage.setItem('ordManageNo', i);
    //     // 跳转页面
    //     window.location.href='touristRoute.jsp';
    // }
    function showDetailForOrd(data) {
        var obj = eval(data);
        var val = obj.orders;
        // 日期处理 注意引用相关js
        var createTime = new Date(val.ordCreateTime);
        var payTime = new Date(val.ordPayTime);
        var startTime = new Date(val.ordStartTime);
        var endTime = new Date(val.ordEndTime);
        var travelTime = startTime.format('yyyy-mm-dd') + " 至 " + endTime.format('yyyy-mm-dd');
        var num = "成人" + (val.ordAdultNum == null ? "0" : val.ordAdultNum) + ",儿童" + (val.ordChildNum == null ? "0" : val.ordChildNum);

        document.getElementById("detail-field-1").innerHTML = (val.ordNo == null ? "" : val.ordNo);
        document.getElementById("detail-field-2").innerHTML = (val.ordCreateTime == null ? "" : createTime.format("yyyy-mm-dd HH:MM:ss"));
        document.getElementById("detail-field-3").innerHTML = (val.ordUser == null ? "" : val.ordUser);
        document.getElementById("detail-field-4").innerHTML = (val.ordTel == null ? "" : val.ordTel);
        document.getElementById("detail-field-5").innerHTML = (val.ordPay == null ? "" : val.ordPay);
        document.getElementById("detail-field-6").innerHTML = (val.ordPayTime == null ? "" : payTime.format("yyyy-mm-dd HH:MM:ss"));
        document.getElementById("detail-field-7").innerHTML = travelTime;
        document.getElementById("detail-field-8").innerHTML = num;
        document.getElementById("detail-field-9").innerHTML = (val.ordAgentName == null ? "" : val.ordAgentName);
        document.getElementById("detail-field-10").innerHTML = (val.ordState == 3 ? "已付款" : "未付款");
        document.getElementById("detail-field-11").innerHTML = (val.ordEmail == null ? "" : val.ordEmail);
    }

    function showDetailForCont(data) {
        var obj = eval(data);
        var tbody = $('<tbody></tbody>');
        for (var i = 0; i < obj.content.length; i++) {
            var val = obj.content[i];
            var tr = $('<tr></tr>');
            var k = i + 1;
            if (val.contName != null) {
                tr.append('<td>' + k + '</td>' + '<td>' + (val.contName == null ? "" : val.contName) + '</td>' + '<td>' + (val.contFare == null ? "" : val.contFare));
                tbody.append(tr);
            }
        }
        $('#detail-table tbody').replaceWith(tbody);
    }

    function getOrdJsonData(ordManageNo) {
        var json = {
            "ordNo": ordManageNo
        };
        return json;
    }

    // 点击查看按钮，查看订单详情
    function showOrder(ordManageNo) {

        // 根据订单号加载订单详情 ord 和 订单内容详情 cont
        $.ajax({
            type: "post",
            url: "findHldOrdAndConts.action",
            data: JSON.stringify(getOrdJsonData(ordManageNo)),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                // 显示订单详情
                showDetailForOrd(data);
                // 显示订单内容详情
                showDetailForCont(data);
            },
            error: function (data) {
                // alert("error");
            }
        });
    }

    // 页面加载完成时
    window.onload = $(function () {
        // 加载订单详单
        $.ajax({
            url: "showAllOrders.action",
            type: "get",
            success: function (data) {
                var obj = eval(data);
                var k = 0;
                var sum = 0;
                // 本月未结算订单表
                var tbody1 = $('<tbody></tbody>');
                for (var i = 0; i < obj.orders.length; i++) {
                    var val = obj.orders[i];
                    var tr = $('<tr></tr>');
                    if (val.ordState != 2) { // 已处理，待结算
                        continue;
                    }
                    k++;
                    if (val.ordPay != null) {
                        sum += val.ordPay;
                    }
                    // 日期处理 注意引用相关js
                    var createDate = new Date(val.ordCreateTime);
                    var payDate = new Date(val.ordPayTime);
                    tr.append('<td>' + k + '</td>' + '<td>' + val.ordNo + '</td>' + '<td>' + (val.ordUser == null ? "" : val.ordUser) + '</td>' + '<td>' + (val.ordCreateTime == null ? "" : createDate.format("yyyy-mm-dd")) + '</td>' + '<td>' + (val.ordPayTime == null ? "" : payDate.format("yyyy-mm-dd")) + '</td>' + '<td>' + (val.ordPay == null ? "" : val.ordPay) + '</td>' + '<td>' + (val.ordState == 2 ? "未付款" : "已付款") + '</td>' + '<td>' + (val.ordAgentName == null ? "" : val.ordAgentName) + '</td>');
                    tbody1.append(tr);
                }
                $('#myTable tbody').replaceWith(tbody1);
                var tfoot1 = $('<tfoot></tfoot>');
                var tftr1 = $('<tr></tr>');
                tftr1.append('<td>' + '' + '</td>' + '<td>' + '' + '</td>' + '<td>' + '' + '</td>' + '<td>' + '' + '</td>' + '<td>' + '订单总额' + '</td>' + '<td>' + sum + '</td>' + '<td>' + '' + '</td>' + '<td>' + '' + '</td>');
                tfoot1.append(tftr1);
                $('#myTable tfoot').replaceWith(tfoot1);

                // 本月已结算订单表
                var tbody2 = $('<tbody></tbody>');
                k = 0, sum = 0;
                for (var i = 0; i < obj.orders.length; i++) {
                    var val = obj.orders[i];
                    var tr = $('<tr></tr>');
                    k = i + 1;
                    if (val.ordState != 3) { // 已结算
                        continue;
                    }
                    if (val.ordPay != null) {
                        sum += val.ordPay;
                    }
                    // 日期处理 注意引用相关js
                    var createDate = new Date(val.ordCreateTime);
                    var payDate = new Date(val.ordPayTime);
                    var btn = '<button type="button" class="btn btn-success" data-toggle="modal" data-target="#con-order-detail-modal" onclick="showOrder(' + val.ordNo + ')">查看</button>';
                    tr.append('<td>' + k + '</td>' + '<td>' + val.ordNo + '</td>' + '<td>' + (val.ordUser == null ? "" : val.ordUser) + '</td>' + '<td>' + (val.ordCreateTime == null ? "" : createDate.format("yyyy-mm-dd")) + '</td>' + '<td>' + (val.ordPayTime == null ? "" : payDate.format("yyyy-mm-dd")) + '</td>' + '<td>' + (val.ordPay == null ? "" : val.ordPay) + '</td>' + '<td>' + (val.ordState == 2 ? "未付款" : "已付款") + '</td>' + '<td>' + (val.ordAgentName == null ? "" : val.ordAgentName) + '</td>' + '<td>' + btn + '</td>');
                    tbody2.append(tr);
                }
                $('#myTable2 tbody').replaceWith(tbody2);
                var tfoot2 = $('<tfoot></tfoot>');
                var tftr2 = $('<tr></tr>');
                tftr2.append('<td>' + '' + '</td>' + '<td>' + '' + '</td>' + '<td>' + '' + '</td>' + '<td>' + '' + '</td>' + '<td>' + '订单总额' + '</td>' + '<td>' + sum + '</td>' + '<td>' + '' + '</td>' + '<td>' + '' + '</td>');
                tfoot2.append(tftr2);
                $('#myTable2 tfoot').replaceWith(tfoot2);
            }
        });
    });
</script>


</body>
</html>