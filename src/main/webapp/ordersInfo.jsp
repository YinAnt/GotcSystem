<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>我的订单 - 桂林海外旅游</title>

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


<div class="container">
    <div class="row">
        <%--左侧导航栏--%>
        <div class="col-sm-3">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">我的订单 - 订单编号</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-sm-12">
                            <div id="treeview" class="">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%--end 左侧导航栏--%>

        <%--右侧详情栏--%>
        <div class="col-sm-9">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="row">
                        <%--TODO 订单详情--%>
                        <div class="col-md-12">
                            <div class="pull-left m-t-30">
                                <p id="pull-left-ordNo"></p>
                                <p id="pull-left-ordCreateTime"></p>
                                <p id="pull-left-ordState"></p>
                            </div>
                            <div class="pull-right m-t-30">
                                <p id="pull-right-ordStartTime"></p>
                                <p id="pull-right-ordEndTime"></p>
                                <p id="pull-right-ordNum"></p>
                            </div>
                        </div>
                        <div class="m-h-50"></div>
                        <div class="row">
                            <div class="col-md-12">
                                <div class="table-responsive">
                                    <table class="table m-t-30" id="ord-cont-detail-table">
                                        <thead></thead>
                                        <tbody></tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <hr>
                        <div class="row" style="border-radius: 0px;">
                            <div class="col-md-6 col-md-offset-6">
                                <p class="text-right" id="p-g-total"></p>
                                <p class="text-right" id="p-discout"></p>
                                <hr>
                                <h3 class="text-right" id="h-o-total"></h3>
                            </div>
                        </div>
                    </div>
                    <%--end row 详单--%>
                    <hr>
                    <%--线路查看--%>
                    <div class="row">
                        <div class="col-sm-12">
                            <h3 id="timeline-title"></h3>
                            <%--<ul class="timeline" id="timeline-ul">--%>
                            <ul id="timeline-ul">

                            </ul>
                        </div>
                    </div>
                    <%--end 线路查看--%>
                </div>
            </div>
        </div>
        <%--end 右侧详情--%>
    </div>
</div>


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
<%--导航树--%>
<script type="text/javascript" src="js/bootstrap-treeview.js"></script>
<!-- 回到顶部 -->
<script src="js/scrolltopcontrol.js"></script>

<!-- 页面加载时过渡动画，使用wow.js插件，wow.js依赖于animate.css -->
<script src="js/wow.min.js"></script>
<script src="js/dataFormat.js" type="text/javascript"></script>
<script type="text/javascript" src="js/json3.3.2.js"></script>
<script>
    new WOW().init();

    // 导航树点击事件
    function itemOnclick(target) {
        // alert("itemOnclick");
        // 找到当前节点id
        var nodeid = $(target).attr('data-nodeid');
        var tree = $('#treeview');   // 为啥不是 id =  treeview
        // 获取当前节点对象
        var node = tree.treeview('getNode', nodeid);
        // 获取对象的值
        var val = node.text();
        // alert("val= " + val);

        var left = nodeid * 13;
        var right = left + 13;
        // 获取订单号ordNo
        var ordNo = val.substring(left, right); //从第3个字符开始,截取到最后个字符;
        // alert("ordNo :" + ordNo);

        // 加载该订单的详单
        var ordNoJson = {
            "ordNo": ordNo
        };
        getOrdDetail(ordNoJson);

        // 加载该订单的订单内容
        var contOrdNoJson = {
            "contOrdNo": ordNo
        };
        getOrdContDetail(contOrdNoJson);

        // if(node.state.expanded){
        //     //处于展开状态则折叠
        //     tree.treeview('collapseNode', node.nodeId);
        // } else {
        //     //处于折叠状态则展开
        //     tree.treeview('expandNode', node.nodeId);
        // }
    }

    // 加载该订单的详单
    function getOrdDetail(ordNoJson) {
        $.ajax({
            url: 'findNowHldOrders.action',
            type: "post",
            data: JSON.stringify(ordNoJson),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                // alert("success");
                var obj = eval(data);
                var val = obj.orders;
                var createTime = new Date(val.ordCreateTime);
                document.getElementById('pull-left-ordNo').innerHTML = '<strong>订单编号：' + '</strong>' + val.ordNo + '</p>';
                document.getElementById('pull-left-ordCreateTime').innerHTML = '<strong>创建时间：' + '</strong>' + createTime.format("yyyy-mm-dd HH:MM:ss") + '</p>';
                document.getElementById('pull-left-ordState').innerHTML = '<strong>订单状态：' + '</strong>' + val.ordState + '</p>';

                var startTime = new Date(val.ordStartTime);
                var endTime = new Date(val.ordEndTime);
                var num = "成人" + val.ordAdultNum + ",儿童" + val.ordChildNum;
                document.getElementById('pull-right-ordStartTime').innerHTML = '<strong>出发时间：' + '</strong>' + startTime.format("yyyy-mm-dd") + '</p>';
                document.getElementById('pull-right-ordEndTime').innerHTML = '<strong>返程时间：' + '</strong>' + endTime.format("yyyy-mm-dd") + '</p>';
                document.getElementById('pull-right-ordNum').innerHTML = '<strong>出行人数：' + '</strong>' + num + '</p>';
            },
            error: function (err) {
                // alert("error");
            }
        });

    }

    // 加载该订单的订单内容
    function getOrdContDetail(ordNoJson) {
        $.ajax({
                url: 'showContentByOrdNo.action',
                type: "post",
                data: JSON.stringify(ordNoJson),
                dataType: 'json',
                contentType: "application/json; charset=utf-8",
                success: function (data) {
                    // alert("success");

                    // 清空表单里原有记录，row(0)是指表头所在行
                    var table = document.getElementById("ord-cont-detail-table"); //定位到table上
                    // alert("table length:"+table.rows.length);
                    if (table.rows.length > 0) {
                        for (var i = table.rows.length - 1; i >= 0; i--) {
                            // 这里需要倒序删，否则会找不到行
                            table.deleteRow(i);
                        }
                    }
                    // 清空时间轴记录，id=timeline-ul
                    $('#timeline-ul li').each(function () {
                        $(this).remove();
                    });
                    // 清除订单总额记录
                    document.getElementById('p-g-total').innerHTML = "";
                    document.getElementById('p-discout').innerHTML = "";
                    document.getElementById('h-o-total').innerHTML = "";

                    // 表头
                    var thead = $('<thead></thead>');
                    var tr1 = $('<tr></tr>');
                    tr1.append('<th>#</th>' + '<th>品名</th>' + '<th>日期</th>' + '<th>单价</th>' + '<th>数量</th>' + '<th>总价</th>');
                    thead.append(tr1);
                    $('#ord-cont-detail-table thead').replaceWith(thead);
                    // 表单内容
                    var obj = eval(data);
                    var sum = 0;
                    var tbody = $('<tbody></tbody>');
                    // 时间轴
                    document.getElementById('timeline-ul').setAttribute('class', 'timeline');
                    document.getElementById('timeline-title').innerHTML = "旅游线路";
                    var ul = document.getElementById("timeline-ul");
                    var li;
                    if (obj.content.length == 0) {
                        //  暂无订单内容
                        var tr = $('<tr></tr>');
                        tr.append('<td>' + '暂无记录' + '</td>');
                        tbody.append(tr);
                    } else if (obj.content.length == 1) {
                        var val = obj.content;
                        var tr = $('<tr></tr>');
                        var date = "";
                        if (val.contType == 1) {  // 景点
                            date = new Date(val.contScnDate);
                            li = timeLeft(val);
                            sum += val.contFare;
                            tr.append('<td>' + "1" + '</td>' + '<td>' + val.contName + '</td>' + '<td>' + date.format("yyyy-mm-dd") + '</td>' + '<td>' + (val.contFare == null ? "" : val.contFare) + '</td>' + '<td>' + "1" + '</td>' + '<td>' + (val.contFare == null ? "" : val.contFare) + '</td>');
                            tbody.append(tr);
                            ul.appendChild(li);
                        } else if (val.contType == 2) {// 酒店
                            date = new Date(val.contHtlCheckIn); // 酒店入住日期
                            li = timeRight(val);
                            sum += val.contFare;
                            tr.append('<td>' + "1" + '</td>' + '<td>' + val.contName + '</td>' + '<td>' + date.format("yyyy-mm-dd") + '</td>' + '<td>' + (val.contFare == null ? "" : val.contFare) + '</td>' + '<td>' + "1" + '</td>' + '<td>' + (val.contFare == null ? "" : val.contFare) + '</td>');
                            tbody.append(tr);
                            ul.appendChild(li);
                        } else if (val.contType == 3) {   // 用车
                            alert("vhc1");
                            tr.append('<td>' + "1" + '</td>' + '<td>' + val.contName + '</td>' + '<td>' + '全程' + '</td>' + '<td>' + (val.contFare == null ? "" : val.contFare) + '</td>' + '<td>' + "1" + '</td>' + '<td>' + (val.contFare == null ? "" : val.contFare) + '</td>');
                            tbody.append(tr);
                            sum += val.contFare;
                            alert("vhc2");
                        }
                    } else {
                        var k = 0;
                        for (var i = 0; i < obj.content.length; i++) {
                            var val = obj.content[i];
                            var tr = $('<tr></tr>');
                            k++;
                            var date = "";
                            if (val.contType == 1) {    // 景点
                                date = new Date(val.contScnDate);
                                li = timeLeft(val);
                            } else if (val.contType == 2) { // 酒店
                                date = new Date(val.contHtlCheckIn);// 酒店入住日期
                                li = timeRight(val);
                            } else if (val.contType == 3) {   // 用车
                                // alert("vhc1");
                                tr.append('<td>' + k + '</td>' + '<td>' + val.contName + '</td>' + '<td>' + '全程' + '</td>' + '<td>' + (val.contFare == null ? "" : val.contFare) + '</td>' + '<td>' + "1" + '</td>' + '<td>' + (val.contFare == null ? "" : val.contFare) + '</td>');
                                tbody.append(tr);
                                sum += val.contFare;
                                // alert("vhc2");
                                continue;
                            }
                            sum += val.contFare;
                            tr.append('<td>' + k + '</td>' + '<td>' + val.contName + '</td>' + '<td>' + date.format("yyyy-mm-dd") + '</td>' + '<td>' + (val.contFare == null ? "" : val.contFare) + '</td>' + '<td>' + "1" + '</td>' + '<td>' + (val.contFare == null ? "" : val.contFare) + '</td>');
                            tbody.append(tr);
                            ul.appendChild(li);
                        }
                        // alert("2.5");
                    }
                    $('#ord-cont-detail-table tbody').replaceWith(tbody);
                    // 填写总价信息，在加载时已清除 订单总额 的记录
                    // document.getElementById('p-g-total').innerHTML = "商品总额 &nbsp;: &nbsp; &nbsp;" + sum;
                    // document.getElementById('p-discout').innerHTML = "折扣 &nbsp;: &nbsp; &nbsp;10%";
                    // document.getElementById('h-o-total').innerHTML = "订单总额 ：" + sum * 0.9;
                    document.getElementById('h-o-total').innerHTML = "订单总额 ：" + sum;
                    // document.getElementById('p-g-total').innerHTML = "商品总额 &nbsp;: &nbsp; &nbsp;" + (val.ordPay == null ? sum : val.ordPay);
                    // document.getElementById('p-discout').innerHTML = "折扣 &nbsp;: &nbsp; &nbsp;" + (val.ordPay == null ? "10%" : "0%");
                    // document.getElementById('h-o-total').innerHTML = "订单总额 ：" + (val.ordPay == null ? sum : val.ordPay);
                },
                error: function (err) {
                    // alert("error");
                }
            }
        );
    }

    function timeLeft(val) {
        //创建元素Li
        var li = document.createElement("li");
        var date = new Date(val.contScnDate);
        var text1 = '<div class="timeline-badge success"></div><div class="timeline-panel">';
        var text2 = '<div class="timeline-heading"><h4 class="timeline-title">' + val.contScnName + '</h4><p><small class="text-muted">' + date.format('yyyy-mm-dd') + " " + val.contScnStartTime + " - " + val.contScnEndTime + '</small></p></div>';

        var text3 = '<div class="timeline-body text-left"><p>' + val.contDetails + '</p>';
        var text4 = '<div class="timeline-body"><div class="m-t-20"><img class="timeline-img" alt="" src="' + val.contNoteTag + '"></div></div>' + '</div></div>';
        //向li中添加内容
        li.innerHTML = text1 + text2 + text3 + text4;
        return li;
    }

    function timeRight(val) {
        var li = document.createElement("li");
        li.setAttribute("class", "timeline-inverted");  // 时间轴右侧，左侧无需设置
        var startDate = new Date(val.contHtlCheckIn);
        var endDate = new Date(val.contHtlCheckOut);
        var text1 = '<div class="timeline-badge info"></div><div class="timeline-panel">';
        var text2 = '<div class="timeline-heading"><h4 class="timeline-title">' + val.contHtlName + '</h4><p><small class="text-muted">' + startDate.format('yyyy-mm-dd') + " - " + endDate.format('yyyy-mm-dd') + '</small></p></div>';
        var text3 = '<div class="timeline-body text-left"><p>' + val.contDetails + '</p></div></div>';
        //向li中添加内容
        li.innerHTML = text1 + text2 + text3;
        return li;
    }

    function GetUserNameJsonData() {
        var json = {
            "ordUser": '${users.userName}'
        };
        return json;
    }

    function initTreeView() {
        $.ajax({
            url: 'findAllOrdByUserName.action',
            type: "post",
            data: JSON.stringify(GetUserNameJsonData()),
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (data) {
                var obj = eval(data);
                var defaultData = "[";
                if (obj.orders.length == 0) {
                    //  TODO 暂无订单
                } else if (obj.orders.length == 1) {
                    var val = obj.orders;
                    var date = new Date(val.ordNo);
                    defaultData = defaultData + "{text:'" + val.ordNo + "',href:'#parent" + 1 + "',tags:['" + 0 + "']}";
                    defaultData = defaultData + "]";
                } else {
                    var i;
                    var k;
                    var val;
                    for (i = obj.orders.length - 1; i > 0; i--) {
                        val = obj.orders[i];
                        k = obj.orders.length - i;
                        defaultData += "{text:\'" + val.ordNo + "\',href:\'#parent" + k + "\',tags:[\'" + i + "\']},";
                    }
                    val = obj.orders[i];
                    k = obj.orders.length - i;
                    defaultData = defaultData + "{text:'" + val.ordNo + "',href:'#parent" + k + "',tags:['" + i + "']}";
                    defaultData = defaultData + "]";
                }

                var data3 = eval(defaultData);  //转为对象
                $('#treeview').treeview({
                    color: "#34ad00",
                    showIcon: false,
                    nodeIcon: null,
                    selectedBackColor: "#34ad00",
                    showBorder: false,
                    data: data3
                });

            },
            error: function (err) {
                // alert("error");
                sweetAlert(swal({
                        title: "错误提示",
                        text: "服务器错误，请重试！",
                        type: "error",
                        showConfirmButton: true
                    }
                ));
            }
        });
    }


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
        initTreeView(); // 导航树
    });

    function signOut() {
        window.location.href = "login.jsp";
    }

</script>
</body>
</html>