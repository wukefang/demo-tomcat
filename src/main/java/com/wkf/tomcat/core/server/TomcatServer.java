package com.wkf.tomcat.core.server;

import com.wkf.tomcat.core.Servlet.OriginalServlet;
import com.wkf.tomcat.core.register.ServletMapper;
import com.wkf.tomcat.core.request.OriginalRequest;
import com.wkf.tomcat.core.request.Request;
import com.wkf.tomcat.core.response.OriginalResponse;
import com.wkf.tomcat.core.response.Response;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author gavinwu
 * @date 18-12-22
 */
public class TomcatServer {

    private int port = 8080;


    public void start(){
        System.out.println("server startup....");
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            boolean f = true;
            while (f){
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                OriginalRequest originalRequest = new OriginalRequest(inputStream);
                OriginalResponse originalResponse = new OriginalResponse(outputStream);
                dispatch(originalRequest,originalResponse);
                socket.close();
                //f = false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("server end...");
    }

    public void dispatch(Request request, Response response){
        OriginalServlet originalServlet = new OriginalServlet();
        Class servletClass = ServletMapper.get(request.url());
        if(servletClass!=null) {
            try {
                originalServlet = (OriginalServlet) servletClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        originalServlet.service(request,response);
    }

}
