<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>车辆分配 - 桂林海外旅游公司</title>

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
                    <li><a href="ordersBillManage.jsp">订单总额</a></li>
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
            <div class="col-lg-12">
                <ul class="nav nav-tabs">

                    <li class="active">
                        <a href="#vehicleSrc" data-toggle="tab" aria-expanded="false">
                            <span class="visible-xs"><i class="fa fa-user"></i></span>
                            <span class="hidden-xs">车辆资源</span>
                        </a>
                    </li>
                    <li class="">
                        <a href="#vehicleDuty" data-toggle="tab" aria-expanded="true">
                            <span class="visible-xs"><i class="fa fa-home"></i></span>
                            <span class="hidden-xs">车辆分配</span>
                        </a>
                    </li>
                    <li class="">
                        <a href="#vehicleHistory" data-toggle="tab" aria-expanded="true">
                            <span class="visible-xs"><i class="fa fa-home"></i></span>
                            <span class="hidden-xs">历史记录</span>
                        </a>
                    </li>
                </ul>

                <div class="tab-content">
                    <!-- 历史记录 -->
                    <div class="tab-pane" id="vehicleHistory">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="panel panel-default">
                                    <div class="panel-body">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12 col-xs-12">
                                                <div class="table-responsive">
                                                    <table class="table table-hover" id="myVehicleHistoryTable">
                                                        <thead>
                                                        <tr>
                                                            <th>#</th>
                                                            <th>流水号</th>
                                                            <th>订单号</th>
                                                            <th>使用日期</th>
                                                            <th>车牌号</th>
                                                            <th>车型</th>
                                                            <th>处理时间</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>

                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div> <!--end id="vehicleHistory" -->

                    <!-- 车辆分配 -->
                    <div class="tab-pane" id="vehicleDuty">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="panel panel-default">
                                    <div class="panel-body">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12 col-xs-12">
                                                <div class="table-responsive">
                                                    <table class="table table-hover" id="myVehicleDutyTable">
                                                        <thead>
                                                        <tr>
                                                            <th>#</th>
                                                            <th>流水号</th>
                                                            <th>订单号</th>
                                                            <th>用车日期</th>
                                                            <th>人数</th>
                                                            <th>分配</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>

                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div> <!--end id="vehicleDuty" -->

                    <!-- 车辆资源 -->
                    <div class="tab-pane active" id="vehicleSrc">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="panel panel-default">
                                    <div class="panel-body">
                                        <div class="row">
                                            <div class="col-md-12 col-sm-12 col-xs-12">
                                                <div class="table-responsive">
                                                    <table class="table table-hover" id="myVehicleSrcTable">
                                                        <thead>
                                                        <tr>
                                                            <th>#</th>
                                                            <th>车牌号</th>
                                                            <th>车型</th>
                                                            <th>座位数</th>
                                                            <th>责任人</th>
                                                            <th>状态</th>
                                                        </tr>
                                                        </thead>
                                                        <tbody>

                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--end id="vehicleSrc"-->
                </div>
            </div>
        </div>
        <!-- End row -->
    </div>
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
<script src="js/jquery.nicescroll.js" type="text/javascript"></script>

<script src="js/jquery.app.js"></script>

<script src="js/dataFormat.js" type="text/javascript"></script>
<script type="text/javascript" src="js/json3.3.2.js"></script>
<script type="text/javascript">

    function GetVhcResultJsonData(i) {
        // alert("GetHldResultJsonData");
        var table = document.getElementById("myVehicleDutyTable");
        var contNo = table.rows[i].cells[1].innerText;   // 流水号
        var contOrdNo = table.rows[i].cells[2].innerText; // 订单号
        // alert("第"+i+"内容为"+contNo + ","+ contOrdNo);
        var json = {
            "contNo": contNo,
            "contOrdNo": contOrdNo,
            "contType": 3
        }
        return json;
    }

    // 分配车辆
    function handle(i) {
        $.ajax({
            type: "post",
            url: "changeContState.action",
            data: JSON.stringify(GetVhcResultJsonData(i)),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                // alert("success");
                // 刷新当前页
                window.location.replace("vehicleDistribution.jsp");
            },
            error: function (data) {
                // alert("error");
            }
        });
    }

    // 加载待处理的车辆信息
    function GetVhcJsonData() {
        // 加载类型为1的景点信息
        var json = {
            "contType": 3
        };
        return json;
    }

    function getVhcDuty() {
        // 加载待处理的车辆分配信息
        $.ajax({
            type: "post",
            url: "showAllWaitCont.action",
            data: JSON.stringify(GetVhcJsonData()),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                // alert("success");
                var obj = eval(data);
                var tbody = $('<tbody></tbody>');
                var k = 0;
                for (var i = 0; i < obj.content.length; i++) {
                    var val = obj.content[i];
                    if (val.contType != 3) {
                        continue;
                    }
                    var tr = $('<tr></tr>');
                   k++;
                    var startDate = new Date(val.contVhcStartTime);
                    var endDate = new Date(val.contVhcEndTime);
                    var d = startDate.format("yyyy-mm-dd") + "至" + endDate.format("yyyy-mm-dd");
                    var button = '<button type="button" class="btn btn-success" value="2" onclick="handle(' + k + ',' + ')">分配</button>';
                    tr.append('<td>' + k + '</td>' + '<td>' + val.contNo + '</td>' + '<td>' + val.contOrdNo + '</td>' + '<td>' + d + '</td>' + '<td>' + (val.contVhcSeat == 1 ? "" : val.contVhcSeat) + '</td>' + '<td>' + button + '</td>');
                    tbody.append(tr);
                }
                $('#myVehicleDutyTable tbody').replaceWith(tbody);
            },
            error: function (data) {
                // alert("error");
            }
        });
    }


    function getVhcSrc() {
        // 加载车辆信息
        $.ajax({
            type: "get",
            url: "showAllVehicle.action",
            success: function (data) {
                var obj = eval(data);
                var tbody = $('<tbody></tbody>');
                for (var i = 0; i < obj.vehicle.length; i++) {
                    var val = obj.vehicle[i];
                    var tr = $('<tr></tr>');
                    var k = i + 1;
                    tr.append('<td>' + k + '</td>' + '<td>' + val.vhcNum + '</td>' + '<td>' + val.vhcModel + '</td>' + '<td>' + val.vhcSeat + '</td>' + '<td>' + val.vhcAgent + '</td>' + '<td>' + val.vhcState + '</td>');
                    tbody.append(tr);
                }
                $('#myVehicleSrcTable tbody').replaceWith(tbody);
            },
            error: function (data) {
                // alert("error");
            }
        });
    }

    function getVhcHistory() {
        // 加载车辆分配的历史信息
        $.ajax({
            type: "get",
            url: "showAllFinishCont.action",
            success: function (data) {
                // alert("success");
                var obj = eval(data);
                var tbody = $('<tbody></tbody>');
                var k = 0;
                for (var i = 0; i < obj.content.length; i++) {
                    var val = obj.content[i];
                    if (val.contType == 3) {
                        var tr = $('<tr></tr>');
                        k ++;
                        var startDate = new Date(val.contVhcStartTime);
                        var endDate = new Date(val.contVhcEndTime);
                        var d = startDate.format("yyyy-mm-dd") + "至" + endDate.format("yyyy-mm-dd");
                        var hldDate = new Date(val.contTimeTag);
                        tr.append('<td>' + k + '</td>' + '<td>' + val.contNo + '</td>' + '<td>' + val.contOrdNo + '</td>' + '<td>' + d + '</td>' + '<td>' + (val.contVhcNum == null ? "" : val.contVhcNum) + '</td>' + '<td>' + (val.contVhcModel == null ? "" : val.contVhcModel) + '</td>' + '<td>' + hldDate.format("yyyy-mm-dd HH:MM:ss") + '</td>');
                        tbody.append(tr);
                    }
                }
                $('#myVehicleHistoryTable tbody').replaceWith(tbody);
            },
            error: function (data) {
                // alert("error");
            }
        });
    }

    // 页面加载完成时
    window.onload = $(function () {
        getVhcSrc();    // 加载车辆信息
        getVhcDuty();   // 加载待处理的车辆分配信息
        getVhcHistory();    // 加载历史（已处理）的车辆分配信息
    });
</script>

</body>
</html>