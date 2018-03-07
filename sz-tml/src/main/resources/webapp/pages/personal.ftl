<!DOCTYPE html>
<html>

<head>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
    <title>个人资料</title>
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
    <div class="wrapper">
        <div class="info_head">
            <div class="user_pic">
                <img src="${loginInfo.header}" alt="" />
                <#--<a class="add_user_pic" href="javascript:void(0)">+</a>-->
            </div>
        </div>
        <div class="container">
            <form action="/user/changePersonal" class="data_form" id="form" method="post">
                <input type="hidden" name="id" value="${personalBaseInfo.id}"/>
                <input type="hidden" name="memberId" value="${personalBaseInfo.memberId}"/>
                <input type="text" placeholder="请输入姓名" name="name" value="${personalBaseInfo.name}"/>
                <input type="text" placeholder="请输入联系电话" name="phone" value="${personalBaseInfo.phone}"/>
                <input type="date"  placeholder="请输入生日" name="birthday" value="${personalBaseInfo.birthday?string("yyyy-MM-dd")}"/>
                <input type="text" placeholder="请输入所在地" name="location" value="${personalBaseInfo.location}"/>
                <input type="text" placeholder="请输入详细地址" name="specificAddress" value="${personalBaseInfo.specificAddress}"/>
                <select name="teamId">
                    <option value="">请选择所属团队</option>
                    <#list teamBasicInformations as item>
                        <#if item.id==personalBaseInfo.teamId>
                            <option value="${item.id}" selected = "selected">${item.name}</option>
                        <#else>
                            <option value="${item.id}">${item.name}</option>
                        </#if>
                    </#list>
                </select>
                <input type="text" placeholder="请输入所在公司" name="company" value="${personalBaseInfo.company}"/>
                <input type="text" placeholder="请输入个人描述" name="personalDescription" value="${personalBaseInfo.personalDescription}"/>
                <input type="button" value="完善个人信息" id="subButton">
                <input type="button" value="切换账号" id="changeButton">
            </form>
        </div>
    </div>
<script>
    $(function () {
        $('#subButton').click(function () {
            $.ajax({
                type:"POST",
                dataType: "json",
                url: "/user/personaling",
                data: $('.data_form').serialize(),
                success: function(response){
                    if(response.status=="success"){
                        alert(response.value);
                        window.location.href='/task/enter';
                    }
                    if(response.status=="error"){
                        $.mvalidateTip(response.value);
                    }
                }
            });
        });

        $('#changeButton').click(function () {
            $.ajax({
                type:"POST",
                dataType: "json",
                url: "/user/changePersonal",
                data: $('.data_form').serialize(),
                success: function(response){
                    if(response.status=="success"){
                        alert(response.value);
                        window.location.href='/auth/login';
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