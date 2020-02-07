package com.util;

public class Session {
    private static boolean xpath = false;
    private static boolean css = false;

    public static boolean isCss() {
        return css;
    }
    public static void setCss(boolean css) {
        Session.css = css;
    }

    public static boolean isXpath() {
        return xpath;
    }

    public static void setXpath(boolean xpath) {
        Session.xpath = xpath;
    }
}
