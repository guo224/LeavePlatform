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
        });
        $(".alert-block").click(function(){
        alert("第一个第二个");
    });

});
function getleaveRecord(returnInfo) {

    if (returnInfo.result !== true || returnInfo.code !== 30) {
        return "";
    }
    var list = returnInfo.returnObject;
    debugger;
    $('#leaveRecord').append("<option>选择请假单</option>")
    for (i in list) {
        $('#leaveRecord').append("<option>" + list[i].id + "</option>");
        $('#leaveRecord').append("<option>" + list[i].name + "</option>");
        $('#leaveRecord').append("<option>" + list[i].startTime + "</option>");
        $('#leaveRecord').append("<option>" + list[i].endTime + "</option>");
    }
}
function revokeLeave(returnInfo) {
    const leaveId = returnInfo;
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
        success: function () {
            alert("略略略略")
            location.reload(false);
        }
    })
    location.reload(true);
}
function applyEndLeave(returnInfo) {
    alert("略略略略emmmm");
    const leaveId = returnInfo;
    if (leaveId === '') {
        alert("用户名不能为空");
        return false;
    }
    $.ajax({
        type: "post",
        url: "leave/applyEndLeave",
        data: {
            leaveId: leaveId,
        },
        success: function () {
            alert("略略略略")
            location.reload(false);
        }
    });
    location.reload(true);
}
function popup(returnInfo){
    const userId1 = returnInfo;
    alert(userId1);
    $.ajax({
        type: "post",
        url: "user/updateUser",
        data: {
            id: userId1,
            isDelete :1
        },
        dataType: "json",
        success: function (returnInfo) {
            if (returnInfo.result === true && returnInfo.code === 30) {
               alert("修改成功");
            }

        }

    })
}
