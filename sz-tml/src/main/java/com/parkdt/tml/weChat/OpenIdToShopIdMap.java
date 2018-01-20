package com.parkdt.tml.weChat;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.parkdt.tml.config.WeChatConfig;
import com.parkdt.tml.utils.HttpPostClient;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class OpenIdToShopIdMap {

    private static ConcurrentHashMap<String, HashSet<String>> map = new ConcurrentHashMap<String, HashSet<String>>();

    private OpenIdToShopIdMap() {
    }

    /**
     * 系统启动时，加载openId与shopId的映射关系
     */
    public static void loadMap() {
        String result = HttpPostClient.doHttpPost(WeChatConfig.getWebUrl(), "merQueryShopUID.mas", null);
        System.out.println();
        System.out.println("OpenIdToShopIdMap");
        System.out.println(result);
        if (result.indexOf("result") == -1) {
            JSONArray array = JSONArray.parseArray(result);
            for (int i = 0; i < array.size(); i++) {
                JSONObject json = array.getJSONObject(i);
                load(json.getString("shopId"), json.getString("uID"));
            }
        }
    }

    /**
     * 向openid中添加shopIds
     *
     * @param shopId
     * @param openid
     */
    public static void load(String shopId, String openid) {
        HashSet<String> set = map.get(shopId);
        if (set == null) {
            set = new HashSet<String>();
        }
        set.add(openid);
        map.put(shopId, set);
    }

    /**
     * 向openid中添加shopIds
     *
     * @param shopId
     * @param openid
     */
    public static void add(String shopId, String openid) {
        boolean exist = false;
        HashSet<String> set = map.get(shopId);
        if (set == null) {
            set = new HashSet<String>();
            exist = false;
        }
        exist = set.contains(openid);
        set.add(openid);
        map.put(shopId, set);

        if (!exist) {
            JSONObject json = new JSONObject();
            json.put("shopId", shopId);
            json.put("UID", openid);
            Map<String, String> param = new HashMap<String, String>();
            param.put("shopUIDJson", json.toJSONString());
            param.put("type", "1");
            String result = HttpPostClient.doHttpPost(WeChatConfig.getWebUrl(), "merModifyShopUID.mas", param);
            System.out.println(result);
        }

    }

    /**
     * 删除openid
     *
     * @param openid
     */
    public static void remove(String openid) {
        boolean exist = false;
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            HashSet<String> openidSet = map.get(key);
            if (openidSet.contains(openid)) {
                openidSet.remove(openid);
                exist = true;
            }
            map.put(key, openidSet);
        }
        if (exist) {
            JSONObject json = new JSONObject();
            json.put("UID", openid);
            Map<String, String> param = new HashMap<String, String>();
            param.put("shopUIDJson", json.toJSONString());
            param.put("type", "2");
            String result = HttpPostClient.doHttpPost(WeChatConfig.getWebUrl(), "merModifyShopUID.mas", param);
            System.out.println(result);
        }
    }

    public static boolean hasOpenId(String openId) {
        return map.keySet().contains(openId);
    }

    /**
     * 通过shopId查询所有的openid
     *
     * @param shopId
     * @return
     */
    public static HashSet<String> getOpenId(String shopId) {
        return map.get(shopId);
    }

    /**
     * 通过openid查询所有的shopId
     *
     * @param openid
     * @return
     */
    public static List<String> getShopIds(String openid) {
        List<String> shopIdList = new ArrayList<String>();
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            HashSet<String> openidSet = map.get(key);
            if (openidSet.contains(openid)) {
                shopIdList.add(key);
            }
        }
        return shopIdList;
    }

}
