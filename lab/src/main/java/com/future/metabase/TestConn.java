package com.future.metabase;

import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.security.jwt.crypto.sign.MacSigner;
/**
 * @author zcd
 * @date 2019-07-18 13:55
 */
public class TestConn
{

    private static  final String METABASE_SITE_URL = "http://10.18.100.3:3000";
    private static  final String METABASE_SECRET_KEY = "0f365bcbf4a9b6629fb37d51da2eb81e921507f60a15b10e1aa0f325950bc6f5";

    public static void main(String[] args){
        TestConn testConn = new TestConn();

        System.out.println(testConn.indexAction());
    }
    public DashboardParams indexAction() {
        Jwt token = JwtHelper.encode("{\"resource\": {\"dashboard\": 1}, \"params\": {}}", new MacSigner(METABASE_SECRET_KEY));
//        String url = METABASE_SITE_URL + "/embed/dashboard/" + token.getEncoded() + "#theme=night&bordered=true&titled=true";
        String url = METABASE_SITE_URL + "/embed/dashboard/" + token.getEncoded() + "#theme=night&bordered=true&titled=true";
        return new DashboardParams(url);
    }


    class DashboardParams {
        private String url;

        @Override
        public String toString()
        {
            return "DashboardParams{" +
                    "url='" + url + '\'' +
                    '}';
        }

        public DashboardParams(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
