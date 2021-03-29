package com.example.demo.service.impl;

import com.example.demo.CacheUtil;
import com.example.demo.service.DemoService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by fcy on 2021/3/29 0029.
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public List<String> getData() {
        List<String> data = null;
        try {
            data = CacheUtil.getObject("user.not.find:zh");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return data;
    }
}
