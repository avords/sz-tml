<!DOCTYPE html>
<html>

<head>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport"/>
    <title>立可平台</title>
    <link href="/css/style.css" rel="stylesheet"/>
    <script>
        window.onload = function () {
            var nav = document.getElementsByClassName("nav")[0];
            var lis = nav.getElementsByTagName("li");
            var platforms = document.getElementsByClassName("platform");
            for (var i = 0; i < lis.length; i++) {
                (function (i) {
                    lis[i].onclick = function () {
                        for (var j = 0; j < platforms.length; j++) {
                            if (j == i) {
                                platforms[j].className = "platform active";
                                lis[j].className = "active";

                            } else {
                                platforms[j].className = "platform";
                                lis[j].className = "";
                            }
                        }
                    }
                })(i);
            }
            ;
        }
    </script>
</head>

<body>
<header>
    <img class="banner" src="/images/about-banner.jpg"/>
</header>
<nav>
    <ul class="nav">
        <li class="active">
            <a href="#">功能</a>
        </li>
        <li>
            <a href="#">价格</a>
        </li>
        <li>
            <a href="#">下载</a>
        </li>
    </ul>
</nav>
<div class="wrapper">
    <div class="platform active">
            <#list gnList as item>
                <h2>${item.title}</h2>
                <p>${item.description}</p>
                ${item.content}
            </#list>
    </div>
    <div class="platform">
        <#list jgList as item>
            <h2>${item.title}</h2>
            <p>${item.description}</p>
            ${item.content}
        </#list>
    </div>
    <div class="platform">
        <#list xzList as item>
            <h2>${item.title}</h2>
            <p>${item.description}</p>
            ${item.content}
        </#list>
    </div>
</div>
</body>

</html>