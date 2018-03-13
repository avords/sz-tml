<!DOCTYPE html>
<html>

<head>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport"/>
    <title>关于立可</title>
    <link href="/css/style.css?ver=100" rel="stylesheet"/>
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
            <a href="#">立可设计</a>
        </li>
        <li>
            <a href="#">立可科技</a>
        </li>
        <li>
            <a href="#">立可空间</a>
        </li>
    </ul>
</nav>
<div class="wrapper">
    <div class="platform active">
        <h2>${sheji.description}</h2>
        ${sheji.content}
        <#list designList as item>
            <img class="top30" src="${item.img}" alt=""/>
            <p>${item.title}</p>
        </#list>
    </div>
    <div class="platform">
        <h2>${keji.description}</h2>
        ${keji.content}
    </div>
    <div class="platform">
        <h2>${kongjian.description}</h2>
        ${kongjian.content}
    </div>
</div>
</body>

</html>