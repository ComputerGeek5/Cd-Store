package com.example.techstore.util;

import java.net.URISyntaxException;

import com.example.techstore.Main;

public class Constant {
    public static String appTitle = "CD-Store";
    public static String baseLocation;

    static {
        try {
            baseLocation = Main.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
            baseLocation = baseLocation.substring(0, baseLocation.lastIndexOf("/"));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
