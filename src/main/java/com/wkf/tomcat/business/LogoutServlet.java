package com.wkf.tomcat.business;

import com.wkf.tomcat.core.Servlet.OriginalServlet;
import com.wkf.tomcat.core.request.Request;
import com.wkf.tomcat.core.response.Response;

/**
 * @author gavinwu
 * @date 18-12-23
 */
public class LogoutServlet extends OriginalServlet {
    @Override
    public void doGet(Request request, Response response) {
        doPost(request,response);
    }

    @Override
    public void doPost(Request request, Response response) {
        response.write("Logout....Please login again");
    }
}
