<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>公告栏 - 桂林海外旅游公司</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-reset.css" rel="stylesheet">

    <!--Animation css-->
    <link href="css/animate.css" rel="stylesheet">

    <!--Icon-fonts css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet"/>
    <link href="assets/ionicon/css/ionicons.min.css" rel="stylesheet"/>

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
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-md-10">
                                <h3 class="panel-title">公告栏</h3>
                            </div>
                            <div class="col-md-1 text-right">
                                <div class="fileUpload btn btn-primary" data-toggle="modal"
                                     data-target="#con-announce-modal">
                                    <span>添加</span>
                                </div>
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
                                            <th>流水号</th>
                                            <th>发布日期</th>
                                            <th>发布者</th>
                                            <th>分类</th>
                                            <th>标题</th>
                                            <th>查看</th>
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

<!-- TODO 发布公告 响应式模态框  label:for input text:id,placeholder-->
<div id="con-announce-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title">发布公告</h4>
            </div>
            <%--<form class="form-horizontal" role="form" action="addAnnounce.action">--%>
            <form class="form-horizontal" role="form">
                <div class="modal-body">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="password-field-1" class="col-md-2 control-label">标题</label>
                                <div class="col-md-10">
                                    <input type="text" class="form-control" id="ancTitle">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="password-field-1" class="col-md-4 control-label">发布者</label>
                                <div class="col-md-8">
                                    <input type="text" class="form-control" id="ancPosterName"
                                           value="${employee.empName}" disabled="">
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="password-field-1" class="col-md-2 control-label">分类</label>
                                <div class="col-md-10">
                                    <select class="form-control" id="ancType">
                                        <option>部门工作</option>
                                        <option>站内公告</option>
                                        <option>会议通知</option>
                                        <option>旅游攻略</option>
                                        <option>其他</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <label for="password-field-1" class="col-md-2 control-label">内容</label>
                                <div class="col-md-10">
                                    <textarea class="form-control" rows="5" id="ancContent"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-white" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-success" data-dismiss="modal" onclick="addAnnounce()">发布
                    </button>
                </div>
            </form>
        </div>
    </div>
</div><!-- con-password-modal end -->


<!-- TODO 查看公告内容 响应式模态框  label:for input text:id,placeholder-->
<div id="con-ancContent-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true" style="display: none;">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title">公告详情</h4>
                <p hidden="" id="getDateForCanlendar"></p>
            </div>
            <%--<form class="form-horizontal" role="form">--%>
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-12 text-center">
                        <h3 id="ancContent-field-title"></h3>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 text-center">
                        <h6 id="ancContent-field-note"></h6>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 text-left">
                        <p id="ancContent-field-content"></p>
                    </div>
                </div>
            </div>
            <%--</form>--%>
        </div>
    </div>

</div><!-- con-ancContent-modal end -->

<!-- js placed at the end of the document so the pages load faster -->
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/pace.min.js"></script>
<script src="js/wow.min.js"></script>
<script src="js/jquery.nicescroll.js"></script>

<script src="js/jquery.app.js"></script>

<script src="assets/sweet-alert/sweet-alert.min.js"></script>
<script src="assets/sweet-alert/sweet-alert.init.js"></script>

<script src="js/dataFormat.js" type="text/javascript"></script>

<script src="js/jquery.table2excel.js" type="text/javascript"></script>
<script>
    // 导出excel
    $(function () {
        $("#btn").click(function () {
            $("#myTable").table2excel({
                exclude: ".noExl",
                name: "Excel Document Name",
                filename: "announce" + new Date().format("yyyymmdd"),
                exclude_img: true,
                exclude_links: true,
                exclude_inputs: true
            });
        });

    });
</script>

<script type="text/javascript" src="js/json3.3.2.js"></script>
<script type="text/javascript">

    function GetJsonData() {
        var json = {
            "ancTitle": $("#ancTitle").val(),
            "ancPoster": ${employee.empNo},
            "ancPosterName": $("#ancPosterName").val(),
            "ancType": $("#ancType").val(),
            "ancContent": $("#ancContent").val()
        };
        return json;
    }

    //提交更改
    function addAnnounce() {
        $.ajax({
            type: "post",
            url: "addAnnounce.action",
            data: JSON.stringify(GetJsonData()),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                // 刷新当前页
                location.reload();
            },
            error: function (data) {
                sweetAlert(swal({
                        title: "错误提示",
                        text: "你输入的公告内容实在是太长长长啦！",
                        type: "error",
                        timer: 2000,
                        showConfirmButton: false
                    }
                ));
            }
        });
    }

    function showAncByNo(ancNo) {
        // alert("a:" + ancNo);
        var json = {
            "ancNo": ancNo
        };
        $.ajax({
            type: "post",
            url: "showAncByAncNo.action",
            data: JSON.stringify(json),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                // alert("success");
                var obj = eval(data);
                var val = obj.announce;
                var date = new Date(val.ancCreateTime);
                var poster = val.ancPosterName == null ? "佚名" : val.ancPosterName;
                var cont = val.ancContent;
                document.getElementById('ancContent-field-title').innerHTML = (val.ancTitle == null ? "公告" : val.ancTitle);
                document.getElementById('ancContent-field-note').innerHTML = date.format('yyyy-mm-dd') + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + poster;
                document.getElementById('ancContent-field-content').innerText = val.ancContent;  // 注意： innerHTML中<br>是换行，innerText 文本域中\n 是换行

            },
            error: function (data) {
                // alert("error");
            }
        });

    }

    function showAnnounce() {
        // 加载公告信息
        $.ajax({
            url: "showAnnounce.action",
            type: "get",
            success: function (data) {
                var obj = eval(data);
                var tbody = $('<tbody></tbody>');
                for (var i = 0; i < obj.announce.length; i++) {
                    var val = obj.announce[i];
                    var tr = $('<tr></tr>');
                    var k = i + 1;
                    // 日期处理 注意引用相关js
                    var utDate = new Date(val.ancCreateTime);
                    // alert("1");
                    var showBtn = '<button class="btn btn-success" data-toggle="modal" data-target="#con-ancContent-modal" onclick="showAncByNo(' + val.ancNo + ')">' + '查看' + '</button>';
                    // 点击标题加载内容
                    // alert("2");
                    tr.append('<td>' + k + '</td>' + '<td>' + val.ancNo + '</td>' + '<td>' + utDate.format('mm/dd/yyyy') + '</td>' + '<td>' + val.ancPosterName + '</td>' + '<td>' + val.ancType + '</td>' + '<td>' + val.ancTitle + '</td>' + '<td>' + showBtn + '</td>');
                    // alert("3");
                    // 不显示内容
                    // tr.append('<td>' + k + '</td>' + '<td>' + val.ancNo + '</td>' + '<td>' + utDate.format('mm/dd/yyyy') + '</td>' + '<td>' + val.ancPosterName + '</td>' + '<td>' + val.ancType + '</td>' + '<td>' + val.ancTitle + '</td>');
                    // 显示内容
                    // tr.append('<td>' + k + '</td>' + '<td>' + utDate.format('mm/dd/yyyy') + '</td>' + '<td>' + val.ancPosterName + '</td>' + '<td>' + val.ancType + '</td>' + '<td>' + val.ancTitle + '</td>'+ '<td>' + val.ancContent + '</td>');
                    tbody.append(tr);
                }
                $('#myTable tbody').replaceWith(tbody);
            }
        });
    }

    // 页面加载完成时
    window.onload = $(function () {
        showAnnounce(); // 加载公告信息
    });
</script>


</body>
</html>