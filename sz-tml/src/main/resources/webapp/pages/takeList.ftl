<!DOCTYPE html>
<html>

<head>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport"/>
    <title>我参与的</title>
    <link href="/css/style.css?ver=100" rel="stylesheet"/>
</head>

<body>
<div class="wrapper">
    <div class="container articlelist">
           <#list projectClaims as item>
               <ul class="article_list">
                   <li>
                       <a href="#">
                           <img src="${item.projectDeliveryVo.image}" alt="">
                           <div>
                               <#--${item.projectDeliveryVo.projectBaseInformationVo.projectStatusStr}&nbsp;-->
                           </div>
                           <span>${item.statusStr}&nbsp;${item.projectDeliveryVo.projectBaseInformationVo.projectName}</span>
                       </a>
                   </li>
               </ul>
           </#list>
    </div>
</div>
</body>

</html>