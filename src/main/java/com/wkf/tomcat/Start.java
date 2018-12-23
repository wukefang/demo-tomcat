package com.wkf.tomcat;

import com.wkf.tomcat.core.server.TomcatServer;

/**
 * Hello world!
 *
 */
public class Start
{
    public static void main( String[] args )
    {
        TomcatServer tomcatServer = new TomcatServer();
        tomcatServer.start();
    }
}
