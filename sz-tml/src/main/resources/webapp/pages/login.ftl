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
                <input data-validate="phone" data-describedby="phone-description" type="text" placeholder="手机号" name="phone"/>
                <input type="password" placeholder="输入密码" name="password"/>
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

            var pwd = $('input[name="password"]').val();
            if(pwd==''){
                $.mvalidateTip('请输入密码');
                return false;
            }

            $.ajax({
                type:"POST",
                dataType: "json",
                url: "/user/logining",
                data: $('.data_form').serialize(),
                success: function(response){
                    if(response.status=="success"){
                        alert(response.value);
                        window.location.href='/user/personal';
                    }
                    if(response.status=="error"){
                        $.mvalidateTip(response.value);
                    }
                }
            });
        });

    });
</script>
</body>

</html>