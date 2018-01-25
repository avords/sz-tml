package com.parkdt.tml.weChat.json;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.parkdt.tml.weChat.result.WxMpUser;

public class WxMpGsonBuilder {

  public static final GsonBuilder INSTANCE = new GsonBuilder();

  static {
    INSTANCE.registerTypeAdapter(WxMpUser.class, new WxMpUserGsonAdapter());

  }

  public static Gson create() {
    return INSTANCE.create();
  }

}
