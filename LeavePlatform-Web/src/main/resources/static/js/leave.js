$(document).ready(function(){
    $("#submitLeave").click(function(){
        const cookie = getCookie("loginInfo")
        if("undefined" == typeof(cookie)){
            location.href = "/";
        }
        const loginInfo = JSON.parse(cookie);
        const  userId = loginInfo.id;
        const startTime = $('#startTime').val();
        const endTime = $('#endTime').val();
        const submitId = $('#teacherId').val();
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
    } );
    $("#addStudent").click(function () {

        const userId = $('#userId').val();
        const name = $('#name').val();
        const sex  = $('#sex').val();
        const mobileNum = $('#mobile').val();
        const passWord = $('#passWord').val();
        const teacherId = $('#teacherId').val();
        if (userId === '') {
            alert("账号不能为空");
            return false;
        }
        if (passWord === '') {
            alert("密码不能为空");
            return false;
        }
        if (teacherId === '') {
            alert("审核人不能为空");
            return false;
        }
        $.ajax({
            type: "Post",
            url: "/user/addUser",
            data: {
                userId: userId,
                name:name,
                sex:sex,
                mobileNum:mobileNum,
                passWord:passWord,
                objectId:teacherId,
                userType:0
            },
            dataType: "json",
            success : function(returnInfo){
                addStudent(returnInfo);
            }
        })
    });
    $("#updateStudent").click(function () {
            const id = $("#id").attr("value");
        const userId = $('#userId').val();
        debugger;
        const name = $('#name').val();
        debugger;
        const sex  = $('#sex').val();
        debugger;
        const mobileNum = $('#mobile').val();
        debugger;
        const passWord = $('#passWord').val();
        debugger;
        const teacherId = $('#teacherId').val();
        if (userId === '') {
            alert("账号不能为空");
            return false;
        }
        if (passWord === '') {
            alert("密码不能为空");
            return false;
        }
        if (teacherId === '') {
            alert("审核人不能为空");
            return false;
        }
        $.ajax({
            type: "Post",
            url: "/user/updateUser",
            data: {
                id:id,
                userId: userId,
                name:name,
                sex:sex,
                mobileNum:mobileNum,
                passWord:passWord,
                objectId:teacherId,
            },
            dataType: "json",
            success : function(returnInfo){
                updateStudent(returnInfo);
            }
        })
    })
});
function submit(returnInfo){
        if (returnInfo.result === true && returnInfo.code === 30) {
            alert("提交申请成功");
            window.location.reload();
        }
    }
function addStudent(returnInfo){
    if (returnInfo.result === true && returnInfo.code === 30) {
        alert("添加学生成功");
        window.location.reload();
    }
}
function updateStudent(returnInfo){
    if (returnInfo.result === true && returnInfo.code === 30) {
        alert("修改成功");
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
