<!DOCTYPE html>
<html>

<head>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
    <title>项目发布-基础信息</title>
    <link href="/css/style.css" rel="stylesheet" />
</head>

<body>
<div class="wrapper">
    <div class="container article">
        <h1 class="title">基础信息</h1>
        <form action="" class="data_form">
            <select>
                <option value="">项目建设地</option>
            </select>
            <select>
                <option value=""></option>
            </select>
            <input type="text" placeholder="建设单位" />
            <select>
                <option value="">建设地址</option>
            </select>
            <select>
                <option value=""></option>
            </select>
            <select>
                <option value=""></option>
            </select>
            <input type="text" placeholder="" />
            <input type="text" placeholder="联系人" />
            <input type="text" placeholder="联系电话" />
            <input type="text" placeholder="项目金额" />
            <div class="claim">
                <input type="text" placeholder="用地面积" />
            </div>
            <div class="claim">
                <input type="text" placeholder="建筑面积" />
            </div>
            <input type="text" placeholder="建设单位" />
            <select>
                <option value="">项目获取类型</option>
            </select>
            <select>
                <option value="">项目来源</option>
            </select>
            <input type="text" placeholder="项目名称" />
            <input type="text" placeholder="项目编号" />
            <input type="text" placeholder="建设单位" />
            <textarea cols="30" rows="10" placeholder="项目详情"></textarea>
            <textarea cols="30" rows="10" placeholder="人员要求"></textarea>
            <div class="row">
                <div class="claim" style="width:60%;">
                    计划时间
                    <input type="text" placeholder="" style="width:100px;">
                </div>
                <span class="sp">~</span>
                <div class="claim" style="width:32%;float:right;">
                    <input type="text" placeholder="" style="width:100%;">
                </div>
            </div>
            <select>
                <option value="">计划周期</option>
            </select>
            <p class="title">成果要求</p>
            <div class="demands">
                <label>文本</label>
                <label class="active">展板</label>
                <label >多媒体</label>
                <label>模型</label>
                <label class="active">其他</label>
                <label>备注</label>
                <div class="clear"></div>
            </div>
            <p class="title">项目附件</p>
            <div class="invite">
                <input type="button" value="项目附注" class="border">
            </div>
            <div style="height:15px;"></div>
            <textarea cols="30" rows="10" placeholder="附件备注"></textarea>
            <p class="title">邀请的项目经理</p>
            <div class="invite">
                <input type="button" value="+ 已有心仪的项目经理">
                <input type="button" value="+ 直接发布到一级市场" class="alt">
            </div>
            <input type="button" value="保存" class="save">
            <input type="button" value="确认提交">
        </form>
    </div>
</div>
</body>

</html>