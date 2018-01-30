<!DOCTYPE html>
<html>

<head>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
    <title>任务报名</title>
    <link href="/css/style.css" rel="stylesheet" />
    <script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
</head>

<body>
    <header>
        <img class="banner" src="/images/banner1.jpg" />
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
                        <input type="text" placeholder="发布时间" name="startDate" value="${startDate}"/>
                        <span class="sp">~</span>
                        <input type="text" style="float:right" name="endDate" value="${endDate}"/>
                    </div>
                    <input type="button" value="搜索" onclick="search();">
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
                        <span>
                            <#if item.job_type=1>
                                设计师
                            <#elseif item.job_type=2>
                                审核员
                            <#else>
                                其他
                            </#if>
                        </span>
                    </p>
                    <p>浏览量/认领数:
                        <span>${item.pv}/${item.claime_num}</span>
                    </p>
                    <p>截止时间:
                        <span>${item.plan_end_time?date("yyyy-MM-dd")}</span>
                    </p>
                </div>
                <div class="op">
                    <#if (item.plan_end_time?date) gt .now?date>
                        <input type="button" value="认领" class="claim" onclick="window.location.href='/task/detail/${item.id}'"/>
                    </#if>
                    <#--<input type="button" value="分享" class="share" />-->
                </div>
            </div>
        </li>
        </#list>
    </ul>
<script>
    function isdate(str){
        var patrn = /^\d{4}-\d{2}-\d{2}$/;
        if (!patrn.exec(str))
            return false;
        return true;
    }
    function search() {
        var startDate = $('input[name="startDate"]').val();
        var endDate = $('input[name="endDate"]').val();
        if (startDate) {
            if(!isdate(startDate)){
                alert('项目发布时间格式为:yyyy-MM-dd格式');
                return false;
            }
        }
        if (endDate) {
            if(!isdate(endDate)){
                alert('项目发布时间格式为:yyyy-MM-dd格式');
                return false;
            }
        }
        $('#search_from').submit();
    }
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