package com.zenika.nc.angular.mybottles;

import restx.server.WebServer;

/**
 * This class can be used to run the app.
 *
 * Alternatively, you can deploy the app as a war in a regular container like tomcat or jetty.
 *
 * Reading the port from system env PORT makes it compatible with heroku.
 */
public class AppServer {
    public static final String WEB_INF_LOCATION = "src/main/webapp/WEB-INF/web.xml";

    private static int port = 8080;
    private static String WEB_APP_LOCATION = "../ui/app";

    public static void main(String[] args) throws Exception {
        if( ! extractArgs(args) ) {
            return;
        }
        WebServer server = new NonBlockingJettyWebServer(WEB_INF_LOCATION, WEB_APP_LOCATION, port, "0.0.0.0");

        /*
         * load mode from system property if defined, or default to dev
         * be careful with that setting, if you use this class to launch your server in production, make sure to launch
         * it with -Drestx.mode=prod or change the default here
         */
        System.setProperty("restx.mode", System.getProperty("restx.mode", "dev"));
        System.setProperty("restx.app.package", "com.zenika.nc.angular.mybottles");
		
		System.out.println("Server starting on port "+port);

        server.startAndAwait();
    }

    private static boolean extractArgs(String[] args) {
        //case HELP
        if( args.length > 0 && "help".equals(args[0]) ) {
            showHelp();
            return false;
        }

        // parse port value
        if( args.length > 0 ) {
            try {
                port = Integer.valueOf(args[0]);
            } catch ( NumberFormatException e) {
                showHelp();
                return false;
            }
        }

        if( args.length > 1 ) {
            WEB_APP_LOCATION = args[1];
        }

        return true;
    }

    private static void showHelp() {
        System.out.println("sh start.sh <port> <ui directory>");
        System.out.println("");
        System.out.println("Example :");
        System.out.println("sh start.sh 8080 ../ui/app");
    }
}
