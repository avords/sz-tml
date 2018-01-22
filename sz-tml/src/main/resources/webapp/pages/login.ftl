<!DOCTYPE html>
<html>

<head>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
    <title>信息绑定</title>
    <link href="/css/style.css" rel="stylesheet" />
    <script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>

    <script type="text/javascript" src="/js/jquery.validate.js"></script>
    <script type="text/javascript" src="/js/jquery.validate_zh.js"></script>
    <script type="text/javascript" src="/js/jquery.metadata.js"></script>
    <script type="text/javascript" src="/js/additional-methods.js"></script>
</head>

<body>
    <header>
        <img class="banner" src="/images/banner1.jpg" />
    </header>
    <div class="wrapper">
        <div class="container">
            <h1>用户信息绑定</h1>
            <form action="/user/login" class="data_form" method="post">
                <input class="required phone" type="text" placeholder="手机号" name="phone"/>
                <input class="required {account_pass:[6,8]}" type="password" placeholder="输入密码" name="password"/>
                <div class="row">
                    <input type="text" class="required valid_input"  placeholder="验证码" name="smsCode"/>
                    <input type="button" class="valid_btn" value="获取验证码">
                </div>
                <input type="button" value="用户信息绑定" onclick="$('.data_form').submit();">
            </form>
        </div>
    </div>
</body>
<script>
    $(function () {
        $('.data_form').valid();
        $('.valid_btn').click(function () {
            //验证两次密码是否相等
            //发送验证码
            var phone = $('input[name="phone"]').val();
            $.ajax({
                type:"POST",
                dataType: "json",
                url: "/user/sendSms",
                data: {'phone':phone,'type':'1'},
                success: function(response){
                    if(response==true){
                        sendSMSTask();
                        return;
                    } else{
                        //发送验证码失败
                    }
                }
            });
        });
        var _zUserInfo = {
            times: 60,
            autoTask : null,
            downTime : true
        };
        function sendSMSTask(){
            if(_zUserInfo.times==60 && _zUserInfo.downTime){
                _zUserInfo.downTime = false;
                var jThis = $(".valid_btn");
                jThis.val('60秒后重发').attr('disabled','disabled');
                _zUserInfo.autoTask = setInterval(function(){
                    _zUserInfo.times--;
                    jThis.val(_zUserInfo.times+'秒后重发');
                    if(_zUserInfo.times==0){
                        clearTimeout(_zUserInfo.autoTask);
                        jThis.val('重发验证码').removeAttr('disabled');
                        _zUserInfo.times=60;
                        _zUserInfo.downTime = true;
                    }
                },1000);
            }
        }
    });
</script>
</html>