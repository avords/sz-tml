package com.parkdt.tml.weChat.message.toMessage.templateMessage;

import com.alibaba.fastjson.JSONObject;

public class ReceiveOrderTemplate {

    /**
     * 消息头
     */
    private String first;

    /**
     * 消息日期
     */
    private String Day;

    /**
     * 订单流水号
     */
    private String orderId;

    /**
     * 订单类型
     */
    private String orderType;

    /**
     * 联系人
     */
    private String customerName;

    /**
     * 联系人电话
     */
    private String customerPhone;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建模板消息JSON数据
     *
     * @return
     */
    public JSONObject buildJson() {
        JSONObject json = new JSONObject();
        String color = "#0A0A0A";
//		String color = "#173177";
        JSONObject first = new JSONObject();
        first.put("value", getFirst());
        first.put("color", "#0A0A0A");
        json.put("first", first);

        JSONObject Day = new JSONObject();
        Day.put("value", getDay());
        Day.put("color", color);
        json.put("Day", Day);

        JSONObject orderId = new JSONObject();
        orderId.put("value", getOrderId());
        orderId.put("color", color);
        json.put("orderId", orderId);

        JSONObject orderType = new JSONObject();
        orderType.put("value", getOrderType());
        orderType.put("color", color);
        json.put("orderType", orderType);

        JSONObject customerName = new JSONObject();
        customerName.put("value", getCustomerName());
        customerName.put("color", color);
        json.put("customerName", customerName);

        JSONObject customerPhone = new JSONObject();
        customerPhone.put("value", getCustomerPhone());
        customerPhone.put("color", color);
        json.put("customerPhone", customerPhone);

        JSONObject remark = new JSONObject();
        remark.put("value", getRemark());
        remark.put("color", color);
        json.put("remark", remark);

        return json;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
