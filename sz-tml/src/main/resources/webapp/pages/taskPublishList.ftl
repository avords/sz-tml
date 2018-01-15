<!DOCTYPE html>
<html>

<head>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
    <title>任务发布</title>
    <link href="/css/style.css" rel="stylesheet" />
</head>

<body>
    <header>
        <img class="banner" src="/images/banner1.jpg" />
    </header>
    <div class="wrapper">
        <div class="container">
            <div class="container_header">
            </div>
            <form action="" class="data_form">
                <input type="text" value="项目名称" placeholder="项目名称" />
                <input type="text" value="项目类型" placeholder="项目类型" />
                <select>
                    <option value="">项目建设地</option>
                </select>
                <input type="button" value="搜索" class="searchAlt">
                <input type="button" value="新增发布">
            </form>
        </div>
    </div>
    <table class="data_list" border="0">
        <thead>
            <tr>
                <td class="center" style="width:6em;">项目名称</td>
                <td style="width:5em;">项目类型</td>
                <td>项目建设地</td>
                <td style="width: 4em;">认领人</td>
            </tr>
        </thead>
        <#list projectInformations as item>
        <tr>
            <td colspan="4" class="mt"></td>
        </tr>
        <tr>
            <td class="center">${item.projectBaseInformation.projectName}</td>
            <td>医疗</td>
            <td>${item.cityName}</td>
            <td>认领人</td>
        </tr>
        </#list>
    </table>
</body>

</html>