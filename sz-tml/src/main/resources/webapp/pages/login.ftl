<!DOCTYPE html>
<html>

<head>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
    <title>用户登录</title>
    <link href="/css/style.css" rel="stylesheet" />
    <link type="text/css" href="/css/validate.css" rel="stylesheet">
    <script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>

    <script type="text/javascript" src="/js/jquery.validate.js"></script>
    <script type="text/javascript" src="/js/jquery.validate_zh.js"></script>
    <script type="text/javascript" src="/js/jquery.metadata.js"></script>
    <script type="text/javascript" src="/js/additional-methods.js"></script>
    <script type="text/javascript" src="/js/jquery-mvalidate.js"></script>
</head>

<body>
    <header>
        <img class="banner" src="/images/banner1.jpg" />
    </header>
    <div class="wrapper">
        <div class="container">
            <h1>用户登录</h1>
            <form class="data_form" method="post">
                <input type="hidden" name="wechatId" value="${personalLoginInfo.wechatId}"/>
                <input class="required phone field-text" data-validate="phone" data-describedby="phone-description" type="text" placeholder="手机号" name="phone"/>
                <div class="row">
                    <input type="text" class="required valid_input"  placeholder="验证码" name="smsCode"/>
                    <input type="button" class="valid_btn" value="获取验证码">
                </div>
                <input type="button" value="登录" id="subButton">
                <input type="button" value="注册" class="claim" onclick="window.location.href='/user/register'"/>
            </form>

        </div>
    </div>
<script>
    $(function () {

        $('#subButton').click(function () {

            var phone = $.trim($('input[name="phone"]').val());
            if (!phone) {
                $.mvalidateTip("请输入号码！");
                return;
            } else if (!/^0?1[3|4|5|8]\d{9}$/.test(phone)) {
                $.mvalidateTip("你输入的手机号码不正确！");
                return;
            }

            $.ajax({
                type:"POST",
                dataType: "json",
                url: "/user/logining",
                data: $('.data_form').serialize(),
                success: function(response){
                    if(response.status=="success"){
                        $.mvalidateTip(response.value);
                        window.location.href='/user/personal';
                    }
                    if(response.status=="error"){
                        $.mvalidateTip(response.value);
                    }
                }
            });
        });

        $('.valid_btn').click(function () {

            var phone = $.trim($('input[name="phone"]').val());
            if (!phone) {
                $.mvalidateTip("请输入号码！");
                return;
            } else if (!/^0?1[3|4|5|8]\d{9}$/.test(phone)) {
                $.mvalidateTip("你输入的手机号码不正确！");
                return;
            }

            $.ajax({
                type:"POST",
                dataType: "json",
                url: "/user/sendSms",
                data: {'phone':phone,'type':'2'},
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
</body>

</html>