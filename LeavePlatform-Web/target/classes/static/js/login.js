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
        alert("222");
        const userId = $('#userId').val();
        const passWord = $('#passWord').val();
        alert(userId);
        alert(passWord);

        if (userId === '') {
            alert("用户名不能为空");
            return false;
        }
        if (passWord === '') {
            alert("密码不能为空");
            return false;
        }
        alert("444");
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
        location.href = "/index";
        setCookie("loginInfo", JSON.stringify(userInfo));
    } else {
        alert("用户名或密码错误");
    }
}