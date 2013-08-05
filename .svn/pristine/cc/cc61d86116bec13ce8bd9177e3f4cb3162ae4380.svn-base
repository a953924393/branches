package com.jingpaidang.tools.batch.rpc;


import com.jd.open.api.sdk.DefaultJdClient;
import com.jd.open.api.sdk.JdClient;
import com.jd.open.api.sdk.JdException;
import com.jd.open.api.sdk.request.ware.WareDelistingGetRequest;
import com.jd.open.api.sdk.request.ware.WareInfoByInfoRequest;
import com.jd.open.api.sdk.request.ware.WareListRequest;
import com.jd.open.api.sdk.request.ware.WareListingGetRequest;
import com.jd.open.api.sdk.response.ware.WareDelistingGetResponse;
import com.jd.open.api.sdk.response.ware.WareInfoByInfoSearchResponse;
import com.jd.open.api.sdk.response.ware.WareListResponse;
import com.jd.open.api.sdk.response.ware.WareListingGetResponse;
import com.jingpaidang.tools.common.utils.JSONUtils;
import com.jingpaidang.tools.common.utils.StringUtil;
import com.jingpaidang.tools.common.utils.ValidateUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * @author jackchen
 * @version 1.0-SNAPSHOT
 */
@Service("batchRpcService")
public class BatchRpcService {

    //private static final String REDIRECT_URI = "http://cshop.jingpaidang.com:8080/user/user!enterSystem.action?flag=3";
    @Value("${jd.url}")
    private String URL;
    @Value("${jd.redirect.uri}")
    private String REDIRECT_URI;
    @Value("${jd.app.key}")
    private String APP_KEY;
    @Value("${jd.app.secret}")
    private String APP_SECRET;
    @Value("${jd.authurl}")
    private String AUTHURL;


    /**
     * 获取京东半年内的商品数据
     */
    public WareInfoByInfoSearchResponse getWareList(String accessToken, String page, String pageSize) throws JdException {
        JdClient client = new DefaultJdClient(URL, accessToken, APP_KEY,
                APP_SECRET);

        WareInfoByInfoRequest wareListRequest = new WareInfoByInfoRequest();

        wareListRequest.setPage(page);

        wareListRequest.setPageSize(pageSize);

        WareInfoByInfoSearchResponse res = client.execute(wareListRequest);
        return res;
    }


    /**
     * 获取京东多个商品数据 根据wareIds
     */
    public WareListResponse getWareList(String accessToken, String wareIds) throws JdException {
        JdClient client = new DefaultJdClient(URL, accessToken, APP_KEY,
                APP_SECRET);

        WareListRequest wareListRequest = new WareListRequest();

        wareListRequest.setWareIds(wareIds);
        WareListResponse res = client.execute(wareListRequest);
        return res;
    }

    /**
     * 得到上架商品的信息
     *
     * @param accessToken
     * @param cid         分类id，可有可无
     * @param page        第多少页
     * @param pageSize    每页显示数量
     * @return
     */
    public WareListingGetResponse getWareList(String accessToken, String cid, String page, String pageSize) throws JdException {
        JdClient client = new DefaultJdClient(URL, accessToken, APP_KEY,
                APP_SECRET);

        WareListingGetRequest wareListRequest = new WareListingGetRequest();

        if (ValidateUtil.isValidated(cid)) {
            wareListRequest.setCid(cid);
        }
        wareListRequest.setPage(page);
        wareListRequest.setPageSize(pageSize);
        WareListingGetResponse res = client.execute(wareListRequest);
        return res;
    }

    /**
     * 得到下架商品的信息
     *
     * @param accessToken
     * @param cid         分类id，可有可无
     * @param page        第多少页
     * @param pageSize    每页显示数量
     * @return
     */
    public WareDelistingGetResponse getWareDeList(String accessToken, String cid, String page, String pageSize) throws JdException {
        JdClient client = new DefaultJdClient(URL, accessToken, APP_KEY,
                APP_SECRET);

        WareDelistingGetRequest wareListRequest = new WareDelistingGetRequest();

        if (ValidateUtil.isValidated(cid)) {
            wareListRequest.setCid(cid);
        }
        wareListRequest.setPage(page);
        wareListRequest.setPageSize(pageSize);
        WareDelistingGetResponse res = client.execute(wareListRequest);
        return res;
    }
    /**
     * 用于定时刷新accessToken，一般 刷新频率一般1/24h
     *
     * @return 刷新后的access_token
     */
//    public String refreshToken(String accessToken) throws IOException {
//
//
//
//        String html = AUTHURL + "?"
//                + "client_id=" + APP_KEY
//                + "&client_secret=" + APP_SECRET
//                + "&grant_type=refresh_token" + "&refresh_token="
//                + refreshToken;
//        URL uri;
//        uri = new URL(html);
//
//        HttpURLConnection conn = (HttpURLConnection) uri.openConnection();
//
//        conn.setRequestProperty("Accept-Charset", "utf-8");
//
//        conn.setRequestMethod("POST");
//
//        InputStream is = conn.getInputStream();
//
//        String jsonStr = StringUtil.inputStream2String(is);
//        Map jsonMap = JSONUtils.toObject(jsonStr, HashMap.class);
//        accessToken = (String) jsonMap.get("access_token");
//
//        return accessToken;
//    }


    /**
     * 根据授权得到的code，state 取得授权信息
     *
     * @param code
     * @param state
     * @return {  "access_token": "1ea34584-87bb-4d5a-a623-a14b6efc495e",  "code": 0,  "expires_in": 31103999,  "refresh_token": "d0bfc3e5-5469-476d-b155-78645e81edf5",  "scope": "null",  "time": "1372212206893",  "token_type": "bearer",  "uid": "1097741719", "user_nick": "jd_jingpaidang"}
     */
    public Map<String, Object> getAccessToken(String code, String state) throws IOException {
        //用得到的code获取accesstoken

        String html = AUTHURL + "?grant_type=authorization_code" +
                "&client_id=" + APP_KEY +
                "&redirect_uri=" + REDIRECT_URI +
                "&code=" + code +
                "&state=" + state +
                "&client_secret=" + APP_SECRET;
        URL uri;
        uri = new URL(html);

        HttpURLConnection conn = (HttpURLConnection) uri.openConnection();

        conn.setRequestProperty("Accept-Charset", "utf-8");

        conn.setRequestMethod("POST");

        InputStream is = conn.getInputStream();

        String jsonStr = StringUtil.inputStream2String(is);

        return JSONUtils.toObject(jsonStr, Map.class);
    }
}
