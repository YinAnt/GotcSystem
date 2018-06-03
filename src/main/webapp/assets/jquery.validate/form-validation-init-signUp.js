/**
 * Author: Ant
 * Form Validator
 */

!function ($) {
    "use strict";

    function GetRegisterJsonData() {
        var json = {
            "userName": $("#userName").val(),
            "userPassword": $("#userPassword").val(),
            "userAlias": $("#userAlias").val(),
            "userEmail": $("#userEmail").val(),
            "userTel": $("#userTel").val(),
        };
        return json;
    }

    var FormValidator = function () {
        this.$signupForm = $("#signupForm");
    };

    //init
    FormValidator.prototype.init = function () {
        //validator plugin 验证器插件
        $.validator.setDefaults({});

        // 注册验证
        this.$signupForm.validate({
            rules: {
                // lastname: "required",
                userName: {
                    required: true,
                    rangelength: [4, 10]
                },
                userAlias: {
                    required: true,
                    rangelength: [2, 10]
                },
                userPassword: {
                    required: true,
                    rangelength: [6, 20]
                },
                Password2: {
                    required: true,
                    rangelength: [6, 20],
                    equalTo: "#userPassword"
                },
                userEmail: {
                    required: true,
                    email: true
                },
                agree: {
                    required: true
                }
            },
            messages: {
                Password2: {
                    equalTo: "两次密码输入不一致"
                }
            },
            submitHandler: function () {
                // 表单提交
                // alert("signup validation submitted!");
                $.ajax({
                    type: "POST",
                    url: 'register.action',
                    contentType: "application/json; charset=utf-8",
                    data: JSON.stringify(GetRegisterJsonData()),
                    dataType: "json",
                    success: function (message) {
                        window.location.href = "welcome.jsp";
                    },
                    error: function (message) {
                        alert("注册失败，请重试!");
                    }
                });
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