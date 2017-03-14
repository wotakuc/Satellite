package com.wotakuc.satellite.server.controller;

import com.wotakuc.satellite.server.model.SAResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bl02512 on 2017/3/14.
 */
@RestController
public class DataController {

    @RequestMapping("/data/{appName}/**")
    public SAResponse getData(@PathVariable String appName){
        return new SAResponse(true,appName,null);
    }
}
