<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>请假管理 - 桂林海外旅游公司</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/bootstrap-reset.css" rel="stylesheet">

    <!--calendar css-->
    <link href="assets/fullcalendar/fullcalendar.css" rel="stylesheet"/>

    <!--Animation css-->
    <link href="css/animate.css" rel="stylesheet">

    <!--Icon-fonts css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet"/>
    <link href="assets/ionicon/css/ionicons.min.css" rel="stylesheet"/>

    <link href="assets/sweet-alert/sweet-alert.min.css" rel="stylesheet">


    <!-- Custom styles for this template -->
    <link href="css/styleOA.css" rel="stylesheet">
    <link href="css/helper.css" rel="stylesheet">

    <!-- Plugins css-->
    <link href="assets/timepicker/bootstrap-timepicker.min.css" rel="stylesheet"/>
    <link href="assets/timepicker/bootstrap-datepicker.min.css" rel="stylesheet"/>

    <link href="assets/bootstrap-Multiselect/prettify.css" rel="stylesheet">
    <link href="assets/bootstrap-Multiselect/bootstrap-multiselect.css" rel="stylesheet">
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
                    <li class="">
                        <a href="#leaveManage" data-toggle="tab" aria-expanded="true">
                            <span class="visible-xs"><i class="fa fa-home"></i></span>
                            <span class="hidden-xs">请假管理</span>
                        </a>
                    </li>
                    <li class="active">
                        <a href="#leaveApplication" data-toggle="tab" aria-expanded="false">
                            <span class="visible-xs"><i class="fa fa-user"></i></span>
                            <span class="hidden-xs">请假申请</span>
                        </a>
                    </li>
                </ul>

                <div class="tab-content">
                    <!-- 请假管理 -->
                    <div class="tab-pane" id="leaveManage">
                        <div class="row">
                            <div class="col-md-12 col-sm-12 col-xs-12">
                                <div class="table-responsive">
                                    <table class="table table-hover" id="myTable">
                                        <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>工单号</th>
                                            <th>请假人</th>
                                            <th>请假时间</th>
                                            <th>请假原因</th>
                                            <th>处理人</th>
                                            <th>处理结果</th>
                                            <th>工单状态</th>
                                        </tr>
                                        </thead>
                                        <tbody>

                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- 请假申请 -->
                    <div class="tab-pane active" id="leaveApplication">
                        <from class="form-horizontal" role="form">
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="setting-field-1" class="col-sm-3 control-label">姓名</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" placeholder="姓名" disabled=""
                                                   value="${employee.empName}">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="setting-field-1" class="col-sm-3 control-label">电话</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" placeholder="电话" disabled=""
                                                   value="${employee.empTel}">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="setting-field-1" class="col-sm-3 control-label">所属部门</label>
                                        <div class="col-sm-9">
                                            <input type="text" class="form-control" placeholder="所属部门" disabled=""
                                                   value="${dept.deptName}">
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="setting-field-1" class="col-sm-3 control-label">开始时间</label>
                                        <div class="col-sm-9">
                                            <div class="input-group">
                                                <input type="text" class="form-control" placeholder="mm/dd/yyyy"
                                                       id="datepicker1">
                                                <span class="input-group-addon"><i
                                                        class="glyphicon glyphicon-calendar"></i></span>
                                            </div><!-- input-group -->
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="setting-field-1" class="col-sm-3 control-label">结束时间</label>
                                        <div class="col-sm-9">
                                            <div class="input-group">
                                                <input type="text" class="form-control" placeholder="mm/dd/yyyy"
                                                       id="datepicker2">
                                                <span class="input-group-addon"><i
                                                        class="glyphicon glyphicon-calendar"></i></span>
                                            </div><!-- input-group -->
                                        </div>
                                    </div>
                                </div>
                                <%--<div class="col-md-4">--%>
                                <%--<div class="form-group">--%>
                                <%--<label for="setting-field-1" class="col-sm-3 control-label">处理人</label>--%>
                                <%--<div class="col-sm-9">--%>
                                <%--<select class="multiselect" multiple="multiple" id="multiselect">--%>
                                <%--</select>--%>
                                <%--</div>--%>
                                <%--</div>--%>
                                <%--</div>--%>
                            </div>

                            <div class="row">
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="password-field-1" class="col-md-3 control-label">请假类型</label>
                                        <div class="col-md-9">
                                            <select class="form-control" id="leaveType">
                                                <option>事假</option>
                                                <option>病假</option>
                                                <option>婚假</option>
                                                <option>产假</option>
                                                <option>年假</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label for="setting-field-1" class="col-sm-3 control-label">处理人</label>
                                        <div class="col-sm-9">
                                            <%--<select class="multiselect" multiple="multiple" id="multiselect">--%>
                                            <select class="multiselect" id="multiselect">
                                            </select>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                        <label for="setting-field-1" class="col-sm-1 control-label">请假原因</label>
                                        <div class="col-sm-11">
                                            <textarea class="form-control" row="5" id="leaveReason"></textarea>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group m-b-0 text-center">
                                    <button type="button" class="btn btn-success" id="btn_submit"
                                            onclick="sbm_ask4Leave()">提交
                                    </button>
                                </div>
                            </div>
                        </from>
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
<script src="js/pace.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/wow.min.js"></script>
<script src="js/jquery.nicescroll.js" type="text/javascript"></script>

<script src="assets/fullcalendar/moment.min.js"></script>
<script src="assets/fullcalendar/fullcalendar.min.js"></script>

<script src="assets/timepicker/bootstrap-timepicker.min.js"></script>
<script src="assets/timepicker/bootstrap-datepicker.js"></script>

<script src="assets/bootstrap-Multiselect/prettify.js" type="text/javascript"></script>
<script src="assets/bootstrap-Multiselect/bootstrap-multiselect.js" type="text/javascript"></script>

<script src="assets/sweet-alert/sweet-alert.min.js"></script>
<script src="assets/sweet-alert/sweet-alert.init.js"></script>

<script src="js/dataFormat.js" type="text/javascript"></script>

<script type="text/javascript">

    jQuery(document).ready(function () {

        $('#multiselect').multiselect({
            buttonWidth: 270,
            enableFiltering: true,
            maxHeight: 300,
            onChange: function (option, checked) {
                var values = [];
                $('#multiselect option').each(function () {
                    if ($(this).val() !== option.val()) {
                        values.push($(this).val());
                    }
                });
                $('#multiselect').multiselect('deselect', values);

                // 使选项最多选择1个
                // var selectedOptions = $('#multiselect option:selected');
                // if (selectedOptions.length >= 1) {
                //     // 限制其他选项.
                //     var nonSelectedOptions = $('#multiselect option').filter(function () {
                //         return !$(this).is(':selected');
                //     });
                //
                //     var dropdown = $('#multiselect').siblings('.multiselect-container');
                //     nonSelectedOptions.each(function () {
                //         var input = $('input[value="' + $(this).val() + '"]');
                //         input.prop('disabled', true);
                //         input.parent('li').addClass('disabled');
                //     });
                // }
                // else {
                //     // 恢复选项.
                //     var dropdown = $('#multiselect').siblings('.multiselect-container');
                //     $('#multiselect option').each(function () {
                //         var input = $('input[value="' + $(this).val() + '"]');
                //         input.prop('disabled', false);
                //         input.parent('li').addClass('disabled');
                //     });
                // }
            }
        });


        // 设置数据
        var data = [
            {label: "丁仙媛", value: "1001"},
            {label: "吴雨珊", value: "1002"},
            {label: "常碧凡", value: "1003"},
            {label: "曾清妙", value: "1004"},
            {label: "唐霞文", value: "1005"},
            {label: "金钰洁", value: "1006"},
            {label: "刘友桃", value: "1007"},
            {label: "姜紫云", value: "1008"},
            {label: "乔梦旋", value: "1009"},
            {label: "董茜茜", value: "1010"},
            {label: "谢涵山", value: "1011"},
            {label: "黄舒兰", value: "1012"},
            {label: "龚沈靖", value: "1013"},
            {label: "何晗晗", value: "1014"},
            {label: "范梦月", value: "1015"},
            {label: "黎阳兰", value: "1016"},
            {label: "崔芮雅", value: "1017"},
            {label: "汤寄琴", value: "1018"},
            {label: "胡碧琳", value: "1019"},
            {label: "宋吉月", value: "1020"},
            {label: "夏弘壮", value: "1021"},
            {label: "许文轩", value: "1022"},
            {label: "徐弘图", value: "1023"},
            {label: "谭雅逸", value: "1024"},
            {label: "马正文", value: "1025"},
            {label: "郝兴发", value: "1026"},
            {label: "易永嘉", value: "1027"},
            {label: "龚宏深", value: "1028"},
            {label: "萧和泽", value: "1029"},
            {label: "林飞扬", value: "1030"},
            {label: "崔熠彤", value: "1031"},
            {label: "曹德泽", value: "1032"},
            {label: "易宏胜", value: "1033"},
            {label: "苏和玉", value: "1034"},
            {label: "蒋烨然", value: "1035"},
            {label: "胡承嗣", value: "1036"},
            {label: "萧景山", value: "1037"},
            {label: "顾文轩", value: "1038"},
            {label: "唐伟懋", value: "1039"},
            {label: "崔阳曦", value: "1040"},
            {label: "王宏旷", value: "1041"},
            {label: "叶嘉实", value: "1042"},
            {label: "张绍钧", value: "1043"}
        ];
        $("#multiselect").multiselect('dataprovider', data);

        // Date Picker
        jQuery('#datepicker1').datepicker();
        jQuery('#datepicker2').datepicker();

    });

    function GetAks4LeaveJsonData() {
        // 注意，multiselect 的value 设置的是工号，应该传给Integer
        var json = {
            "hldEmpNo": ${employee.empNo},
            "startTimeStr": $("#datepicker1").val(),
            "endTimeStr": $("#datepicker2").val(),
            "hldType": $("#leaveType").val(),
            "hldReason": $("#leaveReason").val(),
            "hldHandle": $('#multiselect').val()
        };
        return json;
    }

    // 提交请假申请
    function sbm_ask4Leave() {
        // alert($('#multiselect').val().toString());
        // 提交之前日历验证
        var startDateStr = document.getElementById('datepicker1').value;
        var endDateStr = document.getElementById('datepicker2').value;
        if (startDateStr == null || startDateStr == "" || endDateStr == null || endDateStr == "") {
            sweetAlert(swal({
                    title: "错误提示",
                    text: "请假时间不能为空！",
                    type: "error",
                    showConfirmButton: false,
                    showCancelButton: true
                }
            ));
            return;
        }
        var startArray = startDateStr.split("/"); // 日期格式：mm/dd/yyyy
        var endArray = endDateStr.split("/"); // 日期格式：mm/dd/yyyy
        var startDate = new Date(startArray[2], startArray[0], startArray[1]);
        var endDate = new Date(endArray[2], endArray[0], endArray[1]);
        // alert("1:"+startDate+","+endDate);
        if (startDate.getTime() >= endDate.getTime()) {
            sweetAlert(swal({
                    title: "错误提示",
                    text: "请假开始时间不得大于结束时间！",
                    type: "error",
                    showConfirmButton: false,
                    showCancelButton: true
                }
            ));
            return;
        }
        // 请假原因输入不能为空
        var contText = document.getElementById('leaveReason').value;
        // alert("leave:"+contText);
        if (contText == null || contText == "") {
            sweetAlert(swal({
                    title: "错误提示",
                    text: "请假内容不能为空！",
                    type: "error",
                    showConfirmButton: false,
                    showCancelButton: true
                }
            ));
            return;
        }

        //  提交申请
        $.ajax({
            type: "post",
            url: "askForLeave.action",
            data: JSON.stringify(GetAks4LeaveJsonData()),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                // alert("success");
                // 提示申请成功
                sweetAlert(swal({
                        title: "提示",
                        text: "提交申请成功！",
                        type: "success",
                        showConfirmButton: false,
                        showCancelButton: true
                    }
                ));
                // 刷新当前页
                window.location.reload();
            },
            error: function (data) {
                // alert("error");
                sweetAlert(swal({
                        title: "错误提示",
                        text: "提交申请失败！",
                        type: "error",
                        showConfirmButton: false,
                        showCancelButton: true
                    }
                ));
            }
        });
    };

    function GetJsonData() {
        var json = {
            "hldEmpNo": ${employee.empNo}
        };
        return json;
    }

    // 页面加载完成时
    window.onload = $(function () {
        $.ajax({
            url: "showMyAllHoliday.action",
            type: "post",
            data: JSON.stringify(GetJsonData()),
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
                    // 日期处理 注意引用相关js
                    var createTime = new Date(val.hldCreateTime);
                    var startTime = new Date(val.hldStartTime);
                    var endTime = new Date(val.hldEndTime);
                    var leaveTime = startTime.format('yyyy-mm-dd') + "至" + endTime.format('yyyy-mm-dd');
                    if (val.hldState == 1) {
                        handleTime = new Date(val.hldHandleTime);
                    }
                    tr.append('<td>' + k + '</td>' + '<td>' + val.hldNo + '</td>' + '<td>' + val.hldEmpName + '</td>' + '<td>' + leaveTime + '</td>' + '<td>' + val.hldReason + '</td>' + '<td>' + val.hldHandleName + '</td>' + '<td>' + (val.hldState == 1 ? "" : val.hldResult) + '</td>' + '<td>' + (val.hldState == 1 ? "待处理" : "已处理") + '</td>');
                    tbody.append(tr);
                }
                $('#myTable tbody').replaceWith(tbody);
            }
        })
    });
</script>
</body>
</html>