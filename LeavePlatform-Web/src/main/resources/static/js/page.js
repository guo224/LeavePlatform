$(document).ready(function(){
        const cookie = getCookie("loginInfo");
        if ("undefined" == typeof(cookie)) {
            location.href = "/";
        }
        alert("111111")
        const loginInfo = JSON.parse(cookie);
        const userId = loginInfo.id;
        alert("22222")
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
    alert("3333");
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
        $('#leaveList').append("<td>" +  list[i].id + "</td>");
        $('#leaveList').append("<td>" +  list[i].name + "</td>");
        $('#leaveList').append("<td>" +  list[i].startTime1 + "</td>");
        $('#leaveList').append("<td>" +  list[i].endTime + "</td>");
        $('#leaveList').append("<td>" +  list[i].status + "</td>");
        $('#leaveList').append("</tr>");
    }
}