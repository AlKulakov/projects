package com.example.springbootdemo;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
// Адрес страницы
    @RequestMapping("/home/{color}")
    public String home(


            @PathVariable String color,
            //Запрос параметра в адресной строке браузера в виде ?param=value
            @RequestParam(required = false) String name,

            Model page

    ){
        //Атрибуты для html документа, которые вставляем туда
        page.addAttribute("username", name);
        page.addAttribute("color", color);
        //Имя html документа
        return "home.html";
    }
}
