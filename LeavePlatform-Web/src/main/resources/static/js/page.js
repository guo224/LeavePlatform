function list() {
    const cookie = getCookie("loginInfo");
    if("undefined" == typeof(cookie)){
        location.href = "/";
    }
    const loginInfo = JSON.parse(cookie);
    const  userId = loginInfo.id;
    $.ajax({
        type:"post",
    })

}