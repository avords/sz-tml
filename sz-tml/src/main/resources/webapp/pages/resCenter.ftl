<!DOCTYPE html>
<html>

<head>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
    <title>资源中心</title>
    <link href="/css/style.css" rel="stylesheet" />
    <script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
</head>

<body>
<header>
    <img class="banner" src="/images/banner2.jpg" />
</header>
<div class="wrapper">
    <div class="container">
        <div class="container_header">
            <a href="#">切换</a>
            <a class="active" href="javascript:void(0);" onclick="tabSC();">
                        <#if oneStr=='1'>
                            一级市场
                        <#else>
                            二级市场
                        </#if>
            </a>
        </div>
        <form action="/task/enter" class="data_form" id="search_from" method="post">
            <input type="hidden" name="oneStr" value="${oneStr}">
            <select name="fieldId">
                <option value="">领域</option>
                        <#list sysAreasExpertises as item>
                            <#if fieldId==item.id>
                                <option value="${item.id}" selected="selected">${item.typeName}</option>
                            <#else>
                                <option value="${item.id}">${item.typeName}</option>
                            </#if>
                        </#list>
            </select>
            <select name="designTypeId">
                <option value="">类型</option>
                        <#list sysGoodTypes as item>
                            <#if designTypeId==item.id>
                                <option value="${item.id}" selected="selected">${item.typeName}</option>
                            <#else>
                                <option value="${item.id}">${item.typeName}</option>
                            </#if>
                        </#list>
            </select>
            <select name="companyId">
                <option value="">项目导入方</option>
                <#list projectImports as item>
                    <#if companyId==item['company_id']>
                        <option value="${item['company_id']}" selected="selected">${item['company_name']}</option>
                    <#else>
                        <option value="${item['company_id']}">${item['company_name']}</option>
                    </#if>
                </#list>
            </select>
            <div class="row">
                <input type="text" placeholder="项目产值" name="startOutputValue" value="${startOutputValue}"/>
                <span class="sp">~</span>
                <input type="text" style="float:right" name="endOutputValue" value="${endOutputValue}"/>
            </div>
            <div class="row">
                <input type="date" placeholder="发布时间" name="startDate" value="${startDate}"/>
                <span class="sp">~</span>
                <input type="date" style="float:right" name="endDate" value="${endDate}"/>
            </div>
            <input type="button" value="搜索" onclick="$('#search_from').submit();">
        </form>
    </div>
</div>
<ul class="data_list">
        <#list projectDeliverys as item>
            <li>
                <b>${item.project_name}</b>
                <div class="des">

                    <div class="info">
                        <p>产值:
                            <span>${item.output_value}</span>
                        </p>
                        <p>项目导入方:
                            <span>${item.company_name}</span>
                        </p>
                        <p>发布时间:
                            <span>${item.create_time?date("yyyy-MM-dd")}</span>
                        </p>
                    </div>

                    <div class="info">
                        <p>工作类型:
                            <span>审核员</span>
                        </p>
                        <p>浏览量/认领数:
                            <span>${item.pv}/${item.claime_num}</span>
                        </p>
                        <p>截止时间:
                            <span>${item.plan_end_time?date("yyyy-MM-dd")}</span>
                        </p>
                    </div>
                    <div class="op">
                        <input type="button" value="认领" class="claim" onclick="window.location.href='/task/detail/${item.id}'"/>
                        <input type="button" value="分享" class="share" />
                    </div>
                </div>
            </li>
        </#list>
</ul>
<script>
    function tabSC() {
        var oneStr = $('input[name="oneStr"]').val();
        if(oneStr=='1'){
            $('input[name="oneStr"]').val('2');
        }else{
            $('input[name="oneStr"]').val('1');
        }
        $('#search_from').submit();
    }
</script>
</body>

</html>