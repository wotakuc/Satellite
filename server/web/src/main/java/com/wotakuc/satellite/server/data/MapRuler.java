package com.wotakuc.satellite.server.data;


import javax.servlet.http.HttpServletRequest;

/**
 * Created by bl02512 on 2017/3/14.
 */
public class MapRuler {

    public static String map(String appName, String path, HttpServletRequest request){
        return "map_" + path;
    }
}
