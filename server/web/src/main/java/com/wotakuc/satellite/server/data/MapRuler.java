package com.wotakuc.satellite.server.data;


import javax.servlet.http.HttpServletRequest;

public class MapRuler {

    public static String map(String appName, String path, HttpServletRequest request){
        return "map_" + path;
    }
}
