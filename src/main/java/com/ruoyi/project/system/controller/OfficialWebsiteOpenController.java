package com.ruoyi.project.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 */
@RestController
@RequestMapping("/open")
public class OfficialWebsiteOpenController {

    @GetMapping("/content/config")
    public Object getContentConfig(){
        HashMap<String, Object> data = new HashMap<>();
        data.put("images", Arrays.asList("/image/111.jpg", "/image/112.jpg", "/image/113.jpg"));
        data.put("cards", Arrays.asList("/image/card_111.jpg", "/image/card_112.jpg", "/image/card_113.jpg"));
        return data;
    }

}
