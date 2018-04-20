$(document).ready(function(){
        const cookie = getCookie("loginInfo");
        if ("undefined" == typeof(cookie)) {
            location.href = "/";
        }
        const loginInfo = JSON.parse(cookie);
        const userId = loginInfo.id;
        $.ajax({
            type: "post",
            url: "user/getLeaveRecord",
            data: {
                userId: userId,
            },
            dataType: "json",
            success: function (returnInfo) {
                getleaveRecord(returnInfo);
            }
        })
});
function getleaveRecord(returnInfo){

    if (returnInfo.result !== true || returnInfo.code !== 30) {
        return "";
    }
    var list = returnInfo.returnObject;
    debugger;
    // var list1 =list.list;
    for (i in list) {
        $('#leaveList').append("<tr>");
        $('#leaveList').append("<td>" +  list[i].userId + "</td>");
        $('#leaveList').append("<td>" +  list[i].name + "</td>");
        $('#leaveList').append("<td>" +  list[i].startTime + "</td>");
        $('#leaveList').append("<td>" +  list[i].endTime + "</td>");
        if(list[i].status == 1){
            const io = list[i].userId;
            $('#leaveList').append("<td id='leaveId' class='btn btn-default btn-info'>"+  "审批中" + "</td>")
            $('#leaveList').append("<button id='revokeLeave' class='button'>"+ "撤销" + "</button>")
        }else if(list[i].status == 2){
            $('#leaveList').append("<td>" +  "假期结束" + "</td>");
            $('#leaveList').append("<button>" + "申请销假" +"</button>")
        }else if(list[i].status == 3){
            $('#leaveList').append("<td>" +  "销假中" + "</td>");
            $('#leaveList').append("<button>" + "撤销" +"</button>")
        }else if(list[i].status == 4){
            $('#leaveList').append("<td>" +  "销假完成" + "</td>");
        }
        $('#leaveList').append("</tr>");
    }
}
function revokeLeave() {
    const leaveId = $('#leaveId').val();
    if (leaveId === '') {
        alert("用户名不能为空");
        return false;
    }
    $.ajax({
        type: "post",
        url: "leave/revokeLeave",
        data: {
            leaveId: leaveId,
        },
        dataType: "json",
        success: function (returnInfo) {
            alert("撤销成功");
        }
    })

}