package org.example.old.main;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Man {
    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @PostConstruct
    public void init(){
        this.desc = "LK:fdsdfoklsdfdsf sdfs";
    }
}
