<!DOCTYPE html>
<html>

<head>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
    <title>用户注册</title>
    <link href="/css/style.css?ver=100" rel="stylesheet" />
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
            <h1>用户注册</h1>
            <form action="/user/registering" class="data_form" method="post">
                <input type="hidden" name="wechatId" value="${personalLoginInfo.wechatId}"/>
                <input class="required phone" type="text" placeholder="手机号" name="phone"/>
                <input class="required {account_pass:[6,8]}" type="password" placeholder="输入密码" name="password"/>
                <input class="{pwd_is_equal:['password']}" type="password" placeholder="再次输入密码" id="pwd"/>
                <div class="row">
                    <input type="text" class="required valid_input"  placeholder="验证码" name="smsCode"/>
                    <input type="button" class="valid_btn" value="获取验证码">
                </div>
                <input type="button" value="注册" id="subButton">
                <input type="button" value="登录" class="claim" onclick="window.location.href='/user/login'"/>
            </form>
        </div>
    </div>
<script>

    function CheckPassWord(password) {//必须为字母加数字且长度不小于8位
        var str = password;
        if (str == null || (str.length<8||str.length>20)) {
            return false;
        }
        var reg1 = new RegExp(/^[0-9A-Za-z]+$/);
        if (!reg1.test(str)) {
            return false;
        }
        var reg = new RegExp(/[A-Za-z].*[0-9]|[0-9].*[A-Za-z]/);
        if (reg.test(str)) {
            return true;
        } else {
            return false;
        }
    }

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

            var pwd = $('input[name="password"]').val();
            var pwd1 = $('#pwd').val();
            if(pwd==''){
                $.mvalidateTip('请输入密码');
                return false;
            }

            if(!CheckPassWord(pwd)){
                $.mvalidateTip('密码为字母加数字且长度8-20位');
                return false;
            }

            if(pwd!=pwd1){
                $.mvalidateTip('两次输入的密码不一致');
                return false;
            }

            var smsCode = $.trim($('input[name="smsCode"]').val());
            if (!smsCode) {
                $.mvalidateTip("请输入验证码！");
                return;
            }

            $.ajax({
                type:"POST",
                dataType: "json",
                url: "/user/registering",
                data: $('.data_form').serialize(),
                success: function(response){
                    if(response.status=="success"){
                        alert(response.value);
                        window.location.href='/auth/login';
                    }
                    if(response.status=="certificat"){
                        alert(response.value);
                        window.location.href='/user/certificat';
                    }
                    if(response.status=="error"){
                        $.mvalidateTip(response.value);
                    }
                }
            });
        });
        //$('.data_form').valid();

        $('.valid_btn').click(function () {

            var phone = $.trim($('input[name="phone"]').val());
            if (!phone) {
                $.mvalidateTip("请输入号码！");
                return;
            } else if (!/^0?1[3|4|5|8]\d{9}$/.test(phone)) {
                $.mvalidateTip("你输入的手机号码不正确！");
                return;
            }

            var pwd = $('input[name="password"]').val();
            var pwd1 = $('#pwd').val();
            if(pwd==''){
                $.mvalidateTip('请输入密码');
                return false;
            }
            if(pwd!=pwd1){
                $.mvalidateTip('两次输入的密码不一致');
                return false;
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