package com.wotakuc.satellite.server.controller;

import com.wotakuc.satellite.server.config.PathConfig;
import com.wotakuc.satellite.server.config.SAParams;
import com.wotakuc.satellite.server.data.MapRuler;
import com.wotakuc.satellite.server.model.SAResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by bl02512 on 2017/3/14.
 */
@RestController
public class DataController {

    @RequestMapping(PathConfig.GETDATA)
    public SAResponse getData(@PathVariable String appName, HttpServletRequest request){
        try{
            checkPermission(appName,request);

            String subPath = getDataPath(appName,request.getRequestURI());
            if(StringUtils.isEmpty(subPath))
                throw new Exception("error path");

            boolean enableRule = Boolean.valueOf(request.getParameter(SAParams.ENABLE_RULE));

            String dataPath = subPath;
            if(enableRule)
                dataPath = MapRuler.map(appName,subPath,request);

            String value = getPathValue(appName,dataPath);

            return new SAResponse(true,value,null);
        }
        catch (Exception e){
            e.printStackTrace();
            return new SAResponse(false,null,e.getMessage());
        }
    }

    private void checkPermission(String appName, HttpServletRequest request) throws Exception{
        String token = request.getParameter("token");
        if( StringUtils.isEmpty(token)){
            throw new Exception("invalid user");
        }
    }

    private String getDataPath(String appName,String fullPath){
        String pre = PathConfig.GETDATA_PRE + appName;
        if(fullPath.startsWith(pre)){
            return fullPath.substring(pre.length());
        }
        return null;
    }

    private String getPathValue(String appName,String path){
        return "appName is " + appName + "  path is " + path;
    }
}
