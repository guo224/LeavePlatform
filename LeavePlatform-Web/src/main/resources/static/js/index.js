$(document).ready(function(){
    const cookie = getCookie("loginInfo")
    if("undefined" == typeof(cookie)){
        location.href = "/";
    }
    const loginInfo = JSON.parse(cookie);
    const userId = loginInfo.userId;
    const userName = loginInfo.name;
    // alert(userName);
    const userType = loginInfo.userType;
    $("#currentUserName").text(userName);

    $("#currentUserName1").text(userName);
    $("#getLeaveRecorde").click(function () {
        location.href = "leave?userId=" + userId;
    });
    $("#leaveRecord").change(function () {
        const userId = loginInfo.userId;
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

    })
});
