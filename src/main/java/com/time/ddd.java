package com.time;

import com.lambda.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * wflinzhiyong@163.com
 * Created by lzy on 2016/4/14.
 */
public class ddd {

    public static void main(String[] args) throws Exception {
        Test("https://www.baidu.com");
    }

    private static long getNetTime(String webUrl) {
        try {
            URL url = new URL(webUrl);
            URLConnection uc = url.openConnection();
            uc.setConnectTimeout(500);
            uc.connect();
            return uc.getDate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void Test(String str) throws Exception {

        URL url = new URL(str);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        SSLSocketFactory oldSocketFactory = null;
        HostnameVerifier oldHostnameVerifier = null;

        boolean useHttps = str.startsWith("https");
        if (useHttps) {
            HttpsURLConnection https = (HttpsURLConnection) connection;
            oldSocketFactory = trustAllHosts(https);
            oldHostnameVerifier = https.getHostnameVerifier();
            https.setHostnameVerifier(DO_NOT_VERIFY);
            SimpleDateFormat dateTimeformat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dateTimeformat2.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            System.out.println(dateTimeformat2.format(new Date(https.getDate())));
        }
    }

    /**
     覆盖java默认的证书验证
     *    
     */
    private static final TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return new java.security.cert.X509Certificate[]{};
        }

        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }
    }};

    /**
     * 设置不验证主机
     *    
     */
    private static final HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    };

    /**
     *     * 信任所有
     *     * @param connection
     *     * @return
     *    
     */
    private static SSLSocketFactory trustAllHosts(HttpsURLConnection connection) {
        SSLSocketFactory oldFactory = connection.getSSLSocketFactory();
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            SSLSocketFactory newFactory = sc.getSocketFactory();
            connection.setSSLSocketFactory(newFactory);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return oldFactory;
    }

}