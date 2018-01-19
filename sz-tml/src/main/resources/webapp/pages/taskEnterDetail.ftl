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
            <form action="/task/saveClaime" method="post">
                <input type="hidden" name="projectDeliveryId" value="${projectDelivery.id}"/>
                <p class="title">认领方案</p>
                <div class="claim">
                    报价产值
                    <input type="text" placeholder="请输入产值..." name="outputValue">
                </div>
                <div class="row">
                    <div class="claim" style="width:62%;">
                        工作周期
                        <input type="date" placeholder="" style="width:100px;" name="startTime">
                    </div>
                    <span class="sp">~</span>
                    <div class="claim" style="width:30%;float:right;">
                        <input type="date" placeholder="" style="width:100%;" name="endTime">
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
                    <textarea cols="30" rows="10" placeholder="请输入报名说明..." name="workPlan"></textarea>
                </div>
                <div class="row">
                    <input type="submit" value="认领"/>
                </div>
            </form>
        </div>
    </div>

<script>
    $(function () {
        $('.invite input[type="button"]').click(function () {
            $(this).siblings('input[type="button"]').addClass("alt");
            $(this).removeClass('alt');
            $('input[name="type"]').val($(this).attr('data-val'));
        });
    });
</script>
</body>

</html>