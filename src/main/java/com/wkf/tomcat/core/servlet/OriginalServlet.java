package com.wkf.tomcat.core.servlet;

import com.wkf.tomcat.core.enums.RequestMethod;
import com.wkf.tomcat.core.request.Request;
import com.wkf.tomcat.core.response.Response;

/**
 * @author gavinwu
 * @date 18-12-22
 */
public class OriginalServlet {

    public void doGet(Request request, Response response){
        doPost(request,response);
    }

    public void doPost(Request request,Response response){
        response.write("No mapping servlet,Please register your servlet");
    }

    public void service(Request request,Response response){
        if(request.method().equalsIgnoreCase(RequestMethod.GET.name())){
            doGet(request,response);
        }else if(request.method().equalsIgnoreCase(RequestMethod.POST.name())){
            doPost(request,response);
        }else{
            //处理postman的空请求
            System.out.println("method not found");
        }
    }
}
