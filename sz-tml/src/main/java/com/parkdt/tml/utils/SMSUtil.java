package com.parkdt.tml.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/1/15.
 */
public class SMSUtil {

    private static final String accessKeyId = "LTAI3xiB8G8k9W3u";//你的accessKeyId,参考本文档步骤2
    private static final String accessKeySecret = "Sf5D3aaz1UiwhNMi7LJMHVbBUvR8kk";//你的accessKeySecret，参考本文档步骤2
    private static final String signName = "Teamlinks平台";//你的accessKeySecret，参考本文档步骤2
    private static final String templateCode = "SMS_110215004";//你的accessKeySecret，参考本文档步骤2
    private static final String product = "Dysmsapi";
    private static final String domain = "dysmsapi.aliyuncs.com";

    public static boolean send(String phoneNumber,String signName,String templateCode,String params) throws Exception {
        //设置超时时间-可自行调整
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        //替换成你的AK
        //初始化ascClient,暂时不支持多region（请勿修改）
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
                accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        //组装请求对象
        SendSmsRequest request = new SendSmsRequest();
        //使用post提交
        request.setMethod(MethodType.POST);
        //必填:待发送手机号。支持以逗号分隔的形式进行批量调用，批量上限为1000个手机号码,批量调用相对于单条调用及时性稍有延迟,验证码类型的短信推荐使用单条调用的方式
        request.setPhoneNumbers(phoneNumber);
        //必填:短信签名-可在短信控制台中找到
        request.setSignName(signName);
        //必填:短信模板-可在短信控制台中找到
        request.setTemplateCode(templateCode);
        //可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
        //友情提示:如果JSON中需要带换行符,请参照标准的JSON协议对换行符的要求,比如短信内容中包含\r\n的情况在JSON中需要表示成\\r\\n,否则会导致JSON在服务端解析失败
        request.setTemplateParam(params);
        //可选-上行短信扩展码(扩展码字段控制在7位或以下，无特殊需求用户请忽略此字段)
        //request.setSmsUpExtendCode("90997");
        //可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
        //request.setOutId("yourOutId");
        //请求失败这里会抛ClientException异常
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        if (sendSmsResponse.getCode() != null && sendSmsResponse.getCode().equals("OK")) {
            //请求成功
            return true;
        }
        return false;
    }
    public static boolean sendBindSms(String phoneNumber,String params) throws Exception {
        return send(phoneNumber,signName,templateCode,params);
    }

    public static QuerySendDetailsResponse querySendDetails(String bizId)
            throws ClientException
    {
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI3xiB8G8k9W3u", "Sf5D3aaz1UiwhNMi7LJMHVbBUvR8kk");
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Dysmsapi", "dysmsapi.aliyuncs.com");
        IAcsClient acsClient = new DefaultAcsClient(profile);
        QuerySendDetailsRequest request = new QuerySendDetailsRequest();
        request.setPhoneNumber("15000000000");
        request.setBizId(bizId);
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
        request.setSendDate(ft.format(new Date()));
        request.setPageSize(Long.valueOf(10L));
        request.setCurrentPage(Long.valueOf(1L));
        QuerySendDetailsResponse querySendDetailsResponse = (QuerySendDetailsResponse)acsClient.getAcsResponse(request);
        return querySendDetailsResponse;
    }
    public static void main(String[] args) {
        try {
            send("18583370380",signName,templateCode,"{\"code\":1234}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
