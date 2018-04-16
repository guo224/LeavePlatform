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
});
