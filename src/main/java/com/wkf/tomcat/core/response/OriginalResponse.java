package com.wkf.tomcat.core.response;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author gavinwu
 * @date 18-12-22
 */
public class OriginalResponse implements Response{

    private OutputStream outputStream;

    public OriginalResponse(OutputStream outputStream){
        this.outputStream = outputStream;
    }

    public void write(String content){
        try {
            StringBuilder responseBody = new StringBuilder();
            responseBody.append("HTTP/1.1 200 OK\n")
                    .append("Content-Type:text/html\n")
                    .append("\r\n")
                    .append("<html><body>")
                    .append(content)
                    .append("</body></html>");
            outputStream.write(responseBody.toString().getBytes());
        }catch (IOException e){
            System.out.println("OriginalResponse exeception:"+e.getMessage());
        }finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
