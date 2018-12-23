package com.wkf.tomcat.core.register;

import com.wkf.tomcat.business.LoginServlet;
import com.wkf.tomcat.business.LogoutServlet;
import com.wkf.tomcat.business.WorkServlet;

import java.util.HashMap;

/**
 * @author gavinwu
 * @date 18-12-23
 */
public class ServletMapper {
    public static HashMap<String, Class> servletMapper = new HashMap<>();

    static{
        servletMapper.put("/login", LoginServlet.class);
        servletMapper.put("/work", WorkServlet.class);
        servletMapper.put("/logout", LogoutServlet.class);
    }

    public static Class get(String url){
        return servletMapper.get(url);
    }
}
