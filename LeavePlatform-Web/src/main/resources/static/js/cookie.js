function setCookie(field, value) {
    const cookie = $.cookie(field);
    if(null !== cookie){
        $.cookie(field, {expires : -1});
        $.cookie(field, value, {path : "/"});
    } else {
        $.cookie(field, value, {path : "/"});
    }
}

function getCookie(field) {
    return $.cookie(field);
}

function delCookie(field) {
    $.cookie(field, {expires : -1});
}
