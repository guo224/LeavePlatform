$(document).ready(function () {
    $("#loginButton").click(function () {
        const userId = $('#userId').val();
        const passWord = $('#passWord').val();
        if (userId === '') {
            alert("用户名不能为空");
            return false;
        }
        if (passWord === '') {
            alert("密码不能为空");
            return false;
        }
        $.ajax({
            type: "POST",
            url: '/user/login',
            data: {
                userId: userId,
                passWord: passWord
            },
            dataType: "json",
            success: function (returnInfo) {
                login(returnInfo);
            }
        })
    })
});

function login(returnInfo) {
    if (returnInfo.result === true && returnInfo.code === 30) {
        const userInfo = returnInfo.returnObject;
        setCookie("loginInfo", JSON.stringify(userInfo));
        location.href = "/index";
    } else {
        alert("用户名或密码错误");
    }
}

function logOut() {
    delCookie("loginInfo");
    location.href = "/";
}