<!DOCTYPE html>
<html>

<head>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
    <title>任务报名-详情页</title>
    <link href="/css/style.css" rel="stylesheet" />
    <script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
</head>

<body>
    <div class="wrapper">
        <div class="container article">
            <h1>${projectDelivery.projectInformation.projectName}</h1>
            <div class="author">
                <span class="view"> 浏览人数：${projectDelivery.pv}</span>
                <span class="claim"> 认领人数：${projectDelivery.claimeNum}</span>
                <br>
                <span class="countdown"> 截止时间：00 天 23 小时 23 分 24 秒</span>
            </div>
            <p class="title">项目说明</p>
            <p>
                <strong>建设单位</strong>${projectDelivery.projectInformation.constructionUnit}</p>
            <p>
                <strong>项目类型</strong>${projectDelivery.projectInformation.sysGoodType.typeName}</p>
            <p>
                <strong>项目简介</strong>${projectDelivery.projectInformation.projectBaseInformation.details}
            </p>
            <#assign projectAnnexes=projectDelivery.projectInformation.projectAnnexes/>
            <#if projectAnnexes??&&projectAnnexes?size gt 0>
                <p class="attachment">
                    项目附件
                    <br>
                        <#list projectAnnexes as item>
                            <a href="${item.fileUrl}">${item.fileName}</a>
                        </#list>
                </p>
            </#if>
        </div>
        <div class="container article">
            <form action="" id="data_form">
                <input type="hidden" name="projectDeliveryId" value="${projectDelivery.id}"/>
                <p class="title">认领方案</p>
                <div class="claim">
                    报价产值
                    <input type="text" placeholder="请输入产值..." name="outputValue">
                </div>
                <div class="row">
                    <div class="claim" style="width:62%;">
                        <span style="width: 30%">工作周期</span>
                        <input type="text" placeholder="开始时间" style="width: 70%" name="startTime">
                    </div>
                    <span class="sp">~</span>
                    <div class="claim" style="width:30%;float:right;">
                        <input type="text" placeholder="结束时间" style="width:100%;" name="endTime">
                    </div>
                </div>
                <p class="title">邀请设计师</p>
                <div class="invite">
                    <input type="hidden" name="type" value="0">
                    <input type="button" value="+ 独立认领" data-val="0">
                    <input type="button" value="+ 已有心仪的设计师" class="alt" data-val="1">
                </div>
                <p class="title">工作计划</p>
                <div class="plane">
                    <textarea cols="30" rows="5" placeholder="请输入报名说明..." name="workPlan"></textarea>
                </div>
                <#if (projectDelivery.planEndTime?date) gt .now?date>
                    <div class="data_form">
                        <input type="button" value="认领" id="saveButton"/>
                    </div>
                </#if>
            </form>
        </div>
    </div>

<script>
    $(function () {
        $('#saveButton').click(function () {
            var startDate = $('input[name="startTime"]').val();
            var endDate = $('input[name="endTime"]').val();
            if (startDate) {
                if(!isdate(startDate)){
                    alert('工作周期格式为:yyyy-MM-dd格式');
                    return false;
                }
            }
            if (endDate) {
                if(!isdate(endDate)){
                    alert('工作周期格式为:yyyy-MM-dd格式');
                    return false;
                }
            }
            $.ajax({
                type:"POST",
                dataType: "json",
                url: "/task/saveClaime",
                data: $('#data_form').serialize(),
                success: function(response){
                    if(response==true){
                        alert('认领成功');
                        window.location.href='/task/enter';
                    } else{
                        alert('之前已认领')
                    }
                }
            });
        });
        
        $('.invite input[type="button"]').click(function () {
            $(this).siblings('input[type="button"]').addClass("alt");
            $(this).removeClass('alt');
            $('input[name="type"]').val($(this).attr('data-val'));
        });
        //倒计时
        function countdown(date) {
            var a = new Date(Date.parse(date.replace(/-/g,"/"))).getTime();
            var b = new Date().getTime();
            if(a<b){
                 $('.countdown').html('截止时间：已截止');
                 return;
            }else{
                var time = parseInt((a-b)/1000);
                autoTask = setInterval(function(){
                    time--;
                    if(time>0){
                        var days = parseInt(time / (60 * 60 * 24));
                        var hours = parseInt((time % (60 * 60 * 24)) / (60 * 60));
                        var minutes = parseInt((time % (60 * 60)) /60);
                        var seconds = (time % 60);
                        $('.countdown').html('截止时间：'+days+' 天 '+hours+' 小时 '+minutes+' 分 '+seconds+' 秒');
                    }else{
                        $('.countdown').html('截止时间：已截止');
                    }
                },1000);
            }
        }
        countdown('${projectDelivery.planEndTime?string("yyyy-MM-dd")}');
    });
</script>
</body>

</html>