/**
 * Author: Ant
 * Form Validator
 */

!function ($) {
    "use strict";

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
            // "ordUser": '${users.userName}',
            "ordNoteTag": $("#customNoteTag").val()
        };
        alert("json：" + json.toString());
        return json;
    }

    var FormValidator = function () {
        this.$customizeForm = $("#customizeForm");
    };

    //init
    FormValidator.prototype.init = function () {
        //validator plugin 验证器插件
        $.validator.setDefaults({});

        // 添加订单
        this.$customizeForm.validate({
            rules: {
                datepicker1: {
                    required: true
                },
                datepicker2: {
                    required: true
                },
                customAlais: {
                    required: true
                },
                customEmail: {
                    required: true,
                    email: true
                },
                customTel: {
                    required: true

                },
                ordNoteTag: {
                    required: true
                }
            },
            submitHandler: function () {
                // 表单提交
                alert("add order validation submitted!");
                // 时间验证
                var startDateStr = $("#datepicker1").val();
                var endDateStr = $("#datepicker2").val();
                var startArray = startDateStr.split("/"); // 日期格式：mm/dd/yyyy
                var endArray = endDateStr.split("/"); // 日期格式：mm/dd/yyyy
                var startDate = new Date(startArray[2], startArray[0], startArray[1]);
                var endDate = new Date(endArray[2], endArray[0], endArray[1]);
                // alert("1:"+startDate+","+endDate);
                if (startDate.getTime() >= endDate.getTime()) {
                    alert("出发时间不应晚于结束时间！");
                    return;
                }
            }
        });

    },
        //init
        $.FormValidator = new FormValidator, $.FormValidator.Constructor = FormValidator
}(window.jQuery),


//initializing 
    function ($) {
        "use strict";
        $.FormValidator.init()
    }(window.jQuery);