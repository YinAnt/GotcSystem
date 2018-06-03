<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>首页 - 桂林海外旅游公司</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-reset.css" rel="stylesheet">

    <!--Animation css-->
    <link href="css/animate.css" rel="stylesheet">

    <!--Icon-fonts css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet"/>
    <link href="assets/ionicon/css/ionicons.min.css" rel="stylesheet"/>

    <!--Morris Chart CSS -->
    <link href="assets/morris/morris.css" rel="stylesheet">

    <!-- Plugins css -->
    <link href="assets/modal-effect/css/component.css" rel="stylesheet">

    <link href="assets/sweet-alert/sweet-alert.min.css" rel="stylesheet">

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
            <i class="ion-leaf"></i>
            <!-- <i class="ion-social-buffer"></i> -->
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
            <%--公告展示--%>
            <div class="col-md-8">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title text-center">公告展示</h3>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                    <p id="myLatestAnnounce"></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div> <!-- end col -->


            <!-- 考勤情况 -->
            <div class="col-md-4">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="row">
                            <div class="col-md-11 text-center">
                                <h4>考勤统计</h4>
                            </div>
                            <div class="col-md-1 text-right">
                                <a href="#" class="pull-right btn btn-primary btn-sm" id="sa-close-sign"
                                   onclick=signIn()>签</a>
                            </div>
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive text-center">
                                <table class="table text-center" id="myAttTable">
                                    <thead>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>请假天数</td>
                                        <td>0 天</td>
                                    </tr>
                                    <tr>
                                        <td>签到统计</td>
                                        <td>应签-0-次，已签-0-次</td>
                                    </tr>
                                    <tr>
                                        <td>签退统计</td>
                                        <td>应签-0-次，已签-0-次</td>
                                    </tr>
                                    <tr>
                                        <td>日志统计</td>
                                        <td>应填-0-天，已填-0-次</td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- end col -->
        </div>
        <!-- end row -->



        <div class="row">
            <%--待办事项--%>
            <div class="col-md-12">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title text-center">待办事项</h3>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                    <div class="table-responsive">
                                        <table class="table table-hover" id="myHldTable">
                                            <thead>
                                            <tr>
                                                <th>#</th>
                                                <th>工单号</th>
                                                <th>请假人</th>
                                                <th>请假时间</th>
                                                <th>请假内容</th>
                                                <th>处理人</th>
                                                <th>处理</th>
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
            </div> <!-- end col -->

        </div>
        <%--end row--%>

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
<script src="js/modernizr.min.js"></script>
<script src="js/pace.min.js"></script>
<script src="js/wow.min.js"></script>
<script src="js/jquery.scrollTo.min.js"></script>
<script src="js/jquery.nicescroll.js"></script>
<script src="assets/chat/moment-2.2.1.js"></script>

<script src="assets/sweet-alert/sweet-alert.min.js"></script>
<script src="assets/sweet-alert/sweet-alert.init.js"></script>

<script src="js/jquery.app.js"></script>

<script src="js/dataFormat.js" type="text/javascript"></script>

<script type="text/javascript" src="js/json3.3.2.js"></script>
<script type="text/javascript">

    function GetSignJsonData() {
        // 注意" $ { employee.empName }" 是String,加引号
        var json = {
            "signEmpNo": ${employee.empNo},
            "signEmpName":"${employee.empName}"
        };
        return json;
    }
    //提交签到
    function signIn() {
        $.ajax({
            type: "post",
            url: "signIn.action",
            data: JSON.stringify(GetSignJsonData()),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (data) {
            },
            error: function (data) {
            }
        });
    }

    // TODO 重置密码
    // function GetChangePasswordJsonData() {
    //     var json = {
    //         "password": $("#password-field-1").val(),
    //         "repassword": $("#password-field-2").val()
    //     };
    //     return json;
    // }
    //
    // function changePassword() {
    //     $.ajax({
    //         url: ".action",
    //         type: "post",
    //         data: JSON.stringify(GetChangePasswordJsonData()),
    //         dataType: 'json',
    //         contentType: "application/json; charset=utf-8",
    //         success: function (data) {
    //
    //         }
    //     });
    // }

    function GetHldJsonData() {
        // 注意"${employee.empName}" 是String,加引号
        var json = {
            "hldHandleName": "${employee.empName}"
        };
        return json;
    }

    // 页面加载完成时
    window.onload = $(function () {
        // alert("onload");
        // 加载待处理的请假记录
        $.ajax({
            type: "post",
            url: "showWait4MyHandleHld.action",
            data: JSON.stringify(GetHldJsonData()),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                var obj = eval(data);
                var tbody = $('<tbody></tbody>');
                for (var i = 0; i < obj.holiday.length; i++) {
                    var val = obj.holiday[i];
                    var tr = $('<tr></tr>');
                    var k = i + 1;
                    var handleTime = null;
                    // 工单号处理
                    // 日期处理 注意引用相关js
                    var createTime = new Date(val.hldCreateTime);
                    var startTime = new Date(val.hldStartTime);
                    var endTime = new Date(val.hldEndTime);
                    var leaveTime = startTime.format('yyyy-mm-dd') +"至"+ endTime.format('yyyy-mm-dd');
                    // 处理按钮
                    // alert("1");
                    var button = '<button type="button" class="btn btn-success" id="agreeToLeave" value="同意" onclick="handleLeave('+k+','+'this'+')">同意</button>' + '&nbsp&nbsp&nbsp' +'<button type="button" class="btn btn-success" id="disagreeToLeave" value="不同意" onclick="handleLeave('+k+','+'this'+')">不同意</button>';
                    // alert("2");
                    if (val.hldState == 1) {
                        handleTime = new Date(val.hldHandleTime);
                    }
                    tr.append('<td>' + k + '</td>' + '<td>' + val.hldNo + '</td>' + '<td>' +val.hldEmpName + '</td>' + '<td>' + leaveTime + '</td>' + '<td>' +val.hldReason + '</td>' + '<td>' + val.hldHandleName + '</td>' + '<td>' + button + '</td>');
                    tbody.append(tr);
                }
                $('#myHldTable tbody').replaceWith(tbody);
            },
            error: function (data) {
                // alert("error");
            }
        });

        // 加载考勤情况信息
        $.ajax({
            type:"post",
            url: "calMyAttendance.action",
            data: JSON.stringify(GetSignJsonData()),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                // alert("success");
                var obj = eval(data);
                var table = document.getElementById("myAttTable");
                // float 保留一位小数 float.toFixed(1)
                table.rows[0].cells[1].innerText = obj.leaveDaysCnt.toFixed(1) + "天";
                table.rows[1].cells[1].innerText = "应签 -"+ obj.todayCnt +"- 次，已签 -" + obj.signInCnt + "- 次";
                table.rows[2].cells[1].innerText =  "应签 -"+ obj.todayCnt +"- 次，已签 -" + obj.signOutCnt + "- 次";
                table.rows[3].cells[1].innerText =  "应填 -"+ obj.todayCnt +"- 次，已填 -" + obj.journalCnt + "- 次";
            },
            error: function () {

            }
        });

        // 加载最新公告
        $.ajax({
            type:"get",
            url: "showLatestAnnounce.action",
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                // alert("success");
                var obj = eval(data);
                var val = obj.announce;
                var p = document.getElementById("myLatestAnnounce");
                p.innerHTML += val.ancContent;
            },
            error: function () {

            }
        });
    });

    function GetHldResultJsonData(i,v) {
        // alert("GetHldResultJsonData");
        var table = document.getElementById("myHldTable");
        var num = table.rows[i].cells[1].innerText;
        // alert("v="+v.value);    // 获取按钮的value
        // alert("第"+i+"内容为"+table.rows[i].cells[1].innerText);    //获取的是工单号
        var json = {
            "hldNo": num,
            "hldResult": v.value
        }
        return json;
    }
    // 处理请假事项
    function handleLeave(i,v) {
        $.ajax({
            type: "post",
            url: "handleHld.action",
            data: JSON.stringify(GetHldResultJsonData(i,v)),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                alert("success");
            },
            error: function (data) {
                alert("error");
            }
        });
    }
</script>

</body>
</html>