<!DOCTYPE html>
<html>

<head>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport" />
    <title>项目发布-基础信息</title>
    <link href="/css/style.css" rel="stylesheet" />

    <script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
</head>

<body>
<div class="wrapper">
    <div class="container article">
        <h1 class="title">基础信息</h1>
        <form action="" class="data_form">
            <input type="hidden" name="companyId" value="${companyId}"/>
            <input type="hidden" name="memberId" value="${memberId}"/>
            <input type="hidden" name="status" value="0"/>
            <input type="hidden" name="isDel" value="0"/>
            <input type="hidden" name="provinceName"/>
            <input type="hidden" name="cityName"/>
            <input type="hidden" name="cycleValue"/>
            <input type="hidden" name="cycleUnit"/>
            
            <input type="text" placeholder="项目名称" name="projectName"/>
            <input type="text" placeholder="项目编号" name="projectNum"/>
            <select name="fieldId">
                <option value="">领域</option>
                <#list sysAreasExpertises as item>
                        <option value="${item.id}">${item.typeName}</option>
                </#list>
            </select>
            <select name="designTypeId">
                <option value="">设计类型</option>
                <#list sysGoodTypes as item>
                    <option value="${item.id}">${item.typeName}</option>
                </#list>
            </select>
            <input type="text" placeholder="建设单位" name="constructionUnit"/>
            <input type="text" placeholder="联系人" name="contactPerson"/>
            <input type="text" placeholder="联系电话" name="contactPerson"/>
            <select name="provinceId">
                <option value="">选择省份</option>
                <#list provinces as item>
                        <option value="${item.id}">${item.name}</option>
                </#list>
            </select>
            <select name="cityId">
                <option value="">选择城市</option>
            </select>
            <select name="areaId">
                <option value="">项目区域</option>
                <#list areas as item>
                    <option value="${item.id}">${item.typeName}</option>
                </#list>
            </select>
            <input type="text" placeholder="项目地址" name="detailedAddress"/>
            <textarea name="details" cols="30" rows="10" placeholder="项目详情"></textarea>
            <input type="text" placeholder="建筑面积" name="constructionArea"/>
            <input type="text" placeholder="用地面积" name="planningArea"/>
            <input type="text" placeholder="人员要求" name="personnelRequirements"/>
            <div class="row">
                <div class="claim" style="width:60%;">
                    计划时间
                    <input type="text" placeholder="" style="width:100px;" name="planStartTime">
                </div>
                <span class="sp">~</span>
                <div class="claim" style="width:32%;float:right;">
                    <input type="text" placeholder="" style="width:100%;" name="planEndTime">
                </div>
            </div>
            <select name="cycleId">
                <option value="">项目周期</option>
                <#list sysProjectCycles as item>
                    <option value="${item.id}" data-unit="${item.unit}">${item.typeName}</option>
                </#list>
            </select>
            <input type="text" placeholder="项目金额" name="putAmount"/>
            <select name="acquisitionTypeId">
                <option value="">项目获取类型</option>
                <#list acquisitionTypes as item>
                    <option value="${item.id}">${item.typeName}</option>
                </#list>
            </select>
            <select name="sourceId">
                <option value="">项目来源</option>
                <#list sources as item>
                    <option value="${item.id}">${item.typeName}</option>
                </#list>
            </select>
            <select name="isAutomaticRelease">
                <option value="">是否自动发布</option>
                <option value="0">否</option>
                <option value="1">是</option>
            </select>
            <#--<p class="title">成果要求</p>
            <div class="demands">
                <label>文本</label>
                <label class="active">展板</label>
                <label >多媒体</label>
                <label>模型</label>
                <label class="active">其他</label>
                <label>备注</label>
                <div class="clear"></div>
            </div>-->
            <p class="title">项目附件</p>
            <#--<div class="invite">
                <input type="button" value="项目附注" class="border">
            </div>-->
            <div style="height:15px;"></div>
            <textarea name="relatedInformation" cols="30" rows="10" placeholder="附件备注"></textarea>
            
            <p class="title">邀请的项目经理</p>
            <div class="invite">
                <input type="hidden" name="type" value="0">
                <input type="button" value="+ 已有心仪的项目经理" data-val="1">
                <input type="button" value="+ 直接发布到一级市场" class="alt" data-val="2">
            </div>
            <#--<input type="button" value="保存" class="save" id="saveButton">-->
            <input type="button" value="确认提交" id="saveButton">
        </form>
    </div>
</div>

<script>
    $(function () {
        $('.invite input[type="button"]').click(function () {
            $(this).siblings('input[type="button"]').addClass("alt");
            $(this).removeClass('alt');
            $('input[name="type"]').val($(this).attr('data-val'));
        });
        $('select[name="provinceId"]').change(function () {
            var provinceName = $(this).find("option:selected").html();
            $('input[name="provinceName"]').val(provinceName);
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
        $('select[name="cityId"]').change(function () {
            var cityName = $(this).find("option:selected").html();
            $('input[name="cityName"]').val(cityName);
        });
        $('select[name="cycleId"]').change(function () {
            var cycleValue = $(this).find("option:selected").html();
            var cycleUnit = $(this).find("option:selected").attr('data-unit');
            
            $('input[name="cycleValue"]').val(cycleValue);
            $('input[name="cycleUnit"]').val(cycleUnit);
        });
        function isdate(str){
            var patrn = /^\d{4}-\d{2}-\d{2}$/;
            if (!patrn.exec(str)) 
                return false;
            return true;
        }
        function isDecimal(str){
            var patrn = /^\d{1,18}(\.\d{1,2})?$/;
            if (!patrn.exec(str))
                return false;
            return true;
        }
        $('#saveButton').click(function () {
            var planStartTime = $('input[name="planStartTime"]').val();
            var planEndTime = $('input[name="planEndTime"]').val();
            var projectName = $('input[name="projectName"]').val();
            var projectNum = $('input[name="projectNum"]').val();
            
            var constructionArea = $('input[name="constructionArea"]').val();
            var planningArea = $('input[name="planningArea"]').val();
            var putAmount = $('input[name="putAmount"]').val();
            
            if(!projectName){
                alert('请输入项目名称');
                return false;
            }
            if(!projectNum){
                alert('请输入项目编号');
                return false;
            }
            if (planStartTime) {
                if(!isdate(planStartTime)){
                    alert('项目开始时间格式为:yyyy-MM-dd格式')
                    return false;
                }
            }
            if (planEndTime) {
                if(!isdate(planEndTime)){
                    alert('项目结束时间格式为:yyyy-MM-dd格式')
                    return false;
                }
            }
            if(constructionArea){
                if(!isDecimal(constructionArea)){
                    alert("建筑面积必须为数字");
                    return false;
                }
            }
            if(planningArea){
                if(!isDecimal(planningArea)){
                    alert("用地面积必须为数字");
                    return false;
                }
            }
            if(putAmount){
                if(!isDecimal(putAmount)){
                    alert("项目金额必须为数字");
                    return false;
                }
            }
            $.ajax({
                type:"POST",
                dataType: "json",
                url: "/task/savePublish",
                data: $('.data_form').serialize(),
                success: function(response){
                    if(response==true){
                        alert('保存成功');
                        /*window.location.href='http://weixin.teamlinks.cn/task/enter';*/
                        window.location.href='/task/publish';
                    } else{
                        //发送验证码失败
                        alert('保存失败，请重试')
                    }
                }
            });
        });
    });
</script>
</body>

</html>