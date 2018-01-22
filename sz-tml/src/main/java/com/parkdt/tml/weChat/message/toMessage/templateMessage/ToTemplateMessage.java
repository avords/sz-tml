package com.parkdt.tml.weChat.message.toMessage.templateMessage;

import com.alibaba.fastjson.JSONObject;


public class ToTemplateMessage {

    private String touser;

    private String template_id;

    private String url;

    private String topcolor;

    private String data;

    /**
     * 创建模板消息JSON数据
     *
     * @return
     */
    public JSONObject buildJson(ReceiveOrderTemplate template) {
        JSONObject json = (JSONObject) JSONObject.toJSON(this);
        json.put("data", template.buildJson());
        return json;
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTopcolor() {
        return topcolor;
    }

    public void setTopcolor(String topcolor) {
        this.topcolor = topcolor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
