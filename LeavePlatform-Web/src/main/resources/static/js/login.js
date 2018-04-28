$(document).ready(function() {
    $('.popup-with-zoom-anim').magnificPopup({
        type: 'inline',
        fixedContentPos: false,
        fixedBgPos: true,
        overflowY: 'auto',
        closeBtnInside: true,
        preloader: false,
        midClick: true,
        removalDelay: 300,
        mainClass: 'my-mfp-zoom-in'
    });
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
    });
});



function logOut() {
    delCookie("loginInfo");
    location.href = "/";
}
function login(returnInfo) {
    if (returnInfo.result === true && returnInfo.code === 30) {
        const userInfo = returnInfo.returnObject;
        const userType = userInfo.userType;
        if(userType == 0) {
            location.href = "/index";
        }
        if(userType == 1) {
            location.href = "/teacherIndex";
        }
        if(userType == 2){
            location.href = "/adminIndex";
        }
        setCookie("loginInfo", JSON.stringify(userInfo));
    } else {
        alert("用户名或密码错误");
    }
}