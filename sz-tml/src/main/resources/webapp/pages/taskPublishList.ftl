<!DOCTYPE html>
<html>

<head>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
    <title>任务发布</title>
    <link href="/css/style.css?ver=100" rel="stylesheet" />

    <script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
</head>

<body>
    <header>
        <img class="banner" src="/images/banner1.jpg" />
    </header>
    <div class="wrapper">
        <div class="container">
            <div class="container_header">
            </div>
            <form action="/task/publish" class="data_form" method="post">
                <input name="projectName" type="text" placeholder="项目名称" value="${projectName}"/>
                <select name="designTypeId">
                    <option value="">项目类型</option>
                    <#list sysGoodTypes as item>
                        <#if designTypeId==item.id>
                            <option value="${item.id}" selected="selected">${item.typeName}</option>
                        <#else>
                            <option value="${item.id}">${item.typeName}</option>
                        </#if>
                    </#list>
                </select>
                <select name="provinceId">
                    <option value="">选择省份</option>
                    <#list provinces as item>
                        <#if provinceId==item.id>
                            <option value="${item.id}" selected="selected">${item.name}</option>
                        <#else>
                            <option value="${item.id}">${item.name}</option>
                        </#if>
                    </#list>
                </select>
                <select name="cityId">
                    <option value="">选择城市</option>
                    <#list citys as item>
                        <#if cityId==item.id>
                            <option value="${item.id}" selected="selected">${item.name}</option>
                        <#else>
                            <option value="${item.id}">${item.name}</option>
                        </#if>
                    </#list>
                </select>
                <input type="button" value="搜索" class="searchAlt" onclick="$('.data_form').submit();">
                <input type="button" value="新增发布" onclick="window.location.href='/task/createPublish'">
            </form>
        </div>
    </div>
    <table class="data_list" border="0">
        <thead>
            <tr>
                <td class="center">项目名称</td>
                <td style="width:5em;">项目类型</td>
                <td style="width:6em;">项目建设地</td>
                <td style="width: 4em;text-align: center">认领人数</td>
            </tr>
        </thead>
        <#list projectInformations as item>
        <tr>
            <td colspan="4" class="mt"></td>
        </tr>
        <tr>
            <td class="center">${item['project_name']}</td>
            <td>${item['type_name']}</td>
            <td>${item['province_name']}${item['city_name']}</td>
            <td class="center">${item['claime_num']}</td>
        </tr>
        </#list>
    </table>

<script>
    $(function () {
        $('select[name="provinceId"]').change(function () {
            var provinceId = $(this).val();
            $.ajax({
                type:"POST",
                dataType: "json",
                url: "/task/getCitys",
                data: {'provinceId':provinceId},
                success: function(data){
                    var html = '<option value="">选择城市</option>';
                    for (var i=0;i<data.length;i++)
                    {
                        html = html+'<option value="'+data[i].id+'">'+data[i].name+'</option>'
                    }
                    $('select[name="cityId"]').html(html);
                }
            });
        });
    });
</script>
</body>

</html>