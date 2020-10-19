
if (ctx) ctx = "";

function isSuccess(resultCode){
    return Math.floor(resultCode / 100) === 2;
}

function updateVCode(){
    document.getElementById("imgCode").src
        = ctx + "/captcha/login?type=char&_r=" + Math.random();
}

function defaultLoginFailure(message){
    layer.msg("登录失败：" + message);
}

function login(successFunc=(()=>{}), failureFunc=defaultLoginFailure) {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let vCode = document.getElementById("vCode").value;
    let data = {username: username, password: password, vCode: vCode};

    $.post(ctx + "/login", data, function(result, status){
        if (status === "success" && isSuccess(result.code)){
            successFunc(result.message);
            return ;
        }
        failureFunc(result.message);
        updateVCode();
        console.log("[login] failure: ", result);
    });
}

$('#imgCode').click(function() {
    updateVCode();
});

setInterval(() => {
    updateVCode();
}, 5 * 60 * 1000 - 10); // 5 * 60 * 1000 = 5min, 提前10s自动更新验证码