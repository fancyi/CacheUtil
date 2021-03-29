package com.example.demo.controller;

import com.example.demo.config.CommonConsts;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Created by fcy on 2020/11/25 0025.
 */
@Controller
public class HelloController {

    @RequestMapping(value = "hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/i18n")
    public String changeSessionLanauage(HttpServletRequest request, String lang){
        System.out.println(lang);
        if(CommonConsts.LANG_ZH.equals(lang)){
            //代码中即可通过以下方法进行语言设置
            request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,new Locale("zh","CN"));
        }else if(CommonConsts.LANG_EN.equals(lang)){
            request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,new Locale("en","US"));
        }
        return "redirect:/hello";
    }
}