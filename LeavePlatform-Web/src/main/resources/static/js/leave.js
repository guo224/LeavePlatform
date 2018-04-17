$(document).ready(function(){
    $("#submitButton").click(function(){
        const cookie = getCookie("loginInfo")
        if("undefined" == typeof(cookie)){
            location.href = "/";
        }
        const loginInfo = JSON.parse(cookie);
        const  userId = loginInfo.id;
        const startTime = $('#startTime').val();
        const endTime = $('#endTime').val();
        const submitId = $('#submitId').val();
        if (startTime === '') {
            alert("开始时间不能为空");
            return false;
        }
        if (endTime === '') {
            alert("结束时间不能为空");
            return false;
        }
        if (endTime === '') {
            alert("审核人不能为空");
            return false;
        }
        $.ajax({
            type: "Post",
            url: "/user/submitLeave",
            data: {
                userId: userId,
                startTime: startTime,
                endTime: endTime,
                submitId: submitId
            },
            dataType: "json",
            success : function(returnInfo){
                submit(returnInfo);
            }
        })
    } )
    $(selector).change(function(){
        $.ajax({
                type:"Post",
                url:"/user/getAllTeacher",
                dataType:"json",
                data:{

                },
            success : function(returnInfo){
                setTeacherList(returnInfo);
            }
            })
    })
});
    function submit(returnInfo) {
        if (returnInfo.result === true && returnInfo.code === 30) {
            alert("提交申请成功");
        }
    }
    function setTeacherList(returnInfo){
        $("#teacherList").empty();
        $("#teacherList").append("<option value=''>选择老师</option>")
        if (returnInfo.result !== true || returnInfo.code !== 30) {
            return "";
        }
        var list = returnInfo.returnObject;
        for (i in list) {
            $("#teacherList").append("<option value='" + list[i].id + "'>" + list[i].name + "</option>");
        }
    }
