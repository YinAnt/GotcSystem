/**
 * Theme: Velonic Admin Template
 * Author: Coderthemes
 * Full calendar page
 */

function GetJsonData() {
    var json = {
        "signEmpNo": 1002,
        "empNo": 1002,
        "hldEmpNo": 1002,
        "jnlEmpNo": 1002
    };
    return json;
}

!function ($) {
    "use strict";

    var CalendarPage = function () {
    };

    CalendarPage.prototype.init = function () {

        //checking if plugin is available
        if ($.isFunction($.fn.fullCalendar)) {
            /* initialize the external events */
            $('#external-events .fc-event').each(function () {
                // create an Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
                // it doesn't need to have a start or end
                var eventObject = {
                    title: $.trim($(this).text()) // use the element's text as the event title
                };

                // store the Event Object in the DOM element so we can get to it later
                $(this).data('eventObject', eventObject);

                // make the event draggable using jQuery UI
                $(this).draggable({
                    zIndex: 999,
                    revert: true, // will cause the event to go back to its
                    revertDuration: 0 //  original position after the drag
                });

            });

            /* initialize the calendar */

            var date = new Date();
            var d = date.getDate();
            var m = date.getMonth();
            var y = date.getFullYear();

            $('#calendar').fullCalendar({
                header: {
                    left: 'prev,next today',
                    center: 'title',
                    right: 'month,basicWeek,basicDay'
                },
                timeFormat: '(HH:mm:ss)',
                // editable: true,
                editable: false,
                eventLimit: true, // allow "more" link when too many events
                droppable: true, // this allows things to be dropped onto the calendar !!!
                drop: function (date, allDay) { // this function is called when something is dropped

                    // retrieve the dropped element's stored Event Object
                    var originalEventObject = $(this).data('eventObject');

                    // we need to copy it, so that multiple events don't have a reference to the same object
                    var copiedEventObject = $.extend({}, originalEventObject);

                    // assign it the date that was reported
                    copiedEventObject.start = date;
                    copiedEventObject.allDay = allDay;

                    // render the event on the calendar
                    // the last `true` argument determines if the event "sticks" (http://arshaw.com/fullcalendar/docs/event_rendering/renderEvent/)
                    $('#calendar').fullCalendar('renderEvent', copiedEventObject, true);

                    // is the "remove after drop" checkbox checked?
                    if ($('#drop-remove').is(':checked')) {
                        // if so, remove the element from the "Draggable Events" list
                        $(this).remove();
                    }

                },
                eventSources: [
                    {
                        events: function (start, end, timezone, callback) {
                            // 请假 事件
                            $.ajax({
                                url: 'showMyAllHoliday.action',
                                dataType: 'json',
                                type: "post",
                                data: JSON.stringify(GetJsonData()),
                                contentType: "application/json; charset=utf-8",
                                success: function (data) { // 获取当前月的数据
                                    // alert("showMyAllHoliday");
                                    var events = [];
                                    var obj = eval(data);
                                    for (var i = 0; i < obj.holiday.length; i++) {
                                        var val = obj.holiday[i];
                                        if (val.hldState == 2) {
                                            events.push({
                                                    title: " 请假",
                                                    description: "事由：" + val.hldReason,
                                                    start: new Date(val.hldStartTime),  // 日期
                                                    end: new Date(val.hldEndTime),
                                                    color: '#66cc66'
                                                }
                                            );
                                        }
                                    }
                                    callback(events);
                                }
                            });
                        }
                    },
                    {
                        events: function (start, end, timezone, callback) {

                            $.ajax({
                                url: 'showMyAllSignIn.action',
                                type:"post",
                                dataType: 'json',
                                data: JSON.stringify(GetJsonData()),
                                contentType: "application/json; charset=utf-8",
                                success: function (data) { // 获取当前月的数据
                                    // alert("showMyAllSignIn");
                                    var events = [];
                                    var obj = eval(data);
                                    for (var i = 0; i < obj.sign.length; i++) {
                                        var val = obj.sign[i];
                                        if (val.signInTime != null) {
                                            events.push({
                                                    title: " 签到",
                                                    description: "已签到",
                                                    start: new Date(val.signInTime),  // 日期
                                                    color: '#33cc00'
                                                }
                                            );
                                        }
                                        if (val.signOutTime != null) {
                                            events.push({
                                                    title: " 签退",
                                                    description: "已签退",
                                                    start: new Date(val.signOutTime),  // 日期
                                                    color: '#33cc00'
                                                }
                                            );
                                        }
                                    }
                                    callback(events);
                                }
                            });
                        }
                    },
                    {
                        events: function (start, end, timezone, callback) {

                            // 日报事件
                            $.ajax({
                                url: 'showMyAllJournal.action',
                                dataType: 'json',
                                type: "post",
                                data: JSON.stringify(GetJsonData()),
                                contentType: "application/json; charset=utf-8",
                                success: function (data) { // 获取当前月的数据
                                    // alert("showMyAllJournal");
                                    var events = [];
                                    var obj = eval(data);
                                    for (var i = 0; i < obj.journal.length; i++) {
                                        var val = obj.journal[i];
                                        if (val.jnlCreateTime != null) {
                                            events.push({
                                                    title: " 日报",
                                                    description: "内容：" + val.jnlContent,
                                                    start: new Date(val.jnlCreateTime),  // 日期
                                                    color: '#99ff00'
                                                }
                                            );
                                        }
                                    }
                                    callback(events);
                                }
                            });
                        }
                    }
                ],
                dayClick: function (date, allDay, jsEvent, view) {
                    // alert('Date: ' + date.format());
                    document.getElementById('getDateForCanlendar').innerHTML = date;
                    // TODO 日报
                    $('#record-field-5').attr("value", date.format());
                    $('#con-record-modal').on('show.bs.modal ', function (e) {
                        // alert("d:" + document.getElementById('getDateForCanlendar').innerHTML); // 格子的日期
                        var day = document.getElementById('getDateForCanlendar').innerHTML;
                        day = new Date(day);
                        var sevenDay = 7 * 24 * 60 * 60 * 1000;
                        var todayDate = new Date();
                        // alert("today:" + todayDate);
                        if ((todayDate.getTime() - day.getTime() < 0) || (todayDate.getTime() - day.getTime() > sevenDay)) {
                            // alert("七天之外");
                            document.getElementById('sbm-record').setAttribute("disabled", "");
                            document.getElementById('textarea-record').setAttribute("disabled", "");
                            document.getElementById('textarea-record').innerHTML = "";
                        } else {
                            // alert("七天内");
                            document.getElementById('sbm-record').removeAttribute("disabled");
                            document.getElementById('textarea-record').removeAttribute("disabled");
                            document.getElementById('textarea-record').innerHTML = "";
                        }
                    })
                    $('#con-record-modal').modal();

                },
                eventClick: function (event, jsEvent, view) {
                    $('#modalTitle').html(event.title);
                    $('#modalBody').html(event.description);
                    $('#eventUrl').attr('href', event.url);
                    $('#calendarModal').modal();
                },
            });

            /*Add new event*/
            // Form to add new event

            $("#add_event_form").on('submit', function (ev) {
                ev.preventDefault();

                var $event = $(this).find('.new-event-form'),
                    event_name = $event.val();

                if (event_name.length >= 3) {

                    var newid = "new" + "" + Math.random().toString(36).substring(7);
                    // Create Event Entry
                    $("#external-events").append(
                        '<div id="' + newid + '" class="fc-event">' + event_name + '</div>'
                    );


                    var eventObject = {
                        title: $.trim($("#" + newid).text()) // use the element's text as the event title
                    };

                    // store the Event Object in the DOM element so we can get to it later
                    $("#" + newid).data('eventObject', eventObject);

                    // Reset draggable
                    $("#" + newid).draggable({
                        revert: true,
                        revertDuration: 0,
                        zIndex: 999
                    });

                    // Reset input
                    $event.val('').focus();
                } else {
                    $event.focus();
                }
            });

        }
        else {
            alert("Calendar plugin is not installed");
        }
    },
        //init
        $.CalendarPage = new CalendarPage, $.CalendarPage.Constructor = CalendarPage
}(window.jQuery),

//initializing 
    function ($) {
        "use strict";
        $.CalendarPage.init()
    }(window.jQuery);


