<!DOCTYPE html>
<html>

<head>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport"/>
    <title>我发布的</title>
    <link href="/css/style.css" rel="stylesheet"/>
</head>

<body>
<div class="wrapper">
    <div class="container articlelist">
        <#list projectPublishs as item>
            <ul class="article_list">
                <li>
                    <a href="#">
                        <img src="${item.image}" alt="">
                        <div></div>
                        <span>${item.project_status}__${item.project_name}</span>
                    </a>
                </li>
            </ul>
        </#list>
    </div>
</div>
</body>

</html>