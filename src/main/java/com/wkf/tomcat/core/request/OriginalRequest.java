package com.wkf.tomcat.core.request;

import java.io.InputStream;

/**
 * @author gavinwu
 * @date 18-12-22
 */
public class OriginalRequest implements Request{

    private InputStream inputStream = null;

    private String url;

    private String method = "";

    public OriginalRequest(InputStream inputStream){
        this.inputStream = inputStream;
        initRequest();
    }

    public void initRequest(){
        String requestBody = null;
        try {
            byte[] b = new byte[10240];
            int length = inputStream.read(b);
            if(length<=-1){
                //使用postman时，每次这里都会出现一次空请求，目前还不知道为什么；
                return ;
            }
            requestBody = new String(b,0,length,"utf-8");
            System.out.println("requestBody:"+requestBody);
            String httpHead = requestBody.split("\n")[0];
            this.method = httpHead.split("\\s")[0];
            String urlString = httpHead.split("\\s")[1];
            if(urlString.contains("?")){
                this.url = urlString.split("\\?")[0];
            }else{
                this.url = urlString;
            }
        } catch (Exception e) {
            System.out.println("read inputStream exception-->"+e.getMessage());
        }
    }

    @Override
    public String method() {
        return method;
    }

    @Override
    public String url() {
        return url;
    }

    @Override
    public String toString() {
        return this.method+"---"+this.url;
    }
}
