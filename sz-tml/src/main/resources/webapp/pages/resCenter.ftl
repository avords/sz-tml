﻿<!DOCTYPE html>
<html>

<head>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
    <title>资源中心</title>
    <link href="/css/style.css" rel="stylesheet" />
</head>

<body>
    <header>
        <img class="banner" src="/images/banner2.jpg" />
    </header>
    <div class="wrapper">
        <div class="container">
            <div class="container_header">
                <a href="#">切换</a>
                <a class="active" href="#">二级市场</a>
            </div>
            <form action="" class="data_form">
                <select>
                    <option value=""></option>
                    <#list areasExpertiseList as item>
                        <option value="${item.id}">${item.typeName}</option>
                    </#list>
                </select>
                <select>
                    <option value=""></option>
                    <#list goodTypeList as item>
                        <option value="${item.id}">${item.typeName}</option>
                    </#list>
                </select>
                <select>
                    <option value="">导入项目方</option>
                </select>
                <div class="row">
                    <input type="text" placeholder="项目产值" />
                    <span class="sp">~</span>
                    <input type="text" style="float:right" />
                </div>
                <div class="row">
                    <input type="text" placeholder="发布时间" />
                    <span class="sp">~</span>
                    <input type="text" style="float:right" />
                </div>
                <input type="button" value="搜索">
            </form>
        </div>
    </div>
    <ul class="data_list">
        <li>
            <b>太原国家环保节能控制工程技术中心太原国家环保节能控制工程技术中心</b>
            <div class="des">

                <div class="info">
                    <p>产值:
                        <span>221,245</span>
                    </p>
                    <p>项目导入方:
                        <span>深圳建筑院深圳建筑院</span>
                    </p>
                    <p>发布时间:
                        <span>2017-07-20</span>
                    </p>
                </div>

                <div class="info">
                    <p>工作类型:
                        <span>审核员</span>
                    </p>
                    <p>浏览量/认领数:
                        <span>155/2</span>
                    </p>
                    <p>截止时间:
                        <span>2017-07-20</span>
                    </p>
                </div>
                <div class="op">
                    <input type="button" value="认领" class="claim" />
                    <input type="button" value="分享" class="share" />
                </div>
            </div>
        </li>
        <li>
            <b>太原国家环保节能控制工程技术中心太原国家环保节能控制工程技术中心</b>
            <div class="des">

                <div class="info">
                    <p>产值:
                        <span>221,245</span>
                    </p>
                    <p>项目导入方:
                        <span>深圳建筑院深圳建筑院</span>
                    </p>
                    <p>发布时间:
                        <span>2017-07-20</span>
                    </p>
                </div>

                <div class="info">
                    <p>工作类型:
                        <span>审核员</span>
                    </p>
                    <p>浏览量/认领数:
                        <span>155/2</span>
                    </p>
                    <p>截止时间:
                        <span>2017-07-20</span>
                    </p>
                </div>
                <div class="op">
                    <input type="button" value="认领" class="claim" />
                    <input type="button" value="分享" class="share" />
                </div>
            </div>
        </li>
    </ul>
</body>

</html>