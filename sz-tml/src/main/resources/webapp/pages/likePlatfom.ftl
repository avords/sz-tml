<!DOCTYPE html>
<html>

<head>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
    <title>立可平台</title>
    <link href="/css/style.css" rel="stylesheet" />
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
            };
        }
    </script>
</head>

<body>
    <header>
        <img class="banner" src="/images/about-banner.jpg" />
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
            <h2>进度全览提供实时报告</h2>
            <p>为项目经理、设计师提供精准的工作指引让导入方了解实时的项目进度</p>
            <img class="top30" src="/images/platform-pic-01.jpg" alt="" />
            <h2 class="top30">个人数据分析助力职业规划</h2>
            <p>在这里您可以发布项目，认领项目，和您的团队协同工作，为你提供管理任务、安排日程、 查找文件、即时讨论等团队所需要的一切协作功能，而这一切，完全免费
            </p>
            <img class="top30" src="/images/platform-pic-03.jpg" alt="" />
            <h2 class="top30">标准化看板规范项目管理</h2>
            <p>标准化的模版匹配，个性化的灵活调整 让项目协同清晰高效
            </p>
            <img class="top30" src="/images/platform-pic-03.jpg" alt="" />
            <h2 class="top30">两级市场实现自雇员工作模式</h2>
            <p>
                周期长、流程复杂的项目拆分为周期短、 内容单一的任务模块 设计师可自由认领，线上完成交易
            </p>
            <img class="top30" src="/images/platform-pic-04.jpg" alt="" />
            <h2 class="top30">定制化管理台服务于多类型团队</h2>
            <p>
                解决小微团队的管理问题， 满足中大型团队的多维度需求
            </p>
            <img class="top30" src="/images/platform-pic-05.jpg" alt="" />
        </div>
        <div class="platform">价格</div>
        <div class="platform">下载</div>
    </div>
</body>

</html>