package com.example.demo.controller;

import com.example.demo.model.DemoEntity;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by fcy on 2020/10/30.
 */
@RestController
@RequestMapping("/test")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "/hellow",method = RequestMethod.GET)
    public DemoEntity test(){

        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setId(1122334455667788111L);
        demoEntity.setName("张三");

        return demoEntity;
    }

    @RequestMapping(value = "/data",method = RequestMethod.GET)
    public Integer getData(){
        long s = System.currentTimeMillis();
        List<String> datas = demoService.getData();
        System.out.println(System.currentTimeMillis() - s);
        return datas.size();
    }
}
