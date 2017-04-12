package com.poc.sms;

import org.apache.camel.main.Main;

import com.poc.sms.routers.SmsRouter;

/**
 * A Camel Application
 */
public class MainApp {

    /**
     * A main() so we can easily run these routing rules in our IDE
     */
    public static void main(String... args) throws Exception {
        Main main = new Main();
        main.enableHangupSupport();
        main.addRouteBuilder(new SmsRouter());
        main.run(args);
    }

}

