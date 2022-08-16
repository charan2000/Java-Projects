package com.mobile.os;

import java.util.Locale;

public class OSFactoryClass {

    public OS getOperatingSystem(String str) {

        str = str.toLowerCase();
        if (str.equals("open source")) {
            return new Android();
        }
        else if (str.equals("secure os")) {
            return new IOS();
        }
        else return new Windows();

    }

}
